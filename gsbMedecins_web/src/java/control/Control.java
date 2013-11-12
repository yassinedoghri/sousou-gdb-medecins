/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.util.Collection;
import java.util.TreeSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Pays;
import model.Dep;
import model.Med;

/**
 *
 * @author ydoghri
 */
public class Control extends HttpServlet {

    private Pays gsb;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        gsb = new Pays(); // instancie les objets utiles
    }

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String page;
        String action = request.getParameter("action");

        if ("listeMedecinsDep".equals(action)) {
            String choixDep = request.getParameter("choixDep");
            if (choixDep == null || choixDep == "-1") {
                Collection<Dep> d = gsb.getLesDeps();
                request.setAttribute("listDeps", d);
                page = "selectDep.jsp";
            } else {
                Collection<Med> m = gsb.getLeDep(choixDep).getLesMeds();
                request.setAttribute("leDep", gsb.getLeDep(choixDep));
                request.setAttribute("listMeds", m);
                page = "listMedDep.jsp";
            }

        } else if ("listeMedecinsNom".equals(action)) {
            String nomMed = request.getParameter("nomMed");
            if (nomMed == null) {
                page = "searchMed.jsp";
            } else {
                Collection<Med> m = new TreeSet<Med>();
                for (Dep unDep : gsb.getLesDeps()) {
                    Collection medR = unDep.getLesMedsR(nomMed);
                    m.addAll(medR);
                }
                request.setAttribute("listMeds", m);
                request.setAttribute("nomR", nomMed);
                page = "listMedNom.jsp";
            }

        } else {
            page = "index.jsp";
        }
        //appel de la JSP

        request.getRequestDispatcher(page).forward(request, response); // appel de la page en lui envoyant la requête et la réponses
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
     * Handles the HTTP
     * <code>POST</code> method.
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
