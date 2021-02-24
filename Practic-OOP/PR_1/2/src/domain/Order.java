package domain;

public class Order {
    
    private int id;
    private String name;
    private String courier;
    private String dateTime;
    private int type;

    public Order(int id, String name, String courier, String dateTime, int type) {
        this.id = id;
        this.name = name;
        this.courier = courier;
        this.dateTime = dateTime;
        this.type = type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }
    
    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Id: " + id + "\nName: " + name + "\nCourier: " + courier + "\nDate Time: " + dateTime + "\nType: " + type;
    }
}
