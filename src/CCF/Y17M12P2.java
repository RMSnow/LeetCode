package CCF;

import java.util.Scanner;

/**
 * Created by snow on 05/03/2018.
 */
public class Y17M12P2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] tag = new int[n];

        //tag初始化：1代表在场上，0代表已淘汰
        for (int i = 0; i < n; i++) tag[i] = 1;


        //当前报数人的编号
        int curr = 0;
        //当前所要报的数
        int num = 1;

        do {
            //首先将报数人编号，调至第1个在场人
            while (tag[curr] == 0) curr = (curr + 1) % n;

            //当在场人只有1个时，游戏结束
            int sum = 0;
            for (int i = 0; i < n; i++) {
                sum += tag[i];
            }
            if (sum == 1) {
                break;
            }

            //若出现"淘汰数"
            if (num % k == 0 || num % 10 == k) {
                tag[curr] = 0;
            }

            num++;
            curr = (curr + 1) % n;

        } while (true);

        //------------修改：把0号，N-1号还原为1号，N号
        System.out.println(curr + 1);
    }
}

//30min