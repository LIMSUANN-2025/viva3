/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
    
public class Museum {
    private ArrayList<Exhibit> exhibitList = new ArrayList<>();

    // Reads data from exhibits.txt
    public void loadExhibits(String filename) {
        try {
            Scanner s = new Scanner(new File(filename));
            while (s.hasNextLine()) {         // To process all the exhibits key-ed in
                String title = s.nextLine();
                String artist = s.nextLine();
                int year = Integer.parseInt(s.nextLine());
                String type = s.nextLine();
                String description = s.nextLine();
                exhibitList.add(new Exhibit(title, artist, year, type, description));
            }
            s.close();
            System.out.println("Data loaded successfully.");
        } catch (Exception e) {              // Only when there's something the programme can't read
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Search by Artist
    public void searchExhibitsByArtist(String artist) {
        for (Exhibit e : exhibitList) {
            if (e.getArtist().equalsIgnoreCase(artist)) {
                System.out.println(e.getDetails());
            }
        }
    }

    // Search by Type
    public void searchExhibitsByType(String type) {
        for (Exhibit e : exhibitList) {
            if (e.getType().equalsIgnoreCase(type)) {
                System.out.println(e.getDetails());
            }
        }
    }

    // Search by Year
    public void searchExhibitsByYear(int year) {
        for (Exhibit e : exhibitList) {
            if (e.getYear() == year) {
                System.out.println(e.getDetails());
            }
        }
    }
    
    // View All
    public void viewAllExhibits() {
        for (Exhibit e : exhibitList) {
            System.out.println(e.getDetails());
        }
    }
}
