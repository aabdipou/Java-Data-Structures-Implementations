package UndirectedGenericGraph;

public class Person {
    int age;
    String firstName;
    String lastName;
    public boolean visited;
    
    public Person(int age, String firstName, String lastName){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString(){
        return firstName+ " "+ lastName;
    }
}
