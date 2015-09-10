/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fedex.tracking;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DecimalFormat;

/**
 *
 * @author Karthik
 */
public class FedEXTracking {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Package box = new Package();
        int totalPieces = box.fetchTotalPieces();
        
                
        double test = box.weightRandomizer();
        double testLbs = box.lbsConverter();
        System.out.println("Tracking ID:\t\t" + box.getTrackingID());
        System.out.println("Total Pieces:\t\t" + totalPieces);
        System.out.println("Weight:\t\t\t" + test + "kg/" + testLbs + "Lbs");       
        int[] a; 
        a = box.dimensionsRandomizer();
        System.out.println("Dimensions:\t\t" +a[0] + "x" + a[1] + "x"+ a[2] + " in.");
        
        System.out.println("Signature Services:\t" +box.signatureServices);
        System.out.println("Packaging:\t\t" +  box.packaging);
        System.out.println("Service Type:\t\t" + box.serviceType);
        System.out.println("Special Handling\nRequirements:\t\t"+ box.specialHandling);
        
        Connection myConn = null;
    Statement stmt = null;
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Database Connection Attempted");
        myConn = DriverManager.getConnection("jdbc:mysql://localhost/Fedex", "root", "kaakuASSASSin@4");
        System.out.println("Database opened successfully");
        stmt.executeUpdate("USE Fedex");
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
    
    }
    
}
