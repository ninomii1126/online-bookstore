package com.Joyce.bookstore.controller;

import com.Joyce.bookstore.dto.response.DashboardResponse;
import com.Joyce.bookstore.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    DashboardService dashboardService;

    @GetMapping("/")
    ResponseEntity<DashboardResponse> getOrdersByEmail(){
        return new ResponseEntity<DashboardResponse>(dashboardService.getDashboardInfo(), HttpStatus.OK);
    }

}
