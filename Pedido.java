public class Pedido {
    private int numeroPedido;
    Cliente c;
    static Estoque e;
        
        public Pedido(int numeroPedido, Cliente c, Estoque e) {
            this.numeroPedido = numeroPedido;
            this.c = c;
            this.e = e;
        }
    
        public Pedido() {
        }

    
        public static String verificaPedido(int codigo, int quantidade){
            e.retirarProduto(codigo, quantidade);
        return "Pedido Feito com Sucesso!\n\n"+e.itensPedidos(codigo,quantidade);
    }
}