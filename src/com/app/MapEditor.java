package com.app;


import com.components.buttons.FillButton;
import com.components.buttons.NextButton;
import com.components.buttons.PreviousButton;
import com.components.labels.MinimapTitle;
import com.components.labels.TilesTitle;
import com.components.labels.MapTitle;
import com.components.menus.BarMenu;
import com.components.panels.Minimap;
import com.components.panels.MainMap;
import com.components.panels.TilesCard;
import com.maps.Map;
import com.services.MapEditorServices;
import com.tiles.IconSetter;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.*;

public class MapEditor extends JFrame
    implements MapEditorServices {


  IconSetter iconSetter = new IconSetter();
  Map map = new Map();
  MainMap mainMap = new MainMap(map);
  Minimap minimap = new Minimap(map);
  BarMenu barMenu = new BarMenu(this.iconSetter, this);
  TilesCard tilesCard = new TilesCard(this.iconSetter);
  MapTitle mapTitle = new MapTitle();
  MinimapTitle minimapTitle = new MinimapTitle();
  TilesTitle tilesTitle = new TilesTitle();
  NextButton nextButton = new NextButton(this);
  PreviousButton previousButton = new PreviousButton(this);
  FillButton fillButton = new FillButton(this);


  public MapEditor() {
    setTitle("Map Editor v0.0.1");
    setSize(1200, 800);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setResizable(false);
    setLayout(new GridBagLayout());
    getContentPane().setBackground(Color.DARK_GRAY);


    add(mapTitle, mapTitle.getGridBagConstraints());
    add(mainMap, mainMap.getGridBagConstraints());
    add(tilesTitle, tilesTitle.getGridBagConstraints());
    add(tilesCard, tilesCard.getGridBagConstraints());
    add(nextButton, nextButton.getGridBagConstraints());
    add(previousButton, previousButton.getGridBagConstraints());
    add(fillButton, fillButton.getGridBagConstraints());
    add(minimapTitle, minimapTitle.getGridBagConstraints());
    add(minimap, minimap.getPositionOnMainFrame());


    setJMenuBar(barMenu);
    pack();
    setVisible(true);
  }

  public static void main(String[] args) {
    new MapEditor();
  }

  @Override
  public void onChangeMap(Map map) {
    mainMap.changeMap(map);
    minimap.changeMap(map);
    this.map = map;
  }

  @Override
  public void getPath(String filePath) {
    tilesCard.loadAllTiles(filePath);
  }

  @Override
  public void onChangeCard(int index) {
    int num = 1;
    if (index < 0) {
      tilesCard.previous(num);
    } else if (index > 0) {
      tilesCard.next(num);
    }
  }

  public void saveIt() {
    map.saveMap();
  }

  @Override
  public void fill() {
    map.fillIt();
    minimap.refreshMinimap();
  }

  @Override
  public void refresh() {
    minimap.refreshMinimap();
  }
}
