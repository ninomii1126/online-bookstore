import React from "react";
import { Swiper, SwiperSlide } from "swiper/react";
import { Navigation, Pagination } from "swiper/modules";
import "swiper/css";
import "swiper/css/navigation";
import "swiper/css/pagination";
import { getImgUrl } from "../../utils/getImgUrl";

const BookCarousel = ({ books }) => {
  return (
    <Swiper
      modules={[Navigation, Pagination]}
      navigation
      pagination={{ clickable: true }}
      spaceBetween={10}
      slidesPerView={4}
      loop={true}
      className="relative z-0"
    >
      {books.slice(0, 5).map((book) => (
        <SwiperSlide key={book.id}>
          <div className="book-card">
            <img
              src={getImgUrl(book?.coverImage)}
              alt={book.title}
              style={{ width: "100%", height: "auto", borderRadius: "8px" }}
            />
            <p style={{ textAlign: "center", marginTop: "8px" }}>
              {book.title}
            </p>
          </div>
        </SwiperSlide>
      ))}
    </Swiper>
  );
};

export default BookCarousel;
