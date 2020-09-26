package com.acme.sales.repository.dao;

import com.acme.sales.model.CustomerSpecification;
import com.acme.sales.model.VacationPackage;

import java.util.ArrayList;
import java.util.List;

public class VacationPackageDAOFakeImpl implements VacationPackageDAO{

    // In memory list of vacation packages - REPRESENTS data from DB not the in memory collection
    private static List<VacationPackage> DB = new ArrayList<VacationPackage>();


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
}
