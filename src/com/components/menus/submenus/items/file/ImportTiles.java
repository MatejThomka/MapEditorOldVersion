package com.components.menus.submenus.items.file;

import com.services.MapEditorServices;
import java.awt.event.ActionEvent;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;

public class ImportTiles extends JMenuItem {

  MapEditorServices mapEditorServices;
  public String folderPath;

  public ImportTiles(MapEditorServices mapEditorServices) {
    this.mapEditorServices = mapEditorServices;
    setText("Import Tiles");
    addActionListener(this::importTilesAction);
  }

  private void importTilesAction(ActionEvent actionEvent) {
    JFileChooser chooser = new JFileChooser();
    chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

    int result = chooser.showOpenDialog(null);

    if (result == JFileChooser.APPROVE_OPTION) {
      File selectedFolder = chooser.getSelectedFile();
      folderPath = selectedFolder.getAbsolutePath();
    }

    if (folderPath != null) {
      mapEditorServices.getPath(folderPath);
    }
  }
}
