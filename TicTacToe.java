
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel button_panel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1_turn;

    TicTacToe() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(0,0,255));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textfield.setBackground(new Color(0,0,0));
        textfield.setForeground(new Color(0,255,51));
        textfield.setFont(new Font("SansSerif", Font.BOLD, 75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("TicTacToe");
        textfield.setOpaque(true);

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0, 0, 800, 100);

        button_panel.setLayout(new GridLayout(3, 3));
        button_panel.setBackground(new Color(51,153,255));

        for (int i = 0; i < 9; i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("SansSerif", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        title_panel.add(textfield);
        frame.add(title_panel, BorderLayout.NORTH);
        frame.add(button_panel);
        FirstTurn();
    }

    public void FirstTurn() {
        try{
            Thread.sleep(2000);
        }
        catch (InterruptedException e){
            e.printStackTrace();

        }

        if(random.nextInt(2)==0){
            player1_turn= true;
            textfield.setText("X turn");
        }
        else {
            player1_turn = false;
            textfield.setText("O turn");
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn) {
                    if (buttons[i].getText() == "") {
                        buttons[i].setForeground(new Color(255, 0,0));
                        buttons[i].setText("X");
                        player1_turn = false;
                        textfield.setText("O turn");
                        Check();
                    }
                }

                    else{
                        if(buttons[i].getText()==""){
                            buttons[i].setForeground(new Color(0,204,0));
                            buttons[i].setText("O");
                            player1_turn = true;
                            textfield.setText("X turn");
                            Check();

                        }
                    }

                }
            }
        }





    public void Check() {
        if(
                (buttons[0].getText()=="X") && (buttons[1].getText()=="X") && (buttons[2].getText()=="X")){
            xWINS(0,1,2);
        }
        if(
                (buttons[3].getText()=="X") && (buttons[4].getText()=="X") && (buttons[5].getText()=="X")){
            xWINS(3,4,5);
        }
        if(
                (buttons[6].getText()=="X") && (buttons[7].getText()=="X") && (buttons[8].getText()=="X")){
            xWINS(6,7,8);
        }
        if(
                (buttons[0].getText()=="X") && (buttons[3].getText()=="X") && (buttons[6].getText()=="X")){
            xWINS(0,3,6);
        }
        if(
                (buttons[1].getText()=="X") && (buttons[4].getText()=="X") && (buttons[7].getText()=="X")){
            xWINS(1,4,7);
        }
        if(
                (buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            xWINS(2,4,8);
        }
        if(
                (buttons[0].getText()=="X") && (buttons[4].getText()=="X") && (buttons[8].getText()=="X")){
            xWINS(0,4,8);
        }
        if(
                (buttons[2].getText()=="X") && (buttons[4].getText()=="X") && (buttons[6].getText()=="X")){
            xWINS(2,4,6);
        }
        if(
                (buttons[0].getText()=="O") && (buttons[1].getText()=="O") && (buttons[2].getText()=="O")){
            xWINS(0,1,2);
        }
        if(
                (buttons[3].getText()=="O") && (buttons[4].getText()=="O") && (buttons[5].getText()=="O")){
            oWINS(3,4,5);
        }
        if(
                (buttons[6].getText()=="O") && (buttons[7].getText()=="O") && (buttons[8].getText()=="O")){
            oWINS(6,7,8);
        }
        if(
                (buttons[0].getText()=="O") && (buttons[3].getText()=="O") && (buttons[6].getText()=="O")){
            oWINS(0,3,6);
        }
        if(
                (buttons[1].getText()=="O") && (buttons[4].getText()=="O") && (buttons[7].getText()=="O")){
            oWINS(1,4,7);
        }
        if(
                (buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
            oWINS(2,4,8);
        }
        if(
                (buttons[0].getText()=="O") && (buttons[4].getText()=="O") && (buttons[8].getText()=="O")){
            oWINS(0,4,8);
        }
        if(
                (buttons[2].getText()=="O") && (buttons[4].getText()=="O") && (buttons[6].getText()=="O")){
            oWINS(2,4,6);
        }

    }

    public void xWINS(int a , int b , int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9 ; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("X Wins");
    }

    public void oWINS(int a , int b , int c) {
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i<9 ; i++){
            buttons[i].setEnabled(false);
        }
        textfield.setText("O Wins");
    }
}

