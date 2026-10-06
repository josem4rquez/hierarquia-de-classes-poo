
public class Episodio extends Midia {
    private String nomePodcast;
    private int numero;

    public Episodio(String titulo, int duracaoSegundos, String nomePodcast, int numero) {
        super(titulo, duracaoSegundos);
        this.nomePodcast = nomePodcast;
        this.numero = numero;
    }

    @Override
    public String getDescricao() {
        return nomePodcast + " #" + numero + ": " + titulo;
    }

    public String getNomePodcast() { return nomePodcast; }
    public int getNumero() { return numero; }
}
