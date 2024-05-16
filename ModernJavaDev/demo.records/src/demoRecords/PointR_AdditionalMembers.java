package demoRecords;

record PointR_AdditionalMembers(double x, double y) {

    public boolean isOrigin() {
        return x == 0 && y == 0;
    }

    public PointR_AdditionalMembers getPointReflectedInYAxis() {
        return new PointR_AdditionalMembers(-x, y);
    }

    public PointR_AdditionalMembers getPointReflectedInXAxis() {
        return new PointR_AdditionalMembers(x, -y);
    }

    public static double granularity = 0.01;

    public static PointR_AdditionalMembers getOrigin() {
        return new PointR_AdditionalMembers(0, 0);
    }
}
