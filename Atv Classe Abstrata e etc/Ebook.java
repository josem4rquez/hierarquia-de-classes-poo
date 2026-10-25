public class Ebook extends itemBibliotecaDigital implements Baixavel {
    private int quantidadePaginas;
    private String genero;
    private int tamanhoArquivo;

    public Ebook(String titulo, String autor, String genero, int tamanhoArquivo, int quantidadePaginas) {
        super(titulo, autor);
        this.genero = genero            ;
        this.tamanhoArquivo = tamanhoArquivo;
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getTamanhoArquivo() {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(int tamanhoArquivo) {
        this.tamanhoArquivo = tamanhoArquivo;
    }
    
    public int getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(int quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }  

    @Override
    public String descricao() {
        return "Ebook: " + getTitulo() + " by " + getAutor() + ", Gênero: " + getGenero() +  ", Quantidade de páginas: " + quantidadePaginas + ", Tamanho: " + tamanhoArquivo;
    }
    
    @Override
    public void baixar() {
        System.out.println("Baixando o ebook: " + getTitulo());
    }
}

