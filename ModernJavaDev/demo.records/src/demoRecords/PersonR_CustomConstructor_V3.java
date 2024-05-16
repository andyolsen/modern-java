package demoRecords;

record PersonR_CustomConstructor_V3(long id, String name, String nationality, int age) {

    public PersonR_CustomConstructor_V3(long id, String fn, String sn, String nat, int age) {
        this(id, fn + " " + sn, nat, age);
    }
}
