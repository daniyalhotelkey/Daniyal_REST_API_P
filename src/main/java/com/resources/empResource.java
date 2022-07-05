package com.resources;
import com.example.rest_api_p.Employee;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("/empResource")
public class empResource  {
    @GET
    @Path("/connectionCheck")
    public String connectionCheck() throws Exception{
       /** --- Checking Connection ----- **/
        return "I am Connected";
    }

    @GET
    @Path("/getData")
    public Response getData() throws Exception{
        JsonObject obj=new JsonObject();

        /**--- Sending HardCoded Data to the Server-----**/
        obj.addProperty("empId","emp001");
        obj.addProperty("f_name","Muhammad");
        obj.addProperty("l_name","Daniyal");
        obj.addProperty("salary",100);

        /**--- Sending the Response Back ----- **/
        return Response.ok(obj.toString()).build();
    }

    @POST
    @Path("/PostData")
    public Response postData(String payload) throws Exception
    {
        /**---- Testing Payload -----**/
        System.out.println(payload);

        /**---- Transferring Data from JSON to Class -----**/
        Employee emp=new Gson().fromJson(payload,Employee.class);

        /**---- Checking if the data is Null or Misspelled  -----**/
        try{
            if(emp.getF_name()==null  || emp.getL_name()==null || emp.getEmpId()==null ||emp.getPassword()==null)
                throw new Exception();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.BAD_REQUEST).entity("Field are empty or Misspelled").build();
        }

        /** --- Sending the Response Back ----- **/
        return Response.status(200).entity("Data Inserted Successfully").build();
    }

    @PUT
    @Path("/PutData/{id}")
    public Response putTest(@PathParam("id") String id,@QueryParam("f_name") String f_name,String payload)
    {
        /**---- Transferring Data from JSON to Class -----**/
        Employee emp=new Gson().fromJson(payload,Employee.class);

        /**---- Checking if the data is Null or Misspelled  -----**/
        try{
            if(emp.getEmpId()==null || emp.getPassword()==null)
                throw new Exception();
        }
        catch (Exception ex)
        {
            return Response.status(Response.Status.BAD_REQUEST).entity("One or both field are empty or Misspelled").build();
        }

        /** --- Setting Data coming from Query & Path Param ---- **/
        emp.setEmpId(id);
        emp.setF_name(f_name);

        /** --- Creating JSON Object and adding Properties ---- **/
        JsonObject obj=new JsonObject();
        obj.addProperty("empId",emp.getEmpId());
        obj.addProperty("f_name",emp.getF_name());
        obj.addProperty("l_name",emp.getL_name());
        obj.addProperty("salary",emp.getSalary());

        /** --- Testing ---- **/
        System.out.println(obj.toString());

        /**--- Sending the Response Back ----- **/
        return Response.ok(obj.toString()).build();
    }

    @POST
        @Path("/CheckLogin")
    public Response checkLogin(String payload){

        /**---- Transferring Data from JSON to Class -----**/
        Employee emp=new Gson().fromJson(payload,Employee.class);


        /** Testing Query Params **/
        System.out.println(emp.getEmpId());
        System.out.println(emp.getPassword());

        /**----Creating Login Class --------**/
        Login login=new Login();

        /**------ Checking if Id exsist ----------**/
        boolean flag=false;
        int index=0;
        for(int i=0;i<login.empIds.length;i++)
        {
            if(emp.getEmpId().equals(login.empIds[i]))
            {
                flag=true;
                index=i;
            }
        }
        if(!flag)
            return Response.status(401).entity("Login Failed; Incorrect Id ").build();


        /**------ Checking if Password matches the provided ID ----------**/
        if(login.getPasswords()[index].equals(emp.getPassword()))
            return Response.status(200).entity("Login Successful; Correct Id and Password").build();
        else
            return Response.status(401).entity("Login Failed; Incorrect Password").build();

    }



}
