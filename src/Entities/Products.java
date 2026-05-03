package Entities;

public class Products {
    private int id;
    private String name;
    private double price;
    private int stock;

    public Products (int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public Products() {
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getPrice(){
        return price;
    }


    public int getStock(){
        return stock;
    }

    
    public void setStock(int stock){
        this.stock = stock;
    }

    public void changePrice(double price){
        this.price = price;
    }

   

    public void descrementStock(int stock) {
        this.stock -= stock;
    }

    public void incrementStock(int stock){
        this.stock += stock;
    }

   

}