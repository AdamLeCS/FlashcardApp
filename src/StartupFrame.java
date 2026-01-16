import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartupFrame extends JFrame implements ActionListener {

    ArrayList<FlashcardSet> allSets = new ArrayList<>();
    JButton flashcardSetsButton;
    JButton newSetButton;

    StartupFrame() {
        
        // This block is for misc window stuff
        // Use .getImage to get the Image from the imageicon, which can be used in the .setIconImage method
        ImageIcon flashcard_app_icon = new ImageIcon("flashcard_app_icon.png"); 
        this.setTitle("Flashcard Application");
        this.setIconImage(flashcard_app_icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.LIGHT_GRAY);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
        this.setMinimumSize(new Dimension(550, 400));
        this.setLayout(new BorderLayout());
        
        // North panel block
        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 70));
        this.add(northPanel, BorderLayout.NORTH);
        
        // South panel block
        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(100, 30));
        this.add(southPanel, BorderLayout.SOUTH);
        
        // East panel block
        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(70, 100));
        this.add(eastPanel, BorderLayout.EAST);

        // West panel block
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(70, 100));
        this.add(westPanel, BorderLayout.WEST);

        // Central panel with main buttons

        JPanel center = new JPanel();
        center.setBackground(Color.WHITE);
        center.setLayout(new GridLayout(2, 2, 10, 10));

        // Button to create a new set
        newSetButton = new JButton("Create a new set");
        newSetButton.setFocusable(false);
        newSetButton.setBounds(30, 30, 200, 100);
        newSetButton.addActionListener(this);
        center.add(newSetButton);
        
        this.add(center, BorderLayout.CENTER);
        

        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == newSetButton) {
            String newSetName = JOptionPane.showInputDialog("What do you want the set name to be?");
            if (newSetName != null) {
                FlashcardSet newSet = new FlashcardSet(newSetName);
            } else {
                JOptionPane.showMessageDialog(this,"Set names cannot be empty");
            }

            //FlashcardSet test = new FlashcardSet("Test");
        }
    }

}
 