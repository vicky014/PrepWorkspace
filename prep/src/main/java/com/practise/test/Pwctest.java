package com.practise.test;

public class Pwctest {

	public static void main(String[] args) {
//		You are given the heads of two sorted linked lists list1 and list2.
//		Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
//		Return the head of the merged linked list.
//		 
//		Example 1:
//		 
//		Input: list1 = [1,2,4],
//		list2 = [1,3,4]
//		Output: [1,1,2,3,4,4]
		
//		int list1[] = {1,2,4};
//		int list2[] = {1,3,4};
//		======================================
//		
//		Time : 10 mins
//		 
//		Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.
//		Note that you must do this in-place without making a copy of the array.
//		Example 1:
//		Input: nums = [0,1,0,3,12]Output: [1,3,12,0,0]
//		Example 2:
//		Input: nums = [0]Output: [0]
		
		int list1[] = {0,1,0,3,12};
		
		// a=1, b-2, c=2
//		int min = list1[0];
//		int max = 
		for(int i=0;i<list1.length-1;i++) {
//			int min = list1[i];
//			int minNext = list1[i+1];
			
			
			System.out.println("---"+list1[i]+" "+i);
			if(list1[i] == 0 ) {
				int temp;
				temp = list1[i];
				list1[i] = list1[i+1];
				list1[i+1] = temp;
			}
			
			
		}
		
		for(int num: list1) {
			System.out.println(num);
		}
//		System.out.println(list1);
		
		
		int [] arr={0,1,0,3,12};
		int left=0;
		for (int i = 0; i < arr.length; i++) {
		    if(arr[i]!=0){
		        int temp=arr[i];
		        arr[i]=arr[left];
		        arr[left]=temp;
		        left++;
		    }
		}
		for (int i = 0; i < arr.length; i++) {
		    System.out.println(arr[i]);
		}
		
//		core java to prepare
//		dsa without java 8
//		jvm architecture - class loader process, string pooling, executor services
//		sql-> asset properties
		
//		

		
		
	}

}

//Struct listLinked{
//	
//}