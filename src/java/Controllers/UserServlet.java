package Controllers;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Models.*;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;


@WebServlet({"/app","/new","/delete","/insert","/ajaxList","/update"})
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        switch (action) {
            case "/update": edituser(request, response);break;
            case "/ajaxList":
                ajaxListuser(request, response);
                break;
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertUser(request, response);
                break;
            case "/delete":
                deleteUser(request, response);
                break;
            default:
                listUser(request, response);
                break;
        }
    }
    private void edituser(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
            Users user =Users.getUsersInstance();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String OLDemail = request.getParameter("OLDname");
        String NEWemail = request.getParameter("NEWemail");
boolean success=user.editUser(OLDemail,NEWemail,name);
        response.sendRedirect("app");

        }

private void ajaxListuser(HttpServletRequest request, HttpServletResponse response)
        throws IOException, ServletException {
    Users user =Users.getUsersInstance();
    List<Persone> userList= user.getAllUsers();
    request.setAttribute("listUser",userList);
    String reponse="";
    for(Persone u: userList) {
        reponse += "<tr>";
        reponse += "<td>" + u.getID() + "</td>";
        reponse += "<td>" + u.getName() + "</td>";
        reponse += "<td>" + u.getEmail() + "</td>";

        reponse += "<td id=" + u.getID() + ">";
        reponse += " <a href='#' class='text-primary editbtn' id=" +u.getID() + "><i class='fa fa-edit fa-lg' aria-hidden='true'>&nbsp;edit</i></a>&nbsp;&nbsp;";
        reponse += " <a href='#' class='text-danger deleteUser' id='" + u.getEmail() + "' ><i class='fa fa-trash fa-lg' aria-hidden='true'>&nbsp;delete</i></a> </td>";
        reponse += "</td>";
        reponse += "</tr>";

    }


//
//    for(Persone u: userList) {
//
//        JsonObject jsonUser = Json.createObjectBuilder().add("email", u.getEmail()).add("name", u.getName()).build();
//         jsonArray = new Json.();
//
//    }







    response.setContentType("text/html;charset=UTF-8");
    response.getWriter().write(reponse);
}
    private void listUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        Users user =Users.getUsersInstance();
        List<Persone> userList= user.getAllUsers();
        request.setAttribute("listUser",userList);

        response.getWriter().write("ajax");

        request.getRequestDispatcher("/view/userList.jsp")
              .forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/view/newUser.html")
                .forward(request, response);
    }

    private void insertUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        Users user =Users.getUsersInstance();
        user.AddUser(name,email);
     //   User.addUser(newUser);
        response.sendRedirect("app");
    }

    private void deleteUser(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        String  email = String.valueOf(request.getParameter("REF"));
        Users user =Users.getUsersInstance();
       boolean success= user.Remove(email);
        response.setContentType("text;charset=UTF-8");
        response.getWriter().write(String.valueOf(success));
    }
}