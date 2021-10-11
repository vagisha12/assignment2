/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vagishadeo
 */
public class Uber 
{

    public static void deleteUber(Uber selectedUbers) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  
    private String car_create;
    private int manufacture_year;
    private int seat_count;
    private String serial_no;
    private int model_no;
    private String place;
    private int maintenance;
    private String available_status;
    private String available_date;

    
    
    
    public String getCar_create() {
        return car_create;
    }

    public void setCar_create(String car_create) {
        this.car_create = car_create;
    }

    public int getManufacture_year() {
        return manufacture_year;
    }

    public void setManufacture_year(int manufacture_year) {
        this.manufacture_year = manufacture_year;
    }

    public int getSeat_count() {
        return seat_count;
    }

    public void setSeat_count(int seat_count) {
        this.seat_count = seat_count;
    }

    public String getSerial_no() {
        return serial_no;
    }

    public void setSerial_no(String serial_no) {
        this.serial_no = serial_no;
    }

    public int getModel_no() {
        return model_no;
    }

    public void setModel_no(int model_no) {
        this.model_no = model_no;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(int maintenance) {
        this.maintenance = maintenance;
    }

    public String getAvailable_status() {
        return available_status;
    }

    public void setAvailable_status(String available_status) {
        this.available_status = available_status;
    }
    public String getAvailable_date() {
        return available_date;
    }

    public void setAvailable_date(String available_date) {
        this.available_date = available_date;
    }
 

}
