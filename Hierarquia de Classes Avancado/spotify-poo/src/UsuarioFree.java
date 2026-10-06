public class UsuarioFree extends Usuario {
    public static final int LIMITE_PULOS = 6;

    public UsuarioFree(String nome, String email) {
        super(nome, email);
    }

    @Override public String getPlano() { return "Free"; }
    @Override public int getLimitePulos() { return LIMITE_PULOS; }
    @Override public boolean temAnuncios() { return true; }
    @Override public boolean podeBaixar() { return false; }
}
