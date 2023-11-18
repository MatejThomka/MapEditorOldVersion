package com.maps;

import com.services.MapEditorServices;
import com.components.managers.IconManager;
import java.awt.GridLayout;
import javax.swing.JButton;

public class SmallMap extends Map{

  public SmallMap(IconManager iconManager, MapEditorServices mapEditorServices) {
    this.mapEditorServices = mapEditorServices;
    this.iconManager = iconManager;
    this.setRows(50);
    this.setCols(50);
    this.setTiles(new Tile[this.getRows() * this.getCols()]);
    this.setButtons(new JButton[this.getTiles().length]);
    setLayout(new GridLayout(getRows(), getCols()));
    initializationOfAllButtons();
    addButtons();
  }
}
