/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt1.Descriptions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
public class Descriptions {
    private String[] descriptions;
    
    
    public void addNewDescription(String description){
        //File customersFile = new File("Files\\Descriptions.txt");/*This File (line 29) should be enabled for testing and line 30 commented out */
        File customersFile = new File("src\\wt1\\Descriptions\\Descriptions.txt"); /*This File (line 30) should be enabled for testing and line 29 commented out */
        if(customersFile.exists()){
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(customersFile, true);
                BufferedWriter bf = new BufferedWriter(fileWriter);
                PrintWriter updater = new PrintWriter(bf);
                String lineToWrite = description + ", ";
                updater.println(lineToWrite);
                updater.flush();
                updater.close();
            } catch (IOException ex) {
                Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, "Could Not Find File", ex);
            } finally {
                try {
                    fileWriter.close();
                } catch (IOException ex) {
                    Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, "Programme terminated before saving", ex);
                }
            }
        }
    }
    
        public String[] getDescriptions() throws IOException{
        try {
            //BufferedReader reader = new BufferedReader(new FileReader("Files\\Descriptions.txt")); /*This File (line 55) should be enabled for testing and line 56 commented out */
            BufferedReader reader = new BufferedReader(new FileReader("src\\wt1\\Descriptions\\Descriptions.txt")); /*This File (line 56) should be enabled for testing and line 55 commented out */
            String line;
            StringBuilder resultDescriptions = new StringBuilder();
            while((line= reader.readLine()) != null){
                resultDescriptions.append(line);
            }
            String descriptionCSV = resultDescriptions.toString();
            descriptions = descriptionCSV.split("\\s*,\\s*");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
         return descriptions;
    }
    
    
    
}
