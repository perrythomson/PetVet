package com.petVet.servlets;

import com.petVet.data.DataCache;
import com.petVet.entities.Owner;
import com.petVet.entities.Pet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class CustomerController extends HttpServlet {

    public void doPost(HttpServletRequest request,
                       HttpServletResponse response)
            throws IOException, ServletException {

    String uri = request.getRequestURI();
    System.out.println("Requested URI: "+uri);

    String jspName = uri.substring(uri.lastIndexOf('/')+1);
    System.out.println("JSP Name: "+jspName);

    if(jspName.equalsIgnoreCase("viewAllPets")) {
                ArrayList<Pet> pets = DataCache.getPets();
                request.setAttribute("pets",pets);
    } else if(jspName.equalsIgnoreCase("viewPet")) {
        String petId = request.getParameter("petid");
        Pet pet = DataCache.getPet(petId);
        request.setAttribute("pet", pet);

                                                                // added in JSP from customers files
    } else if(jspName.equalsIgnoreCase("addNewPet")) {

    } else if(jspName.equalsIgnoreCase("editPet")) {


    } else if(jspName.equalsIgnoreCase("viewAllOwners")) {
        ArrayList<Owner> owners = DataCache.getOwners();
        request.setAttribute("owners",owners);
    } else if(jspName.equalsIgnoreCase("viewOwner")) {
        String ownerId = request.getParameter("ownerid");
        Owner owner = DataCache.getOwner(ownerId);
        request.setAttribute("owner",owner);


    } else if(jspName.equalsIgnoreCase("editOwner")) {

    } else if(jspName.equalsIgnoreCase("addNewOwner")) {

    }
    // ... add the if-else logic for the owner views...

    RequestDispatcher view = request.getRequestDispatcher("/customers/"+jspName+".jsp");
    view.forward(request, response);


    }

    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws IOException, ServletException {
        doPost(request,response);
    }


}
