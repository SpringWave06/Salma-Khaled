package com.pioneers.datastructures.functionalinterface;

public class Main {
    public static void main(String[] args) {
        SoundService lionSound = () -> {
            System.out.println("3aaaaaaaaaaaaooooooooooooo");
            System.out.println("ror ror ror");
        };
        EatService hamzaEatStyle = food -> System.out.println("Hm HM Hm Hm ya gamal hm y gaml");

        SendService sendService
                = (message, from, to) -> System.out.println("Sending " + message + " from " + from + " to " + to);

        lionSound.makeSound();
        hamzaEatStyle.eat("Ghazal");
        sendService.send("Hello World", "abdelaziz.said@techpioneershub.com", "mahmoud.dief@techpioneershub.com");

    }
}
