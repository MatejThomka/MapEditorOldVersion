package com.services;

import com.maps.Map;

public interface MapEditorServices {
  void onChangeMap(Map map);
  void onChangeCard(int index);
  void fill();
  void getPath(String filePath);
  void refresh();
  void saveIt();
}
