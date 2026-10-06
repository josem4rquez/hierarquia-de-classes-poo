public class Guerreiro extends Personagem {
    private int forca;
    private int armadura;

    public Guerreiro(String nome, int vidaMaxima, int vidaAtual, int nivel, double moedas, int forca, int armadura){
        super(nome, "Guerreiro", vidaMaxima, vidaAtual, nivel, moedas);
        this.forca = forca;
        this.armadura = armadura;
    }

    public int getForca(){
        return forca;
    }

    public int getArmadura(){
        return armadura;
    }

    public void golpear(){
        System.out.println(getNome() + " realizou um golpe com força " + forca + "!");
    }

    public void setForca(int forca){
        this.forca = forca;
    }

    public void setArmadura(int armadura){
        this.armadura = armadura;
    }

}