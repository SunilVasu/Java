package ctci;

import java.util.Stack;

/**
 * Created by sunil on 1/5/18.
 */
public class a_LinkedList {
    public static void main(String[] arg){

        ListNode curr = init();
        while (curr != null) {
            System.out.print(curr.val+"-->");
            curr=curr.next;
        }System.out.print("null\n");

        //remove Duplicate
        ListNode copy_h = init();
        duplicate(copy_h);
        display(copy_h);
        //display(duplicate2(copy_h));

        //reverse
        copy_h=init();
        System.out.print("Reverse: ");
        display(reverse(copy_h));

        //palindrome
        copy_h=init();
        System.out.print("Palindrome: "+palindrome(copy_h)+"\n");
        System.out.print("Palindrome2: "+palindrome2(copy_h)+"\n");

        //kth elem
        copy_h=init();
        System.out.print("kth elem from end: "+kth_elem(copy_h,3).val+"\n");

        //partition list for given k:  all nodes less than x come before nodes greater than or equal to x
        copy_h=init();
        System.out.print("Partition: ");
        display(partition(copy_h,4));
        //sum
        copy_h=init();
        ListNode c1=copy_h;
        copy_h=sum(copy_h,c1,0);
        System.out.print("Sum of 2 linkedList: ");
        display(copy_h);
    }
    public static ListNode init(){

        ListNode head = new ListNode(1);
        head.next=new ListNode(1);
        head.next.next=new ListNode(9);
        //head.next.next.next=new ListNode(5);

        /*ListNode head = new ListNode(1);
        head.next=new ListNode(4);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(2);
        head.next.next.next.next=new ListNode(5);
        head.next.next.next.next.next=new ListNode(2);*/
        return head;
    }
    public static void display(ListNode node){
        while (node != null) {
            System.out.print(node.val+"-->");
            node=node.next;
        }System.out.print("null\n");
    }
    //remove Duplicate
    public static void duplicate(ListNode copy_h){
        ListNode h = copy_h;
        while(h!=null && h.next!=null){
            if(h.val==h.next.val)
                h.next=h.next.next;
            else
                h=h.next;
        }
    }
    public static ListNode duplicate2(ListNode copy_h){
        ListNode curr = copy_h;
        if(curr==null) return curr;
        if(curr.next!=null && curr.val==curr.next.val){
            while(curr.next!=null && curr.val==curr.next.val)
                curr=curr.next;
            return duplicate2(curr.next);
        }else{
            curr.next = duplicate2(curr.next);
        }return curr;
    }
    //reverse
    public static ListNode reverse(ListNode copy_h){
        ListNode newHead = null;
        while(copy_h!=null){
            ListNode next = copy_h.next;
            copy_h.next = newHead;
            newHead = copy_h;
            copy_h = next;
        }
        return newHead;
    }
    //palindrome: alternative: instead of reversing store the slow val in stack and then compare stack & fast(mid) values.
    public static boolean palindrome(ListNode copy_h){
        ListNode fast=copy_h, slow=copy_h;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null) slow=slow.next;
        slow=reverse(slow);
        fast=copy_h;
        while(slow!=null){
            if(slow.val!=fast.val) return false;
            slow=slow.next;
            fast=fast.next;
        }
        return true;
    }
    public static boolean palindrome2(ListNode copy_h){
        ListNode fast=copy_h, slow=copy_h;
        Stack<Integer> stack = new Stack<>();
        while(fast!=null && fast.next!=null){
            stack.push(slow.val);
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast!=null) slow=slow.next;
        while(slow!=null){
            int top = stack.pop();
            if(top!=slow.val)
                return false;
            slow=slow.next;
        }
        return true;
    }
    //kth element from end= time O(n), space O(1)
    public static ListNode kth_elem(ListNode copy_h, int k){
        ListNode p1=copy_h, p2=copy_h;
        for(int i=0;i<k;i++){
            if(p1==null) return null;
            p1=p1.next;
        }
        while(p1!=null){
            p1=p1.next;
            p2=p2.next;
        }
        return p2;
    }
    //partition: all nodes less than x come before nodes greater than or equal to x
    public static ListNode partition(ListNode copy_h, int k){
        ListNode dummySmall=new ListNode(0);
        ListNode dummyLarge=new ListNode(0);
        ListNode small = dummySmall;
        ListNode large = dummyLarge;
        while(copy_h!=null){
            if(copy_h.val<k){
                small.next=copy_h;
                small=copy_h;
            }else{
                large.next=copy_h;
                large=copy_h;
            }
            copy_h=copy_h.next;
        }
        //connect the small list(elem < k) and large list(elem >= k)
        small.next=dummyLarge.next;
        large.next=null;

        return dummySmall.next;
    }
    //sum list
    public static ListNode sum(ListNode ip1, ListNode ip2, int carry){
        if(ip1==null && ip2==null && carry==0)
            return null;
        ListNode res = new ListNode();
        int value=carry;
        if(ip1!=null)
            value+=ip1.val;
        if(ip2!=null)
            value+=ip2.val;
        res.val=value%10;
        if(ip1!=null || ip2!=null || carry!=0){
            ListNode more = sum(ip1==null?null:ip1.next, ip2==null?null:ip2.next, value>=10?1:0);
            res.next=more;
        }
        return res;
    }
    //intersection : O(A + B) time, where A and Bare the lengths, O(1) space
    public static ListNode intersection(ListNode l1, ListNode l2){
        if(l1==null || l2==null) return null;
        //Step1: get the tail and size of the list
        ResultNode result1 = getTailAndSize(l1);
        ResultNode result2 = getTailAndSize(l2);
        //Step2: if tail is not equal return null
        if(result1.tail!=result2.tail) return null;
        //Step3: Set pointer to start of list
        ListNode shorter = result1.size<result2.size?l1:l2;
        ListNode longer = result1.size<result2.size?l2:l1;
        //Step4: chop excess in larger list
        longer = getkthNode(longer, Math.abs(result1.size-result2.size));
        //Step5: check for intersection
        while(shorter!=longer){
            shorter=shorter.next;
            longer=longer.next;
        }
        return longer;
    }
    public static ResultNode getTailAndSize(ListNode node){
        if(node==null) return null;
        int size=0;
        ListNode cur=node;
        while(cur!=null){
            cur=cur.next;
            size++;
        }
        return  new ResultNode(cur,size);
    }
    public static ListNode getkthNode(ListNode h, int k){
        ListNode curr = h;
        while(k>0 && curr!=null){
            curr=curr.next;
            k--;
        }
        return curr;
    }
    //circular Loop Detection
    public static ListNode loopDetection(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next;
            if(slow==fast) //collision
                break;
        }
        //no collision --> no meeting point & loop
        if(fast==null || fast.next==null)
            return null;

        slow=head;
        while(slow!=fast){
            slow=slow.next;
            fast=fast.next;
        }
        return fast;
    }

}

