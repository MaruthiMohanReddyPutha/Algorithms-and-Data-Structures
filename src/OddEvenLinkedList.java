
public class OddEvenLinkedList {
	
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
		
		OddEvenLinkedList driver = new OddEvenLinkedList();
		System.out.println("Inbound list is: ");
		driver.printLinkedList(test);
		System.out.println("Odd even linked list is ");
		driver.printLinkedList(driver.oddEvenList(test));
		
		
	}
	
	public ListNode oddEvenList(ListNode head) {
        /*//Strategy: Maintain two indices where takes care of the odd valued indices and the other takes care of the even valued indices
        ListNode curr = head;
        int nextOdd = 1;
        
        for(int i = 0; curr != null; nextOdd++){
        	System.out.println("Loop 1");
            ListNode oddNode = curr;
            ListNode evenNode = curr.next;
            ListNode prev = evenNode;
            
            for(int j = 0; evenNode != null && j < nextOdd; j++ ){
            	System.out.println("Inner loop 1"+ " value of nextOdd "+nextOdd+" value of j "+j);
                prev = evenNode;    //holding the prev node to list node
                evenNode = evenNode.next;
            }
            
            if(evenNode == null){   //that means the program has reached end without reaching the next odd index
                break;
            }else {            
	            prev.next = evenNode.next;  //Breaking the link when an odd number is encountered.
	            evenNode.next = curr.next;   //bringing the number 
	            curr.next = evenNode;
	            
	            curr = curr.next;   //Moving the pointer to next level            
            }
            
        }*/
		if(head == null) {
			return null;
		}
		
		ListNode odd = head, even = head.next, evenHead = even;
		int count = 1;
		while(even != null && even.next != null) {
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		
		odd.next = evenHead;
        
        return head;
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
