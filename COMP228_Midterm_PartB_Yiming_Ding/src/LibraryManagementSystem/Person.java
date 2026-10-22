package LibraryManagementSystem;

public abstract class Person {
    protected static int personCount = 0;
    
    protected final String personId;
    protected final String name;
    protected final String phoneNumber;

    public Person(String personId, String name, String phoneNumber) {
        if (personId == null || name == null ) {
            throw new IllegalArgumentException("Person ID and Name cannot be null or empty.");
        }
        this.personId = personId;
        this.name = name;
        this.phoneNumber = phoneNumber;
        personCount++;
    }

    public static int getPersonCount() {
        return personCount;
    }

    public String getPersonId() {
        return personId;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void displayBasicDetails() {
        System.out.println("ID: " + personId + " | Name: " + name + " | Phone: " + phoneNumber);
    }

    public abstract String getRoleDescription();

    @Override
    public String toString() {
        return "Person{personId='" + personId + "', name='" + name + "', phoneNumber='" + phoneNumber + "'}";
    }
}