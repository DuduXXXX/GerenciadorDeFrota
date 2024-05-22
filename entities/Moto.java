package entities;
public class Moto extends Veiculo {
    private boolean partidaEletrica;

    public Moto(String tipo, String marca, String modelo, int ano, String placa, boolean partidaEletrica) {
        super(tipo, marca, modelo, ano, placa);
        this.partidaEletrica = partidaEletrica;
    }

    public boolean isPartidaEletrica() {
        return partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

    @Override
    public String toString() {
        return super.toString() +
               " - Partida Elétrica: " + (partidaEletrica ? "Sim" : "Não") + "\n";
    }
}