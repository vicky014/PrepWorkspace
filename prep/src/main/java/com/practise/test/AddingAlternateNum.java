package com.practise.test;

import java.util.ArrayList;
import java.util.List;

public class AddingAlternateNum {

	private int alternateSum(int[] nums) {
		int sum = 0;
		
		if(nums.length == 1) return 0;
		if(nums.length == 2) return nums[0];
		
		List<Integer> evenNums = new ArrayList<>();
		
		for(int i=0; i<nums.length;i++) {
			
			if(i%2 != 0) {
				evenNums.add(nums[i]);
			}
			else {
				sum+=nums[i];
			}
		}
		
		int [] remainingNums = evenNums.stream().mapToInt(Integer::intValue)
				.toArray();
		
		System.out.println("sum : " + sum);

		return sum+alternateSum(remainingNums);
	}

	public static void main(String args[]) {

		AddingAlternateNum a = new AddingAlternateNum();
		int res = a.alternateSum(new int[] { 1, 2, 3, 4, 5 ,6});
		System.out.println("Sum : "+res);
	}

}
