import { createSlice } from '@reduxjs/toolkit'

const initialState = {
  cartItems: [],
}

const cartSlice = createSlice({
    name: 'cart',
    initialState:initialState,
    reducers:{
        addToCart:(state, action)=>{
             const existingItems = state.cartItems.find(item => 
                item._id===action.payload._id
    
             ) 
             if(!existingItems){
                state.cartItems.push(action.payload)
                alert("Item is added sucessfully!")
                
            }else{
                alert("Item already exist!")
            }
        }
    }
})

// export actions
export const {addToCart} = cartSlice.actions

export default cartSlice.reducer