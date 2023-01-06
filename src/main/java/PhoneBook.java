import java.util.*;

public class PhoneBook {
    private Map<String, List<Contact>> phoneBook = new HashMap<>();
    private Map<String, Contact> phoneBookForMissedCalls = new HashMap<>();

    public void addGroup(String group) {
        if (phoneBook.containsKey(group)) {
            System.out.println("Группа " + group + " уже имеется в телефонном справочнике");
        } else {
            phoneBook.put(group, new LinkedList<Contact>());
            System.out.println("Группа " + group + " успешно добавлена в телефонный справочник");
        }
    }

    public void addContactToGroup(String group, Contact contact) {
        addContactToPhoneBookForMissedCalls(contact.getNumber(), contact);

        if (phoneBook.containsKey(group)) {
            List<Contact> list = phoneBook.get(group);

            if (list.contains(contact)) {
                System.out.println("Контакт " + contact + " уже имеется в группе " + group);
                return;
            }

            list.add(contact);
            phoneBook.put(group, list);
            System.out.println("Контакт " + contact + " добавлен в группу " + group);
            return;
        }

        List<Contact> list = new ArrayList<>();
        list.add(contact);
        phoneBook.put(group, list);
        System.out.println("Создана новая группа " + group + " и в нее добавлен первый контакт " + contact);
    }

    protected void addContactToPhoneBookForMissedCalls(String number, Contact contact) {
        if (phoneBookForMissedCalls.containsKey(number)) return;
        phoneBookForMissedCalls.put(number, contact);
    }

    public Contact findContactInGroup(Contact contact, String group) {
        if (phoneBook.containsKey(group)) {
            List<Contact> list = phoneBook.get(group);

            int i = list.indexOf(contact);
            if (i == -1) {
                System.out.println("Контакт " + contact + " отсутствует в группе " + group);
                return null;
            }

            System.out.println("Контакт " + contact + " имеется в группе " + group);
            return list.get(i);
        }
        System.out.println("Группа " + group + " отсутствует в телефонном справочнике");
        return null;
    }

    public List<Contact> findContactsByGroup(String group) {
        if (phoneBook.containsKey(group)) {
            return new ArrayList<>(phoneBook.get(group));
        }
        System.out.println("Группа " + group + " отсутствует в телефонном справочнике");
        return null;
    }

    public Contact findContactByNumber(String number) {
        for (String group : phoneBook.keySet()) {
            List<Contact> list = phoneBook.get(group);

            for (Contact contact : list) {
                if (contact.getNumber().equals(number)) {
                    System.out.println("Номер " + number + " принадлежит контакту " + contact.getName());
                    return contact;
                }
            }
        }
        System.out.println("Контакта с номером " + number + " в телефонном справочнике не обнаружено");
        return null;
    }

    public Contact getContactByNumber(String number) {
        for (String group : phoneBook.keySet()) {
            List<Contact> list = phoneBook.get(group);

            for (Contact contact : list) {
                if (contact.getNumber().equals(number)) {
                    return contact;
                }
            }
        }
        return null;
    }

    public Contact getContactByNumberForMissedCalls(String number) {
        if (number == null || !phoneBookForMissedCalls.containsKey(number))
            return null;
        return phoneBookForMissedCalls.get(number);
    }
}