
public class PartitionList {
	
	public static void main(String args[]) {
		PartitionList driver = new PartitionList();
		ListNode head = new ListNode(8);
		head.next = new ListNode(7);
		head.next.next = new ListNode(5);
		head.next.next.next = new ListNode(6);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(4);
		head.next.next.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next.next.next = new ListNode(1);
		
		System.out.println("Given list ");
		driver.printLinkedList(head);
		
		System.out.println("Modified list ");
		//driver.partition(head, 5);
		driver.printLinkedList(driver.partition(head, 6));
	}
	
	public ListNode partition(ListNode head, int x) {
        /*ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode first = dummy, second = dummy, fixNode = null, prev = null;
        
        if(head == null){
            return head;
        }
        
        while(second.val < x){
        	System.out.println("The value of Second "+second.val+ " x is : "+x);
            fixNode = second;
            second = second.next;
            first = first.next;
            System.out.println("The value of Second "+second.val+ " x is : "+x+ " first val "+first.val);
        }
        
        prev = fixNode;
        int count = 0;
        
        while(first != null && count < 7){
        	count++;
            //prev = first;   //storing the previous value;
            if(first.val < x){
            	System.out.println("Previous vallue "+prev.val+" first value "+first.val +" Prev next val "+prev.next.val);
                ListNode temp = first.next;
                prev.next = temp;
                
                ListNode temp2 = fixNode.next;
                fixNode.next = first;
                fixNode = fixNode.next;
                fixNode.next = temp2;
                
                first = temp;
                //prev = prev.next;
                System.out.println("Previous vallue "+prev.val+" first value "+first.val +" Prev next val "+prev.next.val);
                
            }else{
                first = first.next;
                //prev.next = first;   //storing the previous value
                prev = prev.next;
            }
            
        }
        
        return dummy.next;*/
		//Another method
		ListNode dummy = new ListNode(0), dummy_2 = new ListNode(0);
        //dummy.next = head;
        ListNode even = dummy, odd = dummy_2, oddHead = odd;
        
        while(head != null) {
        	if(head.val < x) {
        		even.next = head;
        		even = head;
        	}else {
        		odd.next = head;
        		odd = head;
        	}
        	head = head.next;
        	
        }
        
        even.next = oddHead.next;
        odd.next = null;	//This is closing the loop i.e., if the odd number has any further connection to the nodes in the list it would cause a recursive occurance
        
		return dummy.next;
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
