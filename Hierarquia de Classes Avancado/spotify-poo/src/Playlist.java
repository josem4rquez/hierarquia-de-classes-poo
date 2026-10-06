import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private String nome;
    private Usuario dono;
    private boolean publica;
    private List<Midia> itens = new ArrayList<>();

    public Playlist(String nome, Usuario dono, boolean publica) {
        this.nome = nome;
        this.dono = dono;
        this.publica = publica;
    }

    public boolean adicionar(Midia m) {
        if (itens.contains(m)) return false;
        itens.add(m);
        return true;
    }

    public boolean remover(int indice) {
        if (indice < 0 || indice >= itens.size()) return false;
        itens.remove(indice);
        return true;
    }

    public int getDuracaoTotal() {
        int total = 0;
        for (Midia m : itens) total += m.getDuracaoSegundos();
        return total;
    }

    public void listar() {
        System.out.println("Playlist: " + nome + (publica ? " (pública)" : " (privada)")
                + " - de " + dono.getNome());
        if (itens.isEmpty()) {
            System.out.println("  (vazia)");
            return;
        }
        for (int i = 0; i < itens.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + itens.get(i));
        }
        int t = getDuracaoTotal();
        System.out.printf("  Total: %d itens, %d min %02d s%n", itens.size(), t / 60, t % 60);
    }

    public String getNome() { return nome; }
    public Usuario getDono() { return dono; }
    public boolean isPublica() { return publica; }
    public List<Midia> getItens() { return itens; }

    @Override
    public String toString() {
        return nome + " (" + itens.size() + " itens)";
    }
}
