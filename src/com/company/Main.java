package com.company;

import java.util.function.BinaryOperator;

public class Main {

    public static void main(String[] args) {

        Einbauherd BoschHerd = new Einbauherd(4, 9, 250, 7);
        BoschHerd.stromAnschließen();

        BoschHerd.ofenVorheizen(200, 5);
        BoschHerd.setProgramm(3);
        BoschHerd.setOfenTemp(200);
        BoschHerd.ofentuerAuf();
        System.out.println("Kuchen rein");
        BoschHerd.ofentuerZu();
        // ...
    }
}
