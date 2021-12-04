package worldbuilder.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import worldbuilder.entity.*;
import worldbuilder.persistance.GenericDao;

import java.io.IOException;

@WebServlet(
        name = "searchShops",
        urlPatterns = {"/searchShops"}
)
public class SearchShops extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Shop> shops = new GenericDao<>(Shop.class);
        GenericDao<Location> locations = new GenericDao<>(Location.class);
        GenericDao<Owner> owners = new GenericDao<>(Owner.class);

        if (req.getParameter("submit").equals("search")) {
            req.setAttribute("shops", shops.getByIdentifierLike(req.getParameter("shopSearchType"), req.getParameter("shopSearchTerm")));
        } else if (req.getParameter("submit").equals("location")) {
            Location newLocation = locations.getById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("shops", shops.getByIdentifierIntEqual("location", newLocation.getId()));
        }
        else if (req.getParameter("submit").equals("owner")) {
            Owner newOwner = owners.getById(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("shops", shops.getByIdentifierIntEqual("owner", newOwner.getId()));
        }else {
            req.setAttribute("shops", shops.getAll());
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
