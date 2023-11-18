package com.components.buttons;

import com.components.managers.ImageManager;
import com.services.MapEditorServices;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class FillButton extends JButton {

  BufferedImage image;
  ImageIcon icon;
  MapEditorServices mapEditorServices;

  public FillButton(MapEditorServices mapEditorServices) {
    this.mapEditorServices = mapEditorServices;
    getImage();
    this.icon = new ImageIcon(image);
    setIcon(icon);
    setBorder(BorderFactory.createLineBorder(Color.WHITE, 1));
    addActionListener(e -> mapEditorServices.fill());
  }

  // Tiles position in main frame
  public GridBagConstraints getGridBagConstraints() {
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridx = 3;
    gbc.gridy = 8;
    gbc.gridwidth = 1;
    gbc.gridheight = 1;
    gbc.anchor = GridBagConstraints.NORTHWEST;
    gbc.insets.set(5, 5, 5, 5);
    return gbc;
  }

  public void getImage() {
    ImageManager imageManager = new ImageManager();

    try {
      image =
          ImageIO.read(Objects.requireNonNull(getClass().getResourceAsStream("/default/fill.png")));
      image = imageManager.scaledImage(image, 48, 48);
    } catch (IOException e) {
      String error = e.toString();
      JOptionPane.showMessageDialog(null, "Something went wrong! " + error, "Warning!",
          JOptionPane.WARNING_MESSAGE);
    }
  }

}
