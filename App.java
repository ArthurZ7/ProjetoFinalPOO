import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class App {
    static Scanner s = new Scanner(System.in);
    static List<Cliente> listaClientes = new ArrayList<>();
    static String userAdmin = "admin";
    static String passwordAdmin = "admin";

    public static void main(String[] args) {
        Cliente cli = new Cliente("aluno", "12345678910", 20, "Rua 1");
        listaClientes.add(cli);
        
        Estoque.setarProdutos();
        menu();
        
    }


    public static void menu(){
        System.out.println("\n------- MENU --------");
        System.out.println("| 1- Fazer pedido      |");
        System.out.println("| 2- Listar produtos   |");
        System.out.println("| 3- Cadastrar Usuário |");
        System.out.println("| 4- Administrador     |");
        System.out.println("| 5- SAIR              |");
        readMenu();
    }


    public static void readMenu(){
        try{
            System.out.print("\nPara começar digite uma opção: ");
            int opcao = s.nextInt();
            s.nextLine();

            switch (opcao) {
                case 1:
                    App.verificaLogin();
                    break;
                case 2:
                    Estoque.listarProdutos();
                    App.menu();
                    break;
                case 3:
                    App.cadastrar();
                    break;
                case 4:
                    App.login(userAdmin, passwordAdmin);
                    break;
                case 5:
                    System.out.println("\n\nEncerrando...\n\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("\nNão há opção para o número digitado. Tente novamente!");
                    App.menu();
                    break;
            }
        }catch( InputMismatchException e){
            s.nextLine();
            System.out.println("\nDigite uma entrada válida!");
            System.out.println("Deseja recomeçar? [sim ou nao]");
            while (true) {
                System.out.print("RESPOSTA: ");
                String resposta = s.nextLine().toLowerCase();
                if (resposta.equals("sim")) {
                    App.menu();
                    break;
                }else if (resposta.equals("nao")) {
                    System.out.println("\nEncerrando...\n");
                    System.exit(0);
                }
                else{
                    System.out.println("\nDesculte não entendi...");
                }
            }
        }
    }

    public static void verificaLogin() {
        System.out.print("\nDigite seu CPF (Apenas números): ");
        String cpf = s.nextLine();
        
        if (Validacao.regexCpf(cpf) == true){
            if (listaClientes.size() == 0){
                System.out.println("\nNão tem nenhum usuário cadastrado em nosso sistema!\n");
                verificaLogin();
            }

            for (Cliente busca : listaClientes){
                if (busca.getCpf().equals(cpf)){
                    comprar();
                }else{
                    System.out.println("Usuário não foi cadastrado!");
                    App.menu();
                }
            }

        }else{
            System.out.println("\nDigite um CPF válido.");
            verificaLogin();
        }
    }


    public static void comprar(){
        Estoque.listarProdutos();
        System.out.print("\nEscolha um produto pelo código: ");
        int codigo = s.nextInt();
        System.out.print("\nEscolha a quantidade que deseja: ");
        int quantidade = s.nextInt();

        List<Item> itens = Estoque.getItens();
        Validacao.verificaEstoque(codigo, quantidade, itens);
    }

    public static void cadastrar(){
        System.out.print("\nDigite seu nome: ");
        String nome = s.nextLine();
        System.out.print("\nDigite seu CPF (Apenas números): ");
        String cpf = s.nextLine();
        if (Validacao.regexCpf(cpf) == true){
            System.out.print("\nDigite sua idade: ");
            int idade = s.nextInt();
            s.nextLine();
            System.out.print("\nDigite seu endereço: ");
            String endereco = s.nextLine();

            Cliente novoCliente = new Cliente(nome, cpf, idade, endereco);
            listaClientes.add(novoCliente);
            System.out.println("\nCadastro realizado com sucesso !!!");
            App.menu();
        }else{
            System.out.println("\nDigite um CPF válido. Vamos começar de novo.");
            cadastrar();
        }
    }

    public static void login(String user, String senha){
        System.out.print("\nDigite o login: ");
        String login = s.nextLine();
        System.out.print("Agora a senha: ");
        String password = s.nextLine();

        if (login.equals(user)){
            if (password.equals(senha)){
                submenu();
            }else{
                System.out.println("\nUsuário ou senha não cadastrados");
                App.menu();
            }
        } else{
            System.out.println("\nUsuário ou senha não cadastrados");
            App.menu();
        }
    }

    public static void submenu(){
        System.out.println("\n------ SUBMENU ------");
        System.out.println("| 1- Novo Produto      |");
        System.out.println("| 2- Reposição Produto |");
        System.out.println("| 3- Voltar            |");

        try{
            System.out.print("\nDigite um número de opção: ");
            int index = s.nextInt();
            s.nextLine();
            switch (index) {
                case 1:
                    cadastroProduto();
                    break;
                case 2:
                    addProdutoEstoque();
                    break;
                case 3:
                    App.menu();
                    break;
                default:
                    System.out.println("Inválido");
                    submenu();
                    break;
            }
        }catch (InputMismatchException e){
            System.out.println("\nOBS: digite uma entrada válida !!!");
            submenu();
        }
    }

    public static void cadastroProduto(){

        System.out.print("\nDigite o código do produto: ");
        int cod = s.nextInt();
        if (Validacao.verificaProdutoEmEstoque(cod, Estoque.getItens())) {
            System.out.println("\nEsse produto já tem cadastrado no estoque! ");
            System.out.println("\nTente novamente !!!");
            cadastroProduto();
        }
        s.nextLine();
        System.out.print("\nDigite o nome do produto: ");
        String nome = s.nextLine();
        System.out.print("\nDigite a classificação do produto: ");
        String classificacao = s.nextLine();
        System.out.print("\nDigite o preço do produto: ");
        String preco = s.nextLine();
        System.out.print("\nDigite a quantidade do produto: ");
        int quantidade = s.nextInt();
        s.nextLine();

        Estoque.novoProduto(cod, nome, classificacao, preco, quantidade);
        

        App.menu();
    }

    public static void addProdutoEstoque(){
        System.out.print("\nPara repor o estoque informe o código do produto: ");
        int cdg = s.nextInt();
        System.out.print("\nInforme a quantidade:  ");
        int quantidade = s.nextInt();

        if (Validacao.verificaProdutoEmEstoque(cdg, Estoque.getItens())) {
            Estoque.reporProduto(cdg, quantidade);
            System.out.println("\nProduto acrescentado ao estoque.");
        }else{
            System.out.println("\nEsse produto não existe no estoque! ");
        }

        App.menu();
    }

}