package demoRecords;

record PointR_ImplementsInterface(double x, double y) implements Loggable {

    @Override
    public void log() {
        getStream().println(this.toString());
    }
}
