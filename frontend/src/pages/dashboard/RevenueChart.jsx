import React, { useEffect, useState } from "react";
import { Bar } from "react-chartjs-2";
import {
  Chart as ChartJS,
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend,
} from "chart.js";
import getBaseUrl from "../../utils/baseUrl";
import axios from "axios";

ChartJS.register(
  CategoryScale,
  LinearScale,
  BarElement,
  Title,
  Tooltip,
  Legend
);

const RevenueChart = () => {
  const [selectedYear, setSelectedYear] = useState("");
  const [revenueMap, setRevenueMap] = useState({});
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get(
          `${getBaseUrl()}/api/order/monthlyRevenue`,
          {
            headers: {
              Authorization: `Bearer ${localStorage.getItem("token")}`,
              "Content-Type": "application/json",
            },
          }
        );

        const rawData = response.data.revenue;

        const months = [
          "Jan",
          "Feb",
          "Mar",
          "Apr",
          "May",
          "Jun",
          "Jul",
          "Aug",
          "Sep",
          "Oct",
          "Nov",
          "Dec",
        ];

        const revenueData = {};

        Object.keys(rawData).forEach((year) => {
          const monthData = rawData[year];
          const monthlyRevenue = months.map((m) => monthData[m] || 0);
          revenueData[year] = monthlyRevenue;
        });

        setRevenueMap(revenueData);

        const years = Object.keys(revenueData).sort((a, b) => b - a);
        if (years.length > 0) setSelectedYear(years[0]);

        setLoading(false);
      } catch (error) {
        console.error("Error: ", error);
        setLoading(false);
      }
    };

    fetchData();
  }, []);

  const chartData = {
    labels: [
      "Jan",
      "Feb",
      "Mar",
      "Apr",
      "May",
      "Jun",
      "Jul",
      "Aug",
      "Sep",
      "Oct",
      "Nov",
      "Dec",
    ],
    datasets: [
      {
        label: `Revenue (${selectedYear})`,
        data: revenueMap[selectedYear] || Array(12).fill(0),
        backgroundColor: "rgba(34, 197, 94, 0.7)",
        borderColor: "rgba(34, 197, 94, 1)",
        borderWidth: 1,
      },
    ],
  };

  const options = {
    responsive: true,
    plugins: {
      legend: { position: "top" },
      title: { display: true, text: "Monthly Revenue" },
    },
    scales: { y: { beginAtZero: true } },
  };

  if (loading) return <div className="text-center p-4">Loading...</div>;

  return (
    <div className="w-full max-w-3xl mx-auto p-4 bg-white shadow-lg rounded-lg">
      <div className="flex items-center gap-4 mb-4">
        <select
          className="p-1 border rounded text-sm"
          value={selectedYear}
          onChange={(e) => setSelectedYear(e.target.value)}
        >
          {Object.keys(revenueMap)
            .sort((a, b) => b - a)
            .map((year) => (
              <option key={year} value={year}>
                {year}
              </option>
            ))}
        </select>
        <h2 className="text-2xl font-bold text-gray-800 ml-4">
          Monthly Revenue
        </h2>
      </div>

      <div className="hidden md:block">
        <Bar data={chartData} options={options} />
      </div>
    </div>
  );
};

export default RevenueChart;
