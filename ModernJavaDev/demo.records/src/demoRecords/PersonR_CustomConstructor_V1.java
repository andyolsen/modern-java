package demoRecords;

record PersonR_CustomConstructor_V1(long id, String name, String nationality, int age) {

    public PersonR_CustomConstructor_V1(long id, String name, String nationality, int age) {

        // First validate the parameters...
        if (id <= 0 || name == null || nationality == null || age <= 0)
            throw new IllegalArgumentException(String.format("Illegal arguments %d, %s, %s, %d", id, name, nationality, age));

        // If all good, initialize fields with parameters.
        this.id = id;
        this.name = name;
        this.nationality = nationality;
        this.age = age;
    }
}
