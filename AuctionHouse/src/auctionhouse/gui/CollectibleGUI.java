package auctionhouse.gui;
import auctionhouse.model.Collectible;
import auctionhouse.model.CollectibleCollection;
import auctionhouse.model.PriceComparator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * GUI class for managing collectibles in the Auction House.
 * Follows the structure provided in the class example.
 */
public class CollectibleGUI extends JFrame implements ActionListener {

    private JButton moreInfoButton, editButton, sortByIdButton, sortByPriceButton, generateStatsButton, saveButton;
    private JList<String> collectibleList;
    private DefaultListModel<String> collectibleListModel;
    private CollectibleCollection collection;
    private ArrayList<Collectible> collectibles;

    /**
     * Constructor
     * @param title      frame title
     * @param collection the collection of collectibles to manage
     */
    public CollectibleGUI(String title, CollectibleCollection collection) {
        super(title);
        this.collection = collection;
        this.setSize(600, 400);
        this.setLocation(100, 100);
        this.makeLayout();
        this.setClicks();
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // Set the content of the collectible list after initializing the GUI components
        this.setCollectibleListContent(collection.getItems());
    }

    /**
     * Private method generating the UI layout
     */
    private void makeLayout() {
        // Instantiate components
        moreInfoButton = new JButton("More Info");
        editButton = new JButton("Edit");
        sortByIdButton = new JButton("Sort by ID");
        sortByPriceButton = new JButton("Sort by Price");
        collectibleListModel = new DefaultListModel<>();
        collectibleList = new JList<>(collectibleListModel);
        generateStatsButton = new JButton("Generate Statistics");
        saveButton = new JButton("Save");
        // Create containers
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JScrollPane scrollList = new JScrollPane(collectibleList);
        // Add components to containers
        top.add(moreInfoButton);
        top.add(editButton);
        bottom.add(sortByIdButton);
        bottom.add(sortByPriceButton);
        bottom.add(generateStatsButton);
        bottom.add(saveButton);
        //add containers to frame
        this.add(top, BorderLayout.NORTH);
        this.add(bottom, BorderLayout.SOUTH);
        this.add(scrollList, BorderLayout.CENTER);
    }

    /**
     * Private method adding click commands to buttons
     */
    private void setClicks() {
        moreInfoButton.setActionCommand("moreInfo");
        editButton.setActionCommand("edit");
        sortByIdButton.setActionCommand("sortById");
        sortByPriceButton.setActionCommand("sortByPrice");
        generateStatsButton.setActionCommand("generateStats");
        saveButton.setActionCommand("save");
        moreInfoButton.addActionListener(this);
        editButton.addActionListener(this);
        sortByIdButton.addActionListener(this);
        sortByPriceButton.addActionListener(this);
        generateStatsButton.addActionListener(this);
        saveButton.addActionListener(this);
    }

    /**
     * Command to set the content of the collectible list
     * @param collectibles list of collectibles to set
     */
    public void setCollectibleListContent(ArrayList<Collectible> collectibles) {
        this.collectibles = new ArrayList<>(collectibles);
        collectibleListModel.clear();
        for (Collectible item : collectibles) {
            collectibleListModel.addElement(item.shortDescription());
        }
    }

    /**
     * Event handler for the button clicks
     * @param event the event to be processed
     */
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if (command.equals("moreInfo") && collectibleList.getSelectedIndex() != -1) {
            int selectedIndex = collectibleList.getSelectedIndex();
            Collectible selected = collectibles.get(selectedIndex);
            JOptionPane.showMessageDialog(this, selected.toString(), "More Info", JOptionPane.INFORMATION_MESSAGE);
        } else if (command.equals("edit") && collectibleList.getSelectedIndex() != -1) {
            int selectedIndex = collectibleList.getSelectedIndex();
            Collectible selected = collectibles.get(selectedIndex);
            String newPriceStr = JOptionPane.showInputDialog(this, "Type in new price:", selected.getStartingPrice());
            String newCondition = JOptionPane.showInputDialog(this, "Type in new condition:", selected.getCondition());
            try {
                double newPrice = Double.parseDouble(newPriceStr);
                selected.setStartingPrice(newPrice);
                selected.setCondition(newCondition);
                // update the display
                collectibleListModel.set(selectedIndex, selected.shortDescription());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid price format entered", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (command.equals("sortById")) {
            Collections.sort(collectibles);
            setCollectibleListContent(collectibles);
        } else if (command.equals("sortByPrice")) {
            collectibles.sort(new PriceComparator());
            setCollectibleListContent(collectibles);
        } else if (command.equals("generateStats")) {
            String filename = "statistics_summary.txt";
            collection.generateStatisticsSummary(filename);
            JOptionPane.showMessageDialog(this, "Statistics summary generated successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
//        } else if (command.equals("save")) {
//            String saveFilename = "updated_data.csv";
//            collection.saveData(saveFilename);
//            JOptionPane.showMessageDialog(this, "Data saved to " + saveFilename, "Data Saved", JOptionPane.INFORMATION_MESSAGE);
//    }
}
