/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "login", urlPatterns = {"/faces/loginServlet"})
public class LoginServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String usuario = request.getParameter("username");
        String password = request.getParameter("password");

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.setAttribute("name", usuario);
        }
        
        String perfil = LoginDao.validate(usuario, password);
        if (perfil != null) {
            session.setAttribute("perfil", perfil);
            RequestDispatcher rd = request.getRequestDispatcher("home.xhtml");
            rd.forward(request, response);
        } else {
            out.print("User invalido");
        }
        out.close();
    }
}
