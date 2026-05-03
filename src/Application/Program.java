package Application;

import java.util.Locale;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import Entities.Products;

public class Program {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        Scanner sc = new Scanner(System.in);
        List<Products> products = new ArrayList<>();

        int menu;

        do {
            System.out.println("----Menu----");
            System.out.println("1-Cadastrar produto / estoque");
            System.out.println("2-Alterar preço do produto");
            System.out.println("3-Alterar estoque do produto");
            System.out.println("4-Exibir produtos");
            System.out.println("5-Sair");

            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    // Cadastrar produto / estoque
                    int quantity;
                    System.out.println("Quantos produtos deseja cadastrar? ");
                    quantity = sc.nextInt();

                    for (int i = 0; i < quantity; i++) {
                        System.out.println("Cadastrar Produto/estoque");
                        System.out.println("Id: ");
                        int id = sc.nextInt();
                        while (id <= 0) {
                            System.out.println("Id deve ser maior que 0");
                            System.out.println("Id: ");
                            id = sc.nextInt();
                        }
                        System.out.println("Nome: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.println("Preço: ");
                        double price = sc.nextDouble();
                        while (price < 0) {
                            System.out.println("Preço não pode ser negativo ");
                            System.out.println("Preço: ");
                            price = sc.nextDouble();
                        }
                        System.out.println("Estoque: ");
                        int stock = sc.nextInt();
                        while (stock < 0) {
                            System.out.println("O estoque não pode ser negativo ");
                            System.out.println("Estoque: ");
                            stock = sc.nextInt();
                        }
                        Products product = new Products(id, name, price, stock);
                        products.add(product);

                    }
                    System.out.println("Produtos cadastrados com sucesso!");
                    break;

                case 2:
                    // Alterar preço do produto
                    System.out.println("Informe o ID do produto que deseja alterar ");
                    int id = sc.nextInt();
                    Products product = findProductById(products, id);
                    if (product != null) {
                        System.out.println("Informe o novo preço do produto:");
                        double newPrice = sc.nextDouble();
                        while (newPrice < 0){
                            System.out.println("Preço não pode ser negativo ");
                            System.out.println("preço atual do produto: " + product.getPrice());
                            System.out.println("informe o valor novamente");
                            newPrice = sc.nextDouble();
                        }
                        product.changePrice(newPrice);
                        System.out.println("Preço do produto altera4do com sucesso!");
                        System.out.println("Preço atual: "  + product.getPrice());
                    } else {
                        System.out.println("Produto com ID " + id + " não encontrado.");
                    }
                    break;

                case 3:
                    // Alterar estoque do produto
                    System.out.println("Informe o ID do produto: ");
                    int idstock = sc.nextInt();
                    Products productsStock = findProductStockById(products, idstock);
                    if (productsStock != null) {
                        System.out.println("Digite um valor positivo para entrada ou negativo para saída: ");
                        int stockChange = sc.nextInt();

                        if (stockChange < 0) {
                            int removeQuantity = -stockChange;

                            if (removeQuantity > productsStock.getStock()) {
                                System.out.println("Não é possivel  deixar o estoque negativo");
                                System.out.println("quantidade atual de estoque do produto: " + productsStock.getStock());
                                System.out.println("Informe um valor até ficar positivo: ");
                                stockChange = sc.nextInt();
                            }

                            else {
                                productsStock.incrementStock(stockChange);
                                System.out.println("Estoque do produto alterado com sucesso!");
                                System.out.println("Estoque atual: " + productsStock.getStock());
                            }
                        }
                        else {
                                productsStock.incrementStock(stockChange);
                                System.out.println("Estoque do produto alterado com sucesso!");
                                System.out.println("Estoque atual: " + productsStock.getStock());               
                            }
                    }        
                    else {
                            System.out.println("Produto com ID " + idstock + " não encontrado.");
                        }
                       
                    break;
                case 4:
                    // Exibir produtos
                    for (Products prod : products) {
                        System.out.println("ID: " + prod.getId());
                        System.out.println("Nome: " + prod.getName());
                        System.out.println("Preço: " + prod.getPrice());
                        System.out.println("Estoque: " + prod.getStock());
                        System.out.println("------------------------------");
                    }
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;

                default:
                    System.out.println("Opção incorreta, tenta novamente.");
            }

        } while (menu != 5);

        sc.close();

    }

    public static Products findProductById(List<Products> products, int id) {
        for (Products product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    };

    public static Products findProductStockById(List<Products> productsStock, int idstock) {
        for (Products product : productsStock) {
            if (product.getId() == idstock) {
                return product;
            }
        }
        return null;

    };
}
