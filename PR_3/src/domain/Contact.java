package domain;

public class Contact extends Person{

    protected String address;

    public Contact(int id, String firstName, String lastName, String address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }
    
    public Contact() {
        this(5, "Petya", "Poroh", "Pushkin St.");
    }
    
    @Override
    public int getId() {
        return super.getId();
    }

    @Override
    public void setId(int id) {
        if (id >= 0) {
            super.setId(id);
        }
        else {
            System.out.println("Id не може бути менше нуля!");
        }
    }

    @Override
    public String getFirstName() {
        return super.getFirstName();
    }

    @Override
    public void setFirstName(String firstName) {
        super.setFirstName(firstName);
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nAddress: " + getAddress();
    }
}
