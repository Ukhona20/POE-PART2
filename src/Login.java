public class Login {

    private String UserName;
    private String Password;
    private String firstName;
    private String lastName;

    public Login(String UserName, String Password, String firstName, String lastName) {
        UserName = UserName;
        Password = Password;
        firstName = firstName;
        lastName = lastName;
    }

    public String loginUser(String enteredUserName, String enteredPassword) {
        if (enteredUserName.equals(this.UserName) && enteredPassword.equals(this.Password)) {
            return "Welcome" + " " + firstName + " " + "It is great to see you again";
        } else {
            return "UserName or Password incorrect. Please try again.";
        }
    }





}

