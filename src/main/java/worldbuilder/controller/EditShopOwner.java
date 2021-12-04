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

@WebServlet (
        name = "editShopOwner",
        urlPatterns = {"/editShopOwner"}
)
public class EditShopOwner extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        GenericDao<Owner> ownerData = new GenericDao<>(Owner.class);
        GenericDao<World> worldData = new GenericDao<>(World.class);

        if (req.getParameter("id").equals("")) {
            World newWorld = worldData.getById(Integer.parseInt(req.getParameter("world")));
            Owner owner = new Owner(req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("profession"), newWorld);
            ownerData.insert(owner);
        } else {
            World newWorld = worldData.getById(Integer.parseInt(req.getParameter("world")));
            Owner owner = new Owner(Integer.parseInt(req.getParameter("id")), req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("profession"), newWorld);
            ownerData.saveOrUpdate(owner);
        }
        RequestDispatcher dispatcher = req.getRequestDispatcher("searchOwners?searchTerm=&submit=viewAll");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Owner> ownerData = new GenericDao<>(Owner.class);
        req.setAttribute("owner", ownerData.getById(Integer.parseInt(req.getParameter("id"))));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/editOwner.jsp");
        dispatcher.forward(req, resp);
    }
}
