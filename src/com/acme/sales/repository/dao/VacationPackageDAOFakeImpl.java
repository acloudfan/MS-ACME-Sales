package com.acme.sales.repository.dao;

import com.acme.sales.model.CustomerSpecification;
import com.acme.sales.model.VacationPackage;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class VacationPackageDAOFakeImpl implements VacationPackageDAO{

    // In memory list of vacation packages - REPRESENTS data from DB not the in memory collection
    private static List<VacationPackage> DB = new ArrayList<VacationPackage>();


    public VacationPackageDAOFakeImpl(){
        populateDummyData();
    }

    /* This is where the database interactions will be Isolated **/
    public VacationPackage createVacationPackage(VacationPackage vacationPackage) {
        DB.add(vacationPackage);
        return vacationPackage;
    }


    public List<VacationPackage> retrieveActiveVacationPackage() {

        // List of packages
        List<VacationPackage> list = new ArrayList<VacationPackage>();

        // Find all packages that meet the criteria
        for(int i=0; i < DB.size() ; i++){
            if(DB.get(i).isActive()){
                list.add(DB.get(i));
            }
        }
        return list;
    }


    /**
     * Returns the number of objects deleted
     * @param vacationPackage
     * @return
     */
    public int deleteVacationPackage(VacationPackage vacationPackage) {
        // Find all packages that meet the criteria
        for(int i=0; i < DB.size() ; i++){
            if(vacationPackage.equals(DB.get(i))){
                DB.remove(DB.get(i));
                return 1;
            }
        }
        return 0;
    }


    /**
     * Replaces the existing object by deleting from list and then adding
     * @param vacationPackage
     * @return
     */
    public int updateVacationPackage(VacationPackage vacationPackage) {
        deleteVacationPackage((vacationPackage));
        DB.add(vacationPackage);
        return 1;
    }

    /**
     * Populate Dummy Data
     */
    private static void populateDummyData(){

        // Package to Hawaii
        VacationPackage vacationPackage = new VacationPackage("HAWAII-2020", "This is multi island package for the beautiful island of Hawaii!!", 10);
        vacationPackage.setDestination("HNL"); // Airport code for Honululu
        vacationPackage.setActive(true);
        vacationPackage.setRetailPrice(2900);
        vacationPackage.setValidTill(new GregorianCalendar(2021,3,30).getTime());
        DB.add(vacationPackage);

        // Package to Las Vegas
        vacationPackage = new VacationPackage("Viva Vegas - Luxor", "Stay at the pyramid in Vegas!!", 3);
        vacationPackage.setDestination("LAS"); // Airport code for Las Vegas
        vacationPackage.setActive(true);
        vacationPackage.setRetailPrice(999);
        vacationPackage.setValidTill(new GregorianCalendar(2021,12,31).getTime());
        DB.add(vacationPackage);
    }
}
