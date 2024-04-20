package com.zero.learns.algs;


public class Link {
    public int val;
    public Link next;

    public Link() {
    }

    public Link(int v) {
        this.val = v;
    }

    public Link(int v, Link n) {
        this.val = v;
        this.next = n;
    }

    public static Link build(int[] vals) {
        if(vals ==null || vals.length == 0) {
            return null;
        }
        Link res = new Link(vals[0]);
        Link p = res;
        for(int i=1; i<vals.length; i++) {
            p.next = new Link(vals[i]);
            p = p.next;
        }
        return res;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Link p = this;
        while (p != null) {
            sb.append(p.val).append(",");
            p = p.next;
        }
        return sb.substring(0, sb.length()-1);
    }
}
