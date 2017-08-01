package com.brico.compare.config;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import com.brico.compare.entity.Seller;
import com.brico.compare.parser.BMParser;
import com.brico.compare.parser.BricoDepotParser;
import com.brico.compare.parser.CastoParser;
import com.brico.compare.parser.LMParser;
import com.brico.compare.parser.LapeyreParser;
import com.brico.compare.parser.VialParser;
import com.brico.compare.service.BricoService;
import com.brico.compare.service.CleanService;

/**
 * Created by edeltil on 17/03/2017.
 */
@Configuration
@EnableScheduling
public class AppConfig implements SchedulingConfigurer {

	@Value("${etl.catalog.directory}")
	private String directory;

	@Value("${products.bricomarche.path}")
	private String pathBricoMarche;

	@Value("${products.bricodepot.path}")
	private String pathBricoDepot;

	@Value("${products.bricodepot.host}")
	private String hostBricoDepot;

	@Value("${products.casto.path}")
	private String pathCasto;

	@Value("${products.casto.host}")
	private String hostCasto;

	@Value("${products.lapeyre.path}")
	private String pathLapeyre;

	@Value("${products.leroymerlin.path}")
	private String pathLeroymerlin;

	@Value("${products.vial.path}")
	private String pathVial;

	@Value("${products.vial.host}")
	private String hostVial;

	@Bean
	public BricoService bmService() throws IOException {
		return new BricoService(new BMParser(directory, pathBricoMarche));
	}

	@Bean
	public BricoService bdService() throws IOException {
		return new BricoService(new BricoDepotParser(directory, pathBricoDepot, hostBricoDepot));
	}

	@Bean
	public BricoService castoService() throws IOException {
		return new BricoService(new CastoParser(directory, pathCasto, hostCasto));
	}

	@Bean
	public BricoService lpService() throws IOException {
		return new BricoService(new LapeyreParser(directory, pathLapeyre));
	}

	@Bean
	public BricoService lmService() throws IOException {
		return new BricoService(new LMParser(directory, pathLeroymerlin));
	}

	@Bean
	public BricoService vialService() throws IOException {
		return new BricoService(new VialParser(directory, pathVial, hostVial));
	}

	@Bean
	public CleanService bmCleanService() throws IOException {
		return new CleanService(Seller.BM);
	}

	@Bean
	public CleanService bdCleanService() throws IOException {
		return new CleanService(Seller.BD);
	}

	@Bean
	public CleanService castoCleanService() throws IOException {
		return new CleanService(Seller.CASTO);
	}

	@Bean
	public CleanService lapeyreCleanService() throws IOException {
		return new CleanService(Seller.LAPEYRE);
	}

	@Bean
	public CleanService lmCleanService() throws IOException {
		return new CleanService(Seller.LM);
	}

	@Bean
	public CleanService vialCleanService() throws IOException {
		return new CleanService(Seller.VIAL);
	}

	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		taskRegistrar.setScheduler(taskExecutor());
	}

	@Bean(destroyMethod = "shutdown")
	public Executor taskExecutor() {
		return Executors.newScheduledThreadPool(10);
	}
}
