package com.acme.products.api;

import com.acme.products.model.Package;
import com.acme.products.model.PackageRepo;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import java.util.ArrayList;


public class PackageFakeRepo implements PackageRepo {

    private ArrayList<Package> collection = new ArrayList<>();

    public PackageFakeRepo(){

    }

    @PostConstruct
    public void init(){
        System.out.println("Initializing Fake Repo");
        this.addPackage(new Package(1001,"BAH03CRUISE","This is a 3 night package","Bahamas",3));
        this.addPackage(new Package(1002,"BAH07CRUISE","This is a 7 night package","Bahamas",7));
        this.addPackage(new Package(1003,"DISNEY05RESORT","This is a 5 night get away to Disney in FL","Florida",5));
        this.addPackage(new Package(1004,"JAMAICA07RESORT","This is a 7 night resort package","Jamaica",7));
    }

    @Override
    public ArrayList<Package> findPackage(String destination, int minNumNights, int maxNumNights) {
        ArrayList<Package> result = new ArrayList<>();

        for(Package p : collection){
            if(p.numberNights >= minNumNights && p.numberNights <= maxNumNights){
                result.add(p);
            }
        }

        return result;
    }

    @Override
    public boolean addPackage(Package vPackage) {

        collection.add(vPackage);

        return true;
    }
}
