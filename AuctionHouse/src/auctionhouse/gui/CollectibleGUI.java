package auctionhouse.gui;

import auctionhouse.model.Collectible;
import auctionhouse.model.CollectibleCollection;
import auctionhouse.model.PriceComparator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * GUI class for managing collectibles in the Auction House.
 * Follows the structure provided in the class example.
 */
public class CollectibleGUI extends JFrame implements ActionListener {

    private JButton moreInfoButton, editButton, sortByIdButton, sortByPriceButton;
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
        // Create containers
        JPanel top = new JPanel();
        JPanel bottom = new JPanel();
        JScrollPane scrollList = new JScrollPane(collectibleList);
        // Add components to containers
        top.add(moreInfoButton);
        top.add(editButton);
        bottom.add(sortByIdButton);
        bottom.add(sortByPriceButton);
        // Add containers to frame
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
        moreInfoButton.addActionListener(this);
        editButton.addActionListener(this);
        sortByIdButton.addActionListener(this);
        sortByPriceButton.addActionListener(this);
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
    @Override
    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        int selectedIndex = collectibleList.getSelectedIndex();
        if (selectedIndex != -1) {
            Collectible selected = collectibles.get(selectedIndex);
            if (command.equals("moreInfo")) {
                JOptionPane.showMessageDialog(this, selected.toString(), "More Info", JOptionPane.INFORMATION_MESSAGE);
            } else if (command.equals("edit")) {
                String newPriceStr = JOptionPane.showInputDialog(this, "Enter new price:", selected.getStartingPrice());
                String newCondition = JOptionPane.showInputDialog(this, "Enter new condition:", selected.getCondition());
                try {
                    double newPrice = Double.parseDouble(newPriceStr);
                    selected.setStartingPrice(newPrice);
                    selected.setCondition(newCondition);
                    // Update the display of the edited item
                    collectibleListModel.set(selectedIndex, selected.shortDescription());
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Invalid price value", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item first.", "No Selection", JOptionPane.WARNING_MESSAGE);
        }
        if (command.equals("sortById")) {
            Collections.sort(collectibles);
            setCollectibleListContent(collectibles);
        } else if (command.equals("sortByPrice")) {
            collectibles.sort(new PriceComparator());
            setCollectibleListContent(collectibles);
        }
    }
}
