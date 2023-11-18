package com.components.labels;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import javax.swing.JLabel;

public class MinimapTitle extends JLabel {

  public MinimapTitle() {
    setText("Minimap");
    setFont(new Font("Unispace", Font.BOLD, 14));
    setAlignmentX(LEFT_ALIGNMENT);
    setAlignmentY(TOP_ALIGNMENT);
    setForeground(Color.WHITE);
  }

  public GridBagConstraints getGridBagConstraints() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 3;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.insets.set(5, 5, 0, 5);
    return gbc;
  }
}
