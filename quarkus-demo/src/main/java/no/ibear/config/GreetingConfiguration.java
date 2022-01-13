package no.ibear.config;

import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;
import io.smallrye.config.WithName;
import java.util.List;
import java.util.Optional;
import javax.validation.constraints.Positive;

@ConfigMapping(prefix = "greeting")
public interface GreetingConfiguration {
  
  String greeting();

  @WithName("suffix")
  @WithDefault("Señor")
  String getSuffix();

  @WithName("name")
  Optional<String> getName();

  @WithName("content")
  ContentConfig getContent();
  interface ContentConfig {
    @Positive
    @WithName("prizeAmount")
    Integer getPrizeAmount();

    @WithName("recipients")
    List<String> getRecipients();
  }
}
