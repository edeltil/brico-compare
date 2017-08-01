package com.brico.compare.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.brico.compare.service.BricoService;

/**
 * Created by edeltil on 17/07/2017.
 */
@RestController
public class InitController {
	@Autowired
	private BricoService bmService;
	@Autowired
	private BricoService bdService;
	@Autowired
	private BricoService castoService;
	@Autowired
	private BricoService lpService;
	@Autowired
	private BricoService lmService;
	@Autowired
	private BricoService vialService;

	@RequestMapping("/init")
	public void initialise() throws IOException {
		bmService.populateProducts();
		bdService.populateProducts();
		castoService.populateProducts();
		lpService.populateProducts();
		lmService.populateProducts();
		vialService.populateProducts();

	}
}
