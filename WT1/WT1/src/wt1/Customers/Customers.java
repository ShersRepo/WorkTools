/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt1.Customers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author sher-
 */
public class Customers {
    private String[] customers;
    
    //Method to reverse the order of array by replace the first half of the array with the second half in the indexed order
    public String[] sortArrayToMostRecent(String[] customers){
        String replace, with;
        for(int i = 0; i <= (customers.length-1)/2; i++){
            replace = customers[i]; 
            with = customers[customers.length-1-i];
            customers[i] = with;
            customers[customers.length-1-i] = replace;        
        }
        return this.customers = customers;
    }
    
    public void removeCustomer(int index) throws IOException{
        //File customersFile = new File("Files\\Customers.txt");    /* This File (line 29) should be enabled for deployment, and line 30 commented*/
        File customersFile = new File("src\\wt1\\Customers\\Customers.txt"); /*This File (line 30) should be enabled for testing and line 29 commented out */
        List<String> listCustomers = new ArrayList<String>(Arrays.asList(this.getCustomers()));
        String customer = listCustomers.get(index);
        customer = customer + ",";
        BufferedReader reader = new BufferedReader(new FileReader(customersFile)); /*This File (line 56) should be enabled for testing and line 55 commented out */
        String line;
        StringBuilder resultCustomers = new StringBuilder();
        while((line= reader.readLine()) != null){
            line = line.replaceAll(customer, "");
            System.out.println(customer);
            System.out.println(line);
            resultCustomers.append(line);
            System.out.println(resultCustomers);
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(customersFile);
            BufferedWriter bf = new BufferedWriter(fileWriter);
            PrintWriter updater = new PrintWriter(bf);
            updater.println(resultCustomers);
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
    
    public void editCustomer(int index, String replaceWith) throws FileNotFoundException, IOException{
        //File customersFile = new File("Files\\Customers.txt");    /* This File (line 29) should be enabled for deployment, and line 30 commented*/
        File customersFile = new File("src\\wt1\\Customers\\Customers.txt"); /*This File (line 30) should be enabled for testing and line 29 commented out */
        List<String> listCustomers = new ArrayList<String>(Arrays.asList(this.getCustomers()));
        String customer = listCustomers.get(index);
        customer = customer + ",";
        BufferedReader reader = new BufferedReader(new FileReader(customersFile)); /*This File (line 56) should be enabled for testing and line 55 commented out */
        String line;
        StringBuilder resultCustomers = new StringBuilder();
        while((line= reader.readLine()) != null){
            line = line.replaceAll(customer, replaceWith + ", ");
            resultCustomers.append(line);
        }
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(customersFile);
            BufferedWriter bf = new BufferedWriter(fileWriter);
            PrintWriter updater = new PrintWriter(bf);
            updater.println(resultCustomers);
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
    
    public void addNewCustomer(String customer){
        //File customersFile = new File("Files\\Customers.txt");    /* This File (line 29) should be enabled for deployment, and line 30 commented*/
        File customersFile = new File("src\\wt1\\Customers\\Customers.txt"); /*This File (line 30) should be enabled for testing and line 29 commented out */
        if(customersFile.exists()){
            FileWriter fileWriter = null;
            try {
                fileWriter = new FileWriter(customersFile, true);
                BufferedWriter bf = new BufferedWriter(fileWriter);
                PrintWriter updater = new PrintWriter(bf);
                String lineToWrite = customer + ", ";
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
    
    public String[] getCustomers() throws IOException{
        try {
            //BufferedReader reader = new BufferedReader(new FileReader("Files\\Customers.txt")); /*This File (line 55) should be enabled for testing and line 56 commented out */
            BufferedReader reader = new BufferedReader(new FileReader("src\\wt1\\Customers\\Customers.txt")); /*This File (line 56) should be enabled for testing and line 55 commented out */
            String line;
            StringBuilder resultCustomers = new StringBuilder();
            while((line= reader.readLine()) != null){
                resultCustomers.append(line);
            }
            String customerCSV = resultCustomers.toString();
            customers = customerCSV.split("\\s*,\\s*"); //Will split customers with commas in the string and place in the customers array
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Customers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;  //Returns an unsorted array of customers 
    }
    
    
    
    
    
}
