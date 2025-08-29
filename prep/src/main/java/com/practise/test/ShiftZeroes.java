package com.practise.test;

public class ShiftZeroes {

	public void shiftZeroes(int[] nums) {

		int index = 0;

		for (int i = 0; i < nums.length; i++) {

			if (nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}

		}
		while (index < nums.length) {
			nums[index] = 0;
			index++;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShiftZeroes s = new ShiftZeroes();

		int[] nums = { 0, 1, 0, 2, 3 };
		s.shiftZeroes(nums);

		for (int i : nums) {
			System.out.print(i);
		}

	}

}
