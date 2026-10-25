public class Main {
    public static void main(String[] args) {
        System.out.println("Cenário 1: uso básico");
        VideoDigital videoAutenthicGames = new VideoDigital("Video Autenthic Games", "Authentic Games", 10);
        System.out.println(videoAutenthicGames.descricao());
        videoAutenthicGames.baixar();
        videoAutenthicGames.visualizar();

        Ebook livroAuthenticGames = new Ebook("Livro Authentic Games", "Authentic Games", "Aventura", 5, 100);
        System.out.println(livroAuthenticGames.descricao());
        livroAuthenticGames.baixar();

        System.out.println("\nCenário 2: polimorfismo com itemBibliotecaDigital");
        itemBibliotecaDigital[] acervo = {
            videoAutenthicGames,
            livroAuthenticGames,
            new VideoDigital("Aula de POO", "Prof. Silva", 45),
            new Ebook("Java Básico", "Maria Souza", "Educação", 12, 350)
        };
        for (itemBibliotecaDigital item : acervo) {
            System.out.println(item.descricao());
        }

        System.out.println("\nCenário 3: interface Baixavel");
        for (itemBibliotecaDigital item : acervo) {
            if (item instanceof Baixavel) {
                ((Baixavel) item).baixar();
            }
        }

        System.out.println("\nCenário 4: interface VIsualizavel");
        for (itemBibliotecaDigital item : acervo) {
            if (item instanceof VIsualizavel) {
                ((VIsualizavel) item).visualizar();
            } else {
                System.out.println("\"" + item.getTitulo() + "\" não pode ser visualizado");
            }
        }

        System.out.println("\nCenário 5: referência pela interface");
        Baixavel baixavel = new VideoDigital("Trailer", "Estúdio X", 2);
        baixavel.baixar();
        VIsualizavel visualizavel = (VIsualizavel) baixavel;
        visualizavel.visualizar();

        System.out.println("\nCenário 6: setters");
        videoAutenthicGames.setTitulo("Video Authentic Games - Remasterizado");
        videoAutenthicGames.setDuracaoMinutos(25);
        System.out.println(videoAutenthicGames.descricao());

        livroAuthenticGames.setGenero("Ficção");
        livroAuthenticGames.setQuantidadePaginas(150);
        livroAuthenticGames.setTamanhoArquivo(8);
        livroAuthenticGames.setAutor("Marco Túlio");
        System.out.println(livroAuthenticGames.descricao());

        System.out.println("\nCenário 7: valores inválidos");
        VideoDigital videoInvalido = new VideoDigital("", null, -5);
        System.out.println(videoInvalido.descricao());
        Ebook ebookInvalido = new Ebook(null, "", null, 0, -10);
        System.out.println(ebookInvalido.descricao());
        ebookInvalido.baixar();
    }
}
