package com.maps;


import com.components.managers.ImageManager;
import com.services.MapEditorServices;
import com.components.managers.IconManager;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Map extends JPanel implements MouseWheelListener {

  private int rows;
  private int cols;
  private int tileSize;
  private double scale;
  private Tile[] tiles;
  private JButton[] buttons;
  Image image;
  IconManager iconManager;
  MapEditorServices mapEditorServices;
  JFileChooser chooser = new JFileChooser();
  File file;
  FileNameExtensionFilter filter = new FileNameExtensionFilter(".txt", "txt");


  public Map() {
    setBackground(Color.BLACK);
    setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
    this.scale = 3.0;
    this.tileSize = (int) (16 * scale);

    addMouseWheelListener(this);
  }

  // Setters
  public void setRows(int rows) {
    this.rows = rows;
  }

  public void setCols(int cols) {
    this.cols = cols;
  }

  public void setTiles(Tile[] tiles) {
    this.tiles = tiles;
  }

  public void setButtons(JButton[] buttons) {
    this.buttons = buttons;
  }

  // Getters
  public int getRows() {
    return rows;
  }

  public int getCols() {
    return cols;
  }

  public Tile[] getTiles() {
    return tiles;
  }
  public JButton[] getButtons() {
    return buttons;
  }


  public void zoomIn() {
    double maxZoom = 3.0;
    if (scale < maxZoom) {
      scale += 0.5;
    }
  }

  public void zoomOut() {
    double minZoom = 2.0;
    if (scale > minZoom) {
      scale -= 0.5;
    }
  }

  public void initializationOfAllButtons() {
    for (int i = 0; i < buttons.length; i++) {
      buttons[i] = new JButton();
      tiles[i] = new Tile();

      buttons[i].setPreferredSize(new Dimension(tileSize, tileSize));
      buttons[i].setBackground(Color.BLACK);
      buttons[i].setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));

      int index = i;
      buttons[i].addActionListener(e -> {
        ImageManager imageManager = new ImageManager();

        if (iconManager.getIcon() != null) {
          image = iconManager.getIcon().getImage();
          image = imageManager.scaledImage((BufferedImage) image, tileSize, tileSize);
          ImageIcon icon = new ImageIcon(image);
          buttons[index].setIcon(icon);
          tiles[index].setName(iconManager.getName());
        } else {
          buttons[index].setIcon(null);
        }
        mapEditorServices.refresh();
      });

    }
  }

  public void addButtons() {
    removeAll();
    ImageManager imageManager = new ImageManager();
    for (JButton button : buttons) {
      button.setPreferredSize(new Dimension(this.tileSize, this.tileSize));

      if (button.getIcon() != null) {
        ImageIcon icon = (ImageIcon) button.getIcon();
        image = icon.getImage();
        image = imageManager.scaledImage((BufferedImage) image, this.tileSize, this.tileSize);
        icon = new ImageIcon(image);
        button.setIcon(icon);
      } else {
        button.setIcon(null);
      }

      add(button);
    }

    revalidate();
    repaint();
  }

  public void fillIt() {

    for (int i = 0; i < buttons.length; i++) {
      tiles[i].setName(iconManager.getName());

      buttons[i].setIcon(iconManager.getIcon());
    }

    revalidate();
    repaint();
  }


  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
    int notches;
    notches = e.getWheelRotation();
    if (notches < 0) {
      zoomIn();
    } else if (notches > 0) {
      zoomOut();
    }
    setTileSize();

    revalidate();
    repaint();
  }

  public void setTileSize() {
    this.tileSize = (int) (16 * scale);
    addButtons();
  }


  public void saveMap() {

    try {
      for (Tile tile : tiles) {
        String name = tile.getName();
        if (name.length() > 1) {
          if (name.charAt(0) == '0' && name.charAt(1) == '0' && name.charAt(2) == '0') {
            tile.setName("0");
          } else if (name.charAt(0) == '0' && name.charAt(1) == '0' && name.charAt(2) != '0') {
            tile.setName(name.substring(2, 3));
          } else if (name.charAt(0) == '0' && name.charAt(1) != '0') {
            tile.setName(name.substring(1, 3));
          } else if (name.charAt(0) != '0') {
            tile.setName(name);
          }
        }
      }
    } catch (Exception e) {
      String error = e.toString();
      JOptionPane.showMessageDialog(null, "Something went wrong while saving the file! " + error,
          "Warning!", JOptionPane.WARNING_MESSAGE);
      return;
    }


    chooser.setFileFilter(filter);
    chooser.setDialogTitle("Save map!");
    chooser.showSaveDialog(null);
    file = chooser.getSelectedFile();

    if (!file.getName().endsWith(".txt")) {
      file = new File(file + ".txt");
    }

    FileWriter fileWriter;
    int option;

    if (file.getAbsolutePath().endsWith(".txt") ==
        chooser.getSelectedFile().getAbsolutePath().endsWith(".txt")) {
      String[] options = {"Yes!", "No!"};
      option =
          JOptionPane.showOptionDialog(null, "File is already exists! Do you want to overwrite it?",
              "File overwriting!", JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null,
              options, options[0]);
      if (option == 0) {
        try {
          fileWriter = new FileWriter(file, false);

          int index = 0;
          for (int i = 0; i < rows; i++) {
            if (index % cols == 0 && index != 0) {
              fileWriter.write("\n");
            }
            for (int j = 0; j < cols; j++) {
              fileWriter.write(tiles[index].getName() + " ");
              index++;
            }
          }

          fileWriter.close();
          JOptionPane.showMessageDialog(null, "Overwrite successfully!", "Success!",
              JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
          String error = e.toString();
          JOptionPane.showMessageDialog(null,
              "Something went wrong while saving the file! " + error, "Warning!",
              JOptionPane.WARNING_MESSAGE);
        }
      } else if (option == 1) {
        saveMap();
      }

    } else {
      try {
        fileWriter = new FileWriter(file);

        int index = 0;
        for (int i = 0; i < rows; i++) {
          if (index % cols == 0 && index != 0) {
            fileWriter.write("\n");
          }
          for (int j = 0; j < cols; j++) {
            fileWriter.write(tiles[index].getName() + " ");
            index++;
          }
        }
        fileWriter.close();
        JOptionPane.showMessageDialog(null, "Save successfully!", "Success!",
            JOptionPane.INFORMATION_MESSAGE);
      } catch (IOException e) {
        String error = e.toString();
        JOptionPane.showMessageDialog(null, "Something went wrong while saving the file! " + error,
            "Warning!", JOptionPane.WARNING_MESSAGE);
      }
    }
  }
}
