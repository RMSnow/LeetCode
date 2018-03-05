import java.util.ArrayList;

/**
 * Created by snow on 04/03/2018.
 */
public class Problem4 {
    public double findMedianSortedArrays(int[] A, int[] B) {
        //Solution 1: O(m+n)

        ArrayList<Integer> mergedNums = new ArrayList<>();
        int i = 0;
        int j = 0;
        int m = A.length;
        int n = B.length;

        while (i < m || j < n) {
            if (i < m && j < n) {
                if (A[i] <= B[j]) {
                    mergedNums.add(A[i++]);
                } else {
                    mergedNums.add(B[j++]);
                }
            }

            if (i < m && j == n) {
                mergedNums.add(A[i++]);
            }

            if (i == m && j < n) {
                mergedNums.add(B[j++]);
            }

            if (mergedNums.size() == (m + n) / 2 + 1)
                break;
        }

        int index = (m + n) / 2;
        if ((m + n) % 2 != 0) {
            return mergedNums.get(index);
        } else {
            int a = mergedNums.get(index);
            int b = mergedNums.get(index - 1);
            return (a + b) / 2.0;
        }

        //Answer: can't understand

//        int m = A.length;
//        int n = B.length;
//        if (m > n) { // to ensure m<=n
//            int[] temp = A; A = B; B = temp;
//            int tmp = m; m = n; n = tmp;
//        }
//        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
//        while (iMin <= iMax) {
//            int i = (iMin + iMax) / 2;
//            int j = halfLen - i;
//            if (i < iMax && B[j-1] > A[i]){
//                iMin = iMin + 1; // i is too small
//            }
//            else if (i > iMin && A[i-1] > B[j]) {
//                iMax = iMax - 1; // i is too big
//            }
//            else { // i is perfect
//                int maxLeft = 0;
//                if (i == 0) { maxLeft = B[j-1]; }
//                else if (j == 0) { maxLeft = A[i-1]; }
//                else { maxLeft = Math.max(A[i-1], B[j-1]); }
//                if ( (m + n) % 2 == 1 ) { return maxLeft; }
//
//                int minRight = 0;
//                if (i == m) { minRight = B[j]; }
//                else if (j == n) { minRight = A[i]; }
//                else { minRight = Math.min(B[j], A[i]); }
//
//                return (maxLeft + minRight) / 2.0;
//            }
//        }
//        return 0.0;

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3};
        System.out.println(new Problem4().findMedianSortedArrays(nums1, nums2));
    }
}
