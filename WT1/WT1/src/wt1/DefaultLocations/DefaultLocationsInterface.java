/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wt1.DefaultLocations;

import wt1.*;
import java.io.IOException;

/**
 *
 * @author sher-
 */
public interface DefaultLocationsInterface {
    
    public abstract void setLocationFile(String location);
    
    public abstract String getLocationFile()throws IOException;
    
    
    
    
}
