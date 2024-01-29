package com.cengizhan.java.testproject.leet.code.random.interview.zooManagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        List<IAnimal> animals = new ArrayList<>();
        IZoo zoo = new Zoo(animals);
        int aCount = Integer.parseInt(br.readLine().trim());
        for (int i = 1; i <= aCount; i++) {
            String[] a = br.readLine().trim().split(" ");
            IAnimal e = new Animal();
            e.setId(Integer.parseInt(a[0]));
            e.setSpecies(a[1]);
            e.setName(a[2]);
            e.setAge(Integer.parseInt(a[3]));
            zoo.addAnimal(e);
        }

        out.println("There are " + zoo.countAnimals() + " animals in the zoo");
        String[] b = br.readLine().trim().split(" ");
        String species = b[0];
        List<IAnimal> specAnimals = zoo.getAnimalsBySpecies(species);
        out.println(species + ":");
        for (IAnimal sp : specAnimals) {
            out.println("" + sp.getName() + " (" + sp.getAge() + " years old)");
        }
        List<Map.Entry<Integer, List<IAnimal>>> animalsByAge = zoo.getAnimalsByAge();
        out.println("Animals by age:");
        for (Map.Entry<Integer, List<IAnimal>> groups : animalsByAge) {
            out.println("" + groups.getKey() + " year(s) old:");
            for (IAnimal animal : groups.getValue()) {
                out.println("- " + animal.getName() + " (" + animal.getSpecies() + ")");
            }
        }
        String[] c = br.readLine().trim().split(" ");
        int id = Integer.parseInt(c[0]);
        zoo.removeAnimal(id);
        out.println("There are now " + zoo.countAnimals() + " animals in the zoo");

        out.flush();
        out.close();
    }
}
