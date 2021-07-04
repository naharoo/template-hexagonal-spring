package demo.hexagonalspring.domain;

import static demo.hexagonalspring.config.WebProblemConfiguration.ProblemTitle.RESOURCE_NOT_FOUND;
import static java.lang.String.format;
import static org.springframework.util.StringUtils.hasText;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

public class DomainModelNotFoundException extends AbstractThrowableProblem {

  private static final String MESSAGE_TEMPLATE_WITH_IDENTIFIER = "No %s can be found by given %s.";
  private static final String MESSAGE_TEMPLATE_WITHOUT_IDENTIFIER = "No %s can be found.";

  public DomainModelNotFoundException(final Class<?> resourceClass, final String identifier) {
    super(
        null,
        RESOURCE_NOT_FOUND.name(),
        Status.NOT_FOUND,
        formatMessage(resourceClass, identifier));
  }

  public DomainModelNotFoundException(final Class<?> resourceClass) {
    this(resourceClass, null);
  }

  private static String formatMessage(final Class<?> resourceClass, final String identifier) {
    final String resourceSimpleName = resourceClass.getSimpleName();
    if (hasText(identifier)) {
      return format(MESSAGE_TEMPLATE_WITH_IDENTIFIER, resourceSimpleName, identifier);
    } else {
      return format(MESSAGE_TEMPLATE_WITHOUT_IDENTIFIER, resourceSimpleName);
    }
  }
}
