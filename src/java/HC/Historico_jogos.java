/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HC;

/**
 *
 * @author JOÃO VICTOR
 */
public class Historico_jogos {
    String data;
    String jog1;
    String jog2;
    String venc;

    public Historico_jogos(String data, String jog1, String jog2, String venc) {
        this.data = data;
        this.jog1 = jog1;
        this.jog2 = jog2;
        this.venc = venc;
    }

    public String getData() {
        return data;
    }

    public String getJog1() {
        return jog1;
    }

    public String getJog2() {
        return jog2;
    }

    public String getVenc() {
        return venc;
    }
    
    
}
