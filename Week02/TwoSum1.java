import java.util.HashMap;

public class TwoSum1 {

    /**
     * Comments of this problem:
     * 1. The first method is always we can think of the brute force method:
     *      We iterate through the whole array to figure out the solution
     * 2. To reduce the time complexity, we can use the hashmap to expedite the
     *      searching time of the index, if the complement exists in the array
     * 3. We optimize the code using just one loop
     */

    // Method 1: the brute force
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return (new int[] {i, j});
                }
            }
        }
        // inform the user there is no solution
        throw new IllegalArgumentException("There is no solution for this problem!");
    }

    // Method 2: We use the HashMap to store the connection between the index and the element
    // Therefore, we can find the index instantly
    public int[] twoSum2(int[] nums, int target) {

        // store all the element and the index using the HashMap
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        // iterate again to test if there is a solution in the code
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement) && map.get(complement) != i) {
                return new int[] {i, map.get(complement)};
            }
        }

        // Still throw an Exception if there is no solution
        throw new IllegalArgumentException("There is no solution for this problem!");
    }

    // Method 3: From the previous method, we can tell that using HashMap is much faster than
    // nested for loop. However, we can still optimize the code by putting the two steps into
    // one loop
    public int[] twoSum3(int[] nums, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complememt = target - nums[i];
            if (map.containsKey(complememt) && map.get(complememt) != i) {
                return new int[] {i, map.get(complememt)};
            }
            map.put(nums[i] , i);
        }
        // Still throw an Exception if there is no solution
        throw new IllegalArgumentException("There is no solution for this problem!");
    }
}
