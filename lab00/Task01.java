import java.lang.Math;

public class Task01 {

    public static void main(String[] args)
    {
    randomNumber myNumber = new randomNumber(10,3);

    myNumber.showTab();
    myNumber.averagTab();
    myNumber.maxTab();
    myNumber.minTab();
    myNumber.drawTab();
    }

}

class randomNumber
{
    //number of elements in array
    private final int _n;
    //number of random numbers given to class
    private final int _k;
    //table
    double[] _tab;

    public randomNumber(int n, int k)
    {

        _n = n;
        _k = k;
        _tab = new double[_n];
        for(int i = 0;i< _tab.length; i++)
        {
            for(int j = 0; j<_k; j++)
            {
                _tab[i] += Math.random()*10;

            }


        }
    }

    public void showTab()
    {
        for(int i = 0; i< _tab.length;i++)
        {
            System.out.println(_tab[i]);
        }
    }

    public void averagTab()
    {
        double sum = 0.0;

        for(int i = 0; i< _tab.length; i++)
        {
            sum += _tab[i];
        }

        System.out.println("średnia wynosi: "+ sum/ _tab.length);
    }

    public void maxTab()
    {
        double max = 0.0;

        for(int i = 0; i< _tab.length; i++)
        {
            if(_tab[i]>max)
            {
                max = _tab[i];
            }
        }
        System.out.println("max wynosi: "+max);
    }

    public void minTab()
    {
        double min = _tab[0];

        for(int i = 0; i< _tab.length; i++)
        {
            if(_tab[i]<min)
                min = _tab[i];
        }
        System.out.println("min wynosi: "+min);
    }
    public void drawTab()
    {
        int x = 0;
        for(int i = 0; i< _tab.length; i++)
        {
            for(int j = 0; j<(int)_tab[i]; j++)
            {
                System.out.print("*");
            }
            System.out.println();

        }
    }
}