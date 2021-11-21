package homework;

/*
 * Задание
 * Создайте класс Animal
 * Опишите в нем 3 различных поля, создайте конструктор, методы.
 * Создайте файл и выполните сериализацию объекта Animal.
 *
 * Задание 2
 * Необходимо осуществить десериализацию с файла предыдущего проекта(Animal) и вывести на экран содержимое.
 * */

import java.io.*;

public class Extra {
    public static void main(String[] args) {
        File file = new File("./src/homework/animal.txt");
        Animal animal = new Animal("Lion", 5, false);

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            oos.writeObject(animal);

            Animal newAnimal = (Animal) ois.readObject();

            System.out.println(newAnimal);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class Animal implements Serializable {
    private String name;
    private int age;
    private boolean isAquatic;

    public Animal() {
    }

    public Animal(String name, int age, boolean isAquatic) {
        this.name = name;
        this.age = age;
        this.isAquatic = isAquatic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isAquatic() {
        return isAquatic;
    }

    public void setAquatic(boolean aquatic) {
        isAquatic = aquatic;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", isAquatic=" + isAquatic +
                '}';
    }
}