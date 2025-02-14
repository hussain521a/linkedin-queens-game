
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.Flow;

/**
 * Creates the window for the queens game
   @author Hussain Ali, Simon Stone
   @version Spring 2025
*/


public class QueensWindow implements Runnable, ActionListener {
    private JButton startButton;
    private JButton resetButton;
    private int seconds = 0;
    private JLabel timerLabel;
    private static final int BOARD_SIZE = 8;
    private static final int CELL_SIZE = 50; 
    private CellState currentDragState = CellState.Normal;
    private JPanel leftPanel;
    private JPanel boardPanel;
    

    /**
     * 
     * The actionPerformed method to add button clicking
     *
     */
    @Override
    public void actionPerformed(ActionEvent e)	{
        if(e.getSource() == startButton) {
            System.out.println("Start button clicked");
        }
        if(e.getSource() == resetButton) {
            System.out.println("Reset button clicked");
        }
        if(e.getSource() instanceof JButton && e.getSource() != startButton && e.getSource() != resetButton) {
            System.out.println("Board button clicked");
        }
    }

    /**
       The run method to set up the graphical user interface
    */
    @Override
    public void run() {
	
	// set up the GUI "look and feel" (matches OS))
	JFrame.setDefaultLookAndFeelDecorated(false);
	
	// create a JFrame where we build our GUI
	JFrame frame = new JFrame("Queens");
    //frame.setPreferredSize(new Dimension(700,600));
    //Application terminates when window closed
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    createLeftPanel(frame);
    createBoardPanel(frame);
    

	// display the window we've created
	frame.pack();
	frame.setVisible(true);
    }

    private void createLeftPanel(JFrame frame) {
        //Left side menu panel
        leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setPreferredSize(new Dimension(300,frame.getHeight()));
        frame.add(leftPanel, BorderLayout.WEST);

        //Create header label for menu panel
        JLabel menuLabel = new JLabel("Queens");
        menuLabel.setFont(new Font("Arial", Font.BOLD, 30));
        leftPanel.add(menuLabel);
        menuLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(Box.createVerticalStrut(30));
        leftPanel.add(menuLabel);

        //Create panel to hold timer
        JPanel timerPanel = new JPanel();
        timerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        //timerPanel.setBackground(Color.WHITE);

        //Create label for timer
        JLabel timerLabel = new JLabel("Time: 00:00");
        timerLabel.setFont(new Font("Arial", Font.BOLD, 18));
        timerPanel.add(timerLabel);

        //Add timer panel to left panel
        leftPanel.add(Box.createVerticalStrut(100));
        leftPanel.add(timerPanel);


        //Create button panel to hold all buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10)); //horizontal and vertical padding


        //Create start and reset buttons
        startButton = new JButton("Start");
        resetButton = new JButton("Reset");
        startButton.addActionListener(this);
        resetButton.addActionListener(this);

        //Add buttons and label to button panel
        buttonPanel.add(startButton);
        buttonPanel.add(resetButton);

        //Add button panel to menu panel
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(buttonPanel);
        leftPanel.add(Box.createVerticalStrut(30));

        frame.add(leftPanel, BorderLayout.WEST);
    }
    
    private void createBoardPanel(JFrame frame) {
        //Right side board panel
        boardPanel = new JPanel(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        boardPanel.setPreferredSize(new Dimension(BOARD_SIZE * CELL_SIZE, BOARD_SIZE * CELL_SIZE));
        for(int row = 0; row < BOARD_SIZE; row++) {
            for(int col = 0; col < BOARD_SIZE; col++) {
                JButton button = new JButton();
                button.addActionListener(this);
                boardPanel.add(button);
            }
        }
    frame.add(boardPanel, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        // The main method will construct and show the GUI
        javax.swing.SwingUtilities.invokeLater(new QueensWindow());
    }
}
   