package jp.prototype.web;

import java.nio.charset.StandardCharsets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication
@ComponentScan(basePackages = { "jp.prototype.web", "jp.prototype.domain" })
@EntityScan("jp.prototype.domain.model")
@EnableJpaRepositories("jp.prototype.domain.repository")
public class WebApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebApplication.class, args);
  }

  @Bean
  public CharacterEncodingFilter characterEncodingFilter() {
    final CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
    characterEncodingFilter.setEncoding(StandardCharsets.UTF_8.name());
    characterEncodingFilter.setForceEncoding(true);
    return characterEncodingFilter;
  }

  @Bean
  public RestTemplate getRestTemplate() {

    RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
    return restTemplateBuilder.build();
//    return new RestTemplate();
  }

}
