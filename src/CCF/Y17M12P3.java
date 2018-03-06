package CCF;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by snow on 05/03/2018.
 */
public class Y17M12P3 {
//    n s t
//    yyyymmddHHMM

//    3 201711170032 201711222352
//    0 7 * * 1,3-5 get_up
//    30 23 * * Sat,Sun go_to_bed
//    15 12,18 * * * have_dinner

//    min hour dayOfMonth month dayOfWeek command

//    特殊符号：
//    * , -
//    * 只能单独出现
//    , 与 - 可以同时出现


//    其他要求：
//    （1）数字 / 英文缩写（不区分大小写），且可以混合使用
//    （2）若同一时刻有多个指令，则按先后顺序
//    （3）分钟数、小时数可以有前导0，也可以没有

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String start = scanner.next();
        String end = scanner.next();

        //start & end

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

        startCalendar.set(startYear, startMonth - 1, startDay, startHour, startMinute);
        endCalendar.set(endYear, endMonth - 1, endDay, endHour, endMinute);

//        System.out.println(startYear + "-" + startMonth + "-" + startDay + "-" + startHour + "-" + startMinute);
//        System.out.println(endYear + "-" + endMonth + "-" + endDay + "-" + endHour + "-" + endMinute);

        ArrayList<String> finalCommands = new ArrayList<>();

        //对接下来的n行，分别解析各项
        for (int i = 0; i < n; i++) {
            String minutes = scanner.next();
            String hours = scanner.next();
            String dayOfMonth = scanner.next();
            String month = scanner.next();
            String dayOfWeek = scanner.next();
            String command = scanner.next();

//            test
//            1  201711170032 201711222352
//            0 7 * * 1,3-5 get_up

            finalCommands = genCommands(startCalendar, endCalendar,
                    minutes, hours, dayOfMonth, month, dayOfWeek, command);
        }

        //test
        for (int i = 0; i < finalCommands.size(); i++) {
            System.out.println(finalCommands.get(i));
        }

        //将生成的n个命令集合并，排序后输出
    }

    public static ArrayList<String> genCommands(Calendar startCalendar, Calendar endCalendar,
                                                String minutes, String hours,
                                                String dayOfMonth, String month,
                                                String dayOfWeek, String command) {

//    特殊符号：
//    * , -
//    * 只能单独出现
//    , 与 - 可以同时出现


//    其他要求：
//    （1）数字 / 英文缩写（不区分大小写），且可以混合使用
//    （2）若同一时刻有多个指令，则按先后顺序
//    （3）分钟数、小时数可以有前导0，也可以没有


        //------------------- <minutes> and <hours> -------------------
        ArrayList<Integer> minutesList = genValues(minutes, 0, 59);
        ArrayList<Integer> hoursList = genValues(hours, 0, 23);

        //------------------- <day of month> and <month> -------------------
        ArrayList<Integer> dayOfMonthList = genValues(dayOfMonth, 1, 31);
        ArrayList<Integer> monthList = genValues(month, 1, 12);

        //------------------- <day of week> -------------------
        ArrayList<Integer> dayOfWeekList = genValues(dayOfWeek, 0, 6);


        //TODO: 对于month与week暂时不考虑缩写


        //------------------- 检测可行性 -------------------

        ArrayList<String> commands = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");

        //????  小时的判断，在起始时间不为0时，有问题

        for (; startCalendar.compareTo(endCalendar) < 0; startCalendar.add(Calendar.DATE, 1)) {

            //首先判断"天"

            System.out.println(dateFormat.format(startCalendar.getTime()));

            if (!monthList.contains(startCalendar.MONTH + 1) ||
                    !dayOfMonthList.contains(startCalendar.DAY_OF_MONTH) ||
                    !dayOfWeekList.contains(startCalendar.DAY_OF_WEEK)) {

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
            Iterator minutesIt = minutesList.iterator();


            while (hoursIt.hasNext()) {
                int h = (int) hoursIt.next();
                temp.set(Calendar.HOUR_OF_DAY, h);

                if (temp.compareTo(startCalendar) < 0)
                    continue;

                while (minutesIt.hasNext()) {
                    int m = (int) minutesIt.next();
                    temp.set(Calendar.MINUTE, m);

                    if (temp.compareTo(startCalendar) < 0)
                        continue;

                    //ok
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

    public static int parseFromTag(String s, int position) {
        char tag = s.charAt(position);
        return (tag == '0') ?
                Integer.parseInt(s.substring(position + 1, position + 2)) :
                Integer.parseInt(s.substring(position, position + 2));
    }
}

//28 min + 30 min + 30 min + 30 min + 30 min + 30 min