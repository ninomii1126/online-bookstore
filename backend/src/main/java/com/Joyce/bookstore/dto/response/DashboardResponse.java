package com.Joyce.bookstore.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DashboardResponse {

    private Long totalBooks;

    private BigDecimal totalRevenue;

    private Long trendingBooks;

    private Long totalOrders;
}
