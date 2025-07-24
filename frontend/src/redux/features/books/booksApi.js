import { createApi, fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import getBaseUrl from "../../../utils/baseUrl";

const baseQuery = fetchBaseQuery({
  baseUrl: `${getBaseUrl()}/api/book`,
  credentials: "include",
  // credentials: 'same-origin',

  prepareHeaders: (Headers) => {
    const token = localStorage.getItem("token");
    if (token) {
      Headers.set("Authorization", `Bearer ${token}`);
    }
    return Headers;
  },
});

const booksApi = createApi({
  reducerPath: "bookApi",
  baseQuery,
  tagTypes: ["Books"],
  endpoints: (builder) => ({
    // Fetch all books
    fetchAllBooks: builder.query({
      query: () => "/getBooks",
      providesTags: ["Books"],
    }),

    // Fetch a book by ID
    fetchBookById: builder.query({
      query: (id) => `/getSingleBook/${id}`,
      providesTags: (result, error, id) => [{ type: "Books", id }],
    }),

    // Add a new book
    addBook: builder.mutation({
      query: (newBook) => ({
        url: `createBook`,
        method: "POST",
        body: newBook,
      }),
      invalidatesTags: ["Books"],
    }),

    // Update a book
    updateBook: builder.mutation({
      query: ({ id, ...rest }) => ({
        url: `/updateBook/${id}`,
        method: "PUT",
        body: rest,
        headers: {
          "Content-Type": "application/json",
        },
      }),
      invalidatesTags: ["Books"],
    }),

    // Delete a book
    deleteBook: builder.mutation({
      query: (id) => ({
        url: `/deleteBook/${id}`,
        method: "DELETE",
      }),
      invalidatesTags: ["Books"],
    }),

    searchBooks: builder.query({
      query: (query) => `/search?query=${encodeURIComponent(query)}`,
      providesTags: (result) =>
        result
          ? [
              ...result.map(({ id }) => ({ type: "Books", id })),
              { type: "Books", id: "LIST" },
            ]
          : [{ type: "Books", id: "LIST" }],
    }),
  }),
});
export const {
  useFetchAllBooksQuery,
  useFetchBookByIdQuery,
  useAddBookMutation,
  useUpdateBookMutation,
  useDeleteBookMutation,
  useSearchBooksQuery, 
} = booksApi;

export default booksApi;
