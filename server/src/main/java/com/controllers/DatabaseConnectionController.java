package main.java.com.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import main.java.com.service.DatabaseConnectionService;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("/databaseConnection")
@Api(value = "/databaseConnection", description = "Connects to database")
public class DatabaseConnectionController {
    DatabaseConnectionService service;

    @GET
    @Path("/getDatabases")
    @Produces("application/protobuf")
    public Response getDatabaseList(@QueryParam("provider") String provider, @QueryParam("hostUrl") String hostUrl,
                                    @QueryParam("username") String username, @QueryParam("password") String password) {
        service = new DatabaseConnectionService();
        List<String> databaseList = service.getDatabaseList(provider, hostUrl, username, password);
        return Response.ok(databaseList).build();
    }

    @GET
    @Path("/getDatabases/{provider}/getTables")
    @Produces("application/protobuf")
    public Response getTableList(@QueryParam("database") String database) {

        return null;
    }
}