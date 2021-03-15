package domain;

public class Person{
    
    protected int id;
    protected String firstName;
    protected String lastName;
    
    public Person() {
        this.id = 0;
        this.firstName = "Name";
        this.lastName = "Last name";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
        else {
            System.out.println("ID не може бути менше нуля!!!");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + "\nFirst name: " + firstName + "\nLast name: " + lastName;
    }
}