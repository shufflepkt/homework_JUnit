import java.util.Objects;

public class Contact {
    private final String name;
    private final String number;

    public Contact(String name, String number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, number);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(Contact.class)) {
            return false;
        }

        if (this == obj) return true;

        Contact contact = (Contact) obj;
        return name.equals(contact.name) && number.equals(contact.number);
    }

    @Override
    public String toString() {
        return name + ", тел.: " + number;
    }

    public String getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }
}