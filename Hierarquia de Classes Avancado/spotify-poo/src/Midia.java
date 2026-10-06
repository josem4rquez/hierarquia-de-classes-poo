public abstract class Midia {
    protected String titulo;
    protected int duracaoSegundos;
    protected int reproducoes;

    public Midia(String titulo, int duracaoSegundos) {
        this.titulo = titulo;
        this.duracaoSegundos = duracaoSegundos;
        this.reproducoes = 0;
    }

    public abstract String getDescricao();

    public void registrarReproducao() {
        reproducoes++;
    }

    public String getDuracaoFormatada() {
        return String.format("%d:%02d", duracaoSegundos / 60, duracaoSegundos % 60);
    }

    public String getTitulo() { return titulo; }
    public int getDuracaoSegundos() { return duracaoSegundos; }
    public int getReproducoes() { return reproducoes; }

    @Override
    public String toString() {
        return getDescricao() + " (" + getDuracaoFormatada() + ")";
    }
}
