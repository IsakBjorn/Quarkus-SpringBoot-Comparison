package no.ibear.services;

import static no.ibear.entities.FruitCategory.TASTY;

import io.quarkus.arc.DefaultBean;
import javax.enterprise.context.ApplicationScoped;
import no.ibear.entities.Fruit;
import no.ibear.entities.FruitCategory;

@ApplicationScoped
@DefaultBean
public class MockFruitService implements FruitService {

  @Override
  public boolean isFruit(Fruit fruit) {
    return true;
  }

  @Override
  public FruitCategory categorise(Fruit fruit) {
    return TASTY;
  }
}
