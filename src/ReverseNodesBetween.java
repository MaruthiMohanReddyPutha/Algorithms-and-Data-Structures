
public class ReverseNodesBetween {
	
	public static void main(String args[]) {
		ReverseNodesBetween driver = new ReverseNodesBetween();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);
		head.next.next.next.next.next.next.next = new ListNode(8);
		
		System.out.println("Given list ");
		driver.printLinkedList(head);
		
		System.out.println("Modified list ");
		driver.printLinkedList(driver.reverseBetween(head, 1, 8));
	}
	
	public ListNode reverseBetween(ListNode head, int m, int n) {
        int count = 0;
        ListNode newHead = new ListNode(0);
        newHead.next = head;
        head = newHead;
        
        ListNode headConnector = null;
        while(count < m){
            headConnector = head;
            head = head.next;
            count++;
        }
        //ListNode tail = head;
        ListNode prev = null;
        
        while(count < n){
            ListNode temp = head.next;  //This is the broken link and this link has to be maintained inorder to continue our process
            head.next = prev;
            prev = head;
            head = temp;
            count++;
        }
        
        ListNode tempHead = head.next;
        head.next = prev;
        
        ListNode tail = headConnector.next;
        headConnector.next = head;
        
        tail.next = tempHead;
        
        return newHead.next;
        
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
