import React from "react";
import { TfiShoppingCart } from "react-icons/tfi";
import { getImgUrl } from "../../utils/getImgUrl";
import { Link } from "react-router-dom";
import { useDispatch } from "react-redux";
import { addToCart } from "../../redux/features/counter/cartSlice";

const BookCard = ({ book }) => {
  const dispatch = useDispatch();
  const handleAddToCart = (item) => dispatch(addToCart(item));

  return (
    <div className=" rounded-lg transition-shadow duration-300 justify-self-start">
      <div className="flex flex-col sm:flex-row sm:items-center sm:h-72  sm:justify-center gap-4">
        {/* <div className="sm:h-72 sm:flex-shrink-0 border rounded-md"> */}
        <div className="sm:h-72 sm:w-48 sm:flex-shrink-0 border rounded-md overflow-hidden">

          <Link to={`/books/${book?.id}`}>
            <img
              src={`${getImgUrl(book?.coverImage)}`}
              alt=""
              // className="w-full bg-cover p-2 rounded-md cursor-pointer hover:scale-105 transition-all duration-200"
              className="w-full h-full object-cover p-2 cursor-pointer hover:scale-105 transition-all duration-200" 
            />
            
          </Link>
        </div>

        <div className="flex flex-col h-full justify-between">
          {/* {console.log(book)} */}
          <Link to={`/books/${book?.id}`}>
            <h3 className="text-xl font-semibold hover:text-blue-600 mb-3">
              {book?.title}
            </h3>
          </Link>
          <p className="text-gray-600 mb-5">
            {book?.description.length > 80
              ? `${book.description.slice(0, 80)}...`
              : book.description}
          </p>
          <p className="font-medium mb-5">
            ${book?.newPrice}{" "}
            <span className="line-through font-normal ml-2">
              ${book?.oldPrice}
            </span>
          </p>
          <button
            //className="btn-primary px-6 space-x-1 flex items-center gap-1 w-fit"
              className="btn-primary text-white text-sm px-4 py-2 rounded-md hover:bg-blue-600 flex items-center gap-1 w-fit"

            onClick={() => handleAddToCart(book)}
          >
            <TfiShoppingCart className="" />
            <span>Add to Cart</span>
          </button>
        </div>
      </div>
    </div>
  );
};

export default BookCard;
