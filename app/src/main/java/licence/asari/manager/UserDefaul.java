package licence.asari.manager;

public class UserDefaul {

    private String nick, puntos, jugados, victoria,derrota, pJugados,pContra,pDiferencia,pExtras;

    public UserDefaul(String nick, String puntos, String jugados, String victoria, String derrota, String pJugados, String pContra, String pDiferencia, String pExtras) {
        this.nick = nick;
        this.puntos = puntos;
        this.jugados = jugados;
        this.victoria = victoria;
        this.derrota = derrota;
        this.pJugados = pJugados;
        this.pContra = pContra;
        this.pDiferencia = pDiferencia;
        this.pExtras = pExtras;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPuntos() {
        return puntos;
    }

    public void setPuntos(String puntos) {
        this.puntos = puntos;
    }

    public String getJugados() {
        return jugados;
    }

    public void setJugados(String jugados) {
        this.jugados = jugados;
    }

    public String getVictoria() {
        return victoria;
    }

    public void setVictoria(String victoria) {
        this.victoria = victoria;
    }

    public String getDerrota() {
        return derrota;
    }

    public void setDerrota(String derrota) {
        this.derrota = derrota;
    }

    public String getpJugados() {
        return pJugados;
    }

    public void setpJugados(String pJugados) {
        this.pJugados = pJugados;
    }

    public String getpContra() {
        return pContra;
    }

    public void setpContra(String pContra) {
        this.pContra = pContra;
    }

    public String getpDiferencia() {
        return pDiferencia;
    }

    public void setpDiferencia(String pDiferencia) {
        this.pDiferencia = pDiferencia;
    }

    public String getpExtras() {
        return pExtras;
    }

    public void setpExtras(String pExtras) {
        this.pExtras = pExtras;
    }
}
