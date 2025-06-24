import java.awt.*;
import javax.swing.*;

public class Animation extends JPanel{

    @Override
    public void paintComponent(Graphics g) { //method to draw 2D shapes
        super.paintComponent(g); //draws just background (to update visuals)
        Graphics2D g2d = (Graphics2D) g;

        //platform
        g2d.setColor(new Color(245, 245, 220));
        g2d.fillOval(0, 403, 425, 50);

        //platform outline
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(3));
        g2d.drawOval(0, 403, 425, 50);

        // body
        g2d.setColor(new Color(125, 120, 163));
        g2d.fillOval(130, 233, 175, 200);

        // arms
        g2d.fillOval(106, 290, 70, 70);
        g2d.fillPolygon(new int [] {340,310,310}, new int [] {330,310, 330}, 3);
        g2d.fillPolygon(new int [] {340,310,310}, new int [] {320,300, 320}, 3);
        g2d.fillPolygon(new int [] {330,300,300}, new int [] {340,320, 340}, 3);
        g2d.fillOval(250, 290, 80, 60);

        // tail
        g2d.fillPolygon(new int [] {105,155,145}, new int [] {380,370,400}, 3);

        // legs
        g2d.fillRect(140, 330, 46, 110);
        g2d.fillRect(240, 330, 46, 110);
        g2d.fillOval(237, 370, 60, 60);
        g2d.fillPolygon(new int [] {300,260,260}, new int [] {440,410, 440}, 3);

        // spikes
        g2d.fillPolygon(new int [] {130,145,175}, new int [] {230,278,247}, 3);
        g2d.fillPolygon(new int [] {320,280,260}, new int [] {230,310,248}, 3);
        g2d.fillPolygon(new int [] {190,197,237}, new int [] {240,220, 240}, 3);
        g2d.fillPolygon(new int [] {170,177,217}, new int [] {250,230, 250}, 3);
        g2d.fillPolygon(new int [] {287,237,240}, new int [] {250,220, 250}, 3);
        g2d.fillPolygon(new int [] {300,260,260}, new int [] {250,220, 250}, 3);


        //log
        if (Gengar.getShowLog()){
        g2d.setColor(new Color(86,50,50));

        //changes log to light purple if Toxic is selected
        if(Gengar.getPaintLog() && Gengar.getToxic()){ 
                g2d.setColor(new Color (158, 98, 227)); 
            }

        //changes log to black if Shadow Punch is selected
        else if(Gengar.getPaintLog() && Gengar.getShadowPunch()){
                g2d.setColor(Color.BLACK); 
            }
        g2d.fillRect(500, 30, 46, 110);
        g2d.fillArc(500, 15, 46, 30, 0, 180);
        g2d.fillArc(500, 120, 46, 30, 180, 180);
        g2d.fillRect(480, 50, 26, 10);
        g2d.fillRect(540, 100, 26, 10);
        }

        //Shadow Ball visuals
        if (Gengar.getShadowBall() == true){ 

            int x = Gengar.getXX();
            int y = Gengar.getYY();

        //visuals for main Shadow Ball
            if(Gengar.getShowShadowBall()){
            g2d.setColor(new Color(48, 25, 52));
            g2d.fillOval(250 + x, 263 + y, 70, 70);

            g2d.setColor(Color.black);
            g2d.setStroke(new BasicStroke(0));
            g2d.drawOval(250 + x, 263 + y, 70, 70);
            
            g2d.setColor(new Color(237, 142, 233));
            g2d.fillOval(267 + x, 280 + y, 34, 34);
            
            g2d.setColor(new Color(48, 25, 52));
            g2d.fillOval(270 + x, 282 + y, 29, 29);
            
            g2d.setColor(Color.BLACK);
            g2d.fillOval(250 + x, 263 + y, 10, 10);
            g2d.fillOval(276 + x, 287 + y, 16, 16);
            g2d.fillOval(246 + x, 319 + y, 10, 10);
            g2d.fillOval(316 + x, 319 + y, 10, 10);
            g2d.fillOval(312 + x, 264 + y, 10, 10);
            }

        //visuals for Shadow Ball explosion
            if(Gengar.getShowExplosion()){
                g2d.setColor(new Color(48, 25, 52));
                g2d.fillOval(455, 8, 70, 70);
                g2d.fillOval(405, 28, 70, 70);
                g2d.fillOval(385, 78, 70, 70);
                g2d.fillOval(405, 128, 70, 70);
                g2d.fillOval(445, 148, 70, 70);
                g2d.fillOval(495, 138, 70, 70);
                g2d.fillOval(505, 103, 70, 70);
                g2d.fillOval(505, 43, 70, 70); 
                g2d.fillOval(485, 78, 70, 70);
                g2d.fillOval(445, 70, 100, 100);

                g2d.setColor(Color.BLACK);
                g2d.fillOval(395, 20, 20, 20);
                g2d.fillOval(555, 20, 20, 20);
                g2d.fillOval(552, 205, 20, 20);
                g2d.fillOval(392, 205, 20, 20);

                g2d.setColor(new Color(237, 142, 233));
                g2d.setStroke(new BasicStroke(3));
                g2d.drawLine(400, 120, 500, 20);
                g2d.drawLine(410, 130, 510, 30);
                g2d.drawLine(420, 140, 510, 50);
                g2d.drawLine(420, 160, 530, 50);
                g2d.drawLine(420, 180, 550, 50);
                g2d.drawLine(440, 180, 560, 60);
                g2d.drawLine(460, 180, 567, 73);
                g2d.drawLine(460, 200, 540, 120);
                g2d.drawLine(470, 210, 560, 120);
                g2d.drawLine(490, 210, 560, 140);
                
            }
            
        }

        //Dream Eater visuals
        else if (Gengar.getDreamEater() == true){

            int x = Gengar.getXX();
            int y = Gengar.getYY();


            
            g2d.setColor(new Color(255, 143, 143));

            //checks if pink circle collides with gengar; disappears if it does
            if(Gengar.getDream7()){
            g2d.fillOval(502 + x, 184 + y, 13, 13); //pink circles
            g2d.drawLine(512 + x, 179 + y, 520 + x, 171 + y); //trailing lines
            g2d.drawLine(517 + x, 179 + y, 525 + x, 171 + y);
            }

            if(Gengar.getDream1()){
            g2d.drawLine(400 + x, 230 + y, 408 + x, 222 + y);
            g2d.drawLine(405 + x, 230 + y, 413 + x, 222 + y);
            g2d.fillOval(390 + x, 235 + y, 13, 13);
            }

            if(Gengar.getDream5()){
            g2d.fillOval(452 + x, 154 + y, 13, 13);
            g2d.drawLine(462 + x, 149 + y, 470 + x, 141 + y);
            g2d.drawLine(467 + x, 149 + y, 475 + x, 141 + y);
            }

            if(Gengar.getDream2()){
            g2d.fillOval(370 + x, 165 + y, 13, 13);
            g2d.drawLine(380 + x, 160 + y, 388 + x, 152 + y);
            g2d.drawLine(385 + x, 160 + y, 393 + x, 152 + y);
            }

            if(Gengar.getDream3()){
            g2d.fillOval(310 + x, 120 + y, 13, 13);
            g2d.drawLine(320 + x, 115 + y, 328 + x, 107 + y);
            g2d.drawLine(325 + x, 115 + y, 333 + x, 107 + y);
            }

            if(Gengar.getDream4()){
            g2d.fillOval(406 + x, 110 + y, 13, 13);
            g2d.drawLine(416 + x, 105 + y, 424 + x, 97 + y);
            g2d.drawLine(421 + x, 105 + y, 429 + x, 97 + y);
            }

            if(Gengar.getDream6()){
            g2d.fillOval(446 + x, 70 + y, 13, 13);
            g2d.drawLine(456 + x, 65 + y, 464 + x, 57 + y);
            g2d.drawLine(461 + x, 65 + y, 469 + x, 57 + y);
            }

            //visuals to show sleeping log
            g2d.setColor(Color.WHITE);
            g2d.setFont(new Font("SansSerif", Font.BOLD, 20));  

            if (Gengar.getZ1()){
            g2d.drawString("Z", 555, 40);  
            }

            if(Gengar.getZ2()){
            g2d.drawString("Z", 565, 30); 
            }
            
            if(Gengar.getZ3()){
            g2d.drawString("Z", 575, 20);  
            } 

        }
        //Toxic visuals
        else if (Gengar.getToxic() == true){

            //booleans to "animate" bubbles floating up by making them appear
            boolean bubbles1 = Gengar.getTox1();
            boolean bubbles2 = Gengar.getTox2();
            boolean bubbles3 = Gengar.getTox3();
            boolean bubbles4 = Gengar.getTox4();
            boolean bubbles5 = Gengar.getTox5();

            g2d.setColor(new Color (158, 98, 227));

            //bubbles
            if(bubbles1){
            g2d.fillOval(482, 114, 10, 10);
            g2d.fillOval(556, 124, 10, 10);
            }

            if(bubbles2){
            g2d.fillOval(472, 94, 10, 10);
            }
            
            if(bubbles3){
            g2d.fillOval(482, 74, 10, 10);
            g2d.fillOval(556, 74, 10, 10);
            }

            if(bubbles4){
            g2d.fillOval(568, 49, 13, 13);
            g2d.fillOval(460, 49, 13, 13);
            }

            if(bubbles5){
            g2d.fillOval(472, 24, 16, 16);
            g2d.fillOval(552, 24, 16, 16);
            }
            
            //puddles
            g2d.fillOval(445, 139, 60, 10);
            g2d.fillOval(515, 148, 60, 10);
            g2d.fillOval(465, 148, 60, 10);
            g2d.fillOval(540, 140, 60, 10);      
        }

        //Shadow Punch visuals
        else if (Gengar.getShadowPunch() == true){

            int x = Gengar.getXX();
            int y = Gengar.getYY();

            if(Gengar.getShowShadowPunch()){

            //visuals for main fist of Shadow Punch
            g2d.setColor(Color.BLACK);
            g2d.fillRect(300+x, 230+y, 100, 60);
            g2d.fillRect(294+x, 290+y, 50, 30);

            g2d.setColor(new Color(59, 68, 75));
            g2d.fillRect(305+x, 235+y, 90, 50);
            g2d.fillRect(299+x, 295+y, 40, 20);

            g2d.setColor(Color.BLACK);
            g2d.fillRect(320+x, 250+y, 8, 39);
            g2d.fillRect(372+x, 250+y, 8, 39);
            g2d.fillRect(346+x, 250+y, 8, 39);

            //trailing lines
            g2d.setStroke(new BasicStroke(3));
            g2d.drawLine(280+x, 350+y, 290 + x, 335 + y);
            g2d.drawLine(270+x, 340+y, 280 + x, 325 + y);
            g2d.drawLine(260+x, 330+y, 270 + x, 315 + y);
            g2d.drawLine(250+x, 320+y, 260 + x, 305 + y);
            }

            //visuals for log changing after Shadow Punch
            if(Gengar.getShowShadowSpot()){
                g2d.setColor(Color.WHITE);
                g2d.setStroke(new BasicStroke(2));
                g2d.drawLine(523, 30, 522, 50);
                g2d.drawLine(522, 50, 524, 70);
                g2d.drawLine(524, 70, 523, 90);
                g2d.drawLine(523, 90, 525, 110);
                g2d.drawLine(525, 110, 523, 140);
                
                
            }
        }
    }
}
    

