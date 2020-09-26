package com.acme.sales.repository;

import com.acme.sales.model.CustomerSpecification;
import com.acme.sales.model.VacationPackage;
import com.acme.sales.repository.dao.VacationPackageDAO;
import com.acme.sales.repository.dao.VacationPackageDAOFakeImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Pattern: Repository
 * Model: Acme Sales
 * Represents a collection of VacationPackage
 */

public class VacationPackageCollection {

    // Hold an instance of dao
    private static VacationPackageDAO dao = new VacationPackageDAOFakeImpl();

    // Local collection of packages created using the DAO
    private static List<VacationPackage> collection = null;
    // Manages time when the collection was last updated
    private long  lastUpdateTime;
    private final long COLLECTION_EXPIRE_MILLISECOND = 600000; /* 10 minutes */

    // Retrieves the active packages
    public VacationPackageCollection(){
        updateCollection(true);
    }

    // updates the collection
    private void updateCollection(boolean force){
        if(force || (System.currentTimeMillis() - COLLECTION_EXPIRE_MILLISECOND) >= lastUpdateTime){
            collection = dao.retrieveActiveVacationPackage();
            lastUpdateTime = System.currentTimeMillis();
        }
    }

    // Adds a vacation package to the persistent store
    public boolean  addVacationPackage(VacationPackage vacationPackage){
        VacationPackage newVacationPackage =  dao.createVacationPackage(vacationPackage);
        if(newVacationPackage == null) return false;
        updateCollection(true);
        return true;
    }

    /**
     * In actual implementation a SQL or NoSQL critera will be created based on the elemenst in the specification
     * @param customerSpecification
     * @return
     */
    public List<VacationPackage> findVacationPackage(CustomerSpecification customerSpecification) {

        // make sure we have the latest vacation packages
        updateCollection(false);

        // List of packages
        List<VacationPackage> list = new ArrayList<VacationPackage>();

        // Find all packages that meet the criteria
        for(int i=0; i < collection.size() ; i++){
            if(customerSpecification.isSatisfiedBy(collection.get(i))){
                list.add(collection.get(i));
            }
        }
        return list;
    }

    // Get a vacation package by name
    public VacationPackage getVacationPackage(String name){
        CustomerSpecification specs = new CustomerSpecification(name);
        List<VacationPackage> list = this.findVacationPackage(specs);
        if(list.size() == 0){
            return null;
        } else {
            return list.get(0);
        }
    }


}
