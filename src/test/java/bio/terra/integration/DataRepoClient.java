package bio.terra.integration;

import bio.terra.model.ErrorModel;
import bio.terra.model.JobModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.Arrays;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * This class holds a Spring RestTemplate
 */
@Component
public class DataRepoClient {
    @Autowired
    private DataRepoConfiguration dataRepoConfiguration;

    private RestTemplate restTemplate;
    private ObjectMapper objectMapper;
    private HttpHeaders headers;

    public DataRepoClient() {
        restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new DataRepoClientErrorHandler());
        objectMapper = new ObjectMapper();

        headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON, MediaType.APPLICATION_JSON_UTF8));
    }

    public <T> DataRepoResponse<T> get(String path, Class<T> responseClass) throws Exception {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return makeDataRepoRequest(path, HttpMethod.GET, entity, responseClass);
    }

    public <T> DataRepoResponse<T> post(String path, String json, Class<T> responseClass) throws Exception {
        HttpEntity<String> entity = new HttpEntity<>(json, headers);
        return makeDataRepoRequest(path, HttpMethod.POST, entity, responseClass);
    }

    public <T> DataRepoResponse<T> delete(String path, Class<T> responseClass) throws Exception {
        HttpEntity<String> entity = new HttpEntity<>(headers);
        return makeDataRepoRequest(path, HttpMethod.DELETE, entity, responseClass);
    }

    public <T> DataRepoResponse<T> waitForResponse(DataRepoResponse<JobModel> jobModelResponse,
                                                   Class<T> responseClass) throws Exception {
        try {
            while (jobModelResponse.getStatusCode() == HttpStatus.ACCEPTED) {
                String location = getLocationHeader(jobModelResponse);

                // TODO: tune this. Maybe use exponential backoff?
                TimeUnit.SECONDS.sleep(10);
                jobModelResponse = get(location, JobModel.class);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            throw new IllegalStateException("unexpected interrupt waiting for response");
        }

        if (jobModelResponse.getStatusCode() != HttpStatus.OK) {
            throw new IllegalStateException("unexpected interrupt waiting for response");
        }

        String location = getLocationHeader(jobModelResponse);
        DataRepoResponse<T> resultResponse = get(location, responseClass);

        return resultResponse;
    }

    private String getLocationHeader(DataRepoResponse<JobModel> jobModelResponse) {
        if (!jobModelResponse.getLocationHeader().isPresent()) {
            throw new IllegalStateException("No location header present!");
        }
        return jobModelResponse.getLocationHeader().get();
    }

    private <T> DataRepoResponse<T> makeDataRepoRequest(String path,
                                                        HttpMethod method,
                                                        HttpEntity entity,
                                                        Class<T> responseClass) throws Exception {

        ResponseEntity<String> response = restTemplate.exchange(
            makeUrl(path),
            method,
            entity,
            String.class);

        DataRepoResponse<T> drResponse = new DataRepoResponse<>();
        drResponse.setStatusCode(response.getStatusCode());

        URI uri = response.getHeaders().getLocation();
        drResponse.setLocationHeader((uri == null) ? Optional.empty() : Optional.of(uri.toString()));

        if (response.getStatusCode().is2xxSuccessful()) {
            T responseObject = objectMapper.readValue(response.getBody(), responseClass);
            drResponse.setResponseObject(Optional.of(responseObject));
            drResponse.setErrorModel(Optional.empty());
        } else {
            ErrorModel errorModel = objectMapper.readValue(response.getBody(), ErrorModel.class);
            drResponse.setErrorModel(Optional.of(errorModel));
            drResponse.setResponseObject(Optional.empty());
        }

        return drResponse;
    }

    private String makeUrl(String path) {
        return String.format("%s://%s:%s%s",
            dataRepoConfiguration.getProtocol(),
            dataRepoConfiguration.getServer(),
            dataRepoConfiguration.getPort(),
            path);
    }
}