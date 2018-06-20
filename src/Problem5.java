/**
 * Created by snow on 29/03/2018.
 */
public class Problem5 {
    public String longestPalindrome(String s) {
        //Solution
//        int start = 0, end = 0;
//        for (int i = 0; i < s.length(); i++) {
//            int len1 = expandAroundCenter(s, i, i);
//            int len2 = expandAroundCenter(s, i, i + 1);
//            int len = Math.max(len1, len2);
//            if (len > end - start) {
//                start = i - (len - 1) / 2;
//                end = i + len / 2;
//            }
//        }
//        return s.substring(start, end + 1);

        //My Answer
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int lengthOfSub = n - i;
            for (int j = 0; j <= i; j++) {
                String sub = s.substring(j, j + lengthOfSub);
                if (isPalindrome(sub))
                    return sub;
            }
        }
        return null;
    }

    public boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i <= (n - 1) / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i))
                return false;
        }
        return true;
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    public static void main(String[] args) {
        Problem5 problem5 = new Problem5();
//        System.out.println(problem5.longestPalindrome("babad"));
//        System.out.println(problem5.longestPalindrome("cbbd"));
//
//        System.out.println(problem5.longestPalindrome("abcde"));
//
//        System.out.println(problem5.longestPalindrome("babaddtattarrattatddetartrateedredividerb"));

        String test = "whdqcudjpisufnrtsyupwtnnbsvfptrcgvobbjglmpynebblpigaflpbezjvjgbmofejyjssdhbgghgrhzuplbeptpaecfdanhlylgusptlgobkqnulxvnwuzwauewcplnvcwowmbxxnhsdmgxtvbfgnuqdpxennqglgmspbagvmjcmzmbsuacxlqfxjggrwsnbblnnwisvmpwwhomyjylbtedzrptejjsaiqzprnadkjxeqfdpkddmbzokkegtypxaafodjdwirynzurzkjzrkufsokhcdkajwmqvhcbzcnysrbsfxhfvtodqabvbuosxtonbpmgoemcgkudandrioncjigbyizekiakmrfjvezuzddjxqyevyenuebfwugqelxwpirsoyixowcmtgosuggrkdciehktojageynqkazsqxraimeopcsjxcdtzhlbvtlvzytgblwkmbfwmggrkpioeofkrmfdgfwknrbaimhefpzckrzwdvddhdqujffwvtvfyjlimkljrsnnhudyejcrtrwvtsbkxaplchgbikscfcbhovlepdojmqybzhbiionyjxqsmquehkhzdiawfxunguhqhkxqdiiwsbuhosebxrpcstpklukjcsnnzpbylzaoyrmyjatuovmaqiwfdfwyhugbeehdzeozdrvcvghekusiahfxhlzclhbegdnvkzeoafodnqbtanfwixjzirnoaiqamjgkcapeopbzbgtxsjhqurbpbuduqjziznblrhxbydxsmtjdfeepntijqpkuwmqezkhnkwbvwgnkxmkyhlbfuwaslmjzlhocsgtoujabbexvxweigplmlewumcone";
//        System.out.println(test.length());
        System.out.println(problem5.longestPalindrome(test));
    }
}
