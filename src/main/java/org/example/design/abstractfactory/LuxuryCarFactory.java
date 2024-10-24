package org.example.design.abstractfactory;

public class LuxuryCarFactory implements AbstractFactory{
    @Override
    public Car getInstance(int price) {
        if (price <= 2000000 && price >= 1000000) {
            return new LuxuryCar1();
        } else if (price > 2000000) {
            return new LuxuryCar2();
        }
        return null;
    }
}
