import java.util.Scanner;
import java.util.regex.Pattern;

public class ClassNameValidator {

    // Regular expression for class name validation
    private static final String CLASS_NAME_REGEX = "^[CAP]\\d{4}[GHIK]$";

    // Method to validate class name
    public static boolean isValidClassName(String className) {
        return Pattern.matches(CLASS_NAME_REGEX, className);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap ten lop hoc: ");
        String className = scanner.nextLine();

        if (isValidClassName(className)) {
            System.out.println("Hop le.");
        } else {
            System.out.println("Khong hop le.");
        }

        scanner.close();
    }
}
