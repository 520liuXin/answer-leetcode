package com.example.demo.answer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
     * @author liuxin
     * @date 2019/7/14
     出现一次的数字
     题目：给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
     实例：
     输入: [4,1,2,1,2]
     输出: 4
     */
public class No1 {
    public static void main(String[] args){
        int [] nums={1,2,5,2,1,6,6};
        int no1=singleNumber1(nums);
        int no2=singleNumber2(nums);
        int no3=singleNumber3(nums);
        int no4=singleNumber4(nums);
        System.out.println(no1+" "+no2+ " "+no3+" "+no4);


    }


    /*   方法一
         *功能描述 :根据异或运算的特点，相同的数字经过异或运算后结果为0，除单独出现一次的数字外，其他数字都是出现两次的，那么这些数字经过异或运算后结果一定是0。
         * 而任何数字与0进行异或运算都是该数字本身。所以对数组所有元素进行异或运算，运算结果就是题目的答案。
         * @author liuxin
         * @date 2019/7/14
         * @param  * @param nums
         * @return
         */
    public static int singleNumber1(int[] nums) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            num = num ^ nums[i];
        }
        return num;
    }



    /*   方法二
         *功能描述 :思路：先对数组进行排序，然后对 nums[i] 和 nums[i + 1]进行比较，如相等，i += 2，继续下一组比较，直到取到不相等的一组。

　　      注意：首先这个数组的长度肯定是奇数（目标数字只出现一次，其他所有数字出现两次），所以如果上述步骤没有找到不相等的一组数，那么肯定是数组的最后一个数字是单独出现的。
         * @author liuxin
         * @date 2019/7/14
         * @param  * @param nums
         * @return
         */
    public static int singleNumber2(int[] nums) {
        Arrays.sort(nums);  // 排序数组
        for (int i = 0; i < nums.length - 1; i += 2) {
            // 找到不相等的一组，直接返回
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        // 如果没有找到不相等的一组数据，直接返回数组的最后一个数字
        return nums[nums.length - 1];
    }


    /*   方法三
         *功能描述 ：利用HashSet的特性，删除重复的数组元素，最后剩下一个单独的元素，返回即可。
         * @author liuxin
         * @date 2019/7/14
         * @param  * @param nums
         * @return
         */
    public static int singleNumber3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.add(nums[i])) { // add成功返回true，如果set中已有相同数字，则add方法会返回false
                set.remove(nums[i]); // 删除重复出现的数字
            }
        }
        return set.iterator().next();
    }

    /*   方法四
         *功能描述：先对数组排序，显而易见的，单独出现一次的数据必然是出现在数组下标为偶数的位置（下标从0开始），
         * 那么所有奇数下标的元素之和减去偶数下标的元素之和，就是需要求得的结果。
         * @author liuxin
         * @date 2019/7/14
         * @param  * @param null
         * @return
         */
    public static int singleNumber4(int[] nums) {
        int num = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            // 偶数下标位置 num += nums[i]，奇数下标位置 num -= nums[i]
            num = i % 2 == 0 ? num + nums[i] : num - nums[i];
        }
        return num;
    }



}
