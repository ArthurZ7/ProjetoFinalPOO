import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private String nomeEstoque;
    private static List <Item> itens = new ArrayList<>();



        public Estoque(){
        }
    
        public Estoque(String nomeEstoque){
            this.nomeEstoque = nomeEstoque;
            itens = new ArrayList<>();
            setarProdutos();
        }

        
        public static void setarProdutos(){
            Item item = new Item(1, "Televisão", "Eletrônico", "2.500,00", 2);
            itens.add(item);
            item = new Item(2, "Refri lata", "Alimento", "3,95", 45);
            itens.add(item);
            item = new Item(3, "Salgado", "Alimento", "7,00", 15);
            itens.add(item);
            item = new Item(4, "Celular", "Eletrônico", "2.000,00", 5);
            itens.add(item);
            item = new Item(5, "Geladeira", "Eletrodoméstico", "4.500,00", 3);
            itens.add(item);
            item = new Item(6, "Carregador", "Eletrônico", "15,00", 10);
            itens.add(item);
            item = new Item(7, "Notebook", "Eletrônico", "2.500,00", 0);
            itens.add(item);
            item = new Item(8, "Mouse", "Eletrônico", "55,90", 5);
            itens.add(item);
        }
        
        
        public static void listarProdutos(){
            System.out.println("\nLISTA DE PRODUTOS:");
            System.out.println("  Código     nome            classificação      preço        Quantidade");
            
            for (Item buscaItem : itens) {
                System.out.printf("  %-10d %-15s %-18s R$ %-10s %-10d\n",
                buscaItem.getCodigoItem(), 
                buscaItem.getNomeItem(),
                buscaItem.getClassificacao(),
                buscaItem.getPreco(),
                buscaItem.getQuantidade());
            }
        }
        
        
        public static void novoProduto(int codigo, String nome, String clas, String preco, int quantidade){
            Item novoItem = new Item(codigo, nome, clas, preco, quantidade);
            itens.add(novoItem);
        }
        
        public static void reporProduto(int codigo, int quantidade){
            for (Item index : itens){
                if (index.getCodigoItem() == codigo){
                    index.setQuantidade(index.getQuantidade()+quantidade);
                }
            }
        }
        
        public static void retirarProduto(int codigo, int quantidade){
            for (Item index : itens){
                if(index.getCodigoItem() == codigo){
                    index.setQuantidade(index.getQuantidade()-quantidade);
                }
            }
        }
        
        public static String itensPedidos(int codigo, int quantidade){
            for (Item index : itens){
                if(index.getCodigoItem() == codigo){
                    return  "------------- PEDIDO -------------\n"
                    + "Código: " + index.getCodigoItem() + "\n"
                    + "Nome: " + index.getNomeItem() + "\n"
                    + "Quantidade retirada: " + quantidade + "\n"
                    + "Estoque restante: " + index.getQuantidade() + "\n"
                    + "Preço unitário: R$ " + index.getPreco() + "\n"
                    + "---------------------------------\n";
                }
            }
            return "";
        }
        
        public static List<Item> getItens() {
            return itens;
        }
        
        public String getNomeEstoque() {
            return nomeEstoque;
        }
        
    }