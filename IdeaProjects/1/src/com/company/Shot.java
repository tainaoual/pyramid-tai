package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

 class Shot implements ActionListener {

    public static void shot(int[] shot) {
        Scanner input = new Scanner(System.in);

        System.out.print("rw: ");
        shot[0] = input.nextInt();
        shot[0]--;

        System.out.print("col: ");
        shot[1] = input.nextInt();
        shot[1]--;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
