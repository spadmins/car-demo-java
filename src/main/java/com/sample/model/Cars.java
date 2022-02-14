package com.sample.model;

import java.util.Objects;

import com.sample.factory.CarsFactory;

public class Cars {
  private int id;
  private String carName;
  private double price;

  public Cars() {

  }

  public Cars(final int argId, final String argName, final double argPrice) {
    this.id = argId;
    this.carName = argName;
    this.price = argPrice;
  }

  public final int getId() {
    return id;
  }

  public final String getCarName() {
    return carName;
  }

  public final double getPrice() {
      return price;
  }

  public final void setId(final int argId) {
      this.id = argId;
  }

  public final void setCarName(final String argCarName) {
      this.carName = argCarName;
  }

  public final void setPrice(final double argPrice) {
      this.price = argPrice;
  }

  @Override
  public final String toString() {
    return "Cars: [Id: " + this.id  + " Name: " + this.carName + " Price: " + this.price + "]";
  }

  @Override
  public final boolean equals(final Object obj) {
      if(obj == null) {
        return false;
      }
      if(getClass() != obj.getClass()){
        return false;
      }

      Cars car = (Cars) obj;
      if(Objects.equals(id, car.id) && Objects.equals(carName, car.carName)
          && Objects.equals(price, car.price)) {
        return true;
      }
    return false;
  }

  @Override
  public final int hashCode() {
      return Objects.hash(id, carName, price);
  }

  public String addNewCar(String name, double amt) {
    String msg = "Car Not Added";

    int res = CarsFactory.addCar(name, amt);
    if(res > 0) {
      msg = "Car added successfully";
    }
    return msg;
  }

  public String updatePrice(int carId, double argPrice) {
    String msg = "Price not updated";

    int res = CarsFactory.updatePrice(carId, argPrice);
    if(res > 0) {
      msg = "Price updated";
    }
    return msg;
  }
}
