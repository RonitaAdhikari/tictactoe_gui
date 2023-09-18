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
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Ronita Adhikari
 */
public class Game implements ActionListener {
   JFrame frame =new JFrame();
   JLabel text_field=new JLabel();
   JPanel title_panel=new JPanel();
   JPanel buton_panel=new JPanel();
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
        
//        firstTurn();
   }

}