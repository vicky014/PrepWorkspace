package com.practise.test;

public class ShiftZeroes {

	public void shiftZeroesTowardsRight(int[] nums) {

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

	public void shiftZeroesTowardsLeft(int[] nums) {
		// towards left
		int index = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {

			if (nums[i] != 0) {
				nums[index] = nums[i];
				index--;
			}

		}
		while (index >= 0) {
			nums[index] = 0;
			index--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ShiftZeroes s = new ShiftZeroes();

		int[] nums = { 2, 0, 1, 0, 2, 3 };
		s.shiftZeroesTowardsLeft(nums);

		for (int i : nums) {
			System.out.println(i);
		}
		
		System.out.println("---------------");
		int[] nums1 = { 2, 0, 1, 0, 2, 3 };
		s.shiftZeroesTowardsLeft(nums1);
		for (int i : nums1) {
			System.out.println(i);
		}

	}

}
