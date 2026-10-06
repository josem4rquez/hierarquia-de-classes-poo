import java.util.ArrayList;
import java.util.List;

public class UsuarioPremium extends Usuario {
    private double mensalidade;
    private List<Midia> downloads = new ArrayList<>();

    public UsuarioPremium(String nome, String email, double mensalidade) {
        super(nome, email);
        this.mensalidade = mensalidade;
    }

    @Override public String getPlano() { return "Premium"; }
    @Override public int getLimitePulos() { return -1; }
    @Override public boolean temAnuncios() { return false; }
    @Override public boolean podeBaixar() { return true; }

    public boolean baixar(Midia m) {
        if (downloads.contains(m)) return false;
        downloads.add(m);
        return true;
    }

    public List<Midia> getDownloads() { return downloads; }
    public double getMensalidade() { return mensalidade; }
}
