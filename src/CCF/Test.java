package CCF;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by snow on 06/03/2018.
 */
public class Test {
    public static void main(String[] args) throws ParseException {
//        String start = "201711170032";
//        String end = "201711222352";
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
//        Calendar now = Calendar.getInstance();
//        for (int i = 0; i < 7; i++) {
//            System.out.printf(now.get(now.MONTH) + 1 + "月" + now.get(now.DAY_OF_MONTH) + "号是周");
//            System.out.println(now.get(now.DAY_OF_WEEK) - 1);
//            now.add(Calendar.DATE, 1);
//        }

        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        a.add(1);
        b.add(2);
        b.add(3);
        a.addAll(b);

        for (int i=0;i<a.size();i++) System.out.println(a.get(i));


    }

    public static ArrayList<Integer> genValues(String s, int min, int max) {
//        ArrayList<Integer> values = new ArrayList<>();
//        if (s.contains("*")) {
//            for (int i = min; i <= max; i++) {
//                values.add(i);
//            }
//        } else if (s.contains(",")) {
//            String[] a = s.split(",");
//            for (int i = 0; i < a.length; i++) {
//                if (a[i].contains("-")) {
//                    String[] b = a[i].split("-");
//                    int bMin = Integer.parseInt(b[0]);
//                    int bMax = Integer.parseInt(b[1]);
//                    for (int j = bMin; j <= bMax; j++) {
//                        values.add(j);
//                    }
//                } else {
//                    values.add(Integer.parseInt(a[i]));
//                }
//            }
//        } else if (s.contains("-")) {     //only "-" but no ","
//            String[] b = s.split("-");
//            int bMin = Integer.parseInt(b[0]);
//            int bMax = Integer.parseInt(b[1]);
//            for (int j = bMin; j <= bMax; j++) {
//                values.add(j);
//            }
//        } else {
//            values.add(Integer.parseInt(s));
//        }
//
//        return values;

        return null;
    }

    public static int parseFromTag(String s, int position) {
        char tag = s.charAt(position);
        return (tag == '0') ?
                Integer.parseInt(s.substring(position + 1, position + 2)) :
                Integer.parseInt(s.substring(position, position + 2));
    }
}
