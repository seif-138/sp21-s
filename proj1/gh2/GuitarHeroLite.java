package gh2;
import edu.princeton.cs.algs4.StdAudio;
import edu.princeton.cs.algs4.StdDraw;

/**
 * A client that uses the synthesizer package to replicate a plucked guitar string sound
 */
public class GuitarHeroLite {
    public static final double CONCERT_A = 440.0;
    public static final double CONCERT_C = CONCERT_A * Math.pow(2, 3.0 / 12.0);
    public static final String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
    public static GuitarString[] guitar=new GuitarString[keyboard.length()];


    public static void main(String[] args) {
        /* create two guitar strings, for concert A and C */
        GuitarString stringA = new GuitarString(CONCERT_A);
        GuitarString stringC = new GuitarString(CONCERT_C);

        for (int i=0;i<keyboard.length();i++){
            double x=(i-24)/12;
            double y=Math.pow(2.0,x);
            guitar[i]=new GuitarString(440*y);

        }

        while (true) {

            /* check if the user has typed a key; if so, process it */
            char typed='X';
            if (StdDraw.hasNextKeyTyped()) {
                char key = StdDraw.nextKeyTyped();
                typed=key;
                if(keyboard.indexOf(key)==-1)continue;
                guitar[keyboard.indexOf(key)].pluck();
                /*
             if (key == 'a') {
                    stringA.pluck();

                } else if (key == 'c') {
                    stringC.pluck();
                }

                */
            }

            /* compute the superposition of samples */
            double sample = stringA.sample() + stringC.sample();
           double sum=0.0;
           for(int i=0;i<keyboard.length();i++){
               sum+=guitar[i].sample();
           }


            /* play the sample on standard audio */
            StdAudio.play(sum);

            /* advance the simulation of each guitar string by one step */
//            stringA.tic();
//            stringC.tic();
            for (int i=0;i<keyboard.length();i++){
                guitar[i].tic();
            }
        }
    }
}

