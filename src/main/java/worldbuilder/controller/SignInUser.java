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
        name = "signInForm",
        urlPatterns = {"/signInForm"}
)
public class SignInUser extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        GenericDao<User> userData = new GenericDao<>(User.class);

        User userLogin = (User) userData.getSingleByIdentifierEqual("userName", req.getParameter("userName"));

        if (userLogin == null) {
            String errorMessage = "That Username is incorrect.";
            req.setAttribute("errorMessage", errorMessage);
            RequestDispatcher dispatcher = req.getRequestDispatcher("/Signin.jsp");
            dispatcher.forward(req, resp);
        } else {
            if (!userLogin.getPassword().equals(req.getParameter("password"))) {
                String errorMessage = "Incorrect password.";
                req.setAttribute("errorMessage", errorMessage);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/Signin.jsp");
                dispatcher.forward(req, resp);
            } else {
                System.out.println(userLogin.getId());
                session.setAttribute("user", userLogin);
                RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
                dispatcher.forward(req, resp);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/Signin.jsp");
        dispatcher.forward(req, resp);
    }
}
