import React, { useState } from "react";
import { Link } from "react-router-dom";
import { AiOutlineBars } from "react-icons/ai";
import { FaSearch } from "react-icons/fa";
import { FaUserCircle } from "react-icons/fa";
import { FaHeart } from "react-icons/fa";
import { LuShoppingCart } from "react-icons/lu";
import avatarImg from "../assets/avatar.png";
import { useSelector } from "react-redux";
import { useAuth } from "../context/AuthContext";
import { useSearchBooksQuery } from "../redux/features/books/booksApi";
import SearchBar from "./SearchBar";

const Navbar = () => {
  const [isDropdownOpen, setIsDropdownOpen] = useState(false);
  const cartItems = useSelector((state) => state.cart.cartItems);
  const { currentUser, logout } = useAuth();

  const handleLogout = () => {
    logout();
  };

  const navigation = [
    { name: "Dashboard", href: "/dashboard" },
    { name: "Orders", href: "/orders" },
    { name: "Cart Page", href: "/cart" },
    { name: "Check out", href: "/checkout" },
  ];

  const [query, setQuery] = useState("");
  const { data: results, isLoading } = useSearchBooksQuery(query, {
    skip: query.length === 0,
  });

  return (
    <header className="max-w-screen-2x1 mx-auto px-4 py-6">
      <nav className="flex justify-between items-center">
        {/*left side*/}
        <div className="flex items-center md:gap-16 gap-4">
          <Link to="/">
            <AiOutlineBars className="size-6" />
          </Link>
          {/*search input*/}
          <div className="relative sm:w-72 w-40 space-x-2">
            <FaSearch className="absolute inline-block left-4 inset-y-2" />
            {/* <input
              type="text"
              value={query}
              onChange={(e) => setQuery(e.target.value)}
              placeholder="Search by title or author"
              className="bg-[#EAEAEA] w-full py-1 md:px-8 px-6 rounded-md focus:outline-none"
            /> */}
            <SearchBar/>
          </div>
        </div>

        {/*right side*/}

        <div className="relative flex items-center md:space-x-3 space-x-2">
          <div>
            {currentUser ? (
              <>
                <button onClick={() => setIsDropdownOpen(!isDropdownOpen)}>
                  <img
                    src={avatarImg}
                    className={`size-7 rounded-full ${
                      currentUser ? "ring-2 ring-blue-500" : ""
                    }`}
                  />
                </button>
                {/* show dropdown */}
                {isDropdownOpen && (
                  <div className="absolute right-0 mt-2 w-48 bg-white">
                    <ul className="py-2">
                      {navigation.map((item) => (
                        <li
                          key={item.name}
                          onClick={() => setIsDropdownOpen(false)}
                        >
                          <Link
                            to={item.href}
                            className="block px-4 py-2 text-sm hover:bg-gray-100"
                          >
                            {item.name}
                          </Link>
                        </li>
                      ))}
                      <li>
                        <button
                          onClick={handleLogout}
                          className="block w-full text-left px-4 py-2 text-sm hover:bg-gray-100"
                        >
                          Logout
                        </button>
                      </li>
                    </ul>
                  </div>
                )}
              </>
            ) : (
              <Link to="/login">
                <FaUserCircle className="size-6" />
              </Link>
            )}
          </div>
          <button className="hidden sm:block">
            <FaHeart className="size-6" />
          </button>
          <Link
            to="/cart"
            className="bg-primary p-1 sm:px-6 px-2 flex items-center rounded-sm"
          >
            <LuShoppingCart />
            {cartItems?.length > 0 ? (
              <span className="text-sm font-semibold sm: ml-1">
                {cartItems.length}
              </span>
            ) : (
              <span className="text-sm font-semibold sm: ml-1">0</span>
            )}
          </Link>
        </div>
      </nav>
    </header>
  );
};

export default Navbar;
