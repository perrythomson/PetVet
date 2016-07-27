package com.petVet.data;

import com.petVet.entities.Owner;
import com.petVet.entities.Pet;

import java.util.ArrayList;
import java.util.HashMap;

public class DataCache {
    private static DataCache instance = null;
    private static HashMap<String, Pet> petsHashMap;
    private static HashMap<String, Owner> ownersHashMap;

    private DataCache() {
        // Exists only to defeat instantiation.
    }
    public static synchronized DataCache getInstance() { //constructor setting instance to itself...
        if(instance == null) {
            instance = new DataCache();
        }
        return instance;
    }

    public static ArrayList<Pet> getPets() {
        if(petsHashMap==null || petsHashMap.isEmpty()) {
            loadDataCache();
        }
        return new ArrayList<>(petsHashMap.values());
    }

    public static Pet getPet(String petId) {
        if(petsHashMap==null || petsHashMap.isEmpty()) {
            loadDataCache();
        }
        Pet pet = null;
        if(petsHashMap.containsKey(petId)) {
            pet = petsHashMap.get(petId);
        }
        return pet;
    }

    public static ArrayList<Owner> getOwners() {
        if(ownersHashMap==null || ownersHashMap.isEmpty()) {
            loadDataCache();
        }
        return new ArrayList<>(ownersHashMap.values());
    }

    public static Owner getOwner(String ownerId) {
        if(ownersHashMap==null || ownersHashMap.isEmpty()) {
            loadDataCache();
        }
        Owner owner = null;
        if(ownersHashMap.containsKey(ownerId)) {
            owner = ownersHashMap.get(ownerId);
        }
        return owner;
    }

    private static void loadDataCache() {
        petsHashMap = new HashMap<>();
        ownersHashMap = new HashMap<>();

        String ownerId = System.currentTimeMillis()+"-bd";
        ownersHashMap.put(ownerId,new Owner(ownerId,"Bob","Denver","801-111-2222","123 Desert Island"));

        String petId = System.currentTimeMillis()+"-n";
        petsHashMap.put(petId, new Pet(petId,"Nemo",Pet.PetType.FISH,ownerId));

        ownerId = System.currentTimeMillis()+"-jd";
        ownersHashMap.put(ownerId,new Owner(ownerId,"Jane","Doe","801-333-4444","345 Avenue A."));

        petId = System.currentTimeMillis()+"-k";
        petsHashMap.put(petId, new Pet(petId,"Kat",Pet.PetType.CAT,ownerId));

        ownerId = System.currentTimeMillis()+"-mc";
        ownersHashMap.put(ownerId,new Owner(ownerId,"Master","Chief","801-555-6666","678 Halo Way"));

        petId = System.currentTimeMillis()+"-c";
        petsHashMap.put(petId, new Pet(petId,"Cortana",Pet.PetType.BIRD,ownerId));

        ownerId = System.currentTimeMillis()+"-sc";
        ownersHashMap.put(ownerId,new Owner(ownerId,"Santa","Clause","801-777-8888","1 North Pole"));

        petId = System.currentTimeMillis()+"-r";
        petsHashMap.put(petId, new Pet(petId,"Rudolph",Pet.PetType.DOG,ownerId));
    }
}
