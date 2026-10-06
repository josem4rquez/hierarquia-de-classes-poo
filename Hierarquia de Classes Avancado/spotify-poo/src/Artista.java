import java.util.ArrayList;
import java.util.List;

public class Artista {
    private String nome;
    private int seguidores;
    private List<Album> albuns = new ArrayList<>();

    public Artista(String nome) {
        this.nome = nome;
        this.seguidores = 0;
    }

    public Album lancarAlbum(String titulo, int ano) {
        Album album = new Album(titulo, ano, this);
        albuns.add(album);
        return album;
    }

    public List<Musica> getTodasMusicas() {
        List<Musica> todas = new ArrayList<>();
        for (Album a : albuns) {
            todas.addAll(a.getFaixas());
        }
        return todas;
    }

    public void ganharSeguidor() { seguidores++; }
    public void perderSeguidor() { if (seguidores > 0) seguidores--; }

    public String getNome() { return nome; }
    public int getSeguidores() { return seguidores; }
    public List<Album> getAlbuns() { return albuns; }

    @Override
    public String toString() {
        return nome + " (" + seguidores + " seguidor(es), " + albuns.size() + " álbum(ns))";
    }
}
