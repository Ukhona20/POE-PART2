 import org.junit.Test;
import static org.junit.Assert.*;

public class TestingApp {

   // Registration:Username tests
   @Test
   public void testValidUsername() {
       Registration reg =new Registration();
       assertTrue(reg.checkUsername("abc_"));//current: <=5 characters and contains "_"
   }

   @Test
    public void testInvalidUsernameLong(){
    Registration gon = new Registration();
    assertFalse(gon.checkUsername("asdfgh_"));//because the char are more than 5, too long
   }
   @Test
    public void testInvalidUsernameNoUnderscore(){
    Registration naruto = new Registration();
    assertFalse(naruto.checkUsername("abc"));//Underscore ("_") not included
   }

   // Registration:Password tests
    @Test
    public void testValidPassword(){
    Registration edu = new Registration();
    assertTrue(edu.checkPassword("P@ssword2"));//It has Digit,UpperCase,LowerCase,Special
    }
    @Test
    public void testInvalidPasswordNoDigit(){
       Registration reg = new Registration();
       assertFalse(reg.checkPassword("P@ssword"));//No digit
    }
    @Test
    public void testInvalidPasswordNoUppercase(){
       Registration gon = new Registration();
       assertFalse(gon.checkPassword("passw@rd2"));//does not have NoUppercase
    }
    @Test
   public void testInvalidPasswordNoLowercase() {
        Registration naruto = new Registration();
        assertFalse(naruto.checkPassword("PASSW@RD2"));//DOES NOT HAVE LOWERCASE
    }
    @Test
    public void testInvalidPasswordNoSpecial(){
       Registration s = new Registration();
       assertFalse(s.checkPassword("Password2"));//does not have special
    }

    // Registration:PhoneNumber test
    @Test
    public void testValidPhoneNumber(){
       Registration gon = new Registration();
       assertTrue(gon.checkPhoneNumber("+27613898474"));//start with +27 OR 0 digit
    }
    @Test
    public void testInvalidPhoneNumberTooShort(){
       Registration reg = new Registration();
       assertFalse(reg.checkPhoneNumber("+276797"));// Digit are too short
    }
    // Login: Successful login test
    @Test
    public void testSuccessfulLogin(){
       Login gon = new Login("user12","pass12","Don","Williams");
       String result = gon.loginUser("user12","pass12");
       assertTrue(result.startsWith("Welcome Don Williams"));
       //Usings the current userName and Password will welcome to log in
    }
    //Login: Failed login
    @Test
    public void testFailedLogin(){
       Login naruto=new Login("user12","pass12","Don","Williams");
       String result = naruto.loginUser("Wrong12","Wrong12");
       assertEquals("UserName or Password incorrect.Please try again.",result);
       //When you enter the wrong Name and Password the user will be asked to try again
    }
}
