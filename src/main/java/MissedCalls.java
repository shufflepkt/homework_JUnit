import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

public class MissedCalls {
    private Map<LocalDateTime, String> missedCalls = new TreeMap<>();
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    public void addMissedCall(LocalDateTime time, String number) {
        missedCalls.put(time, number);
    }

    public void showMissedCalls(PhoneBook pb) {
        System.out.println("Пропущенные звонки:");
        for (Map.Entry<LocalDateTime, String> entry : missedCalls.entrySet()) {
            Contact contact = pb.getContactByNumberForMissedCalls(entry.getValue());
            if (contact != null) {
                System.out.println("- " + FORMATTER.format(entry.getKey()) + ", " + contact.getName());
            } else {
                System.out.println("- " + FORMATTER.format(entry.getKey()) + ", " + entry.getValue());
            }
        }
    }
}