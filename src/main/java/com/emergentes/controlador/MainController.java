package com.emergentes.controlador;

import com.emergentes.modelo.Registro;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author MILTON
 */
@WebServlet(name = "MainController", urlPatterns = {"/MainController"})
public class MainController extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession ses = request.getSession();
        
        if (ses.getAttribute("listareg") == null) {
            ArrayList<Registro> listaux = new ArrayList<Registro>();
            ses.setAttribute("listareg", listaux);
        }
        ArrayList<Registro> lista = (ArrayList<Registro>) ses.getAttribute("listareg");
        
        String op = request.getParameter("op");
        String opcion = (op != null ? op : "view");
        
        Registro obj1 = new Registro();
        int id, pos;
        
        switch (opcion) {
            case "nuevo":
                request.setAttribute("miRegistro", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                
            case "editar":
                id = Integer.parseInt(request.getParameter("id"));
                pos = buscarIndice(request, id);
                obj1 = lista.get(pos);
                request.setAttribute("miRegistro", obj1);
                request.getRequestDispatcher("editar.jsp").forward(request, response);
                break;
                
            case "eliminar":
                pos = buscarIndice(request, Integer.parseInt(request.getParameter("id")));
                lista.remove(pos);
                ses.setAttribute("listavac", lista);
                response.sendRedirect("index.jsp");
                break;
                
            case "view":
                response.sendRedirect("index.jsp");
                break;
        }
        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession ses = request.getSession();
        ArrayList<Registro> lista = (ArrayList<Registro>) ses.getAttribute("listareg");
  
        Registro obj1 = new Registro();

        obj1.setId(Integer.parseInt(request.getParameter("id")));
        obj1.setDescripcion(request.getParameter("descripcion"));
        obj1.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
        obj1.setPrecio(Integer.parseInt(request.getParameter("precio")));
        obj1.setCategoria(request.getParameter("categoria"));
        
        int idt  = obj1.getId();
        
        if (idt == 0){
            int ultID;
            ultID = ultimoId(request);
            obj1.setId(ultID);
            lista.add(obj1);
        }
        else{
            lista.set(buscarIndice(request, idt), obj1);
        }
        ses.setAttribute("listareg", lista);
        response.sendRedirect("index.jsp");
    }
    
    private int buscarIndice(HttpServletRequest request, int id){
         HttpSession ses = request.getSession();
        ArrayList<Registro> lista = (ArrayList<Registro>) ses.getAttribute("listareg");
        
        int i = 0;
        
        if(lista.size() > 0){
            while(i < lista.size()){
                if(lista.get(i).getId() == id){
                    break;
                }
                else{
                    i++;
                }
            }
        }
        return i;
    }
    
    private int ultimoId(HttpServletRequest request){
         HttpSession ses = request.getSession();
        ArrayList<Registro> lista = (ArrayList<Registro>) ses.getAttribute("listareg");
        
        int idaux = 0;
        for(Registro item: lista){
            idaux = item.getId();
        }
        return idaux + 1;
    }

}
