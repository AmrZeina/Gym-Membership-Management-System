package lab4;

abstract class Person {

    private String name;
    private String id;
    private String email;
    private String phoneNumber;
    abstract public String lineRepresentation();

    abstract public String getSearchKey();

}
