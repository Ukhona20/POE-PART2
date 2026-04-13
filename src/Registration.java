import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration {
    Scanner gon = new Scanner(System.in);
    public String Username;
    public String Password;
    public String PhoneNumber;
    public String firstName;
    public  String lastName;


    public boolean checkUsername(String Username) {
        return Username.length()<=5 && Username.contains("_"); //This is the way to do the UserName

    }
     //This is the way to do the password using the characters below
    public boolean checkPassword(String Password) {
       boolean hasDigit = false;
       boolean hasUpper = false;
       boolean hasLower = false;
       boolean hasSpecial=false;
       for (char c : Password.toCharArray()){
           if (Character.isDigit(c)){
               hasDigit=true;
           } else if (Character.isLowerCase(c)){
               hasLower=true;
           }else if (Character.isUpperCase(c)){
               hasUpper = true;
           }else {
               Pattern sPat = Pattern.compile("[^a-zA-Z0-9]");
               Matcher sMat = sPat.matcher(String.valueOf(c));
               if (sMat.find()){
                   hasSpecial = true;
               }
           }
       }

        return hasDigit&&hasLower&&hasUpper&&hasSpecial;
    }

      public boolean checkPhoneNumber(String PhoneNumber) {

          return PhoneNumber.matches("(\\+27|8) [0+9] {9}");
      }


        public void Register() {


        while (true) {
            System.out.println("Enter UserName (must contain '_' and not be more than 5:");
            Username = gon.nextLine();
            if (!checkUsername(Username)) {
                System.out.println("Invalid UserName try again");
            } else {
                System.out.println("Valid UserName");
                break;
            }
            }
        while (true) {
            System.out.println("Enter Password (must be 8 character,capital,number,special char:");
            Password = gon.nextLine();
            if (!checkPassword(Password)){
                System.out.println("Invalid Password try again");
            } else {
                System.out.println("Valid Password");
                break;
            }
        }

        while (true){
            System.out.println("Enter phoneNumber (they must have [0-9] and must include +27:"); //This is the phoneNumber of South Africa citizens
            PhoneNumber = gon.nextLine();

            if (PhoneNumber.startsWith("+27") && PhoneNumber.length()<=12) {
                System.out.println("Valid Sa number");
                break;
            } else {
                System.out.println("Invalid Sa PhoneNumber");

            }

        }

    }
}