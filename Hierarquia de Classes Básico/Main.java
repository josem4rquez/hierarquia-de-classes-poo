public class Main{
    public static void main(String[] args) {
        Guerreiro guerreiro = new Guerreiro("Aragorn", 120, 120, 12, 70.0, 40, 15);
        Mago mago = new Mago("Gandalf", 100, 100, 10, 50.0, 30, 100);
        Arqueiro arqueiro = new Arqueiro("Legolas", 80, 80, 8, 30.0, 25, 20);

        System.out.println ("Informações dos personagens");
        System.out.println(mago + "\nPoder mágico: " + mago.getPoderMagico() + "\nMana: " + mago.getMana() + "\n");
        System.out.println(arqueiro + "\nPoder de ataque: " + arqueiro.getPoderDeAtaque() + "\nFlechas: " + arqueiro.getFlechas() + "\n");

        System.out.println("Ações específicas");
        System.out.println(guerreiro + "\nForça: " + guerreiro.getForca() + "\nArmadura: " + guerreiro.getArmadura() + "\n");
        guerreiro.golpear();

        System.out.println("\n " + mago.getNome() + " lança magias até ficar sem mana: ");
        while (mago.getMana() > 0) {
            mago.lancarMagia();
        }
        mago.lancarMagia();
        System.out.println("Mana restante: " + mago.getMana());

        System.out.println("\n " + arqueiro.getNome() + " atira até ficar sem flechas");
        while (arqueiro.getFlechas() > 0) {
            arqueiro.atirar();
        }
        arqueiro.atirar();
        System.out.println("Flechas restantes: " + arqueiro.getFlechas());

        System.out.println("\n Ações herdadas de Personagem");
        guerreiro.receberDano(50);
        System.out.println(guerreiro.getNome() + " recebeu 50 de dano. Vida: " + guerreiro.getVidaAtual() + "/" + guerreiro.getVidaMaxima());
        guerreiro.recuperarVida(20);
        System.out.println(guerreiro.getNome() + " recuperou 20 de vida. Vida: " + guerreiro.getVidaAtual() + "/" + guerreiro.getVidaMaxima());
        mago.receberDano(30);
        System.out.println(mago.getNome() + " recebeu 30 de dano. Vida: " + mago.getVidaAtual() + "/" + mago.getVidaMaxima());
        mago.receberMoedas(25);
        System.out.println(mago.getNome() + " recebeu 25 moedas. Moedas: " + mago.getMoedas());

        arqueiro.receberDano(100);
        System.out.println(arqueiro.getNome() + " recebeu 100 de dano. Vida: " + arqueiro.getVidaAtual() + "/" + arqueiro.getVidaMaxima());
        arqueiro.recuperarVida(40);
        System.out.println(arqueiro.getNome() + " recuperou 40 de vida. Vida: " + arqueiro.getVidaAtual() + "/" + arqueiro.getVidaMaxima());
        boolean comprou = arqueiro.gastarMoedas(20);
        System.out.println(arqueiro.getNome() + " gastou 20 moedas: " + comprou + ". Moedas: " + arqueiro.getMoedas());
        arqueiro.subirNivel();
        System.out.println(arqueiro.getNome() + " subiu para o nível " + arqueiro.getNivel());

        System.out.println("\nEstado final");
        System.out.println(guerreiro + "\n");
        System.out.println(mago + "\n");
        System.out.println(arqueiro);
    }
}
