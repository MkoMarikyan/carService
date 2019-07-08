package com.company.carservice;

import java.util.ArrayList;
import java.util.List;


public class Admin {
    private int profit;

    private List<Car> cars = new ArrayList<>();


    public int getProfit() {

        return profit;
    }

    public List<Car> getCars() {

        return cars;
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void incrementProfit(int carPrice){

        profit += carPrice;
    }
    public void saleCar(int index){
        Car car=cars.get(index);
        incrementProfit(car.getPrice());
        cars.remove(car);
        System.out.println("you bought"+cars.get(index)+car.getModel().getName());
    }
    public   void prontCarList() {
        for (Car car :
                cars) {
            System.out.println(car.getModel().getName()+"  "+car.getYear()+"  "+car.getPrice());

        }
    }

}