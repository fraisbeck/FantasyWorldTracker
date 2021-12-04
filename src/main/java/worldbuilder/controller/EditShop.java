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
        name = "editShop",
        urlPatterns = {"/editShop"}
)
public class EditShop extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Shop> shopData = new GenericDao<>(Shop.class);
        GenericDao<Location> locationData = new GenericDao<>(Location.class);
        GenericDao<Owner> ownerData = new GenericDao<>(Owner.class);

        if (req.getParameter("id").equals("")) {
            Location newLocation = locationData.getById(Integer.parseInt(req.getParameter("location")));
            Owner newOwner = ownerData.getById(Integer.parseInt(req.getParameter("owner")));
            Shop shop = new Shop(req.getParameter("name"), req.getParameter("shopCategory"), newLocation, newOwner, newLocation.getWorld());
            shopData.insert(shop);
        } else {
            Location newLocation = locationData.getById(Integer.parseInt(req.getParameter("location")));
            Owner newOwner = ownerData.getById(Integer.parseInt(req.getParameter("owner")));
            Shop shop = new Shop(Integer.parseInt(req.getParameter("id")), req.getParameter("name"), req.getParameter("shopCategory"), newLocation, newOwner, newLocation.getWorld());
            shopData.saveOrUpdate(shop);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("searchShops?searchTerm=&submit=viewAll");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Shop> shopData = new GenericDao<>(Shop.class);
        req.setAttribute("shop", shopData.getById(Integer.parseInt(req.getParameter("id"))));
        listOfLocationsAndOwners(req, resp);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editShop.jsp");
        dispatcher.forward(req, resp);
    }

    public void listOfLocationsAndOwners(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Location> locationData = new GenericDao<>(Location.class);
        GenericDao<Owner> ownerData = new GenericDao<>(Owner.class);

        List<Location> locations = locationData.getAll();
        req.setAttribute("listLocations", locations);

        List<Owner> owners = ownerData.getAll();
        req.setAttribute("listOwners", owners);
    }
}
