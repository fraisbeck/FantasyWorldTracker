package worldbuilder.controller;

import worldbuilder.entity.User;
import worldbuilder.persistance.UserDao;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/users")
public class UserMethods {

    UserDao userDao = new UserDao();

    @GET
    @Path("/all")
    @Produces("text/plain")
    public Response getUsers() {
        List<User> list = userDao.getAllUsers();
        String output = "";
        for (User user : list) {
            output += user.toString();
        }
        return Response.status(200).entity(output).build();
    }

    @GET
    @Path("/anything")
    @Produces("text/plain")
    public Response getAnything() {
        String output = "Here is something";
        return Response.status(200).entity(output).build();
    }

    /**
    @GET
    @Path("/allUsers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<User> allUsers() {
       return userDao.getAllUsers();
    }

    @GET
    @Path("/getUser/{userid}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("userid") int userid) {
        User user = userDao.getById(userid);
        return user;
    }

    @GET
    @Path("/users")
    @Produces(MediaType.APPLICATION_XML)
    public String getUsers(){

    }

    @GET
    @Path("/users/{userid}")
    @Produces(MediaType.APPLICATION_XML)
    public User getUser(@PathParam("userid") int userid){
        return userDao.getById(userid);
    }
    */

}