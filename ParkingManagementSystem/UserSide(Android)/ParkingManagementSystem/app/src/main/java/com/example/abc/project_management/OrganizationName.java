package com.example.abc.project_management;

import java.util.ArrayList;

public class OrganizationName {

    private String name;
   // private int slot;
    ArrayList<Integer> slot;

    public OrganizationName(String name) {
        this.name = name;
       // this.slot = slot;
    }

    public void setName(String name) {
        this.name = name;
    }

   /* public void setSlot(int slot) {
        this.slot = slot;
    }
*/

    public void setSlot(ArrayList<Integer> slot) {
        this.slot = slot;
    }

    public String getName() {

        return name;
    }

    /*public int getSlot() {
        return slot;
    }*/

    public ArrayList<Integer> getSlot() {
        return slot;
    }
}
