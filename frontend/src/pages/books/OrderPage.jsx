import React from "react";
import { useGetOrdersByEmailQuery } from "../../redux/features/order/orderApi";
import { useAuth } from "../../context/AuthContext";

const OrderPage = () => {
  const { currentUser } = useAuth();
  const {
    data: orders = [],
    isLoading,
    isError,
  } = useGetOrdersByEmailQuery(currentUser.email);

  if (isLoading) {
    return <div>Loading</div>;
  }

  if (isError) {
    return <div>Error</div>;
  }

  return (
    <div className="container mx-auto p-6">
      <h2 className="text-2x1 font-semibold mb-4">Your Orders</h2>
      {orders.length === 0 ? (
        <div>No order is found.</div>
      ) : (
        <div>
          {orders.map((order, index) => (
            <div key={order.orderId} className="border-b mb-4 pb-4">
            <p className="p-1 bg-secondary text-white w-20 mb-1"> # {index+1}</p>
              <h2 className="font-bold">Order ID : {order.orderId}</h2>
              <p className="text-gray-600">Name : {order.name}</p>
              <p className="text-gray-600">Email : {order.email}</p>
              <p className="text-gray-600">Phone : {order.phone}</p>
              <p className="text-gray-600">Total Price : {order.totalPrice}</p>
              <h3 className="font-semibold mt-2">Address : </h3>
              <p>
                {order.address.city}, {order.address.state},{" "}
                {order.address.country}, {order.address.zipCode}
              </p>
              <h3 className="font-semibold mt-2">
                Product ID : {order.orderId}
              </h3>
              <ul>
                {orders.productList?.map((id) => (
                  <li key={id}>{id}</li>
                ))}
              </ul>

              <h3>Order ID: {order.orderId}</h3>
            </div>
          ))}
        </div>
      )}
    </div>
  );
};

export default OrderPage;
