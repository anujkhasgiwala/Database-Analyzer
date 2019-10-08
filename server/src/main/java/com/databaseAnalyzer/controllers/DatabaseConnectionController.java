package com.databaseAnalyzer.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.databaseAnalyzer.service.DatabaseConnectionService;

@RestController
public class DatabaseConnectionController {
	@Autowired
	private DatabaseConnectionService service;

	@RequestMapping(value = "/api/databaseConnection/getDatabases", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getDatabaseList(@RequestBody Map<String, String> dbDetails) {
		List<String> databaseList = service.getDatabaseList(dbDetails.get("provider"), dbDetails.get("hostUrl"), dbDetails.get("username"), dbDetails.get("password"));

		return databaseList;
	}

	@RequestMapping(value ="/api/databaseConnection/getDatabases/{databaseName}/{schemaName}/getTables", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<String> getTableList(@PathVariable("databaseName") String databaseName, @PathVariable("schemaName") String schemaName) {
		List<String> tableList = service.getTableList(databaseName, schemaName);
		return tableList;
	}

}