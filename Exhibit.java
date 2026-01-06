/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

public class Exhibit {
    private String title;
    private String artist;
    private int year;
    private String type;
    private String description;

    // Constructor to set up the data
    public Exhibit(String title, String artist, int year, String type, String description) {
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.type = type;
        this.description = description;
    }

    // Display data neatly
    public String getDetails() {
        return "\nTitle: " + title + 
               "\nArtist: " + artist + 
               "\nYear: " + year + 
               "\nType: " + type + 
               "\nDescription: " + description + "\n";
    }

    // You also need these "getters" so the Museum class can search
    public String getArtist() { return artist; }
    public String getType() { return type; }
    public int getYear() { return year; }
}