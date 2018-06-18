package com.example.simplebindingdemo;

public class DataSource {

    private String name;
    private String startName;
    private String endName;

    public static DataSource get(String name) {
        return new DataSource(name);
    }

    public DataSource(String name) {

        this.name = name;
        this.startName = "Start from Data Source";
        this.endName = "End from Data Source";
    }

    public String getMessage() {
        return String.format("Hello, %s!", name);
    }

    public String getStartName() {
        return startName;
    }

    public String getEndName() {
        return endName;
    }

}
