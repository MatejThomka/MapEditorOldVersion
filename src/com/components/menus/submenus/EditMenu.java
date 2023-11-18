package com.components.menus.submenus;

import com.components.menus.submenus.items.edit.Copy;
import com.components.menus.submenus.items.edit.Cut;
import com.components.menus.submenus.items.edit.Paste;
import com.components.menus.submenus.items.edit.Redo;
import com.components.menus.submenus.items.edit.Select;
import com.components.menus.submenus.items.edit.Undo;
import javax.swing.JMenu;

public class EditMenu extends JMenu {

  Undo undo = new Undo();
  Redo redo = new Redo();
  Cut cut = new Cut();
  Copy copy = new Copy();
  Paste paste = new Paste();
  Select select = new Select();

  public EditMenu() {
    setText("Edit");
    add(undo);
    add(redo);
    add(cut);
    add(copy);
    add(paste);
    add(select);
  }
}
