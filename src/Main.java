import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {

    public final static String Pattern = "[\\w]{5,20}";
    public static void main(String[] args) {

        try {
            authorization("Login", "Pass111", "Pass111");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }

    }

    public static boolean authorization(String username, String password, String confirmationPassword) {
        if (!username.matches(Pattern)) {
            throw new WrongPasswordException("Не верный логин");
        }
        if (!password.matches(Pattern)) {
            throw new WrongPasswordException("Не верный пароль");
        }
        if (!confirmationPassword.equals(password)) {
            throw new WrongPasswordException("Пароли не совавдают");
        }
        return true;
    }

}
