package com.components.labels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;

public class MapTitle extends JLabel {

  // Title of MainMap
  public MapTitle() {
    setText("Tiles Map");
    setFont(new Font("Unispace", Font.BOLD, 14));
    setAlignmentX(LEFT_ALIGNMENT);
    setAlignmentY(TOP_ALIGNMENT);
    setForeground(Color.WHITE);
  }

  // Position of Title
  public GridBagConstraints getGridBagConstraints() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.insets.set(5, 5, 5, 5);
    return gbc;
  }
}
