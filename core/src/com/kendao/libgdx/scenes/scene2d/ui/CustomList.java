package com.kendao.libgdx.scenes.scene2d.ui;

import com.badlogic.gdx.scenes.scene2d.ui.List;
import com.badlogic.gdx.scenes.scene2d.ui.ScrollPane;

import java.util.ArrayList;

public class CustomList extends ScrollPane {
  public CustomList(ArrayList<String> items) {
    super(new List<String>(CustomSkin.getInstance()), CustomSkin.getInstance());

    String[] strings = new String[items.size()];
    for (String item : items) {
      strings[items.indexOf(item)] = item;
    }

    List<String> actor = this.getActor();
    actor.setItems(strings);

    actor.getSelection().setMultiple(false);
    actor.getSelection().setRequired(true);
  }

  public void addItem(String item) {
    List<String> actor = this.getActor();
    if (actor != null && item != null) {
      actor.getItems().add(item);
    }
  }

  public boolean isEmpty() {
    List<String> actor = this.getActor();
    if (actor != null) {
      return actor.getItems().isEmpty();
    }
    return true;
  }

  public void setAlignment(int alignment) {
    List<String> actor = this.getActor();
    if (actor != null) {
      actor.setAlignment(alignment);
    }
  }

  public String getSelectedItem() {
    return (this.getActor() == null ? null : this.getActor().getSelected());
  }

  public Integer indexOf(String item) {
    List<String> actor = this.getActor();
    if (item == null || actor == null) {
      return -1;
    }

    for (String currentItem : actor.getItems()) {
      if (currentItem.equals(item)) {
        return actor.getItems().indexOf(currentItem, false);
      }
    }

    return -1;
  }

  @Override
  @SuppressWarnings("unchecked")
  public List<String> getActor() {
    if (super.getActor() == null) {
      return null;
    }
    return (List<String>) super.getActor();
  }
}
