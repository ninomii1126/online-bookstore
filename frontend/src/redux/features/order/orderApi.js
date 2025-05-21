import { createApi } from "@reduxjs/toolkit/query/react";
import { fetchBaseQuery } from "@reduxjs/toolkit/query/react";
import getBaseUrl from "../../../utils/baseUrl";

const orderApi = createApi({
    reducerPath: 'orderApi',
    baseQuery: fetchBaseQuery({
        baseUrl:`${getBaseUrl()}/api/order`,
        credentials:'include',
    }),
    tagTypes: ['Order'],
    endpoints: (builder) => ({
      // Create order
      createOrder: builder.mutation({
        query: (newOrder) => ({
            url: `/createOrder`,
            method: "POST",
            body: newOrder,
            credentials:"include"
        }),
        providesTags: ["Order"],
      }),

    }),
  });

  export const { useCreateOrderMutation } = orderApi;

  export default orderApi;