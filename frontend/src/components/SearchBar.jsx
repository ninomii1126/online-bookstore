import React from "react";
import { useState } from "react";
import { useNavigate } from "react-router-dom";

const SearchBar = () => {
  //   const [query, setQuery] = useState("");
  //   const navigate = useNavigate();

  const handleSubmit = (e) => {
    e.preventDefault();
    if (query.trim()) {
      navigate(`/search?query=${encodeURIComponent(query)}`);
    }
  };

  const [query, setQuery] = useState("");
  const navigate = useNavigate();

  const handleSearch = (e) => {
    e.preventDefault();
    if (query.trim()) {
      navigate(`/search?query=${encodeURIComponent(query)}`);
    }
  };
  return (
    <form onSubmit={handleSubmit}>
      <input
        type="text"
        value={query}
        // onChange={(e) => setQuery(e.target.value)}
        // onChange={(e) => setQuery(e.target.value)}
        onChange={(e) => setQuery(e.target.value)} 
        placeholder="Search by title or author"
        onKeyDown={(e) => {
    if (e.key === "Enter") {
      handleSearch(e);
    }
  }}
        className="bg-[#EAEAEA] w-full py-1 md:px-8 px-6 rounded-md focus:outline-none"
      />
      {/* <button type="submit">Search</button> */}
    </form>
  );
};

export default SearchBar;
