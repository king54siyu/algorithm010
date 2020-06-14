/**
 * Number 26 in the Leetcode problem [Easy]
 */

public class RemoveDupe {

    /**
     * Two_pointer method 1
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {

        // The most important of this problem is the ordering of the number
        // boundary conditions
        if (null == nums || 0 == nums.length) return 0;
        // the other situations
        /**
         * the int i aims to record the next position and indicate the length of not replicated elements
         */
        int i = 0;
        /**
         * using the other pointer to iterate through the whole array
         */
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                nums[i+1] = nums[j];
                i++;
            }

        }
        // return the
        return i+1;
    }

    /**
     * version two with the optimization to solve the case no replication
     * @param nums
     * @return
     */
    public int removeDuplicatesOpt(int[] nums) {

        if (null == nums || nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > nums[i]) {
                if (j - i > 1) {
                    nums[i+1] = nums[j];
                }
                i++; // cannot put inside the inner if condition
            }
        }
        return i+1;
    }

    /**
     * Comments on this problem:
     * (1) the other method is to using the for each to replace the j index, but basically is the same
     * (2) optimization is to solve the case when there is no duplicates in the array, or the adjacent
     *      element is different [a little bit faster!]
     */

}
