package main.java.com.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import main.java.com.service.DatabaseConnectionService;

@Path("/databaseConnection")
//@Api(value = "/databaseConnection", description = "Connects to database class")
public class DatabaseConnectionController {
    DatabaseConnectionService service;

    @GET
    @Path("/getDatabases")
    @Produces("application/json")
	/*
	 * @ApiOperation(value = "get database list", response = String.class)
	 * 
	 * @ApiResponses(value= {
	 * 
	 * @ApiResponse(code=200, message = "database connection successful")})
	 */
    public Response getDatabaseList() {
        service = new DatabaseConnectionService();
        //@QueryParam("provider") String provider, @QueryParam("hostUrl") String hostUrl,
        //@QueryParam("username") String username, @QueryParam("password") String password
        //List<String> databaseList = service.getDatabaseList(provider, hostUrl, username, password);
        return Response.ok().build();
    }

    @GET
    @Path("/getDatabases/{provider}/getTables")
    @Produces("application/protobuf")
//    @ApiOperation(value = "get table list for selected database", response = String.class)
    public Response getTableList(@QueryParam("database") String database) {

        return null;
    }
}