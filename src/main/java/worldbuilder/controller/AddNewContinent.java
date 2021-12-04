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
        name = "addNewContinent",
        urlPatterns = {"/addNewContinent"}
)
public class AddNewContinent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<World> worldData = new GenericDao<>(World.class);
        List<World> worlds = worldData.getAll();
        req.setAttribute("listWorlds", worlds);

        RequestDispatcher dispatcher = req.getRequestDispatcher("editContinent.jsp");
        dispatcher.forward(req, resp);
    }
}
