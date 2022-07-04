package com.example.resource;

import com.example.rest_api_p.Employee;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import javax.servlet.http.HttpServlet;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/empResource")
public class empResource  {

    @GET()
    @Produces("text/plain")
    public String hello() throws Exception{
        return "I am Connected";
    }

    @GET()
    @Path("/getJSON")
    @Produces("/text/JSON")
    public Response getJSON() throws Exception{
        JsonObject obj=new JsonObject();

        obj.addProperty("empId","emp001");
        obj.addProperty("f_name","Muhammad");
        obj.addProperty("l_name","Daniyal");
        obj.addProperty("salary",100);

        return Response.ok(obj.toString()).build();
    }

    @POST
    @Path("/PostTest")
    public Response postJSON(String payload) throws Exception
    {
        final Employee emp=new Gson().fromJson(payload,Employee.class);
        System.out.println(emp.toString());
        return Response.noContent().build();
    }

}
