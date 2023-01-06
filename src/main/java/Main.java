import java.time.LocalDateTime;

public class Main {
    public static void contactCreated(Contact contact) {
        System.out.println("Создан новый контакт: " + contact);
    }

    public static void main(String[] args) throws Exception {
        PhoneBook pb = new PhoneBook();

        Contact contact1 = new Contact("Alex", "+79059995448");
        contactCreated(contact1);
        Contact contact2 = new Contact("Nick", "+79106666666");
        contactCreated(contact2);
        Contact contact3 = new Contact("Tom", "+79457777777");
        contactCreated(contact3);
        Contact contact4 = new Contact("John", "+79019999999");
        contactCreated(contact4);
        System.out.println();

        String workGroup = "Work";
        String friendsGroup = "Friends";

        pb.addContactToGroup(workGroup, contact1);
        pb.addContactToGroup(workGroup, contact2);
        pb.addContactToGroup(workGroup, contact3);
        pb.addContactToGroup(friendsGroup, contact3);
        pb.addContactToGroup(friendsGroup, contact4);
        pb.addContactToGroup(friendsGroup, contact4);
        System.out.println();

        Contact testContact1 = pb.findContactInGroup(contact1, workGroup);
        System.out.println(testContact1);
        pb.findContactInGroup(contact2, friendsGroup);
        pb.findContactInGroup(contact3, "Football");
        System.out.println();

        String footballGroup = "Football";
        pb.addGroup(footballGroup);
        pb.addContactToGroup(footballGroup, contact1);
        System.out.println();


        String number1 = contact4.getNumber();
        String number2 = "+77770000001";

        Contact testContact2 = pb.findContactByNumber(number1);
        System.out.println(testContact2);
        pb.findContactByNumber(number2);
        System.out.println();

        MissedCalls missedCalls = new MissedCalls();

        missedCalls.addMissedCall(LocalDateTime.now(), "+79059995448");
        Thread.sleep(3000);
        missedCalls.addMissedCall(LocalDateTime.now(), "+79106666666");
        Thread.sleep(3000);
        missedCalls.addMissedCall(LocalDateTime.now(), "+77770000002");

        missedCalls.showMissedCalls(pb);
    }
}