package com.components.menus.submenus;

import com.components.menus.submenus.items.view.Column;
import com.components.menus.submenus.items.view.Grid;
import com.components.menus.submenus.items.view.MinimapShow;
import com.components.menus.submenus.items.view.Row;
import com.components.menus.submenus.items.view.TilesMenu;
import javax.swing.JMenu;

public class ViewMenu extends JMenu {

  TilesMenu tilesMenu = new TilesMenu();
  MinimapShow minimapShow = new MinimapShow();
  Row row = new Row();
  Column column = new Column();
  Grid grid = new Grid();

  public ViewMenu() {
    setText("View");
    add(tilesMenu);
    add(minimapShow);
    add(row);
    add(column);
    add(grid);
  }
}
