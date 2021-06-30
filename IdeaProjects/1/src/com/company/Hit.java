package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hit implements ActionListener {

    public static boolean hit(int[] shot, int[][] shps) {

        for (int shp = 0; shp < shps.length; shp++) {
            if (shot[0] == shps[shp][0] && shot[1] == shps[shp][1]) {
                System.out.printf("You hit a shp located in (%d,%d)\n", shot[0] + 1, shot[1] + 1);
                return true;
            }
        }
        return false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
