package com.cengizhan.java.testproject.leet.code.random.interview.zooManagement;

import java.util.List;
import java.util.Map;

interface IZoo {
    void addAnimal(IAnimal animal);

    void removeAnimal(int id);

    int countAnimals();

    List<IAnimal> getAnimalsBySpecies(String species);

    List<Map.Entry<Integer, List<IAnimal>>> getAnimalsByAge();
}
