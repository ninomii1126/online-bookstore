package com.Joyce.bookstore.service;

import com.Joyce.bookstore.dto.request.TotalOrdersRequest;
import com.Joyce.bookstore.dto.request.TotalRevenueRequest;
import com.Joyce.bookstore.dto.response.DashboardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService{

    @Autowired
    private BookService bookService;

    @Autowired
    private  OrderService orderService;

    @Override
    public DashboardResponse getDashboardInfo() {
        DashboardResponse res = new DashboardResponse();

        res.setTotalBooks(bookService.getTotalBooksCount());
        res.setTotalOrders(orderService.getTotalOrders(new TotalOrdersRequest()));
        res.setTotalRevenue(orderService.getTotalRevenue(new TotalRevenueRequest()));
        res.setTrendingBooks(bookService.getTrendingBooks());

        return res;
    }
}
