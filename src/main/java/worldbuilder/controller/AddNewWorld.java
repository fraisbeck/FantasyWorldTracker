package worldbuilder.controller;

import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(
        name = "addNewWorld",
        urlPatterns = {"/addNewWorld"}
)
public class AddNewWorld extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userData = new GenericDao<>(User.class);
        List<User> users = userData.getAll();
        req.setAttribute("listUsers", users);

        RequestDispatcher dispatcher = req.getRequestDispatcher("editWorld.jsp");
        dispatcher.forward(req,resp);
    }
}
