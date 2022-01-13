package no.ibear.services;

import no.ibear.entities.Fruit;
import no.ibear.entities.FruitCategory;

public interface FruitService {

  boolean isFruit(Fruit fruit);

  FruitCategory categorise(Fruit fruit);
}
