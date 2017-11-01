package org.ucsc.ewa.oauthModule.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan("org.ucsc.ewa.oauthModule.service")
@PropertySource("classpath:spring/data-access.properties")
@EnableTransactionManagement
@Import({DataSourceConfig.class, JpaConfig.class})
public class BusinessConfig {


}
