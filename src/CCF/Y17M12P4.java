package CCF;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by snow on 11/03/2018.
 */
public class Y17M12P4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();      //路口的数量
        int m = scanner.nextInt();      //道路的数量

        //记录道路的distance
        int[][] distance = new int[n][n];
        //记录道路的type: true = small, false = big
        boolean[][] type = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = -1;
                type[i][j] = false;
            }
        }

        for (int i = 0; i < m; i++) {
            int t = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();

            distance[a - 1][b - 1] = c;
            distance[b - 1][a - 1] = c;

            if (t == 1) {       //t为0表示大道，t为1表示小道
                type[a - 1][b - 1] = true;
                type[b - 1][a - 1] = true;
            }
        }

        //test
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.printf(distance[i][j]+"\t");
//            }
//            System.out.printf("\n");
//        }
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                System.out.printf(type[i][j]+"\t");
//            }
//            System.out.printf("\n");
//        }

        ArrayList<Integer> tags = new ArrayList<>();     //标记数组：记录所有已经遍历过的数组
        tags.add(1);

        ArrayList<Integer> paths = new ArrayList<>();
        while (tags.size() < n) {
            //遍历tag数组，对所有可达的路口编号（且不再tag中），进行路径的计算
            for (int i = 0; i < tags.size(); i++) {
                int tempNum = tags.get(i);
                for (int j = 0; j < n; j++) {
                    if (distance[tempNum][j] != -1 && !tags.contains(j)) {

                    }
                }
            }
        }

    }
}

class Path {
    int currNum;        //当前路径的最末端路口编号
    int preNum;     //上一个路口编号
    int cost;       //疲劳度

    Path(int c, int p) {
        currNum = c;
        preNum = p;
    }
}

//Mar 11: 60min
