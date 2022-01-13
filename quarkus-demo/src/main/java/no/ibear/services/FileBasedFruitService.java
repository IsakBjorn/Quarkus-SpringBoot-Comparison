package no.ibear.services;

import io.quarkus.arc.profile.IfBuildProfile;
import javax.enterprise.context.ApplicationScoped;
import no.ibear.entities.Fruit;
import no.ibear.entities.FruitCategory;

@ApplicationScoped
@IfBuildProfile("prod")
public class FileBasedFruitService implements FruitService{

  @Override
  public boolean isFruit(Fruit fruit) {
    return false;
  }

  @Override
  public FruitCategory categorise(Fruit fruit) {
    return null;
  }
}
