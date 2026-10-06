public class Musica extends Midia {
    private Artista artista;
    private Album album;
    private String genero;

    public Musica(String titulo, int duracaoSegundos, Artista artista, Album album, String genero) {
        super(titulo, duracaoSegundos);
        this.artista = artista;
        this.album = album;
        this.genero = genero;
    }

    @Override
    public String getDescricao() {
        return "♪ " + titulo + " - " + artista.getNome() + " [" + album.getTitulo() + "]";
    }

    public Artista getArtista() { return artista; }
    public Album getAlbum() { return album; }
    public String getGenero() { return genero; }
}
