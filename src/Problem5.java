/**
 * Created by snow on 29/03/2018.
 */
public class Problem5 {
    public String longestPalindrome(String s) {
        //Solution1: Time limited

//        if (isPalindrome(s))
//            return s;
//
//        int n = s.length();
//        String sub1 = s.substring(0, n - 1);
//        String sub2 = s.substring(1, n);
//
//        String longestOfSub1 = longestPalindrome(sub1);
//        if (longestOfSub1 != null && longestOfSub1.length() == n - 1)
//            return longestOfSub1;
//
//        String longestOfSub2 = longestPalindrome(sub2);
//
//        if (longestOfSub1 == null && longestOfSub2 == null)
//            return null;
//
//        if (longestOfSub1 != null && longestOfSub2 == null)
//            return longestOfSub1;
//
//        if (longestOfSub1 == null && longestOfSub2 != null)
//            return longestOfSub2;
//
//        int n1 = longestOfSub1.length();
//        int n2 = longestOfSub2.length();
//        return (n1 > n2) ? longestOfSub1 : longestOfSub2;

        //Solution2
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
//        int n = s.length();
//
//        if (n == 0 || n == 1)
//            return true;
//
//        if (s.charAt(0) != s.charAt(n - 1))
//            return false;
//
//        return isPalindrome(s.substring(1, n - 1));

        int n = s.length();
        for (int i = 0; i <= (n - 1) / 2; i++) {
            if (s.charAt(i) != s.charAt(n - 1 - i))
                return false;
        }
        return true;
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
