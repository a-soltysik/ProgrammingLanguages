package com.github.a_soltysik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class MainPanel extends JPanel implements MouseListener, KeyListener {
    private Shape chosenShape;
    private Point chosenPoint = new Point(0, 0);

    public MainPanel() {
        super();
        addMouseListener(this);
        addKeyListener(this);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if (chosenShape == null) {
            return;
        }
        Graphics2D g2d = (Graphics2D) g;
        g2d.draw(chosenShape);
        chosenShape = null;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        chosenPoint = e.getPoint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_K -> chosenShape = new Rectangle2D.Float(chosenPoint.x, chosenPoint.y, 50f, 50f);
            case KeyEvent.VK_O -> chosenShape = new Ellipse2D.Float(chosenPoint.x, chosenPoint.y, 70f, 50f);
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
