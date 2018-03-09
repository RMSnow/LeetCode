package CCF;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by snow on 05/03/2018.
 */
public class Y17M12P3 {

//    其他要求：
//    （1）数字 / 英文缩写（不区分大小写），且可以混合使用
//    （2）若同一时刻有多个指令，则按先后顺序
//    （3）分钟数、小时数可以有前导0，也可以没有

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String start = scanner.next();
        String end = scanner.next();

//        int startYear = Integer.parseInt(start.substring(0, 4));
//        int endYear = Integer.parseInt(end.substring(0, 4));
//
//        int startMonth = parseFromTag(start, 4);
//        int endMonth = parseFromTag(end, 4);
//
//        int startDay = parseFromTag(start, 6);
//        int endDay = parseFromTag(end, 6);
//
//        int startHour = parseFromTag(start, 8);
//        int endHour = parseFromTag(end, 8);
//
//        int startMinute = parseFromTag(start, 10);
//        int endMinute = parseFromTag(end, 10);
//
//        Calendar startCalendar = Calendar.getInstance();
//        Calendar endCalendar = Calendar.getInstance();
//        startCalendar.set(startYear, startMonth - 1, startDay, startHour, startMinute);
//        endCalendar.set(endYear, endMonth - 1, endDay, endHour, endMinute);

        //------------------- 对接下来的n行，分别解析各项 -------------------

        ArrayList<String> finalCommands = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String minutes = scanner.next();
            String hours = scanner.next();
            String dayOfMonth = scanner.next();
            String month = scanner.next();
            String dayOfWeek = scanner.next();
            String command = scanner.next();

            ArrayList<String> tempList = genCommands(start, end,
                    minutes, hours, dayOfMonth, month, dayOfWeek, command);
            finalCommands.addAll(tempList);
        }

        //将生成的n个命令集合并，排序后输出
        Collections.sort(finalCommands);
        for (int i = 0; i < finalCommands.size(); i++) {
            System.out.println(finalCommands.get(i));
        }
    }

    public static ArrayList<String> genCommands(String start, String end,
                                                String minutes, String hours,
                                                String dayOfMonth, String month,
                                                String dayOfWeek, String command) {

        //------------------- start & end -------------------

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        Calendar startCalendar = Calendar.getInstance();
        Calendar endCalendar = Calendar.getInstance();
        try {
            startCalendar.setTime(dateFormat.parse(start));
            endCalendar.setTime(dateFormat.parse(end));

        } catch (ParseException e) {
            e.printStackTrace();
        }

        //------------------- <minutes> and <hours> -------------------
        ArrayList<Integer> minutesList = genValues(minutes, 0, 59);
        ArrayList<Integer> hoursList = genValues(hours, 0, 23);

        //------------------- <day of month> and <month> -------------------
        ArrayList<Integer> dayOfMonthList = genValues(dayOfMonth, 1, 31);
        ArrayList<Integer> monthList = genValues(month, 1, 12, "month");

        //------------------- <day of week> -------------------
        ArrayList<Integer> dayOfWeekList = genValues(dayOfWeek, 0, 6, "week");


        //TODO: 对于month与week暂时不考虑缩写


        //------------------- 检测可行性 -------------------

        ArrayList<String> commands = new ArrayList<>();

        for (; startCalendar.compareTo(endCalendar) < 0; startCalendar.add(Calendar.DATE, 1)) {

            //首先判断"天"

            if (!monthList.contains(startCalendar.get(Calendar.MONTH) + 1) ||
                    !dayOfMonthList.contains(startCalendar.get(Calendar.DAY_OF_MONTH)) ||
                    !dayOfWeekList.contains(startCalendar.get(Calendar.DAY_OF_WEEK) - 1)) {

                //将时间改为00:00
                startCalendar.set(Calendar.HOUR_OF_DAY, 0);
                startCalendar.set(Calendar.MINUTE, 0);
                continue;
            }

            //再枚举hour与minute

            Collections.sort(hoursList);
            Collections.sort(minutesList);

            Calendar temp = Calendar.getInstance();
            temp.setTime(startCalendar.getTime());

            Iterator hoursIt = hoursList.iterator();
            while (hoursIt.hasNext()) {
                int h = (int) hoursIt.next();
                temp.set(Calendar.HOUR_OF_DAY, h);

                if (temp.compareTo(startCalendar) < 0)
                    continue;

                for (int i = 0; i < minutesList.size(); i++) {
                    int m = minutesList.get(i);
                    temp.set(Calendar.MINUTE, m);

                    if (temp.compareTo(startCalendar) < 0)
                        continue;

                    commands.add(dateFormat.format(temp.getTime()) + " " + command);
                }

            }

            //将时间改为00:00
            startCalendar.set(Calendar.HOUR_OF_DAY, 0);
            startCalendar.set(Calendar.MINUTE, 0);

        }

        return commands;
    }

    public static ArrayList<Integer> genValues(String s, int min, int max) {
        ArrayList<Integer> values = new ArrayList<>();
        if (s.contains("*")) {
            for (int i = min; i <= max; i++) {
                values.add(i);
            }
        } else if (s.contains(",")) {
            String[] a = s.split(",");
            for (int i = 0; i < a.length; i++) {
                if (a[i].contains("-")) {
                    String[] b = a[i].split("-");
                    int bMin = Integer.parseInt(b[0]);
                    int bMax = Integer.parseInt(b[1]);
                    for (int j = bMin; j <= bMax; j++) {
                        values.add(j);
                    }
                } else {
                    values.add(Integer.parseInt(a[i]));
                }
            }
        } else if (s.contains("-")) {     //only "-" but no ","
            String[] b = s.split("-");
            int bMin = Integer.parseInt(b[0]);
            int bMax = Integer.parseInt(b[1]);
            for (int j = bMin; j <= bMax; j++) {
                values.add(j);
            }
        } else {
            values.add(Integer.parseInt(s));
        }

        return values;
    }

    public static ArrayList<Integer> genValues(String s, int min, int max, String tag) {
        if (tag.equals("month")) {
            s = s.replace("Jan", "1");
            s = s.replace("Feb", "2");
            s = s.replace("Mar", "3");
            s = s.replace("Apr", "4");
            s = s.replace("May", "5");
            s = s.replace("Jun", "6");
            s = s.replace("Jul", "7");
            s = s.replace("Aug", "8");
            s = s.replace("Sep", "9");
            s = s.replace("Oct", "10");
            s = s.replace("Nov", "11");
            s = s.replace("Dec", "12");
        }

        if (tag.equals("week")) {
            s = s.replace("Sun","0");
            s = s.replace("Mon", "1");
            s = s.replace("Tue", "2");
            s = s.replace("Wed", "3");
            s = s.replace("Thu", "4");
            s = s.replace("Fri", "5");
            s = s.replace("Sat", "6");
        }

        return genValues(s, min, max);
    }

    public static int parseFromTag(String s, int position) {
        char tag = s.charAt(position);
        return (tag == '0') ?
                Integer.parseInt(s.substring(position + 1, position + 2)) :
                Integer.parseInt(s.substring(position, position + 2));
    }
}

// Mar 5: 28 min
// Mar 6: 30 min + 30 min + 30 min + 30 min + 30 min
// Mar 9: 60 min + 25 min