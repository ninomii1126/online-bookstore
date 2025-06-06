import { createSlice } from "@reduxjs/toolkit";
import Swal from "sweetalert2";

const initialState = {
  cartItems: [],
};

const cartSlice = createSlice({
  name: "cart",
  initialState: initialState,
  reducers: {
    addToCart: (state, action) => {
      console.log(state.cartItems)
      console.log(action.payload)

      const existingItems = state.cartItems.find(
        (item) => item.id === action.payload.id
      );
      if (!existingItems) {
        state.cartItems.push(action.payload);
        Swal.fire({
          position: "center",
          icon: "success",
          title: "Item is added",
          showConfirmButton: false,
          timer: 1500,
        });
      } else {
        Swal.fire({
          icon: "error",
          title: "Oops...",
          text: "Item already exist!",
        });
      }
    },
    removeFromCart: (state, action) => {
      state.cartItems = state.cartItems.filter(
        (item) => item.id !== action.payload.id
      );
    },
    clearCart: (state) => {
      state.cartItems = [];
    },
  },
});

// export actions
export const { addToCart, removeFromCart, clearCart } = cartSlice.actions;

export default cartSlice.reducer;
