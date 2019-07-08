package com.company.carservice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Admin admin = new Admin();
        Scanner scanner = new Scanner(System.in);
        Model model = chooseModel(scanner);
        System.out.println("model is = " + model.getName());
        myMenu(admin, scanner);

    }

    private static void myMenu(Admin admin, Scanner scanner) {
        System.out.println("  1 - CAR LIST  "+"  2 - ADD NEW CAR  "+"  3 - SORT  "+"  4 - ASMIN PROFIT");
        switch (scanner.nextInt()){
            case 1:
                admin.prontCarList();
                sale(admin,scanner);
                admin.prontCarList();
                break;
            case 2:
                createNewCar(admin,scanner);
                break;
            case 3:
                sortCars(admin);
                admin.prontCarList();
            case 4:
                System.out.println(admin.getProfit());
                break;
            default:
                myMenu(admin,scanner);
        }
        myMenu(admin, scanner);

    }



    public static void sortCars(Admin admin){
        //sort by model
        MySort mySort=new MySort();
        Collections.sort(admin.getCars(),mySort);

        SortByYear sortByYear=new SortByYear();
        Collections.sort(admin.getCars(),sortByYear);
        SortByPrice sortByPrice=new SortByPrice();
        Collections.sort(admin.getCars(),sortByPrice);
    }

    public static void sale (Admin admin, Scanner scanner){
        System.out.println("select car");
        int index=scanner.nextInt();
        index--;
        if (index==-1)
            myMenu(admin,scanner);
        else {
            if (index>=0 && index<admin.getCars().size()){
                admin.saleCar(index);
            }
            else
                sale(admin,scanner);
        }
    }

    public static void createNewCar(Admin admin,Scanner scanner){
        Model model=chooseModelMenu(scanner);
        System.out.println("write price");
        int price=scanner.nextInt();

        System.out.println("write year");
        int year=scanner.nextInt();

        Car car=new Car(model,year,price);
        admin.addCar(car);
        myMenu(admin,scanner);


    }
    public static Model chooseModelMenu(Scanner scanner) {

        System.out.println("Choose Car Model");
        System.out.println("1. BMW" + "\n"
                + "2. MERCEDES" + "\n"
                + "3. KIA" + "\n"
                + "4. PORSCHE" + "\n"
                + "5. VAZ" + "\n"
                + "6. ERAZ");
        int choosenValue = scanner.nextInt();
        Model model = chooseModel(choosenValue);
        while (model == Model.NO_SELECTED) {
            chooseModelMenu(scanner);
        }
        System.out.println(model.getName());
        return model;

    }



    private static Model chooseModel(Scanner scanner){
        System.out.println("choose car model");
        System.out.println("1. BMW 2.MERCEDES 3.KIA 4.VAZ 5.ERAZ");
        int choosenValue = scanner.nextInt();
        Model model = chooseModel(choosenValue);
        while (model == Model.NO_SELECTED){
            model = chooseModel(scanner);
        }
        return model;
    }
    private static Model chooseModel(int number) {
        switch (number) {
            case 1:
                return Model.BMW;
            case 2:
                return Model.MERCEDES;
            case 3:
                return Model.KIA;
            case 4:
                return Model.VAZ;
            case 5:
                return Model.ERAZ;
            default:
                return Model.NO_SELECTED;
        }
    }
}
