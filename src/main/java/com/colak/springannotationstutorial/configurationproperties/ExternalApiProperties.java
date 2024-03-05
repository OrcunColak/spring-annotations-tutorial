package com.colak.springannotationstutorial.configurationproperties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * See <a href="https://medium.com/@bectorhimanshu/streamlining-external-api-configuration-in-spring-boot-a-clean-approach-9caffb5673d5">...</a>
 */
@Configuration
@ConfigurationProperties(prefix = "external.api")

@Getter
@Setter
public class ExternalApiProperties {
    private String countriesApiUrl;
    private String countriesByRegionApiUrl;
    private String countriesByCodeApiUrl;
}
