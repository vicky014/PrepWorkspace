package com.practise.test;

public class MergingTwoLinkedListSorting {

	//created a LinkedList node
	
//	public ListNode mergeUnsortedListNode(ListNode list1, ListNode list2) {
//		if(list1 == null) return list2;
//		if(list2 == null) return list1;
//		
//		ListNode tmp = list1;
//		while(tmp.next != null) {
//			tmp = tmp.next;
//		}
//		
//		tmp.next = list2;
//		
//		return list1;
//	}
	public ListNode sortList(ListNode head) {
		
		
		if(head != null && head.next ==null) return head;
		
		ListNode slow = head;
		ListNode fast = head.next;
		
		while(fast!=null && fast.next!= null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		ListNode mid = slow.next;
		slow.next = null;
		
		ListNode left = sortList(head);
		ListNode right = sortList(mid);

		return mergeLinkedListSorted(left, right);
	}
	public ListNode mergeLinkedListSorted (ListNode list1, ListNode list2) {
		
		ListNode dummy = new ListNode(-1);
		ListNode current = dummy;
		
		while(list1 != null && list2 !=null) {
			
			if(list1.val <= list2.val) {
				current.next = list1;
				list1 = list1.next;
			} else {
				current.next = list2;
				list2 = list2.next;
			}
			
			current=current.next;
		}
		
		if(list1 != null) {
			current.next = list1;
		}
		if(list2 != null) {
			current.next = list2;
		}
		return dummy.next;
	}

	public void printList(ListNode list) {
		while(list != null) {
			System.out.print(list.val + " ");
			list= list.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode list1 = new ListNode(4);
		list1.next = new ListNode(1);
		list1.next.next = new ListNode(3);
		
		ListNode list2 = new ListNode(2);
		list2.next = new ListNode(1);
		list2.next.next = new ListNode(3);
		
		MergingTwoLinkedListSorting m = new MergingTwoLinkedListSorting(); 
//		ListNode list = m.mergeLinkedListSorted(list1, list2);
//		m.printList(list);
		
		ListNode list1tmp = m.sortList(list1);
		ListNode list2tmp = m.sortList(list2);		
//		m.mergeUnsortedListNode(list1tmp, list2tmp);
		ListNode listNew = m.mergeLinkedListSorted(list1tmp, list2tmp);
		m.printList(listNew);
	}

}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}

