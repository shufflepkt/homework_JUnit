import org.junit.jupiter.api.*;

import java.util.ArrayList;
import java.util.List;

public class PhoneBookTests {

    PhoneBook pb;

    @BeforeEach
    public void setup() {
        System.out.println("Test started");
        pb = new PhoneBook();
    }

    @AfterEach
    public void teardown() {
        System.out.println("Test ended");
        pb = null;
    }

    @BeforeAll
    public static void setupAll() {
        System.out.println("All tests started");
    }

    @AfterAll
    public static void teardownAll() {
        System.out.println("All tests ended");
    }


    @Test
    public void findContactByNumberTest() {
        // arrange / given:
        String name = "Alex";
        String number = "+79059995448";
        String groupName = "Test 1 group";
        pb.addContactToGroup(groupName, new Contact(name, number));

        Contact expected = new Contact("Alex", "+79059995448");

        // act / when:
        var result = pb.findContactByNumber(number);

        // assert / then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void notFindingContactInGroupTest() {
        // arrange / given:
        String name = "Nick";
        String number = "+79106666666";
        String groupName = "Test 2 group";
        pb.addContactToGroup(groupName, new Contact(name, number));

        Contact nonExistentContact = new Contact("Alex", "+79059995448");

        Contact expected = null;

        // act / when:
        var result = pb.findContactInGroup(nonExistentContact, groupName);

        // assert / then:
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void findContactsByGroupTest() {
        // arrange / given:
        String name1 = "Nick";
        String number1 = "+79106666666";

        String name2 = "Alex";
        String number2 = "+79059995448";

        String groupName = "Test 2 group";
        pb.addContactToGroup(groupName, new Contact(name1, number1));
        pb.addContactToGroup(groupName, new Contact(name2, number2));

        List<Contact> expected = new ArrayList<>();
        expected.add(new Contact("Nick", "+79106666666"));
        expected.add(new Contact("Alex", "+79059995448"));

        // act / when:
        var result = pb.findContactsByGroup(groupName);

        // assert / then:
        Assertions.assertEquals(expected, result);
    }
}