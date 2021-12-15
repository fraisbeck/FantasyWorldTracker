package worldbuilder.controller;

import worldbuilder.entity.User;
import worldbuilder.persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(
        name = "userForm",
        urlPatterns = {"/userForm"}
)
public class SignUpUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userData = new GenericDao<>(User.class);

        if (req.getParameter("id").equals("")) {
            User currentUser = userData.getSingleByIdentifierEqual("userName", req.getParameter("userName"));
           if(currentUser == null) {
               User user = new User(req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("userName"), req.getParameter("password"));
               userData.insert(user);
           } else {
               String errorMessage = "That Username is already in use. Please try another.";
               req.setAttribute("errorMessage", errorMessage);
               RequestDispatcher dispatcher = req.getRequestDispatcher("/Signup.jsp");
               dispatcher.forward(req, resp);
           }
        } else {
            User user = new User(Integer.parseInt(req.getParameter("id")), req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("userName"), req.getParameter("password"));
            userData.saveOrUpdate(user);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Signup.jsp");
        dispatcher.forward(req, resp);
    }
}
