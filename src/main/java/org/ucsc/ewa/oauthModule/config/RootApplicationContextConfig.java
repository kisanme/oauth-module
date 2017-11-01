package org.ucsc.ewa.oauthModule.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BusinessConfig.class, SecurityConfig.class, AuthServerOAuth2Config.class})
public class RootApplicationContextConfig {

}
