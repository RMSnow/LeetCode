/**
 * Created by snow on 2018/6/21.
 */
public class Problem14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String probablePrefix = strs[0];
        int minLength = probablePrefix.length();

        for (String str : strs) {
            if (minLength > str.length()) {
                minLength = str.length();
                probablePrefix = str;
            }
        }

        for (String str : strs) {
            for (int k = 0; k <= probablePrefix.length(); k++) {
                if (str.substring(0, k).equals(probablePrefix.substring(0, k)))
                    continue;
                else
                    probablePrefix = str.substring(0, k - 1);
            }
        }

        return probablePrefix;

    }

    public static void main(String[] args) {
//        System.out.println("abc".substring(0, 0).equals(""));
        Problem14 problem14 = new Problem14();
//        String[] strs = {"flower", "flow", "flight"};
//        String[] strs = {"dog", "racecar", "car"};
//        String[] strs = {"a", "b", "c"};
        String[] strs = {"aa", "a"};
        System.out.println(problem14.longestCommonPrefix(strs));

//        "abc".substring(0,1000);
    }
}
