/**
 * Created by snow on 2018/7/5.
 */
public class Problem55 {
    public boolean canJump(int[] nums) {
        /* My Solution */

//        int n = nums.length;
//        boolean[] access = new boolean[n];
//        for (boolean tag : access) tag = false;
//
//        access[0] = true;
//        for (int i = 0; i < n; i++) {
//            if (access[i] == true) {
//                for (int j = 1; j <= nums[i]; j++) {
//                    if (i + j >= n - 1) return true;
//                    access[i + j] = true;
//                }
//            }
//        }
//
//        return access[n - 1];

        //Greedy
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;

    }

    public static void main(String[] args){
        Problem55 problem55 = new Problem55();
//        int[] nums = {2,3,1,1,4};
        int[] nums = {3,2,1,0,4};
        System.out.println(problem55.canJump(nums));
    }
}
