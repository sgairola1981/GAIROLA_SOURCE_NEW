package com.gairola.crawler.controller;

import edu.uci.ics.crawler4j.crawler.CrawlController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gairola.crawler.BasicCrawler;

@RestController
public class CrawlerController {

    @Autowired
    private CrawlController crawlController;

    @GetMapping("/start-crawl")
    public String startCrawling() {
        crawlController.startNonBlocking(BasicCrawler.class, 5); // Start crawling with 5 threads
        return "Crawler started!";
    }
}
