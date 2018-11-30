package com.aad888;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame{

    private JPanel topPanel ;
    private Box platformBox;
    private JLabel platformLabel;


    private JPanel bottomPanel ;
    private JTextPane bottomPane;

    public void init(){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

//        SubstanceLookAndFeel.setSkin("org.pushingpixels.substance.api.skin.GraphiteSkin");
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());

        platformBox = Box.createHorizontalBox();
        platformLabel = new JLabel("");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(this);
        this.setVisible(true);



    }

    public static void main(String[] args) {
        new Gui().init();
    }
}
