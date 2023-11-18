package com.components.menus;


import com.components.menus.submenus.EditMenu;
import com.components.menus.submenus.FileMenu;
import com.components.menus.submenus.HelpMenu;
import com.components.menus.submenus.ViewMenu;
import com.services.MapEditorServices;
import com.tiles.IconSetter;
import javax.swing.JMenuBar;

public class BarMenu extends JMenuBar {
  FileMenu file;
  EditMenu edit = new EditMenu();
  ViewMenu view = new ViewMenu();
  HelpMenu help = new HelpMenu();

  public BarMenu(IconSetter iconSetter, MapEditorServices mapEditorServices) {
    file = new FileMenu(iconSetter, mapEditorServices);
    add(file);
    add(edit);
    add(view);
    add(help);
  }
}
