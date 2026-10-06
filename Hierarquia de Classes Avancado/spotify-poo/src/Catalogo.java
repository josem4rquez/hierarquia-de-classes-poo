import java.util.ArrayList;
import java.util.List;

public class Catalogo {
    private List<Artista> artistas = new ArrayList<>();
    private List<Episodio> episodios = new ArrayList<>();

    public void adicionarArtista(Artista a) { artistas.add(a); }
    public void adicionarEpisodio(Episodio e) { episodios.add(e); }

    public List<Midia> getTodasMidias() {
        List<Midia> todas = new ArrayList<>();
        for (Artista a : artistas) todas.addAll(a.getTodasMusicas());
        todas.addAll(episodios);
        return todas;
    }

    public List<Midia> buscar(String termo) {
        String t = termo.toLowerCase();
        List<Midia> resultado = new ArrayList<>();
        for (Midia m : getTodasMidias()) {
            boolean achou = m.getTitulo().toLowerCase().contains(t);
            if (m instanceof Musica) {
                Musica mu = (Musica) m;
                achou = achou || mu.getArtista().getNome().toLowerCase().contains(t)
                        || mu.getGenero().toLowerCase().contains(t);
            } else if (m instanceof Episodio) {
                achou = achou || ((Episodio) m).getNomePodcast().toLowerCase().contains(t);
            }
            if (achou) resultado.add(m);
        }
        return resultado;
    }

    public List<Artista> getArtistas() { return artistas; }
    public List<Episodio> getEpisodios() { return episodios; }

    public static Catalogo criarExemplo() {
        Catalogo c = new Catalogo();

        Artista djavan = new Artista("Djavan");
        Album luz = djavan.lancarAlbum("Luz", 1982);
        luz.adicionarFaixa("Sina", 268, "MPB");
        luz.adicionarFaixa("Samurai", 290, "MPB");
        luz.adicionarFaixa("Pétala", 210, "MPB");
        c.adicionarArtista(djavan);

        Artista racionais = new Artista("Racionais MC's");
        Album sobrevivendo = racionais.lancarAlbum("Sobrevivendo no Inferno", 1997);
        sobrevivendo.adicionarFaixa("Diário de um Detento", 451, "Rap");
        sobrevivendo.adicionarFaixa("Capítulo 4, Versículo 3", 488, "Rap");
        c.adicionarArtista(racionais);

        Artista anavitoria = new Artista("Anavitória");
        Album cor = anavitoria.lancarAlbum("O Tempo É Agora", 2018);
        cor.adicionarFaixa("Trevo (Tu)", 205, "Pop");
        cor.adicionarFaixa("Ai, Amor", 198, "Pop");
        c.adicionarArtista(anavitoria);

        c.adicionarEpisodio(new Episodio("Como funciona a POO", 1800, "Dev Café", 12));
        c.adicionarEpisodio(new Episodio("Carreira em dados", 2400, "Dev Café", 13));

        return c;
    }
}
