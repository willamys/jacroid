package Gerador;

public class GeneratorUtility
{
    public static final String firstToUpperCase(String var)
    {
        if(var.length()>0)
            return var.substring(0,1).toUpperCase()+var.substring(1);
        else
            return var;
    }
    
    public static final String AllToUpperCase(String var)
    {
        if(var.length()>0)
            return var.toUpperCase();
        else
            return var;
    }
    
    public static final String AllToLowerCase(String var)
    {
        if(var.length()>0)
            return var.toLowerCase();
        else
            return var;
    }
    
    public static final String firstToLowerCase(String var)
    {
        if(var.length()>0)
            return var.substring(0,1).toLowerCase()+var.substring(1);
        else
            return var;
    }  
    
    public static final String clearTresPrimeiras(String var)
    {
        if(var.length()>0)
            return var.substring(3,var.length());
        else
            return var;
    }  
}