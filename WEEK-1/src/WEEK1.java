
import java.util.*;

public class WEEK1 {
    private HashMap<String, Integer> usernameMap;
    private HashMap<String, Integer> attemptFrequency;

    public WEEK1() {
        usernameMap = new HashMap<>();
        attemptFrequency = new HashMap<>();
    }

    public boolean checkAvailability(String username) {
        attemptFrequency.put(username, Integer.valueOf(attemptFrequency.getOrDefault(username, Integer.valueOf(0)) + 1));

        if (usernameMap.containsKey(username)) {
            return false;
        }

        return true;
    }

    public void registerUser(String username, int userId) {
        usernameMap.put(username, Integer.valueOf(userId));
    }

    public List<String> suggestAlternatives(String username) {
        List<String> suggestions = new ArrayList<>();

        suggestions.add(username + "1");
        suggestions.add(username + "2");
        suggestions.add(username + "123");

        if (username.contains("_")) {
            suggestions.add(username.replace("_", "."));
        }

        return suggestions;
    }

    public String getMostAttempted() {
        String mostAttempted = "";
        int max = 0;

        for (String user : attemptFrequency.keySet()) {
            if (attemptFrequency.get(user) > max) {
                max = attemptFrequency.get(user);
                mostAttempted = user;
            }
        }

        return mostAttempted + " (" + max + " attempts)";
    }

    public static void main(String[] args) {

        WEEK1 system = new WEEK1();

        system.registerUser("john_doe", 101);
        system.registerUser("admin", 102);

        System.out.println("Check john_doe: " + system.checkAvailability("john_doe"));
        System.out.println("Check jane_smith: " + system.checkAvailability("jane_smith"));

        System.out.println("Suggestions: " + system.suggestAlternatives("john_doe"));

        system.checkAvailability("admin");
        system.checkAvailability("admin");
        system.checkAvailability("admin");

        System.out.println("Most Attempted Username: " + system.getMostAttempted());
    }
}