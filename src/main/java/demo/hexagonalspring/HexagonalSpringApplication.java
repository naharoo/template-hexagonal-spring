package demo.hexagonalspring;

import static org.springframework.boot.Banner.Mode.OFF;

import demo.hexagonalspring.config.HexagonalSpringProperties;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication(exclude = ErrorMvcAutoConfiguration.class)
@EnableConfigurationProperties(HexagonalSpringProperties.class)
public class HexagonalSpringApplication {

  public static void main(final String... args) {
    new SpringApplicationBuilder()
        .sources(HexagonalSpringApplication.class)
        .bannerMode(OFF)
        .run(args);
  }
}
