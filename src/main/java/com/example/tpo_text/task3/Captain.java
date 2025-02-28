package com.example.tpo_text.task3;

class Captain extends Human {
    private int ordersGiven = 0;

    public Captain(String name, int age, int health) {
        super(name, age, health);
    }

    public String giveOrder(String order) {
        ordersGiven++;
        return name + " отдаёт приказ: " + order;
    }

    public int getOrdersGiven() {
        return ordersGiven;
    }
}
