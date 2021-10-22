package view;

import java.util.Random;

public class Base {
    private int id;

    public Base() {
        Random gerador = new Random();
        this.id = gerador.nextInt(10000);
    }

    public int getId() {
        return id;
    }
}
