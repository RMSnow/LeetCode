package CCF;

import java.util.Scanner;

/**
 * Created by snow on 05/03/2018.
 */
public class Y17M12P1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            nums[i] = scanner.nextInt();
        }

        int distance = Math.abs(nums[0] - nums[1]);
        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                int temp = Math.abs(nums[i] - nums[j]);
                distance = (temp < distance) ? temp : distance;
            }
        }
        System.out.println(distance);
    }
}

//18 min