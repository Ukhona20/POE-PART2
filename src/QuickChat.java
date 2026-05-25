import java.util.Random;
import java.util.Scanner;

public class QuickChat {

    static int messageCount = 0;

    public static void startChat() {

        Scanner gon = new Scanner(System.in);

        while (true) {

            System.out.println("\nWelcome to Quick Chat");
            System.out.println("Select transaction:");
            System.out.println("Option 1 - Select Quick chat");
            System.out.println("Option 2 - Send Quick chat");
            System.out.println("Option 3 - Quit");

            System.out.print("Enter your choice (1,2,or3): ");

            int choice = gon.nextInt();
            gon.nextLine();

            switch (choice) {

                case 1:

                    System.out.println("You selected: Select Quick chat");
                    System.out.println("This feature is coming soon, please stay tuned.");
                    break;

                case 2:

                    System.out.println("You selected: Send QuickChat");

                    String recipient;

                    do {
                        System.out.print("Enter recipient number (must start with +27 and be exactly 12 characters): ");
                        recipient = gon.nextLine();

                    } while (!(recipient.startsWith("+27") && recipient.length() == 12));

                    System.out.print("Enter your QuickChat (250 characters or less): ");
                    String message = gon.nextLine();

                    if (message.length() > 250) {
                        System.out.println("Please enter a QuickChat of less than 250 characters.");
                        break;
                    }

                    String messageId = generateMessageId();

                    messageCount++;

                    String messageHash =
                            generateMessageHash(messageId, messageCount, message);

                    System.out.println("Message ID: " + messageId);
                    System.out.println("Message Hash: " + messageHash);

                    System.out.println("\nChoose an option:");
                    System.out.println("Option 1 - Send QuickChat");
                    System.out.println("Option 2 - Disregard QuickChat");
                    System.out.println("Option 3 - Store QuickChat to send later");

                    int subChoice = gon.nextInt();
                    gon.nextLine();

                    switch (subChoice) {

                        case 1:
                            System.out.println("QuickChat sent successfully.");
                            break;

                        case 2:
                            System.out.println("QuickChat discarded.");
                            break;

                        case 3:
                            System.out.println("QuickChat stored for later.");
                            break;

                        default:
                            System.out.println("Invalid option.");
                    }

                    break;

                case 3:

                    System.out.println("Quit");
                    return;

                default:

                    System.out.println("Invalid choice, try again");
            }
        }
    }

    private static String generateMessageHash(String messageId,
                                              int count,
                                              String message) {

        String[] words = message.trim().split("\\s+");

        String first = words.length > 0 ? words[0] : "";
        String last = words.length > 1 ? words[words.length - 1] : first;

        return messageId.substring(0, 2)
                + ":" + count
                + ":" + first.toUpperCase()
                + last.toUpperCase();
    }

    private static String generateMessageId() {

        Random gon = new Random();

        String id = "";

        for (int i = 0; i < 10; i++) {
            id += gon.nextInt(10);
        }

        return id;
    }
}
