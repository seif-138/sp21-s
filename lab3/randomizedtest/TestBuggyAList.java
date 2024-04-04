package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
   public void testThreeAddThreeRemove(){
       BuggyAList<Integer> bug=new BuggyAList<>();
       AListNoResizing<Integer> ls=new AListNoResizing<>();
       for(int i=4;i<=7;i++){
           bug.addLast(i);
           ls.addLast(i);
       }
       for(int i=4;i<=7;i++) {
           int expected = ls.removeLast();
           int actual = bug.removeLast();
           Assert.assertEquals(expected, actual);
       }
  }



    @Test
      public void randomizedTest(){
          AListNoResizing<Integer> L = new AListNoResizing<>();
          BuggyAList<Integer>k=new BuggyAList<>();

          int N = 5000;
          for (int i = 0; i < N; i += 1) {
              int operationNumber = StdRandom.uniform(0, 4);
              if (operationNumber == 0) {
                  // addLast
                  int randVal = StdRandom.uniform(0, 100);
                  L.addLast(randVal);
                  k.addLast(randVal);
                  System.out.println("addLast(" + randVal + ")");
              } else if (operationNumber == 1) {
                  // size
                  int size = L.size();
                  int ksize=k.size();
                  System.out.println("size: " + size);
                  Assert.assertEquals(size,ksize);
              }
              else if(operationNumber == 2&&L.size()>0){
                  int last=L.getLast();
                  int klast=k.getLast();
                  System.out.println("getLast(): "+last);
                  Assert.assertEquals(last,klast);
              }
              else if(operationNumber == 3&&L.size()>0){
                  int rmv=L.removeLast();
                  int krmv=k.removeLast();
                  System.out.println("removeLast(): "+rmv);
                  Assert.assertEquals(rmv,krmv);
              }
          }
      }
}
