package cz.cestadomu.hospis.core.lib;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile(CoreLib.MOCK_PROFILE)
@ComponentScan(basePackages = "cz.cestadomu.hospis.mock")
public class MockProfile {

}
