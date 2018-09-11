package com.resources;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.entity.Category;
import com.enums.Status;
import com.facade.CategoryFacade;
import com.google.gson.Gson;

@Path("/CategoryResource")
public class CategoryResource {
    CategoryFacade categoryFacade = CategoryFacade.getInstance();

    @GET
    @Path("/InsertCategory/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertIntoCategories(@PathParam("name") String name) {

        if (name == null) {

            return Response.serverError().entity("ID cannot be blank").build();

        }

        if (categoryFacade.insertCategory(name).equals(Status.INSERTED)) {

            return Response.ok("Successfully Inserted", MediaType.APPLICATION_JSON).build();

        }

        else {

            return Response.status(Response.Status.CREATED).entity("Entity not Created").build();
        }
    }

    @GET
    @Path("/GetCategory")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllCategories() {

        List<Category> categoryList = categoryFacade.getAll();

        if (categoryList.size() == 0) {

            return Response.status(Response.Status.NOT_FOUND).entity("Entity not found").build();

        }

        else {

            Gson gson = new Gson();

            String categoryJson = gson.toJson(categoryList);

            return Response.ok(categoryJson, MediaType.APPLICATION_JSON).build();
        }
    }

    @GET
    @Path("/UpdateCategory/{id}/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateCategory(@PathParam("id") int id, @PathParam("name") String name) {

        if (id == 0 || name == null) {

            return Response.serverError().entity("input parameters cannot be blank").build();
        }

        if (categoryFacade.updateName(name, id).equals(Status.UPDATED)) {
            return Response.ok("Successfully Updated", MediaType.APPLICATION_JSON).build();
        }

        else {
            return Response.status(Response.Status.NOT_FOUND).entity("Entity not Created").build();

        }
    }

}
