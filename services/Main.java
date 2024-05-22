package services;
import java.util.Scanner;

import entities.Carro;
import entities.Moto;
import entities.Veiculo;

public class Main {
    private static final Utilidades utilidades = new Utilidades();
    private static final Scanner scanner = new Scanner(System.in);

    // MENU
    private static void exibirMenu() {
        System.out.println("\n====== Sistema de Gerenciamento de Frotas ====== \n MENU DE OPÇÕES");
        System.out.print("Escolha uma opção:\n");
        System.out.println("1 - Cadastrar um Veículo");
        System.out.println("2 - Listar Veículos");
        System.out.println("3 - Buscar Veículo pela placa");
        System.out.println("4 - Remover Veículo");
        System.out.println("0 - Sair\n");
    }

    // ADD VEÍCULO
    private static void adicionarVeiculo() {
        System.out.println("\n=== Adicionar Veículo ===");
        System.out.print("Digite o tipo do seu veículo (Carro/Moto): ");
        String tipo = scanner.nextLine();

        System.out.print("Digite a marca do veículo: ");
        String marca = scanner.nextLine();

        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();

        System.out.print("Digite o ano do veículo: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();

        try {
            if (tipo.equalsIgnoreCase("carro")) {
                System.out.print("Digite o número de portas: ");
                int numeroPortas = scanner.nextInt();
                scanner.nextLine();
                Carro novoCarro = new Carro(tipo, marca, modelo, ano, numeroPortas, placa);
                Veiculo veiculo = new Veiculo(novoCarro.getTipo(), novoCarro.getMarca(), novoCarro.getModelo(), novoCarro.getAno(), novoCarro.getPlaca());
utilidades.adicionarVeiculo(veiculo);
            } else if (tipo.equalsIgnoreCase("moto")) {
                System.out.print("A moto tem partida elétrica? (true/false): ");
                boolean partidaEletrica = scanner.nextBoolean();
                scanner.nextLine();
                Moto novaMoto = new Moto(tipo, marca, modelo, ano, placa, partidaEletrica);
                utilidades.adicionarVeiculo(novaMoto);
            } else {
                System.out.println("Tipo de veículo não suportado.");
                return;
            }
            System.out.println("Veículo adicionado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao adicionar veículo: " + e.getMessage());
        }
    }

    // REMOVER VEÍCULO
    private static void removerVeiculo() {
        System.out.println("\n=== Remover Veículo ===");
        System.out.print("Digite a placa do veículo que deseja remover: ");
        String placa = scanner.nextLine();

        try {
            Veiculo veiculoEncontrado = utilidades.buscarVeiculo(placa);
            if (veiculoEncontrado != null) {
                utilidades.removerVeiculo(veiculoEncontrado);
                System.out.println("Veículo removido com sucesso!");
            } else {
                throw new Exception("Veículo com placa " + placa + " não foi encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao remover veículo: " + e.getMessage());
        }
    }

    // BUSCAR VEÍCULO
    private static void buscarVeiculo() {
        System.out.println("\n=== Buscar Veículo ===");
        System.out.print("Digite a placa do veículo a ser buscado: ");
        String placa = scanner.nextLine();

        try {
            Veiculo veiculoEncontrado = utilidades.buscarVeiculo(placa);
            if (veiculoEncontrado != null) {
                System.out.println("Veículo encontrado: \n" + veiculoEncontrado);
            } else {
                throw new Exception("Veículo com placa " + placa + " não foi encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao buscar veículo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        while (true) {
            exibirMenu();
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarVeiculo();
                    break;
                case 2:
                    utilidades.listaVeiculo();
                    break;
                case 3:
                    buscarVeiculo();
                    break;
                case 4:
                    removerVeiculo();
                    break;
                case 0:
                    System.out.println("Encerrando o programa.");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }
}
