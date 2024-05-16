package demoRecords;

record PersonR_OverridingMethods(long id, String name, String nationality, int age) {

    @Override
    public String toString() {
        return String.format("[%d] %s is %s, age %d", id, name, nationality, age);
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof PersonR_OverridingMethods otherP)) {
            return false;
        }
        return this.id == otherP.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
