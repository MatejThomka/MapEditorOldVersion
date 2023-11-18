package com.components.panels;

import com.maps.Map;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Minimap extends JPanel {

  Map map;
  JLabel[] labels;

  public Minimap(Map map) {
    this.map = map;
    setPreferredSize(new Dimension(200, 200));
    setBackground(Color.BLACK);
    prepareMinimap();
  }


  public GridBagConstraints getPositionOnMainFrame() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 2;
    gbc.gridy = 4;
    gbc.gridwidth = 4;
    gbc.gridheight = 2;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.insets.set(0, 5, 0, 5);
    return gbc;
  }

  public void changeMap(Map map) {
    this.map = map;
    prepareMinimap();
  }

  public void prepareMinimap() {
    removeAll();
    if (this.map.getButtons() != null) {
      this.labels = new JLabel[map.getButtons().length];
      setLayout(new GridLayout(map.getRows(), map.getCols()));

      for (int i = 0; i < labels.length; i++) {
        labels[i] = new JLabel();
        labels[i].setIcon(null);
      }

      revalidate();
      repaint();
    }
  }

  public void refreshMinimap() {
    removeAll();

    for (int i = 0; i < map.getButtons().length; i++) {
      labels[i].setBackground(Color.BLACK);
      labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 0));
      if (map.getButtons()[i].getIcon() != null) {
        labels[i].setIcon(map.getButtons()[i].getIcon());
      } else {
        labels[i].setIcon(null);
      }
      add(labels[i]);
    }

    revalidate();
    repaint();
  }
}
