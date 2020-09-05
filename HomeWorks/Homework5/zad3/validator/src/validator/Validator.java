package validator;

public class Validator {
    public static boolean validateUsername(String username) {
        return username.matches("[A-z]{2,}");
    }

    // Email starts with a letter and can have numbers and
    // Email has to end on a letter or number, not _
    public static boolean validateEmail(String email) {
        return email.matches("[A-z]+[A-z0-9_]*[A-z0-9]@[A-z]+.[A-z]+");
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\(\\d{4}\\) \\(\\d{7}\\)");
    }
}
