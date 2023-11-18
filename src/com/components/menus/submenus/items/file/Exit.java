package com.components.menus.submenus.items.file;

import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class Exit extends JMenuItem {

  public Exit() {
    setText("Exit");
    addActionListener(this::exitActionPerformed);
  }

  private void exitActionPerformed(ActionEvent actionEvent) {
    System.exit(0);
  }
}
