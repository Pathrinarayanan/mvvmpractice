package com.example.mvvmpractice;
public class WidgetItem {
    private String widget_title;
    private String widget_type;

    // Default constructor (required for JSON deserialization)
    public WidgetItem() {
    }

    // Getters for each field
    public String getWidgetTitle() {
        return widget_title;
    }

    public String getWidgetType() {
        return widget_type;
    }
}
