
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GUI {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame();
        // Use .getImage to get the Image from the imageicon, which can be used in the .setIconImage method
        ImageIcon flashcard_app_icon = new ImageIcon("flashcard_app_icon.png"); 
        frame.setTitle("Flashcard Application");
        frame.setIconImage(flashcard_app_icon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
