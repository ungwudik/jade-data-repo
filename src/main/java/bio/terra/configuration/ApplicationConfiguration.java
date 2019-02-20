package bio.terra.configuration;

import bio.terra.stairway.Stairway;
import bio.terra.upgrade.Migrate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class ApplicationConfiguration {

    @Value("db.stairway.forceClean")
    private String stairwayForceClean;

    @Bean("stairway")
    public Stairway getStairway(Migrate migrate, ApplicationContext applicationContext) {
        StairwayJdbcConfiguration jdbcConfiguration = migrate.getStairwayJdbcConfiguration();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        DataSource dataSource = jdbcConfiguration.getDataSource();
        boolean forceClean = Boolean.parseBoolean(stairwayForceClean);
        return new Stairway(executorService, dataSource, forceClean, applicationContext);
    }

    @Bean("jdbcTemplate")
    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(DataRepoJdbcConfiguration jdbcConfiguration) {
        return new NamedParameterJdbcTemplate(jdbcConfiguration.getDataSource());
    }

}