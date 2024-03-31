package deque;

import edu.princeton.cs.algs4.StdOut;

public class ADtest {
    public static void  main(String[] args){
        ArrayDeque<Integer> l=new ArrayDeque<>();
//        l.addFirst(9);
        l.addFirst(8);
        l.addFirst(7);
        l.addFirst(6);
        l.addFirst(5);
        l.addFirst(4);
        l.addFirst(3);
        l.addFirst(2);
        l.addFirst(1);

        System.out.println(l.get(8));
        System.out.println(l.removeFirst());
        System.out.println(l.removeLast());
        l.addFirst(9);
        l.addLast(0);
        ArrayDeque<Integer> k=new ArrayDeque<>(l);
    }
}
