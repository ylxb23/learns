package com.zero.learns.algs;

public class LinkReverse {

    public static Link reverse(Link link) {
        if(link == null) {
            return null;
        }
        Link p = link;
        Link rev = null;
        Link temp;
        while(p != null) {
            temp = p.next;
            p.next = rev;

            rev = p;
            p = temp;
        }
        return rev;
    }

    public static void main(String[] args) {
        Link link = Link.build(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println("link: " + link);
        assert link != null;
        System.out.println("reversed link: " + reverse(link));
    }
}
