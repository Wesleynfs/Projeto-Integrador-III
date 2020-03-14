package Model;

public class Endereco {

    private int id_endereco;
    private String telefone;
    private String cep;
    private String rua;
    private String bairro;
    private String cidade;

    public int getId_endereco() {
        return id_endereco;
    }

    public void setId_endereco(int id_endereco) {
        this.id_endereco = id_endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Endereco(int id_endereco, String telefone, String cep, String rua, String bairro, String cidade) {
        this.id_endereco = id_endereco;
        this.telefone = telefone;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
    }

    public Endereco() {

    }

    @Override
    public String toString() {
        return "Endereco{" +
                ", telefone ='" + telefone + '\'' +
                ", cep ='" + cep + '\'' +
                ", rua ='" + rua + '\'' +
                ", bairro ='" + bairro + '\'' +
                ", cidade ='" + cidade + '\'' +
                '}';
    }

}
