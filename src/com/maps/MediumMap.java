package com.maps;

import com.services.MapEditorServices;
import com.tiles.IconSetter;
import com.tiles.Tile;
import java.awt.GridLayout;
import javax.swing.JButton;

public class MediumMap extends Map{

  public MediumMap(IconSetter iconSetter, MapEditorServices mapEditorServices) {
    this.mapEditorServices = mapEditorServices;
    this.iconSetter = iconSetter;
    this.setRows(100);
    this.setCols(100);
    this.setTiles(new Tile[this.getRows() * this.getCols()]);
    this.setButtons(new JButton[this.getTiles().length]);
    setLayout(new GridLayout(getRows(), getCols()));
    initializationOfAllButtons();
    addButtons();
  }
}
