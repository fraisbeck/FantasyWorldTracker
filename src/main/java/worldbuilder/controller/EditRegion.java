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
        name = "editRegion",
        urlPatterns = {"/editRegion"}
)
public class EditRegion extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Region> regionData = new GenericDao<>(Region.class);
        GenericDao<Continent> continentData = new GenericDao<>(Continent.class);

        if (req.getParameter("id").equals("")) {
            Continent newContinent = continentData.getById(Integer.parseInt(req.getParameter("continent")));
            Region region = new Region(req.getParameter("name"), newContinent, newContinent.getWorld());
            regionData.insert(region);
        } else {
            Continent newContinent = continentData.getById(Integer.parseInt(req.getParameter("continent")));
            Region region = new Region(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), newContinent, newContinent.getWorld());
            regionData.saveOrUpdate(region);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchRegions?searchTerm=&submit=viewAll");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Region> regionData = new GenericDao<>(Region.class);
        req.setAttribute("region", regionData.getById(Integer.parseInt(req.getParameter("id"))));
        listOfContinents(req, resp);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editRegion.jsp");
        dispatcher.forward(req, resp);
    }

    protected void listOfContinents(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Continent> continentData = new GenericDao<>(Continent.class);
        List<Continent> continents = continentData.getAll();
        req.setAttribute("listContinents", continents);
    }
}
