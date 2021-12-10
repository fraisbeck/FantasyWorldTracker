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

@WebServlet (
        name = "addNewLocation",
        urlPatterns = {"/addNewLocation"}
)
public class AddNewLocation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GenericDao<Region> regionData = new GenericDao<>(Region.class);

        List<Region> regions = regionData.getAll();
        req.setAttribute("listRegions", regions);

        RequestDispatcher dispatcher = req.getRequestDispatcher("editLocation.jsp");
        dispatcher.forward(req, resp);
    }
}
