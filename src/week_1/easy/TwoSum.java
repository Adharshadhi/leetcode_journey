package week_1.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //Problem Statement 1. Two Sum
    //Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
    //
    //You may assume that each input would have exactly one solution, and you may not use the same element twice.
    //
    //You can return the answer in any order.
    //
    // Example 1:
    //Input: nums = [2,7,11,15], target = 9
    //Output: [0,1]
    //Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
    //Example 2:
    //
    //Input: nums = [3,2,4], target = 6
    //Output: [1,2]
    //Constraints:
    //
    // 2 <= nums.length <= 104
    // -109 <= nums[i] <= 109
    // -109 <= target <= 109
    //Only one valid answer exists.
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumBrute(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSumBrute(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSumBrute(new int[]{3,3}, 6)));
        System.out.println("-------------------------------------------------");
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3,3}, 6)));
    }

    //Bruteforce solution with multiple loops (O(n2))
    public static int[] twoSumBrute(int[] nums, int target){
        int sum;
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                sum = nums[i] + nums[j];
                if(sum == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    //Optimal solution with Map (O(n))
    public static int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> checkMap = new HashMap<>();
        int difference;
        for(int i=0; i<nums.length; i++){
            // check if the map already have the value
            // if it does, it means both the values required for the target are found
            if(checkMap.containsKey(nums[i])){
                return new int[]{checkMap.get(nums[i]),i};
            }
            else{
                difference = target - nums[i];
                checkMap.put(difference,i);
            }
        }
        return null;
    }
}
