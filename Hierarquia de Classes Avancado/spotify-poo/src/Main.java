import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    private static Catalogo catalogo;
    private static List<Usuario> usuarios = new ArrayList<>();
    private static Usuario usuarioAtual;
    private static Player player;

    public static void main(String[] args) {
        catalogo = Catalogo.criarExemplo();
        usuarios.add(new UsuarioFree("Ana", "ana@email.com"));
        usuarios.add(new UsuarioPremium("Bruno", "bruno@email.com", 21.90));

        System.out.println("=== SPOTIFY (versão POO) ===");
        escolherUsuario();

        int op;
        do {
            mostrarMenu();
            op = lerInt("Opção: ");
            System.out.println();
            switch (op) {
                case 1 -> listarCatalogo();
                case 2 -> buscar();
                case 3 -> tocarMidia();
                case 4 -> adicionarNaFila();
                case 5 -> player.proxima();
                case 6 -> player.anterior();
                case 7 -> player.mostrarFila();
                case 8 -> curtir();
                case 9 -> listar("Músicas curtidas", usuarioAtual.getCurtidas());
                case 10 -> criarPlaylist();
                case 11 -> adicionarNaPlaylist();
                case 12 -> verPlaylists();
                case 13 -> tocarPlaylist();
                case 14 -> seguirArtista();
                case 15 -> baixar();
                case 16 -> escolherUsuario();
                case 0 -> System.out.println("Até mais, " + usuarioAtual.getNome() + "!");
                default -> System.out.println("Opção inválida.");
            }
        } while (op != 0);
    }

    private static void mostrarMenu() {
        Midia atual = player.getAtual();
        System.out.println("\n----------------------------------------");
        System.out.println("Usuário: " + usuarioAtual);
        System.out.println("Tocando: " + (atual == null ? "nada" : atual.getDescricao()));
        System.out.println("----------------------------------------");
        System.out.println(" 1. Ver catálogo           9. Ver curtidas");
        System.out.println(" 2. Buscar                10. Criar playlist");
        System.out.println(" 3. Tocar mídia           11. Adicionar à playlist");
        System.out.println(" 4. Adicionar à fila      12. Ver minhas playlists");
        System.out.println(" 5. Próxima               13. Tocar playlist");
        System.out.println(" 6. Anterior              14. Seguir/deixar de seguir artista");
        System.out.println(" 7. Ver fila              15. Baixar mídia (Premium)");
        System.out.println(" 8. Curtir/descurtir      16. Trocar de usuário");
        System.out.println(" 0. Sair");
    }

    private static void escolherUsuario() {
        System.out.println("\nEscolha o usuário:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + usuarios.get(i));
        }
        int i = lerIndice("Usuário: ", usuarios.size());
        usuarioAtual = usuarios.get(i);
        player = new Player(usuarioAtual);
        System.out.println("Logado como " + usuarioAtual.getNome() + " (" + usuarioAtual.getPlano() + ")");
    }

    private static void listarCatalogo() {
        System.out.println("Artistas:");
        for (Artista a : catalogo.getArtistas()) {
            System.out.println("  " + a);
            for (Album al : a.getAlbuns()) {
                System.out.println("    Álbum: " + al.getTitulo() + " (" + al.getAno() + ")");
            }
        }
        listar("Todas as mídias", catalogo.getTodasMidias());
    }

    private static void buscar() {
        System.out.print("Buscar por (título, artista, gênero ou podcast): ");
        String termo = sc.nextLine();
        List<Midia> r = catalogo.buscar(termo);
        if (r.isEmpty()) System.out.println("Nenhum resultado para \"" + termo + "\".");
        else listar("Resultados", r);
    }

    private static void tocarMidia() {
        Midia m = escolherMidia();
        if (m != null) player.tocar(m);
    }

    private static void adicionarNaFila() {
        Midia m = escolherMidia();
        if (m != null) player.adicionarNaFila(m);
    }

    private static void curtir() {
        Midia m = escolherMidia();
        if (m == null) return;
        boolean curtiu = usuarioAtual.curtir(m);
        System.out.println((curtiu ? "Curtiu: " : "Descurtiu: ") + m.getDescricao());
    }

    private static void criarPlaylist() {
        System.out.print("Nome da playlist: ");
        String nome = sc.nextLine();
        System.out.print("Pública? (s/n): ");
        boolean publica = sc.nextLine().trim().equalsIgnoreCase("s");
        Playlist p = usuarioAtual.criarPlaylist(nome, publica);
        System.out.println("Playlist criada: " + p);
    }

    private static void adicionarNaPlaylist() {
        Playlist p = escolherPlaylist();
        if (p == null) return;
        Midia m = escolherMidia();
        if (m == null) return;
        if (p.adicionar(m)) System.out.println("Adicionado em " + p.getNome() + ".");
        else System.out.println("Essa mídia já está na playlist.");
    }

    private static void verPlaylists() {
        if (usuarioAtual.getPlaylists().isEmpty()) {
            System.out.println("Você ainda não tem playlists.");
            return;
        }
        for (Playlist p : usuarioAtual.getPlaylists()) {
            p.listar();
            System.out.println();
        }
    }

    private static void tocarPlaylist() {
        Playlist p = escolherPlaylist();
        if (p != null) player.tocar(p.getItens());
    }

    private static void seguirArtista() {
        List<Artista> artistas = catalogo.getArtistas();
        for (int i = 0; i < artistas.size(); i++) {
            String marca = usuarioAtual.getArtistasSeguidos().contains(artistas.get(i)) ? " ✓ seguindo" : "";
            System.out.println("  " + (i + 1) + ". " + artistas.get(i) + marca);
        }
        Artista a = artistas.get(lerIndice("Artista: ", artistas.size()));
        boolean seguiu = usuarioAtual.seguir(a);
        System.out.println((seguiu ? "Agora você segue " : "Você deixou de seguir ") + a.getNome());
    }

    private static void baixar() {
        if (!usuarioAtual.podeBaixar()) {
            System.out.println("Downloads são exclusivos do plano Premium.");
            return;
        }
        UsuarioPremium premium = (UsuarioPremium) usuarioAtual;
        Midia m = escolherMidia();
        if (m == null) return;
        if (premium.baixar(m)) System.out.println("Baixado: " + m.getDescricao());
        else System.out.println("Essa mídia já foi baixada.");
        listar("Seus downloads", premium.getDownloads());
    }

    private static Midia escolherMidia() {
        List<Midia> todas = catalogo.getTodasMidias();
        listar("Escolha a mídia", todas);
        return todas.get(lerIndice("Número: ", todas.size()));
    }

    private static Playlist escolherPlaylist() {
        List<Playlist> ps = usuarioAtual.getPlaylists();
        if (ps.isEmpty()) {
            System.out.println("Crie uma playlist primeiro (opção 10).");
            return null;
        }
        for (int i = 0; i < ps.size(); i++) System.out.println("  " + (i + 1) + ". " + ps.get(i));
        return ps.get(lerIndice("Playlist: ", ps.size()));
    }

    private static void listar(String titulo, List<? extends Midia> midias) {
        System.out.println(titulo + ":");
        if (midias.isEmpty()) System.out.println("  (nada)");
        for (int i = 0; i < midias.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + midias.get(i));
        }
    }

    private static int lerInt(String msg) {
        while (true) {
            System.out.print(msg);
            String linha = sc.nextLine().trim();
            try {
                return Integer.parseInt(linha);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número.");
            }
        }
    }

    private static int lerIndice(String msg, int max) {
        while (true) {
            int n = lerInt(msg);
            if (n >= 1 && n <= max) return n - 1;
            System.out.println("Escolha entre 1 e " + max + ".");
        }
    }
}
