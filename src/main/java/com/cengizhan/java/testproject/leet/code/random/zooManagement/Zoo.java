package com.cengizhan.java.testproject.leet.code.random.zooManagement;

import java.util.*;
import java.util.stream.Collectors;

class Zoo implements IZoo {
    private final List<IAnimal> animals;

    Zoo(List<IAnimal> animals) {
        this.animals = animals;
    }

    Zoo() {
        animals = new ArrayList<>();
    }


    @Override
    public void addAnimal(IAnimal animal) {
        animals.add(animal);
    }

    @Override
    public void removeAnimal(int id) {
        animals.remove(id);
    }

    @Override
    public int countAnimals() {
        return animals.size();
    }

    @Override
    public List<IAnimal> getAnimalsBySpecies(String species) {
        return animals.stream().filter(x -> x.getSpecies().equals(species)).collect(Collectors.toList());
    }

    @Override
    public List<Map.Entry<Integer, List<IAnimal>>> getAnimalsByAge() {
        return new ArrayList<>(animals.stream().collect(Collectors.groupingBy(IAnimal::getAge)).entrySet());
    }
}

