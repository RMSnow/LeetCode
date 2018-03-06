package CCF;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by snow on 06/03/2018.
 */
public class Test {
    public static void main(String[] args) {
//        String minutes = "*";
//        ArrayList<Integer> minutesList = genValues(minutes, 0, 59);
//
//        //test
//        for (int i = 0; i < minutesList.size(); i++) {
//            System.out.println(minutesList.get(i));
//        }

        //Calendar

//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmm");
//        Calendar calendar = Calendar.getInstance();
//
//        System.out.println(simpleDateFormat.format(calendar.getTime()));

        String start = "201711170032";
        String end = "201711222352";

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();

        int startYear = Integer.parseInt(start.substring(0, 4));
        int endYear = Integer.parseInt(end.substring(0, 4));

        int startMonth = parseFromTag(start, 4);
        int endMonth = parseFromTag(end, 4);

        int startDay = parseFromTag(start, 6);
        int endDay = parseFromTag(end, 6);

        int startHour = parseFromTag(start, 8);
        int endHour = parseFromTag(end, 8);

        int startMinute = parseFromTag(start, 10);
        int endMinute = parseFromTag(end, 10);


        System.out.println(startYear + "-" + startMonth + "-" + startDay + "-" + startHour + "-" + startMinute);
        System.out.println(endYear + "-" + endMonth + "-" + endDay + "-" + endHour + "-" + endMinute);

        startCalendar.set(startYear, startMonth - 1, startDay, startHour, startMinute);
        endCalendar.set(endYear, endMonth - 1, endDay, endHour, endMinute);

        for (; startCalendar.compareTo(endCalendar) < 0; startCalendar.add(Calendar.DATE, 1)) {
            System.out.println(dateFormat.format(startCalendar.getTime()));
        }

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
