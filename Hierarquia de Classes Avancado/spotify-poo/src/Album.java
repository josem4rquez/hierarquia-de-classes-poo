import java.util.ArrayList;
import java.util.List;

public class Album {
    private String titulo;
    private int ano;
    private Artista artista;
    private List<Musica> faixas = new ArrayList<>();

    public Album(String titulo, int ano, Artista artista) {
        this.titulo = titulo;
        this.ano = ano;
        this.artista = artista;
    }

    public Musica adicionarFaixa(String tituloMusica, int duracaoSegundos, String genero) {
        Musica m = new Musica(tituloMusica, duracaoSegundos, artista, this, genero);
        faixas.add(m);
        return m;
    }

    public int getDuracaoTotal() {
        int total = 0;
        for (Musica m : faixas) total += m.getDuracaoSegundos();
        return total;
    }

    public String getTitulo() { return titulo; }
    public int getAno() { return ano; }
    public Artista getArtista() { return artista; }
    public List<Musica> getFaixas() { return faixas; }
}
