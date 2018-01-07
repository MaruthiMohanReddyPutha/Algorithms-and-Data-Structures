
public class InsertionSortList {
	
	public ListNode sortedHead = new ListNode(0); 
	
	public static void main(String[] args) {
		
		ListNode head = new ListNode(3);
		head.next = new ListNode(4);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(5);
		head.next.next.next.next = new ListNode(2);
		head.next.next.next.next.next = new ListNode(8);
		head.next.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next.next = new ListNode(7);
		
		InsertionSortList driver = new InsertionSortList();
		System.out.println("Given list is ");
		driver.printLinkedList(head);
		System.out.println("Sorted List is ");
		driver.printLinkedList(driver.insertionSortList(head));
	}
    
    public ListNode insertionSortList(ListNode head) {
    	/*
    	//This is BRUTEFORCE Method and runs inefficiently, but this just a starter.
    	if(head == null) {
    		return head;
    	}
    
        sortedHead = new ListNode(head.val);
        head = head.next;

        ListNode curr = null; 
        
        while(head != null){
        	
            ListNode prev = null;
            curr = sortedHead;
            Boolean bool = false;
            
            while(curr != null ){
                if(!bool){                	
                    if(head.val <= curr.val){
                        bool = true;                        
                        ListNode newNode = new ListNode(head.val);
                        newNode.next = curr;
                        if(prev == null){   //That means the first node of the sorted list has been changed
                            sortedHead = newNode;
                        }else{
                            prev.next = newNode;
                        }
                    }                 
                }  
                prev = curr;
                curr = curr.next;
            }
            
            if(!bool) {	//That means just add the node to the last of the new sorted list
            	prev.next = new ListNode(head.val);
            }
            
            head = head.next;            
        }
        
        return sortedHead;    */ 
    	
    	//Highly enhanced version
    	if(head == null ) {
    		return head;
    	}
    	
    	ListNode prev = head;
    	ListNode node = head.next;
    	int count = 1;	//This counter is set at the start of the new list
    	
    	while(node != null) {
    		if(node.val > prev.val) {
    			prev = node;
    			System.out.println(" Value of prev in IF "+prev.val);
    			node = node.next;
    			count++;
    			continue;
    		}else {
    			
    			ListNode next = node.next;
    			prev.next = next;	//This should be there since we are using a single linked list
    			//if the program enters this conditional part, that means the current node is going to be replaced
    			//And there is going to be a break here. Therefore maintain the prev node in a variable and attach its next to the current node's next value
    			System.out.println(" Value of prev in ELSE  "+prev.val);
    			ListNode prevTemp = null;
    			
    			ListNode curr = head;
    			int c = 0;
    			
    			while( c < count && curr.val < node.val ) {
    				prevTemp = curr;
    				curr = curr.next;
    				c++;
    			}
    			
    			if(prevTemp == null) {
    				node.next = curr;
    				head = node;
    				node = next;
    			}else {
    				prevTemp.next = node;
    				node.next = curr;
    				node = next;
    			}
    			count++;
    		}
    	}
    	
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
