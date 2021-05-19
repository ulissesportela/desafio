package com.ulisses.desafio.config;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.MediaType;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Class WebConfig.
 */
@Configuration
@ComponentScan({ "com.ulisses.desafio" })
public class WebConfig implements WebMvcConfigurer {
	
    /**
     * COnfiguracao e filtro do Cors
     *
     * @return filter registration bean
     */
    @Bean
    public FilterRegistrationBean<CorsFilter> corsFilterFilterRegistrationBean(){
        List<String> all = Arrays.asList("*");

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowedOrigins(Collections.singletonList("*"));
        corsConfiguration.setAllowedHeaders(all);
        corsConfiguration.addAllowedHeader("Content-Type");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "OPTIONS", "DELETE", "PATCH"));
        corsConfiguration.setMaxAge(3600000L);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);

        CorsFilter corsFilter = new CorsFilter(source);
        FilterRegistrationBean<CorsFilter> filter = new FilterRegistrationBean<>(corsFilter);
        filter.setOrder(Ordered.HIGHEST_PRECEDENCE);
        return filter;
    }
    
    /**
     * Mapeamento do Cors
     *
     * @param registry o CorsRegistry
     */
    @Override
	public void addCorsMappings( CorsRegistry registry ) {
		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
		.allowedHeaders("*")
		.allowCredentials(true).maxAge(3600);
		WebMvcConfigurer.super.addCorsMappings(registry);
	}
	
	/**
	 * Configuracao do content negotiation.
	 * Define os tipos de midias e cabecalhos
	 * @param configurer the configurer
	 */
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer ) {
		configurer.favorPathExtension(false)
		.favorParameter(false)
		.ignoreAcceptHeader(false)
		.parameterName("mediaType")
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON);
	}

}
