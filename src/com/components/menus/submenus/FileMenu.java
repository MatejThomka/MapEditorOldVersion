package com.components.menus.submenus;


import com.components.menus.submenus.items.file.Exit;
import com.components.menus.submenus.items.file.ExportMap;
import com.components.menus.submenus.items.file.ImportMap;
import com.components.menus.submenus.items.file.ImportTiles;
import com.components.menus.submenus.items.file.NewMap;
import com.components.menus.submenus.items.file.Open;
import com.components.menus.submenus.items.file.Save;
import com.components.menus.submenus.items.file.Settings;
import com.services.MapEditorServices;
import com.components.managers.IconManager;
import javax.swing.JMenu;


public class FileMenu extends JMenu {
  NewMap newMap;
  ImportMap importMap = new ImportMap();
  ImportTiles importTiles;
  ExportMap exportMap = new ExportMap();
  Save save;
  Open open = new Open();
  Settings settings = new Settings();
  Exit exit = new Exit();

  public FileMenu(IconManager iconManager, MapEditorServices mapEditorServices) {
    newMap = new NewMap(iconManager, mapEditorServices);
    importTiles = new ImportTiles(mapEditorServices);
    save = new Save(mapEditorServices);
    setText("File");
    add(newMap);
    add(importMap);
    add(importTiles);
    add(exportMap);
    add(save);
    add(open);
    add(settings);
    add(exit);
  }
}
