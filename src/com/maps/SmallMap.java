package com.maps;

import com.services.MapEditorServices;
import com.tiles.IconSetter;
import com.tiles.Tile;
import java.awt.GridLayout;
import javax.swing.JButton;

public class SmallMap extends Map{

  public SmallMap(IconSetter iconSetter, MapEditorServices mapEditorServices) {
    this.mapEditorServices = mapEditorServices;
    this.iconSetter = iconSetter;
    this.setRows(50);
    this.setCols(50);
    this.setTiles(new Tile[this.getRows() * this.getCols()]);
    this.setButtons(new JButton[this.getTiles().length]);
    setLayout(new GridLayout(getRows(), getCols()));
    initializationOfAllButtons();
    addButtons();
  }
}
