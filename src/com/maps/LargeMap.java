package com.maps;

import com.services.MapEditorServices;
import com.tiles.IconSetter;
import com.tiles.Tile;
import java.awt.GridLayout;
import javax.swing.JButton;

public class LargeMap extends Map {

  public LargeMap(IconSetter iconSetter, MapEditorServices mapEditorServices) {
    this.mapEditorServices = mapEditorServices;
    this.iconSetter = iconSetter;
    this.setRows(200);
    this.setCols(200);
    this.setTiles(new Tile[this.getRows() * this.getCols()]);
    this.setButtons(new JButton[this.getTiles().length]);
    setLayout(new GridLayout(getRows(), getCols()));
    initializationOfAllButtons();
    addButtons();
  }
}
