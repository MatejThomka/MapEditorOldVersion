package com.components.menus.submenus;

import com.components.menus.submenus.items.help.About;
import com.components.menus.submenus.items.help.CheckForUpdates;
import com.components.menus.submenus.items.help.Help;
import javax.swing.JMenu;

public class HelpMenu extends JMenu {

  Help help = new Help();
  About about = new About();
  CheckForUpdates checkForUpdate = new CheckForUpdates();

  public HelpMenu() {
    setText("Help");
    add(help);
    add(about);
    add(checkForUpdate);
  }
}
