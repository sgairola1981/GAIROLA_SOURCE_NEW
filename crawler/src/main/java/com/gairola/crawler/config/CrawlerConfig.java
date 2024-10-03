package com.gairola.crawler.config;

import edu.uci.ics.crawler4j.crawler.CrawlConfig;
import edu.uci.ics.crawler4j.crawler.CrawlController;
import edu.uci.ics.crawler4j.fetcher.PageFetcher;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtConfig;
import edu.uci.ics.crawler4j.robotstxt.RobotstxtServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.gairola.crawler.BasicCrawler;

@Configuration
public class CrawlerConfig {

    @Bean
    public CrawlController crawlController() throws Exception {
        String crawlStorageFolder = "data/crawl/root"; // Storage location
        int numberOfCrawlers = 5; // Number of crawler threads

        CrawlConfig config = new CrawlConfig();
        config.setCrawlStorageFolder(crawlStorageFolder);
        config.setMaxDepthOfCrawling(2);
        config.setMaxPagesToFetch(100);

        PageFetcher pageFetcher = new PageFetcher(config);
        RobotstxtConfig robotstxtConfig = new RobotstxtConfig();
        RobotstxtServer robotstxtServer = new RobotstxtServer(robotstxtConfig, pageFetcher);

        CrawlController controller = new CrawlController(config, pageFetcher, robotstxtServer);

        controller.start(BasicCrawler.class, numberOfCrawlers);

        return controller;
    }
}
