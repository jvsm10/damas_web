/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import HC.Classificacao;
import HC.Historico_jogos;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOÃO VICTOR
 */
public class StatementsSQL {
    
    ConexaoBD db;
    Statement stmt;

    public StatementsSQL() {
        db = new ConexaoBD("localhost", 3306, "root", "");
        try {
            db.connect("java");
        } catch (SQLException ex) {
            Logger.getLogger(StatementsSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(StatementsSQL.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(StatementsSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            stmt = db.get();
        } catch (SQLException ex) {
            Logger.getLogger(StatementsSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Historico_jogos> selectHistorico() throws SQLException, InstantiationException{
		String sql;
                sql = "SELECT * FROM `historico`";
                //Executa a instrução
		ResultSet res = stmt.executeQuery(sql);
                ArrayList <Historico_jogos> hist = new ArrayList();
                String data,jog1,jog2,venc;
                while(res.next()){
                    data = res.getString("data/hora");
                    jog1 = res.getString("Jogador_1");
                    jog2 = res.getString("Jogador_2");
                    venc = res.getString("Vencedor");
                    Historico_jogos h1 = new Historico_jogos(data,jog1,jog2,venc);
                    hist.add(h1);
                }
                return hist;
    }
    
    public ArrayList <Classificacao> selectClassificacao() throws SQLException, InstantiationException{
	String sql;
        sql = "SELECT * FROM classificacao ORDER BY pontos desc,vitorias desc,saldo_damas desc,empates desc,derrotas desc";

	// Executa-se a consulta dos campos titulo,ano da tabela de filmes
	ResultSet res = stmt.executeQuery(sql);
        ArrayList <Classificacao> clas = new ArrayList(); 
        while(res.next()){
            String jog = res.getString("nome");
            int  pontos = res.getInt("pontos");
            int vito = res.getInt("vitorias");
            int emp = res.getInt("empates");
            int der = res.getInt("derrotas");
            int saldod = res.getInt("saldo_damas");
            Classificacao c = new Classificacao(jog,vito,der,emp,saldod,pontos);
            clas.add(c);
        }
        return clas;
    }
    
    public void closeConex(){
        try {
            db.close();
        } catch (SQLException ex) {
            Logger.getLogger(StatementsSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
