package demoRecords;

record PersonR_CustomConstructor_V2(long id, String name, String nationality, int age) {

    // Compact constructor.
    public PersonR_CustomConstructor_V2 {
        // CALLS CANONICAL CTOR HERE
        if (id <= 0 || name == null || nationality == null || age <= 0)
            throw new IllegalArgumentException(String.format("Illegal arguments %d, %s, %s, %d", id, name, nationality, age));
    }
}
