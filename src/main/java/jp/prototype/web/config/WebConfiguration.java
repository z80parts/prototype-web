package jp.prototype.web.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.prototype.web.model.WorldModel;

@Configuration
public class WebConfiguration {

  @Value("${prototype.world:World}")
  String world;

  @Bean
  public WorldModel worldModel() {
    WorldModel model = new WorldModel();
    model.setValue(world);
    return model;
  }

}
