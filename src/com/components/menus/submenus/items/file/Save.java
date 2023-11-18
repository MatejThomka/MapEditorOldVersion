package com.components.menus.submenus.items.file;

import com.services.MapEditorServices;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class Save extends JMenuItem {

  MapEditorServices mapEditorServices;

  public Save(MapEditorServices mapEditorServices) {
    this.mapEditorServices = mapEditorServices;
    setText("Save");
    addActionListener(this::openSaveDialog);


  }

  private void openSaveDialog(ActionEvent actionEvent) {
    mapEditorServices.saveIt();
  }

}
