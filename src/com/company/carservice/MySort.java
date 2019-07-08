package com.company.carservice;

import java.util.Comparator;

public class MySort implements Comparator<Car> {


    @Override
    public int compare(Car o1, Car o2) {
        return o1.getModel().compareTo(o2.getModel());
    }

}
class SortByYear implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getYear()-o2.getYear();
    }
}
class SortByPrice implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        return o1.getPrice()-o2.getPrice();
    }
}



