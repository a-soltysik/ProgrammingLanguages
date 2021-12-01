package com.github.a_soltysik;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class MainPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener {
    private Shape chosenShape;
    private Point chosenPoint = new Point(0, 0);
    private final RunningButton runningButton;

    public MainPanel(int width, int height) {
        super();
        addMouseListener(this);
        addKeyListener(this);
        addMouseMotionListener(this);
        setLayout(null);
        setPreferredSize(new Dimension(width, height));

        runningButton = new RunningButton(new Point(0, getPreferredSize().height - 100), new Point(0, 0));

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(getPreferredSize().width - 150, getPreferredSize().height - 100, 150, 50);
        resetButton.addActionListener(e -> {
            runningButton.reset();
            repaint();
            requestFocus();
        });

        add(runningButton);
        add(resetButton);
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

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int safeDistance = 20;
        Rectangle bounds = runningButton.getBounds();
        Rectangle safeArea = new Rectangle(
                bounds.x - safeDistance,
                bounds.y - safeDistance,
                bounds.width + 2 * safeDistance,
                bounds.height + 2 * safeDistance
        );
        System.out.println(safeArea);
        if (safeArea.contains(e.getPoint())) {
            runningButton.run();
        }
    }

    private static class RunningButton extends JButton {
        private final Point position1;
        private final Point position2;
        private final int width = 150;
        private final int height = 50;
        private int positionNumber = 1;

        public RunningButton(Point position1, Point position2) {
            super("Kliknij mnie!");
            this.position1 = position1;
            this.position2 = position2;
            setBounds(position1.x, position1.y, width, height);
        }
        public void run() {
            if (positionNumber == 1) {
                setBounds(position2.x, position2.y, width, height);
                positionNumber = 2;
            }
            else {
                reset();
            }
        }
        public void reset() {
            setBounds(position1.x, position1.y, width, height);
            positionNumber = 1;
        }
    }
}
