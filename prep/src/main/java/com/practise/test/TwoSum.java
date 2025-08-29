package com.practise.test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		
//		Map<Integer,Integer> mapToAdd = new HashMap<>();
//		for(int i = 0; i< nums.length ; i++) {
//			int tmp = target-nums[i];
//			if(mapToAdd.containsKey(tmp)) {
//				
//				return new int[] {mapToAdd.get(tmp),i};
//			}
//			mapToAdd.put(nums[i],i);
//			
//		}
//		return new int[] {};
		
		Map<Integer,Integer> pmap = new HashMap<>();
		for(int i=0;i<= nums.length; i++) {
			
			int tmp =  target - nums[i];
			if(pmap.containsKey(tmp)) {
				return new int[]{pmap.get(tmp),i};
			}
			 pmap.put(nums[i],i);
		}
		return new int[]{};
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] req = { 11, 7,2, 15 };

		TwoSum t = new TwoSum();
		int[] res = t.twoSum(req, 9);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i]);
		}

	}

}
