package com.zero.learns.algs;

public class Link {

    static class Node {
        int value;
        Node next;
        Node(int v) {
            this.value = v;
        }

        public Node reverse() {
            if(this.next == null) {
                return this;
            }
            Node p = this;
            Node rev = null;
            Node temp;
            while(p != null) {
                temp = p.next;
                p.next = rev;

                rev = p;
                p = temp;
            }
            return rev;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node p = this;
            while(p != null) {
                sb.append(p.value).append(",");
                p = p.next;
            }
            return sb.toString();
        }
    }

    static Node buildLink(int[] arr) {
        if(arr.length == 0) {
            return null;
        }
        Node link = new Node(arr[0]);
        Node p = link;
        for(int i=1; i<arr.length; i++) {
            p.next = new Node(arr[i]);
            p = p.next;
        }
        return link;
    }


    public static void main(String[] args) {
        Node link = buildLink(new int[]{1,2,3,4,5,6,7,8,9});
        System.out.println("link: " + link);
        System.out.println("reversed link: " + link.reverse());
    }
}
