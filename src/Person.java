import java.util.Objects;

public class Person {
    private String name;
    private int age;
    private String mail;

    public Person(String name, int age) {
        setAge(age);
        setName(name);
        mail= this.name.replace("_",".")
                .concat("@ironhack.com");

    }

    //------------------------------------------------------------------Getter & Setters
    public void setName(String name) {
        this.name = name.toLowerCase().trim().replace(" ", "_");
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }
    //------------------------------------------------------------------Getter & Setters


    @Override
    public String toString() {
        return "Person {"+
                "name: "+ name
                +" age: "+ age
                +" mail: "+ mail+"}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age;// && Objects.equals(name, person.name) && Objects.equals(mail, person.mail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, mail);
    }
}
