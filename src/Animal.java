public class Animal {
    private String name;
    private String diet;
    private boolean extincted;

    public Animal(String name, String diet, boolean extincted) {
        this.name = name;
        this.diet = diet;
        this.extincted = extincted;
    }

    public String getName() {
        return name;
    }

    public String getDiet() {
        return diet;
    }

    public boolean isExtincted() {
        return extincted;
    }

    @Override
    public String toString() {
        return (isExtincted()?"I was a ":"I am a ")+ name + "\nMy diet is: " + diet;
    }
}
