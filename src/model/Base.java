package model;

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

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Base) {
            Base outro = (Base) obj;
            return outro.id == this.id;
        }
        return false;
    }
}
