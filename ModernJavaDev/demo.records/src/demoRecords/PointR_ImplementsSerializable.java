package demoRecords;

import java.io.Serializable;

record PointR_ImplementsSerializable(double x, double y) implements Serializable {

    // Note, you can't define custom serialization methods for records.
    /*
    private void writeObject(ObjectOutputStream oos) throws IOException {
        System.out.println("NOPE, YOU CAN'T DO THIS!");
        oos.writeDouble(x);
        oos.writeDouble(y);
    }

    private void readObject(ObjectInputStream ois) throws ClassNotFoundException, IOException {
        System.out.println("NOPE, YOU CAN'T DO THIS!");
        x = ois.readDouble();
        y = ois.readDouble();
    }
    */
}
