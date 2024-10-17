package com.nomudev.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springdoc.core.models.GroupedOpenApi;

@Configuration
public class GroupsConfiguration {

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("user").pathsToExclude("/api/v2/**").pathsToMatch("/api/v1/**").build();
    }

}