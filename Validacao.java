import java.util.List;

public class Validacao {

    public static boolean regexCpf (String cpf){
        String regex = "[0-9]{11}";
        if (cpf.matches(regex)){
            return true;
        }
        return false;
    }
    

    public static void verificaEstoque (int codigo, int quantidade, List<Item> lista) {
        boolean encontrado = false;

        for (Item buscaItem : lista) {
            if (buscaItem.getCodigoItem() == codigo) {
                encontrado = true;

                if (buscaItem.getQuantidade() >= quantidade) {
                    System.out.println(Pedido.verificaPedido(codigo, quantidade));
                    App.menu();
                    return;
                } else if (buscaItem.getQuantidade() == 0) {
                    System.out.println("\nEsse produto está em falta em nosso estoque.");
                    App.menu();
                    return;
                } else {
                    System.out.println("\nQuantidade insuficiente no estoque.");
                    App.menu();
                    return;
                }
            }
        }

        if (!encontrado) {
            System.out.println("\nDesculpe, esse produto não existe em nosso estoque.");
            App.menu();
        }
    }

    public static boolean verificaProdutoEmEstoque (int n, List<Item> lista){
        
        for (Item index : lista){
            if (index.getCodigoItem() == n){
                return true;
            }
        }
        return false;
    }
}