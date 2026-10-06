import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    protected String nome;
    protected String email;
    protected List<Playlist> playlists = new ArrayList<>();
    protected List<Artista> artistasSeguidos = new ArrayList<>();
    protected List<Midia> curtidas = new ArrayList<>();

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }

    public abstract String getPlano();
    public abstract int getLimitePulos();
    public abstract boolean temAnuncios();
    public abstract boolean podeBaixar();

    public Playlist criarPlaylist(String nome, boolean publica) {
        Playlist p = new Playlist(nome, this, publica);
        playlists.add(p);
        return p;
    }

    public boolean curtir(Midia m) {
        if (curtidas.contains(m)) {
            curtidas.remove(m);
            return false;
        }
        curtidas.add(m);
        return true;
    }

    public boolean seguir(Artista a) {
        if (artistasSeguidos.contains(a)) {
            artistasSeguidos.remove(a);
            a.perderSeguidor();
            return false;
        }
        artistasSeguidos.add(a);
        a.ganharSeguidor();
        return true;
    }

    public String getNome() { return nome; }
    public String getEmail() { return email; }
    public List<Playlist> getPlaylists() { return playlists; }
    public List<Artista> getArtistasSeguidos() { return artistasSeguidos; }
    public List<Midia> getCurtidas() { return curtidas; }

    @Override
    public String toString() {
        return nome + " <" + email + "> - plano " + getPlano();
    }
}
