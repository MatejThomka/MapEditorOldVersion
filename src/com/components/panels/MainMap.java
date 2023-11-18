package com.components.panels;

import com.maps.Map;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import javax.swing.JScrollPane;

public class MainMap extends JScrollPane {

  Map map;

  public MainMap(Map map) {
    this.map = map;
    setPreferredSize(new Dimension(1330, 592));
    setWheelScrollingEnabled(false);
    setViewportView(this.map);
    setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
  }

  public void changeMap(Map map) {
    this.map = map;
    setViewportView(map);
    revalidate();
    repaint();
  }


  public GridBagConstraints getGridBagConstraints() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 2;
    gbc.gridheight = 5;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.insets.set(0, 5, 5, 5);
    return gbc;
  }
}
