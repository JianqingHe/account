package shiro.account.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 跨域设置
 *
 * @author hejq
 * @date 2019/6/27 14:24
 */
@Configuration
public class CrossConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**")
				.allowedOrigins("*")
				.allowCredentials(true)
				.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
				.maxAge(3600);
	}
}
