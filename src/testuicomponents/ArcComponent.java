/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testuicomponents;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import javax.swing.JComponent;


public class ArcComponent extends JComponent
{

    int arcLength = 220;        // Degrees

    void shorter()
    {
        arcLength -= 5;
        if (arcLength < 0)
        {
            arcLength = 220;
        }
        repaint();
    }

    void longer()
    {
        arcLength += 5;
        if (arcLength > 220)
        {
            arcLength = 0;
        }
        repaint();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);


        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        var arc = new Arc2D.Double(20, 20, 30, 30, 230, -arcLength, Arc2D.OPEN);
        g2.setColor(Color.CYAN);
        g2.setStroke(new BasicStroke(2f));
        g2.draw(arc);
        // g2.drawArc(40, 40, 30, 30, 230, -arcLength);  // same behavior than with Arc2D.Double

        g2.dispose();
    }
}
