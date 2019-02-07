package main.java.com.controllers;

import main.java.com.service.DatabaseConnectionService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/databaseConnection")
public class DatabaseConnectionController {
    DatabaseConnectionService service;

    @GET
    @Path("/getDatabases/")
    @Produces("application/protobuf")
    public Response getDatabaseList(@QueryParam("provider") String provider, @QueryParam("hostUrl") String hostUrl) {
        service = new DatabaseConnectionService();
        List<String> databaseList = service.getDatabaseList(provider, hostUrl);
        return null;
    }

    @GET
    @Path("/getDatabases/{provider}/getTables")
    @Produces("application/protobuf")
    public Response getTableList(@QueryParam("database") String database) {

        return null;
    }
}
