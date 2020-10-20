import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.Box;
import java.awt.*;
//import javax.swing.*;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Container;
import java.awt.Dimension;

//try deleting  all these extra libraries

public class gameDND{
    int playerhp;
    String playerweapon,playerPosition;

    JFrame window;
    Container contain;
    JPanel titleName,mainTextPanel,choiceButtonPanel,playerPanel;
    JLabel titleLabel,a;
    JLabel HPLabel, HP, weaponlabel, weaponName;
    JLabel subtitle;
    JButton startButton,choiceButton1,choiceButton2,choiceButton3,choiceButton4;
    JTextArea mainTextArea;
    Font titleFont = new Font("Ariel",Font.BOLD,50);
    Font subtitleFont = new Font("Ariel",Font.PLAIN,25);

    secondScreen screenOne = new secondScreen();
    playerHandler pHandler = new playerHandler();
     public static void main(String args[]){
         
         new gameDND();
     }
     public gameDND(){
         //.
         //from here
         window = new JFrame();
         window.setSize(800,600);
         window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         window.getContentPane().setBackground(Color.black);
         window.setLayout(null);
         
         contain = window.getContentPane();

         titleName = new JPanel();
         titleName.setBounds(250, 100, 600, 300);
         titleName.setBackground(Color.BLACK);
         titleLabel = new JLabel("<html><center>Dungeons & Dragons</center></html>");
         titleLabel.setForeground(Color.WHITE);
         titleLabel.setFont(titleFont);
         titleName.add(titleLabel);
         subtitle = new JLabel("A Fantasy RPG ");
         subtitle.setFont(subtitleFont);
         subtitle.setText(
             "<html><center>A Fantasy RPG <br> Inspired By Critical Role</center></html>"
         );
         startButton = new JButton("Start");
         startButton.setBounds(400, 900, 100, 40);
         startButton.setBackground(Color.BLACK);
         startButton.setForeground(Color.WHITE);
         startButton.setFont(subtitleFont);
         startButton.addActionListener(screenOne);
         
         titleLabel.setForeground(Color.WHITE);
         contain.add(titleName);
         titleName.add(subtitle);
         //window.add(a);
         titleName.setLayout(new BoxLayout(titleName, BoxLayout.Y_AXIS));
         titleLabel.setFont(subtitleFont);
         titleName.add(Box.createRigidArea(new Dimension(0,10)));
         titleName.add(startButton);
         
         
         
        
        
         window.setVisible(true);

     }
     // to here kuch change mat karna
     //this is done
     public void createGameScreen(){
         titleName.setVisible(false);
         startButton.setVisible(false);
        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.CYAN);
        contain.add(mainTextPanel);

        mainTextArea = new JTextArea(
            "Welcome to the Dwarvern City of KragHammer.You are invited to visit the Mayor of the city Lord ThunderBrand " 
        );
        mainTextArea.setBounds(100, 100, 600, 250);
        mainTextArea.setLineWrap(true);
        mainTextArea.setBackground(Color.black);
        mainTextArea.setForeground(Color.white);
        mainTextPanel.add(mainTextArea);
        mainTextArea.setFont(subtitleFont);

        choiceButtonPanel = new JPanel();
        choiceButtonPanel.setBounds(250, 350, 300, 150);
        choiceButtonPanel.setBackground(Color.GREEN);
        choiceButtonPanel.setLayout(new GridLayout(4,1));
        contain.add(choiceButtonPanel);

        choiceButton1= new JButton("Choice 1");
        choiceButton1.setBackground(Color.BLACK);
        choiceButton1.setForeground(Color.WHITE);
        choiceButton1.setFont(subtitleFont);
        choiceButton1.setActionCommand("c1");
        choiceButton1.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton1);

        choiceButton2= new JButton("Choice 2");
        choiceButton2.setBackground(Color.BLACK);
        choiceButton2.setForeground(Color.WHITE);
        choiceButton2.setFont(subtitleFont);
        choiceButton2.setActionCommand("c2");
        choiceButton2.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton2);

        choiceButton3= new JButton("Choice 3");
        choiceButton3.setBackground(Color.BLACK);
        choiceButton3.setForeground(Color.WHITE);
        choiceButton3.setFont(subtitleFont);
        choiceButton3.setActionCommand("c3");
        choiceButton3.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton3);

        choiceButton4= new JButton("Choice 4");
        choiceButton4.setBackground(Color.BLACK);
        choiceButton4.setForeground(Color.WHITE);
        choiceButton4.setFont(subtitleFont);
        choiceButton4.setActionCommand("c4");
        choiceButton4.addActionListener(pHandler);
        choiceButtonPanel.add(choiceButton4);

        playerPanel = new JPanel();
        playerPanel.setBounds(100,15,600,50);
        playerPanel.setLayout(new GridLayout(1,4));
        playerPanel.setBackground(Color.green);
        contain.add(playerPanel);

         HPLabel = new JLabel("HP:");
         HPLabel.setFont(subtitleFont);
         HPLabel.setForeground(Color.white);
         playerPanel.add(HPLabel);

         HP = new JLabel();
         HP.setFont(subtitleFont);
         HP.setForeground(Color.white);
         playerPanel.add(HP);

         weaponlabel = new JLabel("Weapon:");
         weaponlabel.setFont(subtitleFont);
         weaponlabel.setForeground(Color.white);
         playerPanel.add(weaponlabel);

         weaponName = new JLabel();
         weaponName.setFont(subtitleFont);
         weaponName.setForeground(Color.white);
         playerPanel.add(weaponName);

         playerSetup();
        

     }
     // ye wala createGameScreen bhi thik hai
     //no need to change this
     
     public void playerSetup(){
         playerhp =20;
         playerweapon ="Dagger";
         weaponName.setText(playerweapon);
         HP.setText(""+playerhp);
         mayorHouse();
         
     }

     public void mayorHouse(){
         playerPosition ="mayorHouse";
         mainTextArea.setText(
        "Lord ThunderBrand: \n Welcome Traveller to my beautiful city.\n I have a quest for you. \n Are you ready for it?");
        choiceButton1.setText("Accept Quest");
        choiceButton2.setText("Decline Quest");
        choiceButton3.setText("");
        choiceButton4.setText("");
     }

     public void acceptQuest(){
         playerPosition ="acceptQuest";
         mainTextArea.setText("Thats the spirit!");
         choiceButton1.setText("Continue");
         choiceButton2.setText("");
         choiceButton3.setText("");
        choiceButton4.setText("");

     }

     // idhar se start adding methods
     //dont forget to add playerposition to each method
     //plis watch previous videos to get full context
     // c1 matlab choicebutton 1
     //c2 matlab choice button 2
     //c3 matlbab choice button 3
     //c4 matlab choice button 4

     //your choice will read c1,c2,c3,c4
     // playerposition will help jump from scene to scene

     //isme you need to now add hp ka counter for attack sequences and healing potion wala thingy
     //equip dagger kiya to playerweapon wala string badalna chahiye


     // bryan if you can figure how to separate these into separate classes then plis do
     //nahi toh rehne do
     public class secondScreen implements ActionListener {
    
        public void actionPerformed(ActionEvent event){
            createGameScreen();
        }
    }
    public class playerHandler implements ActionListener{
        public void actionPerformed(ActionEvent event){
            String yourChoice = event.getActionCommand();

            switch(playerPosition)
            {
                case "mayorHouse":
                 switch(yourChoice){
                     case "c1": acceptQuest(); break;
                     case "c2": mayorHouse(); break;
                     case "c3": break;
                     case "c4": break;
                 }

            }

        }
    }
    
   
 }

 