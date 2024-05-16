package demo.methods;

public class Person { 

    private String name;
    private int age;
    private boolean welsh;

    public static int myStaticCompare(Person p1, Person p2) {
    	return p1.name.compareTo(p2.name);
    }
    
    public int myInstanceCompare(Person other) {
    	return this.age - other.age;
    }
    
    public Person() {
        this.name = "[Unknown]";
        this.age = 0;
        this.welsh = false;
    }

    public Person (String name, int age, boolean welsh) {
        this.name = name;
        this.age = age;
        this.welsh = welsh;
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

    public boolean isWelsh() {
        return welsh;
    }

    public void setWelsh(boolean welsh) {
        this.welsh = welsh;
    }

    @Override
    public String toString() {
        return String.format("%s is %d and %s Welsh", name, age, welsh ? "is" : "sadly is not");
    }
}

