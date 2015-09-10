/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fedex.tracking;

/**
 *
 * @author Karthik
 */
import java.math.BigInteger;
import java.security.SecureRandom;
import java.text.DecimalFormat;
import java.util.Random;

public class Package {

    /*
    This class contains a Tracking ID, Weight of package(randomize)
    (include kg to lb conversion), dimensions of package(randomize inches), 
    Service type(FedEx home delivery), total pieces(1 to 9), Packaging(package),
    Signature Services(Direct Signature Required), Special Handling Section
    (Direct Signature Required).    
    */
    private static SecureRandom ID = new SecureRandom();
    private String TrackingNumber;
    private double weightInKg, weightInLbs;
    private int[] dimensions;
    public String serviceType = "FedEx Home Delivery";//FedEx Home Delivery
    private int totalPieces; 
    public String packaging = "Package"; //Package
    public String signatureServices = "Direct Signature Required";//Direct Signature Requiered
    public String specialHandling = signatureServices;
    int dimensionMaxValue= 45;//used in dimensionRandomizer method

    public Package() {
        
        this.dimensions = new int[3];        
    }
    
    public final String getTrackingID()
    {
        /*
        Tracking ID is an alphanumeric key saved in a string.
        Class contains Generation, extract a tracking ID.
        Param: None
        Return: String TrackingNumber
        */
        this.TrackingNumber = new BigInteger(50, ID).toString(36).toUpperCase();
        return this.TrackingNumber;
    }
    
    public double weightRandomizer()
    {
        /*
        Random weight generated. Weight limit from 0.5 to 20 
        Param: None
        Return: double weightinKg
        */
        Random generator = new Random();
        this.weightInKg = 0.5 + (20 - 0.5)*generator.nextDouble();
        DecimalFormat form = new DecimalFormat("##.00");
        this.weightInKg = Double.parseDouble(form.format(this.weightInKg));
        return this.weightInKg;        
    }
    public double lbsConverter()
    {
        this.weightInLbs = 2.21*this.weightInKg;
        DecimalFormat form = new DecimalFormat("##.00");
        this.weightInLbs = Double.parseDouble(form.format(this.weightInLbs));
        return this.weightInLbs;
    }
    
    public int[] dimensionsRandomizer()
    {        
        /*
        Random dimension values assigned to an array of integer.
        Dimensions limited to max value of 45
        Param: None
        Return: int[3] dimensions
        */
        for(int i =0; i <=2; i++)
        {
            Random generator = new Random();
            int j = generator.nextInt() % dimensionMaxValue;
            this.dimensions[i] =  Math.abs(3 + j);
        }
       return this.dimensions;
    }
    
    public int fetchTotalPieces(){
        /*
        Random TotalPieces in package generated. Limit is 9 pieces per package
        Param: None
        Return: int totalPieces 
       */
        Random generator = new Random();
        int j = generator.nextInt() % 10;
        this.totalPieces = Math.abs(2+j);
        if(this.totalPieces == 0)
            this.totalPieces+=1;
        return this.totalPieces;
    }
    
    
    
}
 