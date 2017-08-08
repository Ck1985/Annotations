package annotations;

import java.util.*;

/**
 * Created by anonymous.vn1985@gmail.com
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "Password must contains at least one numeric")
    public boolean validatePassword(String password) {
        return password.matches("\\w*\\d\\w*");
    }
    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }
    @UseCase(id = 49, description = "New Passwords can not equal previously used one")
    public boolean checkForNewPassword(List<String> newPasswords, String oldPassword) {
        return (!newPasswords.contains(oldPassword));
    }
}
