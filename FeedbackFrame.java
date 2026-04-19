package Resturante;

public class ClasseTavolo {
    private String numeroTavolo;
    private boolean occupato;
    private String tipoMenu;
    private int persone;

    public ClasseTavolo(String numeroTavolo) {
        this.numeroTavolo = numeroTavolo;
        this.occupato = false;
    }

    public String getNumeroTavolo() {
        return numeroTavolo;
    }

    public boolean isOccupato() {
        return occupato;
    }

    public void setOccupato(boolean occupato) {
        this.occupato = occupato;
    }

    public String getTipoMenu() {
        return tipoMenu;
    }

    public void setTipoMenu(String tipoMenu) {
        this.tipoMenu = tipoMenu;
    }

    public int getPersone() {
        return persone;
    }

    public void setPersone(int persone) {
        this.persone = persone;
    }
}