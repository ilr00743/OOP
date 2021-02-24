package domain;

public class Contact {
            
    protected int id;
    protected String firstName;
    protected String lastName;
    protected String address;

    public Contact() {
        id = 0;
        firstName = "First name";
        lastName = "Last name";
        address = "Address";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if (id >= 0) {
            this.id = id;
        }
        else {
            System.out.println("Id не може бути менше нуля!");
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return "ID: " + getId() + "\nFirst name: " + getFirstName() + "\nLast name: " + getLastName() + "\nAddress: " + getAddress();
    }
}
