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
        name = "editLocation",
        urlPatterns = {"/editLocation"}
)
public class EditLocation extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Location> locationData = new GenericDao<>(Location.class);
        GenericDao<Region> regionData = new GenericDao<>(Region.class);

        if (req.getParameter("id").equals("")) {
            Region newRegion = regionData.getById(Integer.parseInt(req.getParameter("region")));
            Location location = new Location(req.getParameter("name"), newRegion, newRegion.getWorld());
            locationData.insert(location);
        } else {
            Region newRegion = regionData.getById(Integer.parseInt(req.getParameter("region")));
            Location location = new Location(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), newRegion, newRegion.getWorld());
            locationData.saveOrUpdate(location);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("searchLocations?searchTerm=&submit=viewAll");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Location> locationData = new GenericDao<>(Location.class);
        req.setAttribute("location", locationData.getById(Integer.parseInt(req.getParameter("id"))));
        listOfRegions(req, resp);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editLocation.jsp");
        dispatcher.forward(req, resp);
    }

    public void listOfRegions(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Region> regionData = new GenericDao<>(Region.class);
        List<Region> regions = regionData.getAll();
        req.setAttribute("listRegions", regions);
    }
}
