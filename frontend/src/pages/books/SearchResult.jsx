import React from "react";
import { useSearchParams } from "react-router-dom";
import { useSearchBooksQuery } from "../../redux/features/books/booksApi";
import { useLocation } from "react-router-dom";
import BookCard from "./BookCard";

function useQuery() {
  return new URLSearchParams(useLocation().search);
}

const SearchResult = () => {
  const query = useQuery().get("query") || "";
  const { data: books, error, isLoading } = useSearchBooksQuery(query);
  return (
    <div>
      {isLoading ? (
        <p>Loading...</p>
      ) : books?.length === 0 ? (
        <p>No results found.</p>
      ) : (
        <div className="p-4">
          <h2 className="text-2xl font-semibold mb-4">
            Search results for "{query}"
          </h2>
          <div className="grid grid-cols-1 sm:grid-cols-2 gap-6 justify-start">
            {books.map((book) => (
              <BookCard key={book.id} book={book} />
            ))}
          </div>
        </div>
      )}
    </div>
  );
};

export default SearchResult;
