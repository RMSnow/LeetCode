package Lanqiao;

/**
 * Created by snow on 30/03/2018.
 */
public class Y17P2 {
    //    public static void main(String[] args) {
//        int num1, num2, outcome;
//        Set<Integer> digits1;
//        Set<Integer> digits2;
//
//        /*
//            1 - digit
//         */
//        for (int i = 1; i <= 9; i++) {
//            //init
//            digits1 = new HashSet<>();
//            digits2 = new HashSet<>();
//
//            //division
//            digits1.add(i);
//            for (int j = 1; j <= 9; j++) {
//                if (j != i) digits2.add(j);
//            }
//
//            //sort
//
//            //calculate
//
//        }
//
//
//        /*
//            2 - digit
//         */
//
//
//        /*
//            3 - digit
//         */
//
//
//        /*
//            4 - digit
//         */
//    }
//
//    public static Set<Character> characters = new HashSet<>();
//    public static Set<Integer> digits = new HashSet<>();
//
//    static {
//        for (int i = 1; i <= 9; i++) {
//            characters.add(String.valueOf(i).charAt(0));
//            digits.add(i);
//        }
//    }
//
//    public static boolean isGood(int outcome) {
//        String num = String.valueOf(outcome);
//        Set<Character> digitsOfNum = new HashSet<>();
//
//        if (num.length() != 9)
//            return false;
//
//        for (int i = 0; i < 9; i++) {
//            char temp = num.charAt(i);
//
//            if (!characters.contains(temp))
//                return false;
//
//            if (i == 0) {
//                digitsOfNum.add(temp);
//                continue;
//            }
//
//            if (digitsOfNum.contains(num.charAt(i)))
//                return false;
//
//            digitsOfNum.add(num.charAt(i));
//        }
//
//        return true;
//    }
//
//    public static ArrayList<Integer> getNumsFromDigits(Set<Integer> d) {
//        ArrayList<Integer> results = new ArrayList<>();
//
//        String result = "";
//        for (int i = 0; i < d.size(); i++) {
//            result += "";
//        }
//
//        return results;
//    }
    //static String num = "";
    static int flag[] = new int[10];
    static int sum = 0;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        fun(0, "");
        System.out.println(sum / 2);//乘数被乘数交换视为一种方案，结果需要除以2

    }

    static void fun(int n, String num) {//将乘数被乘数1-9进行排列
        if (n == 9) {
            insert(num);
            return;

        }
        for (int i = 1; i <= 9; i++) {
            if (flag[i] == 0) {
                flag[i] = 1;
                fun(n + 1, num + i);
                flag[i] = 0;

            }

        }

    }


    static void insert(String num) {//将排序的数分为两个部分，进行相乘运算
        for (int i = 1; i < 9; i++) {
            String left = num.substring(0, i);
            String right = num.substring(i, 9);
            int res = Integer.parseInt(left) * Integer.parseInt(right);
            if (check(res, num)) {
                //System.out.println(left+"*"+right+"="+res);//输出结果，便于检查
                sum++;

            }

        }

    }


    static boolean check(int res, String num) {//用于判断计算结果是否满足1-9
        int[] resFlag = new int[10];
        resFlag[0] = 1;
        String s = String.valueOf(res);
        if (s.length() != 9) {
            return false;

        }
        for (int i = 0; i < 9; i++) {
            int n = Integer.parseInt(s.substring(i, i + 1));
            if (resFlag[n] == 0) {
                resFlag[n] = 1;

            } else {
                return false;
            }

        }
        return true;

    }
}

//12min + 30min