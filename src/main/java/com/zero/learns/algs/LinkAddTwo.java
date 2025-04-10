package com.zero.learns.algs;

public class LinkAddTwo {

    public static Link addTwoNumbers(Link l1, Link l2) {
        boolean upper = false;
        Link res = new Link();
        Link idx = res;
        int currSum;
        while(!(l1 == null && l2 == null)) {
            currSum = upper ? 1 : 0;
            if(l1 != null) {
                currSum += l1.val;
            }
            if(l2 != null) {
                currSum += l2.val;
            }
            upper = currSum > 9;
            idx.next = new Link(currSum % 10);
            idx = idx.next;
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }
        if(upper) {
            idx.next = new Link(1);
        }
        return res.next;
    }

    public static void main(String[] args) {
        Link l1 = Link.build(new int[]{2,4,3});
        Link l2 = Link.build(new int[]{5,6,4});
        Link sum = addTwoNumbers(l1, l2);
        System.out.println("sum of link(" + l1 + ") and link(" + l2 + ") is: " + sum);
    }
}
