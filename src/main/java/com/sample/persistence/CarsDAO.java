package com.sample.persistence;

import java.util.List;

import com.sample.model.Cars;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

public interface CarsDAO {
    @SqlQuery("SELECT * FROM CARS")
    @Mapper(CarsMapper.class)
    List<Cars> listAllCars();

    @SqlUpdate("INSERT INTO CARS (car_name, price) VALUES (:name, :price)")
    int addCar(@Bind("name") String name, @Bind("price") double price);

    @SqlQuery("SELECT * FROM CARS WHERE ID = :id")
    @Mapper(CarsMapper.class)
    Cars findACar(@Bind("id") int id);

    @SqlUpdate("UPDATE CARS SET PRICE = :price WHERE ID = :id")
    int updatePrice(@Bind("price") double price, @Bind("id") int id);
}
