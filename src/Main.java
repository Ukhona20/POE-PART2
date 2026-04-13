//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter
void main() {
    Registration registration = new Registration();
registration.Register();

Scanner gon=new Scanner(System.in);
System.out.println("Please log in now");
System.out.println("Enter UserName: ");
String loginUser=gon.nextLine();
System.out.println("Enter Password: ");
String loginPass = gon.nextLine();

Login login = new Login(registration.Username, registration.Password, registration.firstName, registration.lastName);
System.out.println(login.loginUser(loginUser,loginPass));
}

