package ru.aparfenov.restful.pocket.model;

/**
 * Created by ArtemParfenov on 12.04.2018.
 */
public class PocketElement {
    private String data;
    private String dataTitle;
    public PocketElement(String data, String dataTitle) {
        this.data = data;
        this.dataTitle = dataTitle;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public void setDataTitle(String dataTitle) {
        this.dataTitle = dataTitle;
    }

    public boolean isEmpty() {
        return (dataTitle == null || dataTitle.isEmpty()) ||
                (data == null || data.isEmpty());
    }
}
