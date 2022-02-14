package com.sample.factory;

import java.util.List;

import com.sample.model.Cars;
import com.sample.persistence.CarsDAO;
import com.sample.persistence.DBConnection;

public class CarsFactory {
   protected CarsFactory() {

   }

   private static CarsDAO dao() {
       DBConnection db = new DBConnection();
       return db.getConnect().onDemand(CarsDAO.class);
   }

   public static Cars[] listAllCars() {
       List<Cars> list = dao().listAllCars();
       return list.toArray(new Cars[list.size()]);
   }

   public static Cars findCar(int id) {
       return dao().findACar(id);
   }

   public static int addCar(String argName, double argPrice) {
    return dao().addCar(argName, argPrice);
   }

   public static int updatePrice(int argId, double argPrice) {
       return dao().updatePrice(argPrice, argId);
   }
}
