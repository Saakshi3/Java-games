/**Project : Connect Four Game
 * @author : Bhumika
 * @author : Saakshi
 * description : To develop grid based board game using a java GUI interface, and our game is connect four
 **/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**  assigning variables that are necessary
 *   to implement GUI for the game.
 **/
public class Connect4 extends JComponent implements ActionListener
{
    /** creating 7 buttons representing each column**/
    private JButton button0 = new JButton("0");
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JButton button4 = new JButton("4");
    private JButton button5 = new JButton("5");
    private JButton button6 = new JButton("6");

    /**creating the bottom text field to display the players turn and winner **/
    private JTextField playerTurnField = new JTextField(30);
    /**attribute for empty cell**/
    private static int empty = 0;
    /**red and yellow represents the 2 players with yellow starting first**/
    private static int yellow = 1;
    private static int red = 2;
    /** size of the frame**/
    private static int size = 800;
    /**assigning the first player with yellow checker**/
    private static int playerTurn = yellow;
    /**setting the background colour of the frame**/
    private Color componentColor = new Color(12,23,80);
    /**creating a 2D array to reprsent our rows and columns on the frame **/
    private int[][] board = new int[7][7];
    /**creating a button that is a part of menu**/
    private JButton helpMenu = null;

    /** implenting GUI for our elements of the game **/

    public Connect4() {

        /**creating an attribute for action listener **/
        listener act = new listener();
        /**creating a frame with our title**/
        JFrame frame = new JFrame("Connect 4");
        /**creating a menu bar below it to display our help button**/
        JMenuBar menu = new JMenuBar();
        helpMenu = new JButton("How to Play");
        menu.add(helpMenu);
        /**calling the ActionListener to display the pop up message **/
        helpMenu.addActionListener(act);
        frame.setJMenuBar(menu);
        /**fits all the components on the window **/
        frame.pack();

        /**creating a JPanel and adding each button to every column **/
        JPanel panel = new JPanel();

        panel.setLayout(new GridLayout(1,7));
        panel.add(button0);
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);

        /**actionListener for each button is defined here **/
        button0.addActionListener(this);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
        button4.addActionListener(this);
        button5.addActionListener(this);
        button6.addActionListener(this);

        /**Creating the board and adding all the elements to the layout**/
        setPreferredSize(new Dimension(size, size)); // of this, the JComponent
        frame.getContentPane().add(panel, BorderLayout.NORTH);
        frame.getContentPane().add(this, BorderLayout.CENTER);
        frame.getContentPane().add(playerTurnField, BorderLayout.SOUTH);
        frame.setVisible(true);

