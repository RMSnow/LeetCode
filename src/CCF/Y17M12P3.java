package CCF;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by snow on 05/03/2018.
 */
public class Y17M12P3 {
//    n s t
//      yyyymmddHHMM

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
        String to = scanner.next();

        //解析start与to

        //对接下来的n行，分别解析各项

        //将生成的n个命令集合并，排序后输出
    }

    public static ArrayList<String> genCommands(String start, String to,
                                                String min, String hour,
                                                String dayOfMonth, String month,
                                                String dayOfWeek, String command) {

        return null;
    }
}

//28 min +