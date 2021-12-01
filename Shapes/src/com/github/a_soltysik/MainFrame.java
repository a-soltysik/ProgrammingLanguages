package com.github.a_soltysik;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public void init() {
        MainPanel panel = new MainPanel();
        getContentPane().add(BorderLayout.CENTER, panel);
        setSize(500, 500);
        panel.setPreferredSize(new Dimension(500, 500));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        pack();

        panel.setFocusable(true);
        panel.requestFocusInWindow();
    }
}
