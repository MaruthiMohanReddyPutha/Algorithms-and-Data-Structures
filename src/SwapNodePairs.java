
public class SwapNodePairs {
	
	public static void main(String[] args)
	{
		ListNode test = new ListNode(1);
		test.next = new ListNode(2);
		test.next.next = new ListNode(3);
		test.next.next.next = new ListNode(4);
		test.next.next.next.next = new ListNode(5);
		test.next.next.next.next.next = new ListNode(6);
		test.next.next.next.next.next.next = new ListNode(7);
		test.next.next.next.next.next.next.next = new ListNode(8);
		
		System.out.println("Original list: ");
		SwapNodePairs driver = new SwapNodePairs();
		driver.printLinkedList(test);
		System.out.println("Swapped list: ");
		driver.printLinkedList(driver.swapPairs(test));
		
	}

	public ListNode swapPairs(ListNode head) {
        if(head == null){
            return head;
        }
        
        ListNode curr = head;
        ListNode second = curr.next;
        ListNode newHead = curr.next;
        ListNode prev = null;
        
        while(curr != null && curr.next != null){
        	second = curr.next;
            
        	ListNode temp = second.next;     //storing the next node in a temp node
            second.next = curr;      //Then linking the current node's next node with curent node            
            curr.next = temp;    //setting up the current node to the temp
            
            if(prev != null) {
            	prev.next = second;            	
            }
            prev = curr;
            
            curr = curr.next;
        }
        
        return newHead;
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
