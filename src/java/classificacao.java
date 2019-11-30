/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import BD.StatementsSQL;
import HC.Classificacao;
import HC.Historico_jogos;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JOÃO VICTOR
 */
@WebServlet(urlPatterns = {"/classificacao"})
public class classificacao extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        StatementsSQL st = new StatementsSQL();
        ArrayList <Classificacao> clas = null;
        try {
            clas = st.selectClassificacao();
        } catch (SQLException ex) {
            Logger.getLogger(historico.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(historico.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet classificao</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Classificação</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<td> Posição</td>");
            out.println("<td> Nome</td>");
            out.println("<td> Pontos</td>");
            out.println("<td> Vitórias</td>");
            out.println("<td> Empates</td>");
            out.println("<td> Derrotas</td>");
            out.println("<td> Saldo de damas</td>");
            out.println("</tr>");
            int i=1;
            for(Classificacao c: clas){
                out.println("<tr>");
                out.println("<td>"+i+"</td>");
                out.println("<td>"+c.getNome()+"</td>");
                out.println("<td>"+c.getPontos()+"</td>");
                out.println("<td>"+c.getVit()+"</td>");
                out.println("<td>"+c.getEmp()+"</td>");
                out.println("<td>"+c.getDerr()+"</td>");
                out.println("<td>"+c.getSaldo()+"</td>");
                out.println("</tr>");
                i++;
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
