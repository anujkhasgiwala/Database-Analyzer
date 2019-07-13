package com.databaseAnalyzer.controllers;

import java.util.ArrayList;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.databaseAnalyzer.service.DatabaseConnectionService;

@RestController
@RequestMapping("/api/databaseConnection")
public class DatabaseConnectionController {
	@Autowired
    DatabaseConnectionService service;
    
	@RequestMapping(value = "/getDatabases", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON)
    public Response getDatabaseList(/*
									 * @QueryParam("provider") String provider, @QueryParam("hostUrl") String
									 * hostUrl,
									 * 
									 * @QueryParam("username") String username, @QueryParam("password") String
									 * password
									 */) {
            //List<String> databaseList = service.getDatabaseList(provider, hostUrl, username, password);
        return Response.ok(new ArrayList()).build();
    }

	@RequestMapping(value = "/getDatabases/{provider}/getTables", method = RequestMethod.GET)
    public Response getTableList(@PathVariable("provider") String provider) {
        return null;
    }
}