package org.ondetem.test;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@EnableAutoConfiguration
@ComponentScan(basePackages = { "org.ondetem.data.jpa" })
@Configuration
public class TestContextConfiguration {

}
