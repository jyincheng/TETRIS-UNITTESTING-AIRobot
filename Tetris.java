package com.zetcode;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;

/*
Java Tetris game clone

Author: Jan Bodnar
Website: http://zetcode.com
 */

/*
public class Tetris extends JFrame {

    private JLabel statusbar;

    public Tetris() {

        initUI();
    }

    private void initUI() {

        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    JLabel getStatusBar() {

        return statusbar;
    }

    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {

            var game = new Tetris();
            game.setVisible(true);
        });
    }
}
 */

public class Tetris extends JFrame {
    private JLabel statusbar;
    private Board board;
    public Tetris() { initUI(); }
    private void initUI() {
        statusbar = new JLabel(" 0");
        add(statusbar, BorderLayout.SOUTH);

        var board = new Board(this);
        add(board);
        board.start();

        setTitle("Tetris");
        setSize(200, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    public JLabel getStatusBar() { return statusbar; }
    public void dropDown() { board.dropDown(); }
    public boolean isGameOver() { return (statusbar.getText() == "Game over"); }
    //public int numLinesRemoved() { return board.numLinesRemoved(); }
    public void restart() {
        board.start();
        statusbar.setText("");
    }
    public boolean move(int x_val) {
        return board.tryMove(board.getCurPiece(), board.curX + x_val, board.curY);
    }
    public boolean rotate(boolean clockwise) {
        Shape piece;
        if (clockwise)
            piece = board.getCurPiece().rotateLeft();
        else
            piece = board.getCurPiece().rotateRight();
        return board.tryMove(piece, board.curX, board.curY);
    }
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            Tetris game = new Tetris();
            game.setVisible(true); });
    }
}