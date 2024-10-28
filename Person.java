package lab4;

abstract class Person {

    private String name;
    private String id;
    private String email;
    private String phoneNumber;

    public Person(String name, String id, String email, String phoneNumber) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
        
    abstract public String lineRepresentation();

    abstract public String getSearchKey();

}
