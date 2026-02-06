import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class StartupFrame extends JFrame{

    ArrayList<String> allSets = new ArrayList<>();
    FlashcardSet currentSet;
    JPanel cards;
    
    /*
    JButton openSetsButton;
    JButton newSetButton;
    JButton importSetButton;
    JButton settingsButton;
    */

    // Card names for card layout
    final String MAINCARD = "Main card";
    final String OPENSETCARD = "Open set card";
    final String INSETCARD = "In set card";
    final String SETTINGSCARD = "Settings card";

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

        // Populate allSets arraylist
        Path allSetNamesPath = Paths.get("./Flashcard_Sets/allSetNames.csv");
        try (Scanner reader = new Scanner(allSetNamesPath)) {
            while (reader.hasNextLine()) {
                String nextLine = reader.nextLine();
                String[] nameAndTime = nextLine.split(",");
                allSets.add(nameAndTime[0]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cards = new JPanel(new CardLayout());
        // Create the different cards that the card layout will belong to
        cards.add(mainFrame(), MAINCARD); 
        cards.add(inSet(), INSETCARD);
        cards.add(openSet(), OPENSETCARD);
        
        this.add(cards);
        this.setVisible(true);
    }
    
    private JPanel mainFrame() {
         
        JPanel card = new JPanel(new BorderLayout());

        // North panel block --------------
        JPanel northPanel = new JPanel();
        northPanel.setPreferredSize(new Dimension(100, 70));
        card.add(northPanel, BorderLayout.NORTH);
        
        // South panel block --------------
        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(100, 30));
        card.add(southPanel, BorderLayout.SOUTH);
        
        // East panel block --------------
        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(70, 100));
        card.add(eastPanel, BorderLayout.EAST);

        // West panel block --------------
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(70, 100));
        card.add(westPanel, BorderLayout.WEST);

        // Central panel with main buttons -------------
        JPanel center = new JPanel();
        center.setBackground(Color.WHITE);
        center.setLayout(new GridLayout(2, 2, 10, 10));

        // Button to create a new set
        JButton newSetButton = new JButton("Create a new set");
        newSetButton.setFocusable(false);
        newSetButton.setBounds(30, 30, 200, 100);
        newSetButton.addActionListener(e -> {
            String newSetName = JOptionPane.showInputDialog("What do you want the set name to be?");
            Path filePath = Paths.get("./Flashcard_Sets/" + newSetName + ".txt");
            if (!newSetName.equals("") && !Files.exists(filePath)) {
                try {
                    // Add set name to allSetNames.csv file and allSets arraylist
                    String newLine = newSetName + "," + System.currentTimeMillis() + "\n";
                    Path allSetNamesPath = Paths.get("./Flashcard_Sets/allSetNames.csv");
                    Files.writeString(allSetNamesPath, newLine, StandardOpenOption.APPEND);
                    allSets.add(newSetName);
                    // Create file for the set
                    Files.createFile(filePath);
                    currentSet = new FlashcardSet(newSetName);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                
                // Change to insetcard
                CardLayout c1 = (CardLayout)(cards.getLayout()); // cards.getLayout returns object of type LayoutManager, so need to type cast
                c1.show(cards, INSETCARD);
            } else if (newSetName.equals("")) {
                JOptionPane.showMessageDialog(this, "Set names cannot be empty");
            } else {
                JOptionPane.showMessageDialog(this, "This set name is taken. Try another name!");
            }
        });
        center.add(newSetButton);

        // Button to open a pre-existing set
        JButton openSetsButton = new JButton("Open a set");
        openSetsButton.setFocusable(false);
        openSetsButton.addActionListener(e -> {
            cards.add(openSet(), OPENSETCARD);
            CardLayout c1 = (CardLayout)(cards.getLayout());
            c1.show(cards, OPENSETCARD);
        });
        center.add(openSetsButton);

        // Button to import a file
        JButton importSetButton = new JButton("Import a set here");
        importSetButton.setFocusable(false);
        importSetButton.setSize(200, 100);
        importSetButton.addActionListener(e -> {
            // Add implementation later
            JOptionPane.showMessageDialog(cards, "Feature coming soon!");
        });
        center.add(importSetButton);

        
        card.add(center, BorderLayout.CENTER);
        
        return card;
    }
    
    private JPanel inSet() {
        
        JPanel card = new JPanel(new BorderLayout());
        
        // North panel block --------------
        JPanel northPanel = new JPanel();
        northPanel.setLayout(null);
        northPanel.setPreferredSize(new Dimension(100, 70));
        
        // Button to go back to main page
        JButton backButton = new JButton();
        ImageIcon buttonIcon = resizeImage(40, 40, "images/back_button.png");
        backButton.setIcon(buttonIcon);
        backButton.setFocusable(false);
        backButton.setBounds(85, 15, 40, 40);
        backButton.addActionListener(e -> {
            CardLayout c1 = (CardLayout)(cards.getLayout());
            c1.show(cards, MAINCARD);
        });
        northPanel.add(backButton);

        card.add(northPanel, BorderLayout.NORTH);
        
        // South panel block -------------
        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(100, 30));
        card.add(southPanel, BorderLayout.SOUTH);
        
        // East panel block --------------
        JPanel eastPanel = new JPanel();
        eastPanel.setPreferredSize(new Dimension(70, 100));
        card.add(eastPanel, BorderLayout.EAST);

        // West panel block -------------
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(70, 100));
        card.add(westPanel, BorderLayout.WEST);

        // Central panel with cards
        JPanel center = new JPanel();
        center.setBackground(Color.WHITE);
        center.setLayout(new GridLayout(2, 2, 10, 10));
        center.add(new JLabel("IN SET CARD"));
        card.add(center, BorderLayout.CENTER);


        return card;
    }

    private JPanel openSet() {

        JPanel card = new JPanel(new BorderLayout());
        
        // North panel block --------------
        JPanel northPanel = new JPanel();
        northPanel.setLayout(null);
        northPanel.setPreferredSize(new Dimension(100, 70));
        
        // Button to go back to main page
        JButton backButton = new JButton();
        ImageIcon buttonIcon = resizeImage(40, 40, "images/back_button.png");
        backButton.setIcon(buttonIcon);
        backButton.setFocusable(false);
        backButton.setBounds(85, 15, 40, 40);
        backButton.addActionListener(e -> {
            CardLayout c1 = (CardLayout)(cards.getLayout());
            c1.show(cards, MAINCARD);
        });
        northPanel.add(backButton);

        card.add(northPanel, BorderLayout.NORTH);
        
        // South panel block -------------
        JPanel southPanel = new JPanel();
        southPanel.setPreferredSize(new Dimension(100, 30));
        card.add(southPanel, BorderLayout.SOUTH);   

        // Central panel with sets
        // Will display 4 sets at a time
        JPanel center = new JPanel(new CardLayout());
        center.setBackground(Color.WHITE);
        
        int[] cardGroupIndex = {0, 0}; // this array is passed to the left and right button lambdas
                                       // first value is for the cardGroup, second is for num of total cards
        // East panel block --------------
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(70, 100));
        JButton rightButton = new JButton("->");
        rightButton.addActionListener(e -> { // this function will go right and loop to the front
            cardGroupIndex[0]++;
            if (cardGroupIndex[0] == cardGroupIndex[1]) {
                cardGroupIndex[0] = 0;
            }
            CardLayout c1 = (CardLayout)(center.getLayout());
            c1.show(center, Integer.toString(cardGroupIndex[0]));
        });
        eastPanel.add(rightButton);
        card.add(eastPanel, BorderLayout.EAST);

        // West panel block -------------
        JPanel westPanel = new JPanel(new BorderLayout());
        eastPanel.setPreferredSize(new Dimension(70, 100));
        JButton leftButton = new JButton("<-");
        leftButton.addActionListener(e -> { // this function will go left and loop to the front
            cardGroupIndex[0]--;
            if (cardGroupIndex[0] == -1) {
                cardGroupIndex[0] = cardGroupIndex[1] - 1;
            }
            CardLayout c1 = (CardLayout)(center.getLayout());
            c1.show(center, Integer.toString(cardGroupIndex[0]));
        });
        westPanel.add(leftButton);
        card.add(westPanel, BorderLayout.WEST);

        // Create panels that card layout will cycle through
        JPanel newCard = null;
        JButton nextButton;
        int cardNum = 0;
        for (int i = 0; i < allSets.size(); i++) {
            if (i % 4 == 0) {
                // if this is the first iteration of the loop, set newCard to new panel
                if (newCard == null) {
                    newCard = new JPanel();
                } else { // if it isn't the first iteration, add the previous card and reset newCard
                    center.add(newCard, Integer.toString(cardNum++));
                    cardGroupIndex[1]++;
                    newCard = new JPanel();
                } // after resetting/instantiating newCard, set the layout and add the first button
                newCard.setLayout(new GridLayout(2, 2, 10, 10));
            }
            nextButton = makeNextSetButton(i);
            newCard.add(nextButton);
        }
        // add final card
        center.add(newCard, Integer.toString(cardNum));
        cardGroupIndex[1]++;

        card.add(center, BorderLayout.CENTER);
        return card;
    }

    private JButton makeNextSetButton(int index) {
        JButton newButton = new JButton(allSets.get(index));
        newButton.setFocusable(false);
        newButton.addActionListener(e -> {
            currentSet = new FlashcardSet(newButton.getText());
            CardLayout c1 = (CardLayout)(cards.getLayout());
            c1.show(cards, INSETCARD);
        });
        return newButton;
    }
    // Resizes images to fit within their containers correctly
    private ImageIcon resizeImage(int newWidth, int newHeight, String filePath) {
        ImageIcon icon = new ImageIcon(filePath);
        Image originalImage = icon.getImage();
        Image newImage = originalImage.getScaledInstance(newWidth, newHeight, 0);
        ImageIcon newIcon = new ImageIcon(newImage);

        return newIcon;
    }
}