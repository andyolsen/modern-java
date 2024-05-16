package demoRecords;

final class PersonC {

    private final long id;
    private final String name;
    private final String nationality;
    private final int age;

    public PersonC(long id, String name, String nationality, int age) {
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
    }

    public long id() {
        return id;
    }

    public String name() {
        return name;
    }

    public String nationality() {
        return nationality;
    }

    public int age() {
        return age;
    }

    @Override
    public String toString() {
        return String.format("PersonC[id=%d, name=%s, nationality=%s, age=%d]", id, name, nationality, age);
    }

    @Override
    public int hashCode() {
        // Dummy implementation.
        return Long.hashCode(id) + name.hashCode() + nationality.hashCode() + Integer.hashCode(age);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PersonC otherP)) {
            return false;
        }
        return this.id == otherP.id &&
               this.name.equals(otherP.name) &&
               this.nationality.equals(otherP.nationality) &&
               this.age == otherP.age;
    }
}