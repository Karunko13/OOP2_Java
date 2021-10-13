import java.lang.Math;

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class lab01 {

    public static void main(String[] args)
    {
   
        functionNumber myFunc = new functionNumber(2.0, 2.0, -4.0);
        myFunc.printFunction();
        System.out.println("wyroznik wynosi="+myFunc.delta());
        
        double[] testTab = myFunc.miejsceZerowe();
        System.out.println("pierwsze miejsce zerowe = " +testTab[0]);
        System.out.println("drugie miejsce zerowe  = " +testTab[1]);
        
        myFunc.kan();
        myFunc.ilocz();
        
        image myImg = new image();
        
        
        int imageWidth = 500;
        int imageHeight = 500;
        String filename = "graph.png";
        
        BufferedImage myPicture = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myPicture.createGraphics();
        
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLUE);
        for(int i =0 ;i < 500; i++)
        {
        g.drawRect(i,myFunc.licz(i),1,1);
        }
       
        
        try {
            File outputfile = new File(filename);
            ImageIO.write(myPicture, "png", outputfile);
        } catch (IOException e) {
            System.out.println("I/O error while saving " + filename);
        }
    }

}

class functionNumber
{
    
    private double  _a = 0;
    private double  _b = 0;
    private double  _c = 0;
    
    private double _delta = 0;
        
    double[] myTab = new double[2];
    
    public functionNumber(double a, double  b, double c)
    {
            _a = a;
            _b = b;
            _c = c;
            
            double _delta = (_b)*(_b) - (4*_a*_c);
            //System.out.println("delta test = "+_delta);
            
    }
   
   public void printFunction()
   {
    System.out.println("Funkcja w postaci standardowej f(x)="+_a+"x^2+"+_b+"x+"+_c);
    
   }
   
   public double delta()
   {
    double delta = (_b)*(_b) - (4*_a*_c);
    return delta;
   }
   
   public double[] miejsceZerowe()
   {
    
    //double[] myTab = new double[2];
    
    if ( delta() > 0 )
    {
        myTab[0] = ((-_b) - Math.sqrt(delta()))/(2*_a);
        
        myTab[1] = ((-_b) + Math.sqrt(delta()))/(2*_a);
        
        //System.out.println("1 = " + myTab[0]);
        //System.out.println("2 = " + myTab[1]);
      
    }
    
    else if(delta() == 0)
    {
        myTab[0] = -_b/2*_a;
        myTab[1] = myTab[0];
        //System.out.println("1 = " + myTab[0]);
       
    }
    
    else if(delta() < 0)
    {
        return null;
    }  
      
     return myTab;
      
   }
    
    
   public void kan()
   {
    
    if(_a != 0)
    {
    
     double p = (-_b)/2*_a;
     double q = -delta()/4*_a;
     
     System.out.println("postac kanoniczna = " +_a+"(x"+p+")^2"+"+"+"("+q+")");
    
    }
    
    else
    {
        System.out.println("nie da sie zrobic postaci kanonicznej, dzielimy przez zero");
       
    }
    
   }
   
   public void ilocz()
   {
    
    if(_a != 0 && delta()>= 0 )
    {
        
        System.out.println("postac iloczynowa =" + _a+"(x- "+"("+myTab[0]+"))"+"(x-"+"("+myTab[1]+"))");
        
    }
    
    else
    {
    
    }
    
    
     
   }
    
    
   public int licz(int x)
   {
    
    double y = _a*x*x+_b*x +_c;
    
    return  (int)y;
   }
    
}




