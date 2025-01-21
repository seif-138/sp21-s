package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        // TODO: YOUR CODE HERE
        AList<Integer> l =new AList<>();
        AList<Integer> ns = new AList<>();
        AList<Double> times = new AList<>();

        int x = 1000,ll=0;
        while (x <= 128000) {
            ns=new AList<>();
            Stopwatch ec = new Stopwatch();
            l.addLast(x);
            double timeforeachcall = ec.elapsedTime();

            Stopwatch sw = new Stopwatch();
            for(int i=0;i<x;i++){
                ns.addLast(ll);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            x *= 2;


        }
        printTimingTable(l,times,l);
    }
}
      /*

          l = new AList<>();
          Stopwatch sw = new Stopwatch();
          double sum = 0;
          for (int i = 0; i < x; i++) {
              Stopwatch ec = new Stopwatch();
              l.addLast(i);
              double timeforeachcall = ec.elapsedTime();
              sum += timeforeachcall;
          }
          double timeInSeconds = sw.elapsedTime();
          ns.addLast(x);
          times.addLast(timeInSeconds);
          x *= 2;
      }
         printTimingTable(l,times,l);
    }
}

       */
