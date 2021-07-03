package demo.hexagonalspring.domain;

import static java.lang.String.format;
import static org.springframework.util.StringUtils.hasText;

import lombok.Getter;

public class DomainModelNotFoundException extends RuntimeException {

  private static final String MESSAGE_TEMPLATE_WITH_IDENTIFIER = "No %s can be found by given %s.";
  private static final String MESSAGE_TEMPLATE_WITHOUT_IDENTIFIER = "No %s can be found.";

  @Getter private final Class<?> resourceClass;

  public DomainModelNotFoundException(final Class<?> resourceClass, final String identifier) {
    super(formatMessage(resourceClass, identifier));
    this.resourceClass = resourceClass;
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
