package TV;

import TV.SmartTv;

import java.util.Scanner;

public class UsuárioTv {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        SmartTv smartTv = new SmartTv ();

        System.out.println("A Tv está ligada? " + smartTv.ligada);
        System.out.println("Canal atual : " + smartTv.canal);
        System.out.println("Volume atual : " + smartTv.volume);

        smartTv.ligar();
        System.out.println("A Tv está ligada? " + smartTv.ligada);
        System.out.println("Escre");
        int i = scan.nextInt();

        smartTv.mudarCanal(i);

        System.out.println(smartTv.canal);
    }
}
