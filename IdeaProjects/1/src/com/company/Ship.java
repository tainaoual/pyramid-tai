package com.company;

import javax.swing.*;
import java.util.Random;

public class  Ship extends JFrame {



    public static void initshps(int[][] shps) {
        Random random = new Random();

        for (int shp = 0; shp < 2; shp++) {
            shps[shp][0] = random.nextInt(2);
            shps[shp][1] = random.nextInt(2);

//let's check if that shot was already tried
//if it was, just finish the do...while when a new pair was randomly selected
            for (int last = 0; last < shp; last++) {
                if ((shps[shp][0] == shps[last][0]) && (shps[shp][1] == shps[last][1]))
                    do {
                        shps[shp][0] = random.nextInt(2);
                        shps[shp][1] = random.nextInt(2);
                    } while ((shps[shp][0] == shps[last][0]) && (shps[shp][1] == shps[last][1]));
            }

        }
    }

}
