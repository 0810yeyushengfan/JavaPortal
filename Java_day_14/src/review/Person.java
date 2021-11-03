package review;

import java.util.Objects;

public class Person {

    //@Override
    //public boolean equals(Object o) {
    //    if (this == o) return true;
    //    if (o == null || getClass() != o.getClass()) return false;
    //    Person person = (Person) o;
    //    return age == person.age && Objects.equals(name, person.name);
    //}
    public boolean equals(Object obj){
        if(obj == this){
            return true;
        }
        if(obj instanceof Person){
            Person u = (Person) obj;
            return this.age == u.age && this.name.equals(u.name);
        }
        return false;
    }


    String name;
    int age;
    public Person() {
    }
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
