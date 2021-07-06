package Java_Algo;

public class CountSubstring {

    int countSubstrings(String s, String b) {
        int count = 0;
        // input: "app", "apple_app" want to stop at index 6 of b string
        int length = b.length() - s.length() + 1;
        for (int i = 0; i < length; i++) {
            String bSubstring = b.substring(i, i + s.length());
            if (bSubstring.equals(s)) {
                count++;
            }
        }
        return count;
       }
    public static void main(String[] args) {
        CountSubstring countSS = new CountSubstring();
        int count = countSS.countSubstrings("app", "apple_app_app");
        System.out.println(count);
    }
}
