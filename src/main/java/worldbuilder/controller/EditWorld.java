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
        name = "editWorld",
        urlPatterns = {"/editWorld"}
)
public class EditWorld extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<World> worldData = new GenericDao<>(World.class);
        GenericDao<User> userData = new GenericDao<>(User.class);

        if (req.getParameter("id").equals("")) {
            User newUser = userData.getById(Integer.parseInt(req.getParameter("user")));
            World world = new World(req.getParameter("name"), newUser);
            worldData.insert(world);
        } else {
            User newUser = userData.getById(Integer.parseInt(req.getParameter("user")));
            World world = new World(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), newUser);
            worldData.saveOrUpdate(world);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchWorlds?searchTerm=&submit=viewAll");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<World> worldData = new GenericDao<>(World.class);
        req.setAttribute("world", worldData.getById(Integer.parseInt(req.getParameter("id"))));
        listOfUsers(req, resp);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editWorld.jsp");
        dispatcher.forward(req, resp);
    }

    public void listOfUsers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<User> userData = new GenericDao<>(User.class);
        List<User> users = userData.getAll();
        req.setAttribute("listUsers", users);
    }
}
