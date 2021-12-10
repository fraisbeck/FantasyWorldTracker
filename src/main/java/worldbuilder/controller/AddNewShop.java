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
        name = "addNewShop",
        urlPatterns = {"/addNewShop"}
)
public class AddNewShop extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Location> locationData = new GenericDao<>(Location.class);
        GenericDao<Owner> ownerData = new GenericDao<>(Owner.class);

        List<Location> locations = locationData.getAll();
        req.setAttribute("listLocations", locations);

        List<Owner> owners = ownerData.getAll();
        req.setAttribute("listOwners", owners);

        RequestDispatcher dispatcher = req.getRequestDispatcher("editShop.jsp");
        dispatcher.forward(req, resp);
    }
}
