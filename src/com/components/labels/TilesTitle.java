package com.components.labels;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;

public class TilesTitle extends JLabel {

  public TilesTitle() {
    setText("Tiles");
    setFont(new Font("Unispace", Font.BOLD, 14));
    setAlignmentX(LEFT_ALIGNMENT);
    setAlignmentY(TOP_ALIGNMENT);
    setForeground(Color.WHITE);
    setPreferredSize(new Dimension(600, 14));
  }

  public GridBagConstraints getGridBagConstraints() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 2;
    gbc.gridheight = 1;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.insets.set(5, 5, 5, 5);
    return gbc;
  }
}
