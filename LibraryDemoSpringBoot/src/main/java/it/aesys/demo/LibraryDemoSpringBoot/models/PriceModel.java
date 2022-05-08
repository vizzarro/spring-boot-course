package it.aesys.demo.LibraryDemoSpringBoot.models;

public class PriceModel {
  private double price;
  private double disccount;
  private double finalPrice;
  private String pippo;

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public double getDisccount() {
    return disccount;
  }

  public void setDisccount(double disccount) {
    this.disccount = disccount;
  }

  public double getFinalPrice() {
    return finalPrice;
  }

  public void setFinalPrice(double finalPrice) {
    this.finalPrice = finalPrice;
  }

  public String getPippo() {
    return pippo;
  }

  public void setPippo(String pippo) {
    this.pippo = pippo;
  }
}
