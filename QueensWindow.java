
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
    frame.setPreferredSize(new Dimension(600,500));
    //Application terminates when window closed
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(new BorderLayout());

    //Left side menu panel
    JPanel menuPanel = new JPanel();
    menuPanel.setLayout(new BorderLayout());
    menuPanel.setPreferredSize(new Dimension(150,frame.getHeight()));
    frame.add(menuPanel, BorderLayout.WEST);

    //Create button panel to center in menu panel
    JPanel buttonPanel = new JPanel();
    buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

    //Create label for timer
    JLabel timerLabel = new JLabel("Time: 00:00");
    timerLabel.setFont(new Font("Serif", Font.BOLD, 20));

    //Create start and reset buttons
    startButton = new JButton("Start");
    resetButton = new JButton("Reset");
    startButton.addActionListener(this);
    resetButton.addActionListener(this);

    //Add buttons and label to button panel
    buttonPanel.add(timerLabel, BorderLayout.NORTH);
    buttonPanel.add(startButton);
    buttonPanel.add(resetButton);

    //Add button panel to menu panel
    menuPanel.add(buttonPanel, BorderLayout.CENTER);
    frame.add(menuPanel, BorderLayout.WEST);

    //Right side board panel
    JPanel boardPanel = new JPanel(new GridLayout(8, 8));
    for(int i = 0; i < 64; i++) {
        JButton button = new JButton();
        button.addActionListener(this);
        boardPanel.add(button);
    }
    frame.add(boardPanel, BorderLayout.CENTER);

	// display the window we've created
	frame.pack();
	frame.setVisible(true);
    }
    
    public static void main(String args[]) {

	// The main method will construct and show the GUI
	javax.swing.SwingUtilities.invokeLater(new QueensWindow());
    }
}
   