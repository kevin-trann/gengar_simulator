import java.awt.*;
import javax.swing.*;

public class Animation extends JPanel{


    @Override
    public void paintComponent(Graphics g) { //method to draw 2D shapes
        super.paintComponent(g); //draws just background (to update visuals)
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(new Color(125, 120, 163));
        //body
        g2d.fillOval(30, 233, 175, 200);
    
        //arms
        g2d.fillOval(6, 290, 70, 70);
        g2d.fillPolygon(new int [] {240,210,210}, new int [] {330,310, 330}, 3);
        g2d.fillPolygon(new int [] {240,210,210}, new int [] {320,300, 320}, 3);
        g2d.fillPolygon(new int [] {230,200,200}, new int [] {340,320, 340}, 3);
    
        g2d.fillOval(150, 290, 80, 60);
        //tail
        g2d.fillPolygon(new int [] {5,55,45}, new int [] {380,370,400}, 3);
    
        //legs
        g2d.fillRect(40, 330, 46, 110);
        g2d.fillRect(140, 330, 46, 110);
        g2d.fillOval(137, 370, 60, 60);
        g2d.fillPolygon(new int [] {200,160,160}, new int [] {440,410, 440}, 3);
    
        //top
        g2d.fillPolygon(new int [] {30,45,75}, new int [] {230,278,247}, 3);
        g2d.fillPolygon(new int [] {220,180,160}, new int [] {230,310,248}, 3);
        g2d.fillPolygon(new int [] {90,97,137}, new int [] {240,220, 240}, 3);
        g2d.fillPolygon(new int [] {70,77,117}, new int [] {250,230, 250}, 3);
        g2d.fillPolygon(new int [] {187,137,140}, new int [] {250,220, 250}, 3);
        g2d.fillPolygon(new int [] {200,160,160}, new int [] {250,220, 250}, 3);

        //log
        g2d.setColor(new Color(86,50,50));
        g2d.fillRect(500, 30, 46, 110);
        g2d.fillArc(500, 15, 46, 30, 0, 180);
        g2d.fillArc(500, 120, 46, 30, 180, 180);
        g2d.fillRect(480, 50, 26, 10);
        g2d.fillRect(540, 100, 26, 10);

        //Shadow Ball visuals
        if (Gengar.getShadowBall() == true){ //if Shadow Ball is clicked, draw visuals for Shadow Ball
            g2d.setColor(new Color(48, 25, 52));
            g2d.fillOval(250, 233, 70, 70);
            
            g2d.setColor(new Color(237, 142, 233));
            g2d.fillOval(267, 250, 34, 34);
            
            g2d.setColor(new Color(48, 25, 52));
            g2d.fillOval(270, 252, 29, 29);
            
            g2d.setColor(Color.BLACK);
            g2d.fillOval(250, 233, 10, 10);
            g2d.fillOval(276, 257, 16, 16);
            g2d.fillOval(246, 289, 10, 10);
            g2d.fillOval(316, 289, 10, 10);
            g2d.fillOval(312, 234, 10, 10);
            
        }

        //Dream Eater visuals
        else if (Gengar.getDreamEater() == true){

            //pink circles
            g2d.setColor(new Color(255,143,143));
            g2d.fillOval(452, 234, 13, 13);
            g2d.fillOval(402, 204, 13, 13);
            g2d.fillOval(320, 215, 13, 13);
            g2d.fillOval(260, 170, 13, 13);
            g2d.fillOval(340, 285, 13, 13);
            g2d.fillOval(356, 160, 13, 13);
            g2d.fillOval(396, 120, 13, 13);

            //trailing lines
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(462, 229, 470, 221);
            g2d.drawLine(467, 229, 475, 221);
            g2d.drawLine(412, 199, 420, 191); 
            g2d.drawLine(417, 199, 425, 191);

            g2d.drawLine(330, 210, 338, 202); 
            g2d.drawLine(335, 210, 343, 202);

            g2d.drawLine(270, 165, 278, 157); 
            g2d.drawLine(275, 165, 283, 157);

            g2d.drawLine(350, 280, 358, 272); 
            g2d.drawLine(355, 280, 363, 272);

            g2d.drawLine(366, 155, 374, 147); 
            g2d.drawLine(371, 155, 379, 147);

            g2d.drawLine(406, 115, 414, 107); 
            g2d.drawLine(411, 115, 419, 107);
        }
        //Toxic Visuals
        else if (Gengar.getToxic() == true){
            g2d.setColor(new Color (158, 98, 227));
            g2d.fillOval(552, 24, 16, 16);
            g2d.fillOval(556, 74, 10, 10);
            g2d.fillOval(556, 124, 10, 10);
            g2d.fillOval(568, 49, 13, 13);

            g2d.fillOval(472, 24, 16, 16);
            g2d.fillOval(482, 74, 10, 10);
            g2d.fillOval(460, 49, 13, 13);
            g2d.fillOval(472, 94, 10, 10);
            g2d.fillOval(482, 114, 10, 10);

            g2d.fillOval(445, 139, 60, 10);
            g2d.fillOval(515, 148, 60, 10);
            g2d.fillOval(465, 148, 60, 10);
            g2d.fillOval(540, 140, 60, 10);
            
        }

        //Shadow Punch visuals
        else if (Gengar.getShadowPunch() == true){
            g2d.setColor(Color.BLACK);
            g2d.fillRect(300, 150, 100, 60);
            g2d.fillRect(294, 210, 50, 30);

            g2d.setColor(new Color(59, 68, 75));
            g2d.fillRect(305, 155, 90, 50);
            g2d.fillRect(299, 215, 40, 20);

            g2d.setColor(Color.BLACK);
            g2d.fillRect(320, 170, 8, 39);
            g2d.fillRect(372, 170, 8, 39);
            g2d.fillRect(346, 170, 8, 39);

            //trailing lines
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(280, 270, 290, 255);
            g2d.drawLine(270, 260, 280, 245);
            g2d.drawLine(260, 250, 270, 235);
            g2d.drawLine(250, 240, 260, 225);
        }
    }
}
    

