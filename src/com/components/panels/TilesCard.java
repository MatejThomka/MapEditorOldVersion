package com.components.panels;

import com.components.managers.ImageManager;
import com.components.managers.IconManager;
import com.maps.Tile;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TilesCard extends JPanel {

  private final Tiles[] panel = new Tiles[10];
  private final Tile[] tiles = new Tile[1000];
  private int currentPanelIndex = 0;
  CardLayout cardLayout = new CardLayout();
  IconManager iconManager;

  public TilesCard(IconManager iconManager) {
    this.iconManager = iconManager;
    setLayout(cardLayout);
    setBackground(Color.BLACK);
    loadAllTiles(null);
    this.cardLayout.show(this, String.valueOf(currentPanelIndex));
  }

  // Tiles position in main frame
  public GridBagConstraints getGridBagConstraints() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 0;
    gbc.gridy = 7;
    gbc.gridwidth = 2;
    gbc.gridheight = 2;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.insets.set(0, 5, 5, 5);
    return gbc;
  }

  public void next(int num) {
    currentPanelIndex += num;

    if (currentPanelIndex >= panel.length) {
      currentPanelIndex = 0;
    }

    this.cardLayout.show(this, String.valueOf(currentPanelIndex));
  }

  public void previous(int num) {
    currentPanelIndex -= num;

    if (currentPanelIndex < 0) {
      currentPanelIndex = panel.length - 1;
    }

    this.cardLayout.show(this, String.valueOf(currentPanelIndex));
  }


  // load all tiles images from directory
  public void loadAllTiles(String filePath) {

    if (filePath != null) {
      File folder = new File(filePath);
      File[] files = folder.listFiles((dir, name) -> name.endsWith(".png"));

      for (int i = 0; i < tiles.length; i++) {
        if (Objects.requireNonNull(files).length > i) {
          File file = files[i].getAbsoluteFile();
          String fileName = files[i].getName().substring(0, 3);
          setup(i, file, fileName);
        } else {
          tiles[i] = null;
        }
      }
    } else {
      Arrays.fill(tiles, null);
    }

    createButtons();
  }

  // setup all tiles with image or empty tile
  public void setup(int index, File file, String name) {

    ImageManager imageManager = new ImageManager();
    int size = 48;

    try {
      tiles[index] = new Tile();
      tiles[index].setName(name);
      tiles[index].setImage(ImageIO.read(file));
      tiles[index].setImage(imageManager.scaledImage(tiles[index].getImage(), size, size));
    } catch (IOException e) {
      String error = e.toString();
      JOptionPane.showMessageDialog(null, "Something went wrong while importing tiles! " + error,
          "Warning!", JOptionPane.WARNING_MESSAGE);
    }
  }

  // Set buttons for all Panels in cardLayout
  public void createButtons() {
    removeAll();

    int index = 0;

    for (int i = 0; i < panel.length; i++) {
      panel[i] = new Tiles(this.iconManager);
      for (int j = 0; j < panel[i].button.length; j++) {
        panel[i].addButtons(j, tiles[index]);
        index++;
      }
      add(panel[i], String.valueOf(i));
    }
  }
}
