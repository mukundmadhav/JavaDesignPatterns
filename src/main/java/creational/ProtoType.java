package creational;

import java.util.ArrayList;
import java.util.List;

interface Proto {
    Proto clone();
}

public class ProtoType implements Proto {

    String name;
    Integer age;
    List<String> hobbies;

    public ProtoType(String name, Integer age, List<String> hobbies) {
        this.name = name;
        this.age = age;
        this.hobbies = hobbies;
    }


    @Override
    public Proto clone() {
        List<String> hobbiesCopy = new ArrayList<>(hobbies);
        return new ProtoType(this.name, this.age, hobbiesCopy);
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Hobbies: " + hobbies;
    }

}
