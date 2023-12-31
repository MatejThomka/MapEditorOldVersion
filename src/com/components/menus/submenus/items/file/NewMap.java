package com.components.menus.submenus.items.file;

import com.maps.LargeMap;
import com.maps.Map;
import com.maps.MediumMap;
import com.maps.SmallMap;
import com.services.MapEditorServices;
import com.components.managers.IconManager;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class NewMap extends JMenuItem {
  Map map;
  IconManager iconManager;
  MapEditorServices mapEditorServices;



  public NewMap(IconManager iconManager, MapEditorServices mapEditorServices) {
    this.iconManager = iconManager;
    this.mapEditorServices = mapEditorServices;
    setText("New Map");
    addActionListener(this::openMapOptionPane);
  }

  private void openMapOptionPane(ActionEvent actionEvent) {
    String[] options = {"Small", "Medium", "Large"};
    int option =
        JOptionPane.showOptionDialog(null, "Chose the size of map. All previous work will be lost!",
            "Chose Map", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, options,
            options[0]);


    if (option == 0) {
      map = new SmallMap(iconManager, mapEditorServices);
    } else if (option == 1) {
      map = new MediumMap(iconManager, mapEditorServices);
    } else if (option == 2) {
      map = new LargeMap(iconManager, mapEditorServices);
    }

    if (map != null && mapEditorServices != null) {
      mapEditorServices.onChangeMap(map);
    }

  }

}
