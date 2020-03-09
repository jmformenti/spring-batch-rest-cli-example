package org.atypical.batch.api.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { "org.atypical.batch.core.configuration" })
public class BatchApiConfiguration {

}
