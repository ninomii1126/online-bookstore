import React from "react";
import bannerImg from "../../assets/banner.png";
import BookCarousel from "./BookCarousel";
import { useFetchAllBooksQuery } from "../../redux/features/books/booksApi";

const Banner = () => {
  const { data: books = [], isLoading, isError } = useFetchAllBooksQuery();
  if (isLoading) return <p>Loading...</p>;
  if (isError) return <p>Something went wrong</p>;

  return (
    <div className="flex flex-col md:flex-row-reverse py-16 justify-between items-center gap-12">
      <div className="md:w-1/2 w-full flex items-center md:justify-end">
        <BookCarousel books={books} />
        {/* <img src={bannerImg} alt="" /> */}
      </div>
      <div className="md:w-1/2 w-full">
        {/* <h1 className="md:text-5x1 text-2x1 font-Large font-bold mb-7 font-primary"> */}
        <h1 className="md:text-5xl text-2xl font-bold mb-7 font-primary">
          New Releases This Week
        </h1>
        <p className="mb-10">
          Refresh your reading list with the latest and most acclaimed new releases in the literary world.
        </p>
        <button className="btn-primary">Subscribe</button>
      </div>
    </div>
  );
};

export default Banner;
