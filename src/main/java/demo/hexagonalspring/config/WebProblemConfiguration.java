package demo.hexagonalspring.config;

import com.fasterxml.jackson.databind.Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.zalando.problem.ProblemModule;
import org.zalando.problem.spring.web.advice.ProblemHandling;
import org.zalando.problem.violations.ConstraintViolationProblemModule;

@Configuration
@ControllerAdvice
public class WebProblemConfiguration implements ProblemHandling {

  @Bean
  public Module problemModule() {
    return new ProblemModule();
  }

  @Bean
  public Module constraintViolationProblemModule() {
    return new ConstraintViolationProblemModule();
  }

  public enum ProblemTitle {
    RESOURCE_NOT_FOUND
  }
}
