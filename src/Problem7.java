import java.util.ArrayList;

/**
 * Created by snow on 2018/6/20.
 */
public class Problem7 {
    public static void main(String[] args) {
        Problem7 problem7 = new Problem7();
        int intput = -2147483412;
        System.out.println("Java Max Value: " + Integer.MAX_VALUE);
        System.out.println("Input: "+ intput);
        System.out.printf("Output: ");
        System.out.println(problem7.reverse(intput));
    }

    public int reverse(int x) {
        try {
            int divNum = 1;
            int modNum = 10;
            int minusFlag = (x > 0) ? 1 : -1;
            x *= minusFlag;
            ArrayList<Integer> digits = new ArrayList<>();

            int mod = x % modNum;
            while (mod != x) {
                digits.add(mod / divNum);

                divNum *= 10;
                modNum *= 10;
                mod = x % modNum;
            }
            digits.add(mod / divNum);

            int reverseNum = 0;
            int mulNum = 1;
            for (int i = digits.size() - 1; i >= 0; i--, mulNum *= 10) {
                if (Integer.MAX_VALUE - reverseNum < digits.get(i) * mulNum)
                    return 0;
                reverseNum += digits.get(i) * mulNum;
            }
            return reverseNum * minusFlag;

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
