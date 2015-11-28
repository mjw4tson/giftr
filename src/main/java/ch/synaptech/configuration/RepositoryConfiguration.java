package ch.synaptech.configuration;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by mwatson on 11/28/2015.
 */
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"ch.synaptech.domain"})
@EnableJpaRepositories(basePackages = {"ch.synaptech.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
