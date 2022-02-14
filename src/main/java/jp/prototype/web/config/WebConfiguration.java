package jp.prototype.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {

  @Value("${prototype.world:World}")
  String world;

}
