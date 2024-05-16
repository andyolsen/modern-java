package demoRecords;

@SuppressWarnings("unchecked")
record PointR_WithAnnotations(
    @MyAnnotation("Primary axis") double x,
    @MyAnnotation("Secondary axis") double y,
    double z) {
}
