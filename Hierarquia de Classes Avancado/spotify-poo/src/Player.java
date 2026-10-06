import java.util.ArrayList;
import java.util.List;

public class Player {
    private static final int MUSICAS_ENTRE_ANUNCIOS = 3;

    private Usuario usuario;
    private List<Midia> fila = new ArrayList<>();
    private int posicao = -1;
    private int pulosUsados = 0;
    private int tocadasDesdeAnuncio = 0;

    public Player(Usuario usuario) {
        this.usuario = usuario;
    }

    public void tocar(List<Midia> novaFila) {
        if (novaFila.isEmpty()) {
            System.out.println("Nada para tocar.");
            return;
        }
        fila = new ArrayList<>(novaFila);
        posicao = 0;
        tocarAtual();
    }

    public void tocar(Midia m) {
        List<Midia> umItem = new ArrayList<>();
        umItem.add(m);
        tocar(umItem);
    }

    public void adicionarNaFila(Midia m) {
        fila.add(m);
        System.out.println("Adicionado à fila: " + m.getDescricao());
        if (posicao == -1) {
            posicao = 0;
            tocarAtual();
        }
    }

    public void proxima() {
        if (!temFila()) return;
        if (!podePular()) {
            System.out.println("Limite de " + usuario.getLimitePulos()
                    + " pulos atingido no plano " + usuario.getPlano() + ". Assine o Premium!");
            return;
        }
        if (posicao + 1 >= fila.size()) {
            System.out.println("Fim da fila.");
            return;
        }
        pulosUsados++;
        posicao++;
        tocarAtual();
    }

    public void anterior() {
        if (!temFila()) return;
        if (!podePular()) {
            System.out.println("Limite de pulos atingido no plano " + usuario.getPlano() + ".");
            return;
        }
        if (posicao == 0) {
            System.out.println("Já está no início da fila.");
            return;
        }
        pulosUsados++;
        posicao--;
        tocarAtual();
    }

    public void mostrarFila() {
        if (fila.isEmpty()) {
            System.out.println("Fila vazia.");
            return;
        }
        System.out.println("Fila de reprodução:");
        for (int i = 0; i < fila.size(); i++) {
            String marcador = (i == posicao) ? " ▶ " : "   ";
            System.out.println(marcador + (i + 1) + ". " + fila.get(i));
        }
        int limite = usuario.getLimitePulos();
        System.out.println("Pulos usados: " + pulosUsados + (limite < 0 ? " (ilimitado)" : " de " + limite));
    }

    public Midia getAtual() {
        return (posicao >= 0 && posicao < fila.size()) ? fila.get(posicao) : null;
    }

    private void tocarAtual() {
        if (usuario.temAnuncios() && tocadasDesdeAnuncio >= MUSICAS_ENTRE_ANUNCIOS) {
            System.out.println("[ANÚNCIO] Ouça sem interrupções com o Spotify Premium!");
            tocadasDesdeAnuncio = 0;
        }
        Midia m = fila.get(posicao);
        m.registrarReproducao();
        tocadasDesdeAnuncio++;
        System.out.println("Tocando agora: " + m);
    }

    private boolean podePular() {
        int limite = usuario.getLimitePulos();
        return limite < 0 || pulosUsados < limite;
    }

    private boolean temFila() {
        if (fila.isEmpty()) {
            System.out.println("A fila está vazia. Toque algo primeiro.");
            return false;
        }
        return true;
    }
}
