package com.mykeep.r3j3ct3d.mykeep;

public class ItemObjects {

    private String  _title;
    private String  _content;
    private int     _image;

    ItemObjects(String title, String content, int image) {

        _title = title;
        _content = content;
        _image = image;
    }

    ItemObjects(String title, String content) {

        _title = title;
        _content = content;
        _image = -1;
    }

    // Getters
    public String getTitle() {
        return _title;
    }

    public int getImage() {
        return _image;
    }

    String getContent() {
        return _content;
    }

    // Setters
    public void setTitle(String title) {
        _title = title;
    }

    public void setImage(int image) {
        _image = image;
    }

    public void setContent(String content) {
        _content = content;
    }
}
