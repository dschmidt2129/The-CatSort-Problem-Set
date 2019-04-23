/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package the.catsort.problem.set;


/**
 *
 * @author david
 */
public class Cat {

    private String name;
    private final int weight;
    private final int age;

    public Cat(String name, int weight, int age) {
        this.name = name;
        this.weight = weight;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Cat{" + "name=" + name + ", weight=" + weight + ", age=" + age + '}';
    }

    public int getWeight() {
        return weight;
    }

    public String getName() {
        return name;
    }

    public String setName(String catName) {
        name = catName;
        return name;
    }

}
