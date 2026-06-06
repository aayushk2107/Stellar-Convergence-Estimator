package model;

public class Star {
    private String name;
    private double mass;
    private String knownFate;
    public Star(String name,double mass,String knownFate){
        this.name=name;
        this.mass=mass;
        this.knownFate=knownFate;
    }
    public String getName(){
        return name;
    }
    public double getMass(){
        return mass;
    }
    public String getKnownFate(){
        return knownFate;
    }
    public String toString(){
        return "Star{name='"+ name + "',mass=" +mass + ",knownFate='" + knownFate+ "'}";
    }
}
