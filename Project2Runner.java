
public class Project2Runner {
    
    /*
     * Name: <Kevin Tran>
     * 
     * 
     ******** Project Description ********
     * 
     * My program is based off the popular video game known as Pokemon. The
     * premise is that you're controlling a pokemon known as "Gengar" and
     * you can choose 4 different attacks to use on a training dummy. Each
     * move/button does a different attack and shows new visuals.
     * 
     ******** Swing Requirement ********
     * 
     * My 3 JSwing components that I used are JLabel, JButton, and a JSeperator. 
     * The JLabel displays information about the attack and which attack Gengar
     * uses based on the button clicked. The JButtons are used to allow the user
     * to choose which attack they want Gengar to use. The JSeperator is used to 
     * seperate the button and the actual graphics of the project. All code is
     * located in "Gengar.java". The code for JLabel is located from line 34 to 
     * line 41. The code for JButton is located from line 43 to line 69. The code 
     * for JSeperator is located from line 71 to line 73.
     * 
     ******** 2D Graphics Requirement ********
     * 
     * In Animation.java, the class extends JPanel which allows me to use 2D graphics, as 
     * shown on line 4. The paintComponent is where I use different methods to draw
     * different shapes starting from line 8 and ending at line 143 in Animation.java. 
     * paintComponent allows me to draw the inital drawing of Gengar in addition to
     * drawing different visuals for each attack. I then called created an instance of 
     * Animation.java in the Gengar constructor to implement it in my project.
     * 
     ******** Event Listener Requirement ********
    
     * The ActionListeners are linked to each JButton. When clicked, they trigger
     * an animation for Gengar to use on the training dummy in addition to changing 
     * the text of the JLabel displays which attack was used. The MouseListener 
     * use MouseEntered and MouseExited and tracks when the mouse is hovering over
     * a JButton and when it is not. If the mouse is hovering over the JButton, 
     * it displays the stats of the attack in the JLabel. When exiting, the frame
     * disappears. However, if the JButton is clicked and an attack is used, the
     * JLabel stays. All code is located in "Gengar.java". The ActionListener code
     * that connects to each button is located from line 75 to line 125. The 
     * MouseListener code is located from line 127 to line 177.
     */
    public static void main(String[] args) {
        Gengar a = new Gengar(); 
    }
}
