import { configureStore } from '@reduxjs/toolkit'
import cartReducer from "./features/counter/cartSlice.js"

export const store = configureStore({
  reducer: {
    cart: cartReducer
  },
})

// The Redux store is created using the configureStore function from Redux Toolkit. 
// configureStore requires that we pass in a reducer argument.

