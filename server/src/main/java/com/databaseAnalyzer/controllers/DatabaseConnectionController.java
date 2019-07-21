package com.databaseAnalyzer.controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.databaseAnalyzer.service.DatabaseConnectionService;

@RestController
public class DatabaseConnectionController {
	@Autowired
    private DatabaseConnectionService service;
    
	@RequestMapping(value = "/api/databaseConnection/getDatabases", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List getDatabaseList(/* @RequestBody
									 * @QueryParam("provider") String provider, @QueryParam("hostUrl") String
									 * hostUrl,
									 * 
									 * @QueryParam("username") String username, @QueryParam("password") String
									 * password
									 */) {
		List<String> databaseList = service.getDatabaseList("Postgres", "jdbc:postgresql://wallabybeta:5432/qiws", "akhasgiwala", "Anumey@12345");
		
        return databaseList;
    }

	/*
	 * @RequestMapping(value =
	 * "/api/databaseConnection/getDatabases/{provider}/getTables", method =
	 * RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) public List
	 * getTableList(@PathVariable("provider") String provider) { return null; }
	 */
}