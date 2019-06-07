/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import wt1.Customers.Customers;

/**
 *
 * @author sher-
 */
public class InternalJobLocation implements LocationClass{
        private String locationFile;
    
    public InternalJobLocation() throws IOException{
        //try{ BufferedReader reader = new BufferedReader(new FileReader("Files\\\\MasterLocation.txt")); /*This File (line 27) should be enabled for testing and line 28 commented out */
        try{ BufferedReader reader = new BufferedReader(new FileReader("src\\wt1\\InternalJobLocation.txt"));  /*This File (line 28) should be enabled for testing and line 27 commented out */
        String line;
        StringBuilder location = new StringBuilder();
        while((line= reader.readLine()) != null){
            location.append(line);
        }
        String masterFile = location.toString();
        this.locationFile = masterFile;
        }   catch (FileNotFoundException ex) {
        Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    @Override
    public void setLocationFile(String location){
            try {
                //FileWriter fileWriter = new FileWriter("Files\\MasterLocation.txt");/*This File (line 42) should be enabled for testing and line 43 commented out */
                FileWriter fileWriter = new FileWriter("src\\wt1\\InternalJobLocation.txt"); /*This File (line 43) should be enabled for testing and line 42 commented out */
                BufferedWriter bf = new BufferedWriter(fileWriter);
                PrintWriter updater = new PrintWriter(bf);
                String lineToWrite = location;
                updater.println(lineToWrite);
                updater.flush();
                updater.close();
            } catch (IOException ex) {
                Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, "Could not set file", ex);
            }
        this.locationFile = location;
    }
    
    
    @Override
    public String getLocationFile() throws IOException{
        try {
            //BufferedReader reader = new BufferedReader(new FileReader("Files\\MasterLocation.txt")); /*This File (line 59) should be enabled for testing and line 60 commented out */
            BufferedReader reader = new BufferedReader(new FileReader("src\\wt1\\InternalJobLocation.txt")); /*This File (line 60) should be enabled for testing and line 59 commented out */
            String line;
            StringBuilder location = new StringBuilder();
            while((line= reader.readLine()) != null){
                location.append(line);
            }
            String masterFile = location.toString();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
         return locationFile;
    }
}
