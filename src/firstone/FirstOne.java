/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstone;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 *
 * @author Alejandro
 */

@SuppressWarnings("serial")
public class FirstOne extends JPanel {
    
    int x = 0;
    int y = 0;
    
    int ovalSize = 30;
    
    int moveX = 3;
    int moveY = 3;
    
    private void moveBall (JFrame framep){
        
        if ((x >= framep.getWidth() - ovalSize - ovalSize/2 && moveX > 0) || (x <= 0 && moveX < 0) ){
            moveX *= -1;
        }
        if ((y >= framep.getHeight() - ovalSize - ovalSize && moveY > 0) || (y <= 0 && moveY < 0) ){
            moveY *= -1;
        }
        
        x += moveX;
        y += moveY;
    }
    
    @Override
    public void paint (Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.fillOval(x, y, ovalSize, ovalSize);
        
    }
    
    public static void main (String [] args){
        JFrame frame = new JFrame("Mini Tennis");
        FirstOne game = new FirstOne();
        frame.add(game);
        frame.setSize(500, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        while (true){
            game.moveBall(frame);
            game.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException reallyIgnored) {};
        }
    }
}
