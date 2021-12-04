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
        name = "editContinent",
        urlPatterns = {"/editContinent"}
)
public class EditContinent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Continent> continentData = new GenericDao<>(Continent.class);
        GenericDao<World> worldData = new GenericDao<>(World.class);

        if (req.getParameter("id").equals("")) {
            World newWorld = worldData.getById(Integer.parseInt(req.getParameter("world")));
            Continent continent = new Continent(req.getParameter("name"), newWorld);
            continentData.insert(continent);
        } else {
            World newWorld = worldData.getById(Integer.parseInt(req.getParameter("world")));
            Continent continent = new Continent(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), newWorld);
            continentData.saveOrUpdate(continent);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchContinents?continentSearchTerm=&submit=viewAll");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Continent> continentData = new GenericDao<>(Continent.class);
        req.setAttribute("continent", continentData.getById(Integer.parseInt(req.getParameter("id"))));
        listOfWorlds(req, resp);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editContinent.jsp");
        dispatcher.forward(req, resp);
    }

    public void listOfWorlds(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<World> worldData = new GenericDao<>(World.class);
        List<World> worlds = worldData.getAll();
        req.setAttribute("listWorlds", worlds);
    }
}
