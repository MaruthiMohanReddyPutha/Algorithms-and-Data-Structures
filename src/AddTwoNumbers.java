class AddTwoNumbers {

    public static void main(String[] args){
        ListNode test1 = new ListNode(5);
        test1.next = new ListNode(2);
        test1.next.next = (new ListNode(3));
        ListNode test2 = new ListNode(5);
        test2.next  = new ListNode(9);
        AddTwoNumbers driver = new AddTwoNumbers();
        driver.printLinkedList(driver.addTwoNumbers(test1, test2));
    }

    int carryOver = 0;

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = length(l1);
        int len2 = length(l2);
        ListNode result = null;
        if(len1 > len2){
            //Which means the length of first list is greater than the second one
            //padding the second list to the first one.
            l2 = paddingList(l2, len1-len2);
            result = recursivelyAdd(l1, l2);
        }else{
            //Which covers the case of when the second list is larger than the first one
            //Hence we have to pad the first list to reach the size of second list
            l1 = paddingList(l1, len2-len1);
            result = recursivelyAdd(l1, l2);
        }
        System.out.println("Carry over value inside the main driver "+carryOver);
        if(carryOver != 0){
            ListNode latestHead = new ListNode(carryOver);
            latestHead.next = result;
            result = latestHead;
        }

        return result;
    }

    //A method used to recursively add the value;
    public ListNode recursivelyAdd(ListNode h1, ListNode h2){
        if(h1.next == null && h2.next == null){     //Base Case to get out of recursion
            int total = h1.val+h2.val + carryOver;
            carryOver = total / 10;
            System.out.println("Carry over inside if loop, "+carryOver);
            return new ListNode(total % 10);
        }
        ListNode sumUntilNow = recursivelyAdd(h1.next, h2.next);    //Recursively get the sum and the latest significant digit's node.

        //Setting the final parameters
        int newTotal = h1.val + h2.val + carryOver;
        carryOver = (newTotal)/10;
        System.out.println("Carry over outside if loop, "+carryOver);
        ListNode stepHead = new ListNode((newTotal)%10);
        stepHead.next = sumUntilNow;    //Creating the new head with the sum until now
        return stepHead;
    }

    //Used to get the length of the linked lists
    public int length(ListNode head){
        int count = 0;
        while(head != null){
            count++;
            head = head.next;
        }
        return count;
    }

    //Pad the smaller linked list with extra leading zeroes to make it to the size of bigger list
    public ListNode paddingList(ListNode oldHead, int p){
        ListNode current = oldHead;
        for(int i = 0; i < p; i++){
            ListNode temp = new ListNode(0);
            temp.next = current;
            current = temp;
        }
        return current;
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
