package demoRecords;

record PointR_Reflection(double x, double y) {

    public PointR_Reflection(String sx, String sy) {
        this(parse(sx), parse(sy));
    }

    private static double parse(String s) {
        try {
            return Double.parseDouble(s);
        }
        catch (NumberFormatException ex) {
            return 0.0;
        }
    }
}
