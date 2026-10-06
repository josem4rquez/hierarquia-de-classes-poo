public class Arqueiro extends Personagem {
    private int poderDeAtaque;
    private int flechas;

    public Arqueiro(String nome, int vidaMaxima, int vidaAtual, int nivel, double moedas, int poderDeAtaque, int flechas){
        super(nome, "Arqueiro", vidaMaxima, vidaAtual, nivel, moedas);
        this.poderDeAtaque = poderDeAtaque;
        this.flechas = flechas;
    }

    public int getPoderDeAtaque(){
        return poderDeAtaque;
    }

    public int getFlechas(){
        return flechas;
    }

    public void atirar(){
        if (flechas <= 0) {
            System.out.println(getNome() + " não tem flechas suficientes para atirar!");
            return;
        }
        System.out.println(getNome() + " atirou uma flecha com poder " + poderDeAtaque + "!");
        flechas -= 1;
    }

    public void setPoderDeAtaque(int poderDeAtaque){
        this.poderDeAtaque = poderDeAtaque;
    }

    public void setFlechas(int flechas){
        this.flechas = flechas;
    }

}