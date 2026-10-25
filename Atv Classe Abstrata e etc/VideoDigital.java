public class VideoDigital extends itemBibliotecaDigital implements Baixavel, VIsualizavel {
    private int duracaoMinutos;

    public VideoDigital(String titulo, String autor, int duracaoMinutos) {
        super(titulo, autor);
        this.duracaoMinutos = duracaoMinutos;
    }

    public int getDuracaoMinutos() {
        return duracaoMinutos;
    }

    public void setDuracaoMinutos(int duracaoMinutos) {
        this.duracaoMinutos = duracaoMinutos;
    }

    @Override
    public String descricao() {
        return "Título: " + getTitulo() + ", Autor: " + getAutor() + ", Duração: " + duracaoMinutos + " minutos";
    }

    @Override
    public void baixar() {
        System.out.println("Baixando o vídeo: " + getTitulo());
    }

    @Override
    public void visualizar() {
        System.out.println("Visualizando o vídeo: " + getTitulo());
    }
}