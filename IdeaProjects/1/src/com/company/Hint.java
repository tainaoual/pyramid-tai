package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hint implements ActionListener {

    public static void hint(int[] shot, int[][] shps, int attempt) {
        int rw = 0,
                col = 0;

        for (int line = 0; line < shps.length; line++) {
            if (shps[line][0] == shot[0])
                rw++;
            if (shps[line][1] == shot[1])
                col++;
        }

        System.out.printf("\nHint %d: \nrw %d -> %d shps\n" +
                "col%d -> %d shps\n", attempt, shot[0] + 1, rw, shot[1] + 1, col);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
