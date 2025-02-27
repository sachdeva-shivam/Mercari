package com.shiv.test.cucmber.testUtils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader{
	
	private Properties ps;
	String filePath =  getClass().getClassLoader().getResource("cucumber.properties").getFile();
	
	public ConfigReader() {
        ps = new Properties();
        
        try (FileInputStream fis = new FileInputStream(filePath)) {
            ps.load(fis);  // Load properties from the file
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	// Method to get a property value
    public String getProperty(String key) {
        return ps.getProperty(key);
    }
    
    // Method to set a property explicitly if it doesn't exist or update it
    public void setProperty(String key, String value) {
        if (!ps.containsKey(key)) {
            System.out.println("Property not found, setting default value for key: " + key);
        } else {
            System.out.println("Property found, updating value for key: " + key);
        }
        ps.setProperty(key, value);
        savePropertiesToFile();
    }

    // Method to save properties back to the file
    private void savePropertiesToFile() {
        try (FileOutputStream fos = new FileOutputStream(filePath)) {
            ps.store(fos, "Updated properties");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	
}