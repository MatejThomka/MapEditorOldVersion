package com.components.panels;

import com.components.managers.IconManager;
import com.maps.Tile;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class Tiles extends JPanel {

  JButton[] button = new JButton[100];
  IconManager iconManager;

  // Constructor
  public Tiles(IconManager iconManager) {
    this.iconManager = iconManager;
    setPreferredSize(new Dimension(1325, 212));
    setLayout(new GridLayout(4, 25));
    setAlignmentX(LEFT_ALIGNMENT);
    setAlignmentY(TOP_ALIGNMENT);
    setBackground(Color.BLACK);
    setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
  }

  // draw buttons with Tiles images
  public void addButtons(int index, Tile tile) {
    if (tile != null) {
      ImageIcon icon = new ImageIcon(tile.getImage());

      button[index] = new JButton();
      button[index].setIcon(icon);
      button[index].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
      button[index].addActionListener(e -> {
        iconManager.setIcon((ImageIcon) button[index].getIcon());
        iconManager.setName(tile.getName());
      });
      add(button[index]);
    } else {
      button[index] = new JButton();
      button[index].setPreferredSize(new Dimension(48, 48));
      button[index].setBackground(Color.BLACK);
      button[index].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
      button[index].addActionListener(e -> iconManager.setIcon((ImageIcon) button[index].getIcon()));
      add(button[index]);
    }


    revalidate();
    repaint();
  }


}
