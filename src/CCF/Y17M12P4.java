package CCF;

import java.util.ArrayList;
import java.util.Hashtable;
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

        //标记数组：记录所有已经遍历过的数组
        ArrayList<Integer> tags = new ArrayList<>();
        //每个tags中的元素，都对应着一条当前路径
        Hashtable<Integer, Path> pathOfTag = new Hashtable<>();

        tags.add(1);

        int choicedTag = 1;     //此次迭代所选择的路口
        int next = -1;       //此次迭代所选择路口的下一个路口
        int minCost = -1;        //此次迭代的最小疲劳度

        while (!tags.contains(n)) {
            //遍历tag数组，对所有可达的路口编号（且不再tag中），进行路径的计算
            for (int i = 0; i < tags.size(); i++) {
                int tagNum = tags.get(i) - 1;
                for (int j = 0; j < n; j++) {
                    int d = distance[tagNum][j];
                    if (d != -1 && !tags.contains(j + 1)) {
                        boolean t = type[tagNum][j];
                        //first time
                        if (next == -1) {
                            next = j;
                            minCost = (t == false) ? d : (d * d);

                            pathOfTag.put(choicedTag + 1,
                                    new Path(t, d, minCost, null));
                            continue;
                        }

                        //TODO: debug cost = 29 计算函数存在问题
                        int cost = calCost(pathOfTag.get(choicedTag + 1), t, d);
                        if (cost < minCost) {
                            choicedTag = tagNum;
                            next = j;
                            minCost = cost;
                        }

                    }
                }

            }

            tags.add(next + 1);
            boolean t = type[choicedTag][next];
            int d = distance[choicedTag][next];
            pathOfTag.put(next + 1, new Path(t, d, minCost, pathOfTag.get(choicedTag + 1)));
        }

        System.out.println(pathOfTag.get(n).cost);

    }

    //记录道路的type: true = small, false = big
    public static int calCost(Path path, boolean typeOfD, int d) {
        if (path != null) {
            //新加的是大道，则无需遍历之前
            if (typeOfD == false) {
                return path.cost + d;
            }

            //新加的是小道，但之前一段为大道
            if (path.type == false) {
                return path.cost + d * d;
            }

            //新加的是小道，之前一段也是小道
            return calCost(path.prePath, path.type, d + path.finalDistance);
        }

        //如果遍历到第一个路口
        if (typeOfD == false) {
            return d;
        }
        return d * d;
    }
}

class Path {
    boolean type;
    int finalDistance;
    int cost;       //疲劳度
    Path prePath;

    public Path(boolean type, int finalDistance, int cost, Path prePath) {
        this.type = type;
        this.finalDistance = finalDistance;
        this.cost = cost;
        this.prePath = prePath;
    }
}

//Mar 11: 60min + 10min + 30min + 30min
