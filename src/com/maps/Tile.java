package com.maps;

import java.awt.image.BufferedImage;

public class Tile {
  private BufferedImage image;
  private String name;

  // Setters
  public void setName(String name) {
    this.name = name;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }

  // Getters
  public String getName() {
    return name;
  }

  public BufferedImage getImage() {
    return image;
  }
}
