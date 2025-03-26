
import java.awt.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
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


    public Gengar()
    {
        JFrame frame = new JFrame("Project 2"); //sets up frame
        frame.setSize(1300,700);
        this.setPreferredSize(new Dimension(1300,700));
        Animation b = new Animation(); // creates new instance of Animation and adds to Gengar constructor
        b.setBounds(200, 0, 600, 480);
        frame.add(b); // adds Animation to frame
        frame.setLayout(null);
        frame.add(this);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        JLabel tip = new JLabel(" "); //sets up JLabel
        tip.setFont(new Font("Verdana", Font.PLAIN, 25));
        tip.setBounds(800, 285, 400, 200);
        tip.setVerticalAlignment(SwingConstants.TOP);
        frame.add(tip);
        Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
        tip.setVisible(false);
        tip.setBorder(border);

        JButton button1 = new JButton(); //sets up JButton visuals
        button1.setText("Shadow Ball");
        button1.setBounds(100, 520, 450, 50);
        button1.setFont(new Font("Verdana", Font.BOLD, 14));
        button1.setForeground(Color.WHITE);
        button1.setBackground(new Color (68, 46, 117));

        JButton button2 = new JButton();
        button2.setText("Dream Eater");
        button2.setBounds(100, 590, 450, 50);
        button2.setFont(new Font("Verdana", Font.BOLD, 14));
        button2.setForeground(Color.WHITE);
        button2.setBackground(new Color (240, 84, 123));

        JButton button3 = new JButton();
        button3.setText("Toxic");
        button3.setBounds(720, 590, 450, 50);
        button3.setFont(new Font("Verdana", Font.BOLD, 14));
        button3.setForeground(Color.WHITE);
        button3.setBackground(new Color (158, 98, 227));

        JButton button4 = new JButton();
        button4.setText("Shadow Punch");
        button4.setBounds(720, 520, 450, 50);
        button4.setFont(new Font("Verdana", Font.BOLD, 14));
        button4.setForeground(Color.WHITE);
        button4.setBackground(new Color (61, 48, 31));

        JSeparator groundLine = new JSeparator(JSeparator.HORIZONTAL); //sets up JSeparator
        groundLine.setBounds(0, 500, 1300, 500);
        groundLine.setForeground(Color.BLACK);

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
            b.repaint(); //repaints drawing with new shadow ball visuals
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
            b.repaint();
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
            b.repaint();
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
            b.repaint();
        });

        button1.addMouseListener(new MouseAdapter() { // adds mouseListener to each JButton to displays attack stats
            public void mouseEntered(MouseEvent m){ //tracks if mouse enters JButton, when it does change JLabel to display stats about attack move
                tip.setText("<html> Shadow Ball <br> Category: Special <br> Type: Ghost <br> The user hurls a shadowy <br> blob at the target <br> Power: 80 Accuracy: 100</html>");
                tip.setVisible(true);
            }
    
            public void mouseExited(MouseEvent m){ //tracks if mouse exits JButton, when it does, remove visbility of JButton
                if (moveUsed == false) //however if moveUsed is true (user clicks on move), the JLabel will stay even after exiting and if statement won't run
                tip.setVisible(false);
                
            }
        });

        button2.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent m){
                tip.setText("<html> Dream Eater <br> Category: Special <br> Type: Psychic <br> The user eats the dreams of a <br> of a sleeping target.<br> Power: 100 Accuracy: 100</html>");
                tip.setVisible(true);
            }
    
            public void mouseExited(MouseEvent m){
                if (moveUsed == false)
                tip.setVisible(false);
                
            }
        });

        button3.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent m){
                tip.setText("<html> Toxic <br> Category: Status <br> Type: Poison <br> A technique that badly poisons the target with intense poison.<br> Power:-- Accuracy: 90</html>");
                tip.setVisible(true);
            }
    
            public void mouseExited(MouseEvent m){
                if (moveUsed == false)
                tip.setVisible(false);
                
            }
        });

        button4.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent m){
                tip.setText("<html> Shadow Punch <br> Category: Physical <br> Type: Dark <br> The user throws a punch from the shadows. Lands w/o fail. <br> Power:60 Accuracy: 100</html>");
                tip.setVisible(true);
            }
    
            public void mouseExited(MouseEvent m){
                if (moveUsed == false)
                tip.setVisible(false);
                
            }
        });

        frame.add(button1); //adding all JComponents to frame
        frame.add(button2);
        frame.add(button3);
        frame.add(button4);
        frame.add(groundLine);
        frame.setVisible(true);
        repaint();
    }

    // getter methods
    public static boolean getShadowBall() {return shadowBall;}
    public static boolean getDreamEater() {return dreamEater;}
    public static boolean getToxic() {return toxic;}
    public static boolean getShadowPunch() {return shadowPunch;}
}
