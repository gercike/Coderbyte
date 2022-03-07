package RegExp;

public class CodelandUsernameValidation {

    public static String codelandUsernameValidation(String str) {
        if (str.matches("^[a-zA-Z][a-zA-Z0-9_]{3,24}[^_]$")){
            return "true";
        }
        return "false";
    }
}