        /**Running a for loop to assign all the cells of the grid to empty intially **/
        for (int row=0; row<6; row++) {
            for(int col=0; col<7; col++) {
                board[row][col]=empty;
            }
        }

    }

    /** This is used to rotate turns between both the players **/

    public void changeTurn() {
        if (playerTurn == yellow) {
            playerTurn = red;
            playerTurnField.setText("Red's Turn");
        } else {
            playerTurn = yellow;
            playerTurnField.setText("Yellow's Turn");
        }
    }

    /** creating our checkers according to the height and width of each cell**/

    public void yellowCircle(Graphics graphics, int x, int y) {
        graphics.setColor(new Color(255,255,0));
        graphics.fillOval(x, y, getWidth()/7, getHeight()/6);
    }
    public void redCircle(Graphics graphics, int x, int y) {
        graphics.setColor(new Color(255,0,0));
        graphics.fillOval(x, y, getWidth()/7, getHeight()/6);
    }

    /**performs an action when the button 0 is clicked**/
    public void actionPerformed(ActionEvent event) {
        if (event.getSource() == button0) {
            for (int i=5; i>=0; i--) {
                /** checks which cell is empty in each column **/
                if (board[0][i]==empty) {
                    board[0][i]=playerTurn;
                    break;
                }
            }
            /** call for the next player to play **/
            changeTurn();
            /**change colour of checker to be dropped **/
            repaint();
            /**check function is called to see if there is a 4 in a row **/
            check();
        }
        /**performs an action when the button 1 is clicked**/
        else if (event.getSource() == button1) {
            for (int i=5; i>=0; i--) {
                if (board[1][i]==empty) {
                    board[1][i]=playerTurn;
                    break;
                }
            }
            changeTurn();
            repaint();
            check();
        }
        /**performs an action when the button 2 is clicked**/
        else if (event.getSource() == button2) {
            for (int i=5; i>=0; i--) {
                if (board[2][i]==empty) {
                    board[2][i]=playerTurn;
                    break;
                }
            }
            changeTurn();
            repaint();
            check();
        }
        /**performs an action when the button 3 is clicked**/
        else if (event.getSource() == button3) {
            for (int i=5; i>=0;  i--) {
                if (board[3][i]==empty) {
                    board[3][i]=playerTurn;
                    break;
                }
            }
            changeTurn();
            repaint();
            check();
        }
        /**performs an action when the button 4 is clicked**/
        else if (event.getSource() == button4) {
            for (int i=5; i>=0;  i--) {
                if (board[4][i]==empty) {
                    board[4][i]=playerTurn;
                    break;
                }
            }
            changeTurn();
            repaint();
            check();
        }
        /**performs an action when the button 5 is clicked**/
        else if (event.getSource() == button5) {
            for (int i=5; i>=0;  i--) {
                if (board[5][i]==empty) {
                    board[5][i]=playerTurn;
                    break;
                }
            }
            changeTurn();
            repaint();
            check();
        }
        /**performs an action when the button 6 is clicked**/
        else if (event.getSource() == button6) {
            for (int i=5; i>=0; i--) {
                if (board[6][i]==empty) {
                    board[6][i]=playerTurn;
                    break;
                }
            }
            changeTurn();
            repaint();
            check();
        }
    }

    /** Setting the background colour and creating lines of the grid **/
    public void paintComponent(Graphics graphics) {
        // Fill the background
        graphics.setColor(componentColor);
        graphics.fillRect(0,0, getWidth(), getHeight());
        //makes the columns lines
        for (int i=0; i<getHeight(); i+=getHeight()/6) {
            graphics.setColor(Color.gray);
            graphics.drawLine(0, i, getWidth(), i);
        }
        //makes the rows lines
        for (int i=0; i<getWidth(); i+=getWidth()/7) {
            graphics.setColor(Color.gray);
            graphics.drawLine(i, 0, i, getHeight());
        }

        /** calls the yellow or red circle depending upon the players turn **/
        for (int row=0; row<7; row++) {
            for (int col=0; col<=6; col++) {
                if(board[row][col]==yellow) {
                    yellowCircle(graphics, getWidth()/7*row, getHeight()/6*col);
                } else if (board[row][col]==red) {
                    redCircle(graphics, getWidth()/7*row, getHeight()/6*col);
                }
            }
        }
    }
    /**checking the winning conditions **/
    public void check()
    {
        /**checks horizontal rows**/
        for(int row=0; row<6; row++){
            for (int col=0; col<4; col++){
                if (board[row][col]>0 && board[row][col]==board[row][col+1]
                        && board[row][col]==board[row][col+2] &&board[row][col]==board[row][col+3]){
                    if(playerTurn==1){
                        playerTurnField.setText("Yellow is the Winner !!!");
                    }else{
                        playerTurnField.setText("Red is the Winner !!!");
                    }

                }
            }
        }
        /**checks vertical columns**/
        for(int row=0; row<3; row++){
            for (int col=0; col<7; col++){
                if(board[row][col]>0 && board[row+1][col]==board[row][col] && board[row+2][col]==board[row][col]
                        && board[row+3][col]==board[row][col]){
                    if(playerTurn==1){
                        playerTurnField.setText("Yellow is the winner!!!");
                    }else{
                        playerTurnField.setText("Red is the winner!!!");
                    }
                }
            }
        }
        /**diagonal lower left to upper right**/
        for (int row=0; row<3; row++) {
            for (int col=0; col<4; col++) {
                if (board[row][col]>0 && board[row][col] == board[row+1][col+1] && board[row][col] == board[row+2][col+2]
                        &&board[row][col] == board[row+3][col+3]) {
                    if(playerTurn==1){
                        playerTurnField.setText("Yellow is the winner!!!");
                    }else{
                        playerTurnField.setText("Red is the winner!!!");
                    }
                }
            }
        }
        /**diagonal upper left to lower right**/
        for (int row=5; row>=3; row--) {
            for (int col=0; col<4; col++) {
                if (board[row][col]>0 && board[row][col] == board[row-1][col+1] && board[row][col] == board[row-2][col+2]
                        && board[row][col] == board[row-3][col+3]) {
                    if(playerTurn==1){
                        playerTurnField.setText("Yellow is the winner!!!");
                    }else{
                        playerTurnField.setText("Red is the winner!!!");
                    }
                }
            }
        }
    }
    /**inner class created for when the "help" button is clicked upon and to display pop up message **/
    class listener implements ActionListener{
        public void actionPerformed(ActionEvent actionEvent) {
         Object instructions = actionEvent.getSource();
         if(instructions == helpMenu)
             /**pop up to display our game instructions **/
         JOptionPane.showMessageDialog(null,"This game is played amongst 2 players.\n" +
                 "1.\tThe player to begin first is assigned a yellow checker and the other player is assigned a red checker.\n" +
                 "\n" +
                 "2.\tThe first player starts the game by clicking on one of the buttons above each column, the checker drops to the bottommost cell and then the other player performs the same with its red checker.\n" +
                 "\n" +
                 "3.\tThe players will react to their opponent’s move and alternate turns after playing a checker. \n" +
                 "\n" +
                 "4.\tOnce the entire grid is filled, the player that makes the greater number of combinations of 4 checkers in a row which can be horizontally, vertically, and diagonally is declared as the winner of the game.\n");

         }

        }

        /**calling the main function **/
    public static void main(String[] args) {
        Connect4 connect4 = new Connect4();
    }
}