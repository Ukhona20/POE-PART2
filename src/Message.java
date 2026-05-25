public class Message {
    private static int messageCounter = 0;
    private final int messageNumber;
    private final String messageID;
    private final String recipientNumber;
    private final String messageText;
    private final String messageHash;
    private String status;

    public Message(String recipientNumber, String messageText) {
        this.messageNumber = messageCounter;
        this.recipientNumber = recipientNumber;
        this.messageText = messageText;
        this.messageID = String.valueOf((long)(Math.random() * 9000000000L) + 1000000000L);
        this.messageHash = createMessageHash();
        this.status = "Pending";
        messageCounter++;
    }

    public String checkMessageLength() {
        if (messageText.length() <= 250) return "Message ready to send.";
        int excess = messageText.length() - 250;
        return "Message exceeds 250 characters by " + excess + " [enter number here]; please reduce the size.";
    }

    public String checkRecipientCell() {
        if (recipientNumber != null && recipientNumber.startsWith("+") && recipientNumber.substring(1).matches("\\d+"))
            return "Cell phone number successfully captured.";
        return "Cell phone number is incorrectly formatted or does not contain an international code. Please correct the number and try again.";
    }

    public String createMessageHash() {
        if (messageText==null || messageText.trim().isEmpty()){
            return messageID.substring(0,2)+":" + messageNumber +":".toUpperCase();
        }
        String idPrefix = messageID.substring(0, 2);
        String[] words = messageText.trim().split("\\s+");
        String first = words[0];
        String last = words[words.length - 1].replaceAll("[^a-zA-Z0-9]$", "");
        return (idPrefix + ":" + messageNumber + ":" + (first + last)).toUpperCase();
    }

    public String sendMessage()      { status = "Sent";        return "Message successfully sent."; }
    public String disregardMessage() { status = "Disregarded"; return "Press 0 to delete the message."; }
    public String storeMessage()     { status = "Stored";      return "Message successfully stored."; }

    public String printMessage() {
        return "Message ID: " + messageID + "\nMessage Hash: " + messageHash + "\nRecipient: " + recipientNumber + "\nMessage: " + messageText;
    }

    public static void resetCounter() { messageCounter = 0; }
    public static int getMessageCounter() { return messageCounter; }
    public String getMessageID()       { return messageID; }
    public String getMessageHash()     { return messageHash; }
    public String getRecipientNumber() { return recipientNumber; }
    public String getMessageText()     { return messageText; }
    public String getStatus()          { return status; }
