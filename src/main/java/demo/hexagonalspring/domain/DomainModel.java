package demo.hexagonalspring.domain;

import java.io.Serializable;

public abstract class DomainModel implements Serializable {

  @Override
  public abstract int hashCode();

  @Override
  public abstract boolean equals(final Object other);

  @Override
  public abstract String toString();
}
