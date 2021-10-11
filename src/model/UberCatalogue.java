/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vagishadeo
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;



public class UberCatalogue 
{
    
     private ArrayList<Uber> uber_catalogue;

    public String getLastTime() {
        return lastTime;
    }

    public void setLastTime(String lastTime) {
        this.lastTime = lastTime;
    }
    private String lastTime;
    
    public UberCatalogue(){
        this.uber_catalogue = new ArrayList<Uber>();
    }

    public ArrayList<Uber> getUber_catalogue() {
        return uber_catalogue;
    }

    public void setCar_fleet(ArrayList<Uber> uber_catalogue) {
        this.uber_catalogue = uber_catalogue;
    }
    
    public Uber addUber(){
        
        Uber newUber = new Uber();
        uber_catalogue.add(newUber);
        
        return newUber; 
    }
    
    public void deleteUber(UberCatalogue uc)
    {
         uber_catalogue.remove(uc);
    }
    
    public ArrayList<Uber> findEasyAvailable() {
        //create a new arraylist for the filtered list of cars
        ArrayList<Uber> FoundUber = new ArrayList<Uber>();
        Uber selectedUber= new Uber();
        
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        long leastAvailableDays = 99999; //Have some unrealistic number of days which will not fall in a realistic difference
        
        try {
             for(Uber newUber : uber_catalogue) { 
                if (newUber.getAvailable_status().matches("yes")) {
                    long monthdifference = formatter.parse(newUber.getAvailable_date()).getTime() - (new Date()).getTime();
                    long daysdifference = TimeUnit.DAYS.convert(monthdifference, TimeUnit.MILLISECONDS);
                    System.out.println(formatter.parse(newUber.getAvailable_date()).getTime());
                    System.out.println(new Date().getTime());
                    System.out.println(monthdifference + " " + daysdifference);
                    
                    if (daysdifference < leastAvailableDays) {
                        leastAvailableDays = daysdifference;
                        selectedUber = newUber;
                    }
                }
            }
        } catch(Exception e) {
        }
        FoundUber.add(selectedUber);
     //   this.setfilteredFleetCatalogList(filteredResult); //We will use this for Secondary filter search
        return FoundUber;
    }

    public ArrayList<Uber> SearchforCarAttribute(String uberFeatures, String text) {
        ArrayList<Uber> FoundUber = new ArrayList<Uber>();
        try {
            for (Uber uber: uber_catalogue) {
                System.out.println(uber.getSerial_no() + text.trim());
                if ((uberFeatures.equals("carMake") && uber.getCar_create().equals(text.trim()))
                    || (uberFeatures.equals("manufacturingYear") && Integer.toString(uber.getManufacture_year()).equals(text.trim()))
                    || (uberFeatures.equals("serial number") && uber.getSerial_no().equals(text.trim()))   
                    || (uberFeatures.equals("model number") && String.valueOf(uber.getModel_no()).equals(text.trim()))
                    || (uberFeatures.equals("city") && uber.getPlace().equals(text.trim()))
                    ) {
                    FoundUber.add(uber);
                }
            }
        } catch (Exception e) {
            
        }
        return FoundUber;
    }

    public ArrayList<Uber> searchSeatNumber(int min_seats, int max_seats) {
        ArrayList<Uber> FoundUber = new ArrayList<Uber>();
         
         try {
            for (Uber uber: uber_catalogue) {
                if ((uber.getSeat_count()>= min_seats) && (uber.getSeat_count() <= max_seats)) {
                    FoundUber.add(uber);
                }
            }
        } catch (Exception e) {
        }
        return FoundUber;
    }

    public String[] getListofCarManufacturers() {
        ArrayList<String> brands = new ArrayList<String>();
         
        for (Uber uber: uber_catalogue) {
            if(!brands.contains(uber.getCar_create())) {
                brands.add(uber.getCar_create());
            }
        }
         
        String[] brand_updated = new String[brands.size()];
        brand_updated = brands.toArray(brand_updated);
         
        return brand_updated;
    }

    public ArrayList<Uber> searchFirstAvailable() {
       //To change body of generated methods, choose Tools | Templates.
   
        ArrayList<Uber> FoundUber = new ArrayList<Uber>();
        Uber selectedUber= new Uber();
        
        SimpleDateFormat date = new SimpleDateFormat("MM-dd-yyyy HH:mm:ss");
        long leastAvailableDays = 99999; //Have some unrealistic number of days which will not fall in a realistic difference
        
        try {
             for(Uber newUber : uber_catalogue) { 
                    
                if (newUber.getAvailable_status().equals("yes")) {

                    long monthdifference = date.parse(newUber.getAvailable_date()).getTime() - (new Date()).getTime();
                    long daysdifference = TimeUnit.DAYS.convert(monthdifference, TimeUnit.MILLISECONDS);
                    System.out.println(date.parse(newUber.getAvailable_date()).getTime());
                    System.out.println(new Date().getTime());
                    System.out.println(monthdifference + " " + daysdifference);
                    
                    if (daysdifference < leastAvailableDays) 
                    {
                        leastAvailableDays = daysdifference;
                        selectedUber = newUber;
                    }
                }
            }
        } catch(Exception e) {
        }
        FoundUber.add(selectedUber);
     //   this.setfilteredFleetCatalogList(filteredResult); //We will use this for Secondary filter search
        return FoundUber;
    }
}
