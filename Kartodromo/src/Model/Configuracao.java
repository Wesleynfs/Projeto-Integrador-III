package Model;

public class Configuracao {

    // Aqui ficam configurações que funcionam mesmo após finalizar o app, elas salvam no .txt //

    private boolean tema;

    public boolean isTema() {
        return tema;
    }

    public void setTema(boolean tema) {
        this.tema = tema;
    }

    public Configuracao(boolean tema) {
        this.tema = tema;
    }

    public Configuracao() {

    }

}
