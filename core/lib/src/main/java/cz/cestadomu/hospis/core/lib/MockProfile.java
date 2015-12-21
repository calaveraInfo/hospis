package cz.cestadomu.hospis.core.lib;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Profile(CoreLib.MOCK_PROFILE)
@PropertySource("classpath:/core-mock.properties")
public class MockProfile {

}
