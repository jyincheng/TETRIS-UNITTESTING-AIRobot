package com.zetcode;

import org.junit.*;
import static org.junit.Assert.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.awt.event.WindowEvent;

public class TetrisTest {
    static public Tetris tetris;
    //@BeforeClass
    public static void beforeTest() {
        tetris = new Tetris();
        tetris.setVisible(true);
    }

    @ Test
    public void testRandomMove() {
        tetris.restart();
        // Random move
        int t = 0;
        try {
            while (t < 100) {
                if (Math.random() > 0.5)
                    tetris.move(1);
                else
                    tetris.move(-1);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                }
                if (Math.random() > 0.5)
                    tetris.rotate(false);
                else
                    tetris.rotate(true);
                t++;
            }
        } catch (Exception e) {
            fail();
        }
    }

    @ Test
    public void testGameOver() {
        for (int i=0; i<10; i++)
            tetris.dropDown();
        boolean ret = tetris.isGameOver();
        assertTrue(ret);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
    }
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TetrisTest.class);
        for ( Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        System.out.println(result.wasSuccessful());
        // Closing the window after the final result is printed
        tetris.dispatchEvent(new WindowEvent(tetris, WindowEvent.WINDOW_CLOSING));
    }

}