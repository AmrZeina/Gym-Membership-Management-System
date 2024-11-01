package lab4;

public class ClassDatabase extends Database<Class> {

    public ClassDatabase(String filename) {
        super(filename);
    }

    @Override
    public Class createRecordFrom(String line) {

        String[] temp = line.split(",");
        Class class1 = new Class(temp[0], temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]));
        return class1;
    }
}
