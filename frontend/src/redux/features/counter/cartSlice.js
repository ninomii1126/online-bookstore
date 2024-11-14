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
      const existingItems = state.cartItems.find(
        (item) => item._id === action.payload._id
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
  },
});

// export actions
export const { addToCart } = cartSlice.actions;

export default cartSlice.reducer;
