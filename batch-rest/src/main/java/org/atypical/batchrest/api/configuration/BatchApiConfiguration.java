package org.atypical.batchrest.api.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.atypical.batchrest.common.configuration" })
public class BatchApiConfiguration {

}
