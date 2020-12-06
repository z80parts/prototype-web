package jp.prototype.web;

import java.nio.charset.StandardCharsets;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.filter.CharacterEncodingFilter;

@SpringBootApplication(scanBasePackages = { "jp.prototype" })
@EnableJpaRepositories(basePackages = { "jp.prototype.domain.repository" })
@EntityScan(basePackages = { "jp.prototype.domain.model" })
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
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
  }

}
