package com.brico.compare.controller;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brico.compare.service.CleanService;

/**
 * Created by edeltil on 17/07/2017.
 */
@RestController
public class CleanController {

	@Autowired
	private CleanService bmCleanService;
	@Autowired
	private CleanService bdCleanService;
	@Autowired
	private CleanService castoCleanService;
	@Autowired
	private CleanService lapeyreCleanService;
	@Autowired
	private CleanService lmCleanService;
	@Autowired
	private CleanService vialCleanService;

	@RequestMapping("/clean")
	public void clean() throws InterruptedException, ExecutionException, IOException {
		bmCleanService.cleanDB();
		bdCleanService.cleanDB();
		castoCleanService.cleanDB();
		lapeyreCleanService.cleanDB();
		lmCleanService.cleanDB();
		vialCleanService.cleanDB();
	}
}
