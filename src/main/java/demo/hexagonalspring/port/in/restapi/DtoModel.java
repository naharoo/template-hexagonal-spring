package demo.hexagonalspring.port.in.restapi;

import java.io.Serializable;

public abstract class DtoModel implements Serializable {

  @Override
  public abstract int hashCode();

  @Override
  public abstract boolean equals(final Object other);

  @Override
  public abstract String toString();
}
