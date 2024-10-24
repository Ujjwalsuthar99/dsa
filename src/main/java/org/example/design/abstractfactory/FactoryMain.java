package org.example.design.abstractfactory;

public class FactoryMain {

    public static void main(String[] args) {
        AbstractFactoryProducer abstractFactoryProducer = new AbstractFactoryProducer();
        AbstractFactory abstractFactory = abstractFactoryProducer.getFactoryInstance("Luxury");
        Car car = abstractFactory.getInstance(5000000);
        System.out.println(car.getTopSpeed());

    }

}
