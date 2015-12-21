package cz.cestadomu.hospis.core.lib;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile(CoreLib.MOCK_PROFILE)
@PropertySource("classpath:/core-mock.properties")
@ImportResource(locations = "classpath:/mock.xml")
public class MockProfile {

}
