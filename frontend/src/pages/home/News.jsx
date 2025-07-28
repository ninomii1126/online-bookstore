import React, { useEffect, useState } from "react";
// Import Swiper React components
import { Swiper, SwiperSlide } from "swiper/react";

// Import Swiper styles
import "swiper/css";
import "swiper/css/navigation";

// import required modules
import { Pagination, Navigation } from "swiper/modules";

import { NEWS_API_KEY, NEWS_API_URL } from '../../config';

import { Link } from "react-router-dom";
import axios from "axios";

import getBaseUrl from "../../utils/baseUrl";

const News = () => {

const [articles, setArticles] = useState([]);
  const keyword = "literature"; // change this as needed


  useEffect(() => {
  const fetchNews = async () => {
    try {
      const res = await axios.get(`${getBaseUrl()}/api/news?q=${keyword}`);
      setArticles(res.data.articles);
    } catch (error) {
      console.error("Failed to fetch news:", error);
    }
  };

  fetchNews();
}, []);

  return (
    <div>
      <h2 className="text-3xl font-semibold mb-6">News</h2>
      <Swiper
        slidesPerView={1}
        spaceBetween={30}
        navigation={true}
        breakpoints={{
          640: { slidesPerView: 1, spaceBetween: 20 },
          768: { slidesPerView: 2, spaceBetween: 40 },
          1024: { slidesPerView: 2, spaceBetween: 50 },
        }}
        modules={[Navigation, Pagination]}
        className="mySwiper"
      >
        {articles.map((item, index) => (
          <SwiperSlide key={index}>
            <div className="flex flex-col sm:flex-row sm:justify-between gap-4">
              <div className="py-4 flex-1">
                <Link to={item.url} target="_blank">
                  <h3 className="text-lg font-medium hover:text-blue-500 mb-4">
                    {item.title}
                  </h3>
                </Link>
                <div className="w-14 h-[3px] bg-primary mb-6"></div>
                <p className="text-sm text-gray-600">{item.description}</p>
              </div>
              <div className="flex-shrink-0 w-full sm:w-48">
                <img
                  src={item.urlToImage || "/placeholder-news.png"}
                  alt={item.title}
                  className="w-full object-cover rounded"
                />
              </div>
            </div>
          </SwiperSlide>
        ))}
      </Swiper>
    </div>
  );
};

export default News;
