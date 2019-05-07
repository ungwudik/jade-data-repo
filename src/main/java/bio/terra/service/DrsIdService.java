package bio.terra.service;

import bio.terra.service.exception.InvalidDrsIdException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.URI;

/**
 * This class provides DRS id parsing and building methods
 */
@Component
public class DrsIdService {

    private String datarepoDnsName;

    @Autowired
    public DrsIdService(String datarepoDnsName) {
        this.datarepoDnsName = datarepoDnsName;
    }

    public String toDrsUri(String studyId, String datasetId, String fsObjectId) {
        return fromParts(studyId, datasetId, fsObjectId).toDrsUri();
    }

    public String toDrsObjectId(String studyId, String datasetId, String fsObjectId) {
        return fromParts(studyId, datasetId, fsObjectId).toDrsObjectId();
    }

    private DrsId fromParts(String studyId, String datasetId, String fsObjectId) {
        return DrsId.builder()
            .dnsname(datarepoDnsName)
            .version("v1")
            .studyId(studyId)
            .datasetId(datasetId)
            .fsObjectId(fsObjectId)
            .build();
    }


    public DrsId fromUri(String drsuri) {
        URI uri = URI.create(drsuri);
        if (!StringUtils.equals(uri.getScheme(), "drs") ||
            uri.getAuthority() == null ||
            !StringUtils.startsWith(uri.getPath(), "/")) {
            throw new InvalidDrsIdException("Invalid DRS URI '" + drsuri + "'");
        }

        String objectId = StringUtils.remove(uri.getPath(), '/');
        return parseObjectId(objectId).dnsname(uri.getAuthority()).build();
    }

    public DrsId fromObjectId(String drsObjectId) {
        return parseObjectId(drsObjectId).build();
    }

    private DrsId.Builder parseObjectId(String objectId) {
        // The format is v1_<studyid>_<datasetid>_<fsobjectid>
        String[] idParts = StringUtils.split(objectId, '_');
        if (idParts.length != 4 || !StringUtils.equals(idParts[0], "v1")) {
            throw new InvalidDrsIdException("Invalid DRS object id '" + objectId + "'");
        }

        return DrsId.builder()
            .dnsname(datarepoDnsName)
            .version(idParts[0])
            .studyId(idParts[1])
            .datasetId(idParts[2])
            .fsObjectId(idParts[3]);
    }
}