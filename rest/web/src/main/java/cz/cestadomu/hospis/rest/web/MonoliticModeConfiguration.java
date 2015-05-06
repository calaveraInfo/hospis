package cz.cestadomu.hospis.rest.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

import cz.cestadomu.hospis.core.lib.CoreLibConfiguration;

@Configuration
@Profile("monolitic")
@Import(CoreLibConfiguration.class)
@ImportResource("classpath:broker.xml")
public class MonoliticModeConfiguration {

}
