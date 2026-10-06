public class Mago extends Personagem {
    private int poderMagico;
    private int mana;

    public Mago(String nome, int vidaMaxima, int vidaAtual, int nivel, double moedas, int poderMagico, int mana){
        super(nome, "Mago", vidaMaxima, vidaAtual, nivel, moedas);
        this.poderMagico = poderMagico;
        this.mana = mana;
    }

    public int getPoderMagico(){
        return poderMagico;
    }

    public int getMana(){
        return mana;
    }

    public void lancarMagia(){
        if (mana <= 0) {
            System.out.println(getNome() + " não tem mana suficiente para lançar uma magia!");
            return;
        }
        System.out.println(getNome() + " lançou um feitiço com poder " + poderMagico + "!");
        mana -= 10;
    }

    public void setPoderMagico(int poderMagico){
        this.poderMagico = poderMagico;
    }

    public void setMana(int mana){
        this.mana = mana;
    }

}