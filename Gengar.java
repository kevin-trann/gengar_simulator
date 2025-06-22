
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class Gengar extends JPanel {
private boolean moveUsed = false; //Tracks if a move is used (used in the mouseListener)
private static boolean shadowBall = false; //Tracks if Shadow Ball is activated (true if clicked)
private static boolean dreamEater = false; //Tracks if Dream Eater is activated (true if clicked)
private static boolean toxic = false; //Tracks if Toxic is activated (true if clicked)
private static boolean shadowPunch = false; //Tracks if Shadow Punch is activated (true if clicked)
private static int x = 0; //x-value for animation
private static int y = 0; //y-value for animation

private static boolean showLog = true;

private static boolean showShadowBall = true;
private static boolean showExplosion = false;

private static boolean showShadowPunch = true;
private static boolean showShadowSpot = false;

private static boolean showDream1 = true;
private static boolean showDream2 = true;
private static boolean showDream3 = true;
private static boolean showDream4 = true;
private static boolean showDream5 = true;
private static boolean showDream6 = true;
private static boolean showDream7 = true;
private static boolean showZ1 = false;
private static boolean showZ2 = false;
private static boolean showZ3 = false;


private static boolean paintLog = false;
private static boolean tox1 = false; //for Toxic animation
private static boolean tox2 = false; 
private static boolean tox3 = false; 
private static boolean tox4 = false; 
private static boolean tox5 = false; 

ImageIcon originalSoundOnIcon = new ImageIcon(getClass().getResource("/assets/sound_on.png")); //image for sound-on
Image scaledSoundOnIcon = originalSoundOnIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
ImageIcon resizedSoundOnIcon = new ImageIcon(scaledSoundOnIcon);

ImageIcon originalSoundOffIcon = new ImageIcon(getClass().getResource("/assets/sound_off.png")); //image for sound-off
Image scaledSoundOffIcon = originalSoundOffIcon.getImage().getScaledInstance(50, 40, Image.SCALE_SMOOTH);
ImageIcon resizedSoundOffIcon = new ImageIcon(scaledSoundOffIcon);

    public Gengar()
    {
        JFrame frame = new JFrame("Project 2"); //sets up frame
        frame.setSize(1300,700);
        this.setPreferredSize(new Dimension(1300,700));
        Animation b = new Animation(); // creates new instance of Animation and adds to Gengar constructor
        audio m = new audio(); // creates new instance of audio and adds to Gengar constructor
        b.setBounds(200, 0, 600, 480);
        frame.add(b); // adds Animation to frame
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setTitle("Gengar Simulator by Kevin Tran");
        
        JLabel tip = new JLabel(" "); //sets up JLabel
        tip.setFont(new Font("Verdana", Font.PLAIN, 25));
        tip.setBounds(800, 285, 400, 200);
        tip.setVerticalAlignment(SwingConstants.TOP);
        frame.add(tip);
        Border border = BorderFactory.createLineBorder(Color.WHITE, 1);
        tip.setVisible(false);
        tip.setBorder(border);
        tip.setOpaque(true);
        tip.setBackground(Color.BLACK);

        frame.getContentPane().setBackground(new Color(10, 10, 40)); //changing background color
        b.setBackground(new Color(10, 10, 40));

        JButton toggleButton = new JButton(resizedSoundOffIcon);
        toggleButton.setBounds(1200, 10, 60, 60);
        toggleButton.setBackground(new Color(30, 30, 122));
        toggleButton.setOpaque(true);
        toggleButton.setContentAreaFilled(true);
        toggleButton.setBorderPainted(false); 
        toggleButton.setFocusPainted(false);

        JButton button1 = new JButton(); //sets up JButton visuals
        button1.setText("Shadow Ball");
        button1.setBounds(100, 520, 450, 50);
        button1.setFont(new Font("Verdana", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(new Color (68, 46, 117));
        button1.setOpaque(true);
        button1.setContentAreaFilled(true);
        button1.setBorderPainted(false); 

        JButton button2 = new JButton();
        button2.setText("Dream Eater");
        button2.setBounds(100, 590, 450, 50);
        button2.setFont(new Font("Verdana", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(new Color (240, 84, 123));
        button2.setOpaque(true);
        button2.setContentAreaFilled(true);
        button2.setBorderPainted(false); 

        JButton button3 = new JButton();
        button3.setText("Toxic");
        button3.setBounds(720, 590, 450, 50);
        button3.setFont(new Font("Verdana", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(new Color (158, 98, 227));
        button3.setOpaque(true);
        button3.setContentAreaFilled(true);
        button3.setBorderPainted(false); 

        JButton button4 = new JButton();
        button4.setText("Shadow Punch");
        button4.setBounds(720, 520, 450, 50);
        button4.setFont(new Font("Verdana", Font.BOLD, 14));
        button4.setForeground(Color.WHITE);
        button4.setBackground(new Color (61, 48, 31));
        button4.setOpaque(true);
        button4.setContentAreaFilled(true);
        button4.setBorderPainted(false); 

        JSeparator groundLine = new JSeparator(JSeparator.HORIZONTAL); //sets up JSeparator
        groundLine.setBounds(0, 500, 1300, 500);
        groundLine.setForeground(Color.WHITE);
        tip.setForeground(Color.WHITE);

        button1.addActionListener(e -> { //sets up ActionListners for each button 
            tip.setVerticalAlignment(SwingConstants.CENTER); 
            tip.setHorizontalAlignment(SwingConstants.CENTER);
            tip.setText("Gengar uses Shadow Ball!");
            tip.setVisible(true);
            moveUsed = true; //turns on to ensure the text stays on JLabel even after mouse exits JButton
            shadowBall = true; //turns on shadowBall to draw visuals for shadow ball move
            dreamEater = false; // turns off other moves to ensure it doesnt draw two moves at once if a move was used before this
            toxic = false; 
            shadowPunch = false;
            showLog = true;
            showShadowBall = true;
            showExplosion = false;
            paintLog=false;

            x = 0;
            y = 0;

        new Thread(() -> {
            for(int i = 0; i < 205; i++){
                x = x+=1;
                y = y-=1.01;
                if(i == 204){
                    showLog = false;
                    showShadowBall = false;
                    showExplosion = true;
                }
                b.repaint(); //repaints drawing with new shadow ball visuals

                try {
                    Thread.sleep(4);
                } catch (InterruptedException a) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
            
        });

        button2.addActionListener(e -> {
            tip.setVerticalAlignment(SwingConstants.CENTER);
            tip.setHorizontalAlignment(SwingConstants.CENTER);
            tip.setText("Gengar uses Dream Eater!");
            tip.setVisible(true);
            moveUsed = true;
            shadowBall = false;
            dreamEater = true;
            toxic = false;
            shadowPunch = false;
            showLog = true;
            paintLog=false;
            showDream1 = true;
            showDream2 = true;
            showDream3 = true;
            showDream4 = true;
            showDream5 = true;
            showDream6 = true;
            showDream7 = true;
            showZ1 = false;
            showZ2 = false;
            showZ3 = false;

            x = 0;
            y = 0;

        new Thread(() -> {
            for(int i = 0; i < 210; i++){ // 164, 207, 139, 119, 69, 64, 100
                x = x-=1;
                y = y+=1;
                if(i >= 63){
                    showDream1 = false;
                }
                if(i >= 68){
                    showDream2 = false;
                }
                if(i >= 99){
                    showDream3 = false;
                }
                if(i >= 118){
                    showDream4 = false;
                }
                if(i >= 138){
                    showDream5 = false;
                }
                if(i >= 163){
                    showDream6 = false;
                }
                if(i >= 206){
                    showDream7 = false;
                }

                if(i >=70){
                    showZ1 = true;
                }

                if(i >= 140){
                    showZ2 = true;
                }

                if(i >= 209){
                    showZ3 = true;
                }
                b.repaint(); 

                try {
                    Thread.sleep(8);
                } catch (InterruptedException a) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        });

        button3.addActionListener(e -> {
            tip.setVerticalAlignment(SwingConstants.CENTER);
            tip.setHorizontalAlignment(SwingConstants.CENTER);
            tip.setText("Gengar uses Toxic!");
            tip.setVisible(true);
            moveUsed = true;
            shadowBall = false;
            dreamEater = false;
            toxic = true;
            shadowPunch = false;
            showLog = true;
            paintLog=false;

            tox1 = false;
            tox2 = false;
            tox3 = false;
            tox4 = false;
            tox5 = false;
            
            new Thread(() -> {
            for(int i = 0; i < 7; i++){
                if(i >=1){
                    tox1 = true;
                }
                if(i >=2){
                    tox2 = true;
                }
                if(i >=3){
                    tox3 = true;
                }
                if(i >=4){
                    tox4 = true;
                }
                if(i >=5){
                    tox5 = true;
                
                }
                if(i >=6){
                
                    paintLog = true;
                }
                b.repaint(); //repaints drawing with new shadow ball visuals

                try {
                    Thread.sleep(300);
                } catch (InterruptedException a) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();

        });

        button4.addActionListener(e -> {
            tip.setVerticalAlignment(SwingConstants.CENTER);
            tip.setHorizontalAlignment(SwingConstants.CENTER);
            tip.setText("Gengar uses Shadow Punch!");
            tip.setVisible(true);
            moveUsed = true;
            shadowBall = false;
            dreamEater = false;
            toxic = false;
            shadowPunch = true;
            showLog = true;
            paintLog=false;
            showShadowPunch = true;
            showShadowSpot = false;

            x = 0;
            y = 0;
            
            new Thread(() -> {
            for(int i = 0; i < 300; i++){
                x = x+=1;
                y = y-=1.01;
                if(i >= 169){
                    showShadowPunch = false;
                    paintLog = true;
                }

                if(i >= 299){
                    showShadowSpot = true;
                }
                b.repaint(); //repaints drawing with new shadow ball visuals

                try {
                    Thread.sleep(5);
                } catch (InterruptedException a) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
        });

        toggleButton.addActionListener(e -> {
            m.toggleMusic();
            if(m.getIsPlaying()){
                toggleButton.setIcon(resizedSoundOnIcon);
            }
            else{
                toggleButton.setIcon(resizedSoundOffIcon);
            }
        });

        button1.addMouseListener(new MouseAdapter() { // adds mouseListener to each JButton to displays attack stats
            public void mouseEntered(MouseEvent m){ //tracks if mouse enters JButton, when it does change JLabel to display stats about attack move
                tip.setText("<html> <b>Shadow Ball</b> <br> Category: Special <br> Type: Ghost <br> The user hurls a shadowy <br> blob at the target <br> Power: 80 Accuracy: 100</html>");
                tip.setVisible(true);
                tip.setHorizontalAlignment(SwingConstants.LEFT);
                button1.setBackground(new Color (108, 86, 157));
            }
    
            public void mouseExited(MouseEvent m){ //tracks if mouse exits JButton, when it does, remove visbility of JButton
                if (moveUsed == false) //however if moveUsed is true (user clicks on move), the JLabel will stay even after exiting and if statement won't run
                tip.setVisible(false);
                button1.setBackground(new Color (68, 46, 117));
            }
        });

        button2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent m){
                tip.setText("<html> <b>Dream Eater</b> <br> Category: Special <br> Type: Psychic <br> The user eats the dreams of a <br> of a sleeping target.<br> Power: 100 Accuracy: 100</html>");
                tip.setVisible(true);
                tip.setHorizontalAlignment(SwingConstants.LEFT);
                button2.setBackground(new Color(242, 110, 143));
            }
    
            public void mouseExited(MouseEvent m){
                if (moveUsed == false)
                tip.setVisible(false);
                button2.setBackground(new Color (240, 84, 123));
            }
        });

        button3.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent m){
                tip.setText("<html> <b>Toxic</b> <br> Category: Status <br> Type: Poison <br> A technique that badly poisons the target.<br> Power:-- Accuracy: 90</html>");
                tip.setVisible(true);
                button3.setBackground(new Color(198, 138, 255));
            }
    
            public void mouseExited(MouseEvent m){
                if (moveUsed == false)
                tip.setVisible(false);
                button3.setBackground(new Color (158, 98, 227));
            }
        });

        button4.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent m){
                tip.setText("<html> <b>Shadow Punch</b> <br> Category: Physical <br> Type: Dark <br> The user throws a punch from the shadows. Lands w/o fail. <br> Power: 60 Accuracy: 100</html>");
                tip.setVisible(true);
                button4.setBackground(new Color(101, 88, 71));

            }
    
            public void mouseExited(MouseEvent m){
                if (moveUsed == false)
                tip.setVisible(false);
                button4.setBackground(new Color (61, 48, 31));
            }
        });

        frame.add(button1); //adding all JComponents to frame
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(toggleButton);
        frame.add(groundLine);
        frame.setVisible(true);
        repaint();
    }

    // getter methods
    public static boolean getShadowBall() {return shadowBall;}
    public static boolean getDreamEater() {return dreamEater;}
    public static boolean getToxic() {return toxic;}
    public static boolean getShadowPunch() {return shadowPunch;}
    public static int getXX() {return x;}
    public static int getYY() {return y;}

    public static boolean getShowLog(){return showLog;}
    public static boolean getShowShadowBall(){return showShadowBall;}
    public static boolean getShowExplosion(){return showExplosion;}

    public static boolean getPaintLog(){return paintLog;}
    public static boolean getTox1(){return tox1;}
    public static boolean getTox2(){return tox2;}
    public static boolean getTox3(){return tox3;}
    public static boolean getTox4(){return tox4;}
    public static boolean getTox5(){return tox5;}

    public static boolean getDream1(){return showDream1;}
    public static boolean getDream2(){return showDream2;}
    public static boolean getDream3(){return showDream3;}
    public static boolean getDream4(){return showDream4;}
    public static boolean getDream5(){return showDream5;}
    public static boolean getDream6(){return showDream6;}
    public static boolean getDream7(){return showDream7;}
    public static boolean getZ1(){return showZ1;}
    public static boolean getZ2(){return showZ2;}
    public static boolean getZ3(){return showZ3;}

    public static boolean getShowShadowPunch(){return showShadowPunch;}
    public static boolean getShowShadowSpot(){return showShadowSpot;}

}
