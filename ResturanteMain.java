package Resturante;

public class Ordine {
    private String nome;
    private int quantita;
    private double prezzo;

    public Ordine(String nome, int quantita, double prezzo) {
        this.nome = nome;
        this.quantita = quantita;
        this.prezzo = prezzo;
    }

    public String getNome() { return nome; }
    public int getQuantita() { return quantita; }
    public double getPrezzo() { return prezzo; }

    public double getTotale() {
        return prezzo * quantita;
    }
}