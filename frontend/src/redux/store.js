import { configureStore } from '@reduxjs/toolkit'
import cartReducer from "./features/counter/cartSlice.js"
import booksApi from './features/counter/booksApi.js'


export const store = configureStore({
  reducer: {
    cart: cartReducer,
    [booksApi.reducerPath]: booksApi.reducer,
  },
  middleware: (getDefaultMiddleware) =>
    getDefaultMiddleware().concat(booksApi.middleware),
})


