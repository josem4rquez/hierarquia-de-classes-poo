public class Personagem {
    private String nome;
    private String classe;
    private int vidaMaxima;
    private int vidaAtual;
    private int nivel;
    private double moedas;

    public Personagem(String nome, String classe, int vidaMaxima){
        this.nome = nome;
        this.classe = classe;
        this.vidaMaxima = vidaMaxima;

        this.nivel = 1;
        this.moedas = 100;
        this.vidaAtual = vidaMaxima;
    }

    public Personagem(String nome, String classe, int vidaMaxima, int vidaAtual, int nivel, double moedas){
        this.nome = nome;
        this.classe = classe;
        this.vidaMaxima = vidaMaxima;
        this.vidaAtual = Math.min(vidaAtual, vidaMaxima);
        this.nivel = nivel;
        this.moedas = moedas;
    }

    public String getNome(){
        return nome;
    }

    public String getClasse(){
        return classe;
    }

    public int getVidaMaxima(){
        return vidaMaxima;
    }

    public int getNivel(){
        return nivel;
    }

    public double getMoedas(){
        return moedas;
    }

    public int getVidaAtual(){
        return vidaAtual;
    }

    public void setClasse(String classe){
        this.classe = classe;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void receberDano(int dano) {
        if (dano < 0) {
            return;
        }

        vidaAtual -= dano;

        if (vidaAtual < 0) {
            vidaAtual = 0;
        }
    }

    public void recuperarVida(int cura) {
        if (cura < 0) {
            return;
        }

        vidaAtual += cura;

        if (vidaAtual > vidaMaxima) {
            vidaAtual = vidaMaxima;
        }
    }

    public boolean gastarMoedas(int quantidade) {
        if (quantidade < 0) {
            return false;
        }
        if (quantidade > moedas) {
            return false;
        }

        moedas -= quantidade;
        return true;
    }

    public void subirNivel(){
        nivel++;
    }

    public void receberMoedas(int quantidade) {
        if (quantidade < 0){
            return;
        }
        moedas += quantidade;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\n"
                + "Classe: " + classe + "\n"
                + "Vida: " + vidaAtual + "/" + vidaMaxima + "\n"
                + "Nivel: " + nivel + "\n"
                + "Moedas: " + moedas;
    }
}
