/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tic.tac.toe.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ronita Adhikari
 */
public class Game implements ActionListener {
   Random random=new Random();
   JFrame frame =new JFrame();
   JLabel text_field=new JLabel();
   JPanel title_panel=new JPanel();
   JPanel button_panel=new JPanel();
   JButton[] button=new JButton[9];
    boolean Player_1_turn;
    boolean winner;
   
   Game()
   {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        
        text_field.setBackground(new Color(25,25,25));
//        text_field.setForeground(Color.BLACK);
        text_field.setForeground(new Color(255,255,255));
        text_field.setFont(new Font("Serif",Font.BOLD,75));
//        text_field.setFont(new Font("Ink Free",Font.BOLD,75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);
        
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,800);
        
        button_panel.setLayout(new GridLayout(3,3));
        
        for(int i=0;i<9;i++)
        {
            button[i]=new JButton();
            button_panel.add(button[i]);
            button[i].setFont(new Font("Courier", Font.BOLD ,120));
//            button[i].setFont(new Font("MV Boli",Font.BOLD,120));
            button[i].setFocusable(false);
            button[i].addActionListener(this);
//            button[i].setBackground(new Color(130,92,121));
            button[i].setBackground(Color.pink);
        }
        
        title_panel.add(text_field);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(button_panel);
        
        firstTurn();
   }
   @Override
    public void actionPerformed(ActionEvent e) {
         for(int i=0;i<9;i++)
        {
            if(e.getSource()==button[i])
            {
                if(Player_1_turn)
                {
                    if("".equals(button[i].getText()))
                    {
//                        button[i].setForeground(new Color(255,165,0));
                        button[i].setForeground(new Color(0xf7f7f7));
//                        button[i].setForeground(new Color(255,0,0));
                        button[i].setText("X");
                        Player_1_turn=false;
                        text_field.setText("O Turn");
                        check();
                    }
                }
                else
                {
                    if("".equals(button[i].getText()))
                    {
                         button[i].setForeground(new Color(152,109,142));
//                        button[i].setForeground(new Color(0xf7f7f7));
//                         button[i].setForeground(new Color(0,0,255));
                        button[i].setText("O");
                        Player_1_turn=true;
                        text_field.setText("X Turn");
                        check();
                    }
                }
            }
        }
    }
    public void firstTurn()
    {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Game.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if(random.nextInt(2)==0)
        {
            Player_1_turn=true;
            text_field.setText("X Turn");
            
        }
        else 
        {
            Player_1_turn=false;
            text_field.setText("O Turn");
        }
        
    }
    public void check()
    {
         //check x wins conditions
        
        if(
                ("X".equals(button[0].getText()))&&
                ("X".equals(button[1].getText()))&&
                ("X".equals(button[2].getText()))
                
          )
        {
            XWins(0,1,2);
        }
        if(
                ("X".equals(button[3].getText()))&&
                ("X".equals(button[4].getText()))&&
                ("X".equals(button[5].getText()))
                
          )
        {
            XWins(3,4,5);
        }
        if(
                ("X".equals(button[6].getText()))&&
                ("X".equals(button[7].getText()))&&
                ("X".equals(button[8].getText()))
                
          )
        {
            XWins(6,7,8);
        }
        if(
                ("X".equals(button[0].getText()))&&
                ("X".equals(button[3].getText()))&&
                ("X".equals(button[6].getText()))
                
          )
        {
            XWins(0,3,6);
        }
        if(
                ("X".equals(button[1].getText()))&&
                ("X".equals(button[4].getText()))&&
                ("X".equals(button[7].getText()))
                
          )
        {
            XWins(1,4,7);
        }if(
                ("X".equals(button[2].getText()))&&
                ("X".equals(button[5].getText()))&&
                ("X".equals(button[8].getText()))
                
          )
        {
            XWins(2,5,8);
        }
        if(
                ("X".equals(button[2].getText()))&&
                ("X".equals(button[4].getText()))&&
                ("X".equals(button[6].getText()))
                
          )
        {
            XWins(2,4,6);
        }
        if(
                ("X".equals(button[0].getText()))&&
                ("X".equals(button[4].getText()))&&
                ("X".equals(button[8].getText()))
                
          )
        {
            XWins(0,4,8);
        }
        //check 0 wins conditions
        
        if(
                ("O".equals(button[0].getText()))&&
                ("O".equals(button[1].getText()))&&
                ("O".equals(button[2].getText()))
                
          )
        {
            YWins(0,1,2);
        }
        if(
                ("O".equals(button[3].getText()))&&
                ("O".equals(button[4].getText()))&&
                ("O".equals(button[5].getText()))
                
          )
        {
            YWins(3,4,5);
        }
        if(
                ("O".equals(button[6].getText()))&&
                ("O".equals(button[7].getText()))&&
                ("O".equals(button[8].getText()))
                
          )
        {
            YWins(6,7,8);
        }
        if(
                ("O".equals(button[0].getText()))&&
                ("O".equals(button[3].getText()))&&
                ("O".equals(button[6].getText()))
                
          )
        {
            YWins(0,3,6);
        }
        if(
                ("O".equals(button[1].getText()))&&
                ("O".equals(button[4].getText()))&&
                ("O".equals(button[7].getText()))
                
          )
        {
            YWins(1,4,7);
        }if(
                ("O".equals(button[2].getText()))&&
                ("O".equals(button[5].getText()))&&
                ("O".equals(button[8].getText()))
                
          )
        {
            YWins(2,5,8);
        }
        if(
                ("O".equals(button[2].getText()))&&
                ("O".equals(button[4].getText()))&&
                ("O".equals(button[6].getText()))
                
          )
        {
            YWins(2,4,6);
        }
        if(
                ("O".equals(button[0].getText()))&&
                ("O".equals(button[4].getText()))&&
                ("O".equals(button[8].getText()))
                
          )
        {
            YWins(0,4,8);
        }
    }
    
    public void XWins(int a,int b,int c)
    {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        
        for(int i=0;i<9;i++)
        {
            button[i].setEnabled(false);
        }
        text_field.setText("X Wins");
        winner=true;
    }
    public void YWins(int a,int b,int c)
    {
        button[a].setBackground(Color.GREEN);
        button[b].setBackground(Color.GREEN);
        button[c].setBackground(Color.GREEN);
        
        for(int i=0;i<9;i++)
        {
            button[i].setEnabled(false);
        }
        text_field.setText("O Wins");
        winner=true;
    }
}



