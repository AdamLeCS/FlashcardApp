import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StartupFrame extends JFrame implements ActionListener {

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


        
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }


}
 