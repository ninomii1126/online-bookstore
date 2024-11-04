import React, { useEffect, useState } from "react";

const categories = ["Choose a genre", "Business", "Fiction", "Horror", "Adventure"];

const TopSeller = () => {
  const [books, setBooks] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState("Choose a genre");
  
  useEffect(() => {
    fetch("books.json")
      .then((res) => res.json())
      .then((data) => setBooks(data));
  }, []);

  const filteredBooks = selectedCategory === "choose a genre" ? books : books.filter(book => book.category === selectedCategory.toLowerCase())

  console.log(filteredBooks)


  return (
  <div className="py-10">
  <h2 className="text-3x1 font-semibold mb-6">Top Sellers</h2>
  {/* category filtering*/}
  <div className="mb-8 flex items-center">
    <select onChange={(e)=>setSelectedCategory(e.target.value)}
    name="category" id="category" className="border bg-[#EAEAEA] border-gray-300 rounded-md px-4 py-2 focus:outline-none">
        {
            categories.map((category, index)=>(
                <option key={index} value={category} className="font-secondary ">{category}</option>
            )) 
        }
    </select>
    </div>
    {
        filteredBooks.map((book, index)=>(
            <div>{book.title}</div>
        ))
    }
  </div>
);
};

export default TopSeller;
