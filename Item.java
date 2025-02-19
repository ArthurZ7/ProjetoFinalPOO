public class Item {
    
    private int codigoItem;
    private String nomeItem;
    private String classificacao;
    private String preco;
    private int quantidade;

    public Item(int codigoItem, String nomeItem, String classificacao, String preco, int quantidade) {
        this.codigoItem = codigoItem;
        this.nomeItem = nomeItem;
        this.classificacao = classificacao;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public Item(int codigoItem, String nomeItem, String classificacao, String preco) {
        this.codigoItem = codigoItem;
        this.nomeItem = nomeItem;
        this.classificacao = classificacao;
        this.preco = preco;
    }


    public int getCodigoItem() {
        return codigoItem;
    }

    public void setCodigoItem(int codigoItem) {
        this.codigoItem = codigoItem;
    }

    public String getNomeItem() {
        return nomeItem;
    }

    public void setNomeItem(String nomeItem) {
        this.nomeItem = nomeItem;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }



}