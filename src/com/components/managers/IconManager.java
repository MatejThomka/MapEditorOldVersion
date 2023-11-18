package com.components.managers;

import javax.swing.ImageIcon;

public class IconManager {


  private ImageIcon icon;
  private String name;

  public IconManager() {
    this.icon = new ImageIcon();
  }

  public ImageIcon getIcon() {
    return icon;
  }

  public void setIcon(ImageIcon icon) {
    this.icon = icon;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
