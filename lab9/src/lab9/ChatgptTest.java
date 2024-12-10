package lab9;

public class ChatgptTest {

    public static String fixFlyingSaucer(String input) {
        int leftIndex = input.indexOf('（');
        int rightIndex = input.indexOf('）', leftIndex + 1);

        if (leftIndex != -1 && rightIndex != -1) {
            String before = input.substring(0, leftIndex + 1);
            String after = input.substring(rightIndex);
            String middle = input.substring(leftIndex + 1, rightIndex).replaceAll(".", "ニ");

            return before + middle + after;
        }

        return input;
    }

    public static void main(String[] args) {
        System.out.println(fixFlyingSaucer("（==****＝ニー）")); // Expected output: （ニニニニニニニニ）
        System.out.println(fixFlyingSaucer("(==****)**=)*"));   // Expected output: (==****)**=)*
        System.out.println(fixFlyingSaucer("(==)**"));          // Expected output: (==)**
    }
}
