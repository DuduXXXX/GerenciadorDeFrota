package services;
import java.util.ArrayList;
import java.util.List;

import entities.Veiculo;

public class Utilidades {
    private final List<Veiculo> lista;

    public Utilidades() {
        lista = new ArrayList<>();
    }

    public List<Veiculo> getList() {
        return lista;
    }

    // ADICIONAR VEÍCULO
    public void adicionarVeiculo(Veiculo veiculo) throws Exception {
        if (veiculo == null) {
            throw new IllegalArgumentException("O veículo não pode ser nulo.");
        }
        if (veiculo.getTipo() == null || veiculo.getTipo().isEmpty()) {
            throw new Exception("O tipo do veículo não pode ser nulo.");
        }
        if (veiculo.getMarca() == null || veiculo.getMarca().isEmpty()) {
            throw new Exception("A marca do veículo não pode ser nula.");
        }
        if (veiculo.getModelo() == null || veiculo.getModelo().isEmpty()) {
            throw new Exception("O modelo do veículo não pode ser nulo.");
        }
        if (veiculo.getNumeroPortas() == -1) {
            throw new Exception("O número de portas não pode ser nulo.");
        }
        if (veiculo.getAno() < 1885) {
            throw new Exception("O ano deve ser maior que 0.");
        }
        if (veiculo.getPlaca() == null || veiculo.getPlaca().isEmpty()) {
            throw new Exception("A placa é obrigatória.");
        }
        for (Veiculo v : lista) {
            if (v.getPlaca().equalsIgnoreCase(veiculo.getPlaca())) {
                throw new Exception("Já existe um veículo com essa placa cadastrado.");
            }
        }
        lista.add(veiculo);
    }

    // REMOVER VEÍCULO
    public void removerVeiculo(Veiculo veiculo) {
        lista.remove(veiculo);
    }

    // LISTAR OS VEÍCULOS
    public void listaVeiculo() {
        if (lista.isEmpty()) {
            System.out.println("Não há veículos para serem listados.");
            return;
        }
        System.out.println("=== Veículos na Lista ===");
        for (Veiculo veiculo : lista) {
            System.out.println(veiculo);
        }
    }

    // BUSCAR VEÍCULO
    public Veiculo buscarVeiculo(String placa) {
        for (Veiculo veiculo : lista) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa)) {
                return veiculo;
            }
        }
        return null;
    }
}
