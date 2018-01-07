
public class RemoveNthNodeFromEnd {
	
	public static void main(String args[]) {
		RemoveNthNodeFromEnd driver = new RemoveNthNodeFromEnd();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		/*head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);*/
		
		System.out.println("Given list ");
		driver.printLinkedList(head);
		
		System.out.println("Modified list ");
		driver.printLinkedList(driver.removeNthFromEnd(head, 1));
	}
	
	public ListNode removeNthFromEnd(ListNode head, int n) {
        //Strategy is to maintain two pointers at a distance of n and move the first pointer to n distance and then move two pointers at once
        /*ListNode first = head, second = head;
        if(head == null){
            return head;
        }
        
        int count = 1;
        while(count < n){
            second = second.next;
            count++;
        }
        
        ListNode prevFirst = null;
        
        
        
        while(second.next != null){
            prevFirst = first;
            first = first.next;
            second = second.next;
        }
        
        //Case when there is only one element in the list and n=1
        if(prevFirst == null && n == 1){
            return null;
        }
        
        if(head == first) {		//the case where first element is deleted
        	head = head.next;
        	first = first.next;
        	return first;
        }
        
        prevFirst.next = first.next;
        
        return head;*/
		
		//Second method
		ListNode temp = new ListNode(0);
		temp.next = head;
		ListNode first = temp,second = temp;
		for(int i = 0; i < n; i++) {	//I am putting the end pointer 
			first = first.next;
		}
		System.out.println("Val of first "+first.val);
		while(first != null && first.next != null) {
			first = first.next;
			second = second.next;
		}
		System.out.println("val of first & second "+first.val+" & "+second.val);
		second.next = second.next.next;		
		return temp.next;
    }
	
	public void printLinkedList(ListNode head){
        ListNode curr = head;
        while(curr != null){
            System.out.print(curr.val+" -> ");
            curr = curr.next;
        }
        System.out.println("\n");
    }
	
}
