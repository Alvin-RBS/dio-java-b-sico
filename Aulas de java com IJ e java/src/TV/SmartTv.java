package TV;

public class SmartTv {

    boolean ligada = false;
    int canal = 1;
    int volume = 25;

    public void ligar (){
        ligada = true;
    }

    public void desligar (){
        ligada = false;
    }

    public void mudarCanal (int novoCanal){
        if (canal != novoCanal) {

            canal = novoCanal;
        }
        else {
            canal = canal;
        }
    }

    public void aumentarCanal (){
        canal++;
    }

    public void diminuirCanal (){
        canal--;
    }

    public void aumentarVolume (){
        volume++;
    }

    public void diminuirVolume (){
        volume--;
    }

    public static void main(String[] args) {

    }
}


