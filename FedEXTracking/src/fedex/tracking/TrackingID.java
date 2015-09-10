/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fedex.tracking;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.sql.*;

/**
 *
 * @author Karthik
 */
public class TrackingID {

    /*
      Tracking ID is an alphanumeric key saved in a string.
      Class contains Generation, extract a tracking ID.
    */
    private static SecureRandom ID = new SecureRandom();
    private static String UID; 
    
    TrackingID()
    {   /*
            Tracking ID String Generation
        */
       this.UID = new BigInteger(50, ID).toString(36).toUpperCase();
    }
    
    public String getTrackingID()
    {
        /*
            Returns Tracking ID
            param: None
            return: String 
        */
        return this.UID;        
    }
}
