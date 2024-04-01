package deque;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Assert;
import org.junit.Assert.*;
import org.junit.Test;


public class ADtest {
        @Test
    public void testadd() {
            ArrayDeque<Integer> l = new ArrayDeque<>();
//        l.addFirst(9);
            l.addFirst(8);
            l.addFirst(7);
            l.addFirst(6);
            l.addFirst(5);
            l.addFirst(4);
            l.addFirst(3);
            l.addFirst(2);
            l.addFirst(1);



            l.addFirst(9);
            l.addLast(0);
            int x=9;
            int y=l.get(0);
              org.junit.Assert.assertEquals(x,y);
    }
    @Test
        public void testadd2() {
                ArrayDeque<Integer> k = new ArrayDeque<>();
                Assert.assertEquals(null, k.get(1));
                k.addLast(2);

        }

}
