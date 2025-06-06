import { createBrowserRouter } from "react-router-dom";
import App from "../App";
import Home from "../pages/home/Home";
import Login from "../components/Login";
import Register from "../components/Register";
import Cart from "../pages/books/Cart";
import CheckoutPage from "../pages/books/CheckoutPage";
import SingleBook from "../pages/books/SingleBook";
import PrivateRoute from "./PrivateRoute";
import OrderPage from "../pages/books/OrderPage";
import AdminRoute from "./AdminRoute";
import AdminLogin from "../components/AdminLogin";

const router = createBrowserRouter([
  {
    path: "/",
    element: <App />,
    children: [
      {
        path: "/",
        element: <Home />,
      },
      {
        path: "/orders",
        element: <PrivateRoute><OrderPage /></PrivateRoute>,
      },
      {
        path: "/admin",
        element: <AdminLogin/>,
      },
      {
        path: "/cart",
        element: <Cart/>,
      },
      {
        path: "/login",
        element: <Login />,
      },
      {
        path: "/register",
        element: <Register />,
      },
      {
        path: "/checkout",
        element: <PrivateRoute><CheckoutPage /></PrivateRoute>,
      },
      {
        path: "/books/:id",
        element: <SingleBook/>
      },
      {
        path: "/dashboard",
        element: <AdminRoute><div>Admin Dashboard</div></AdminRoute>,
        children:[
          {
            path:"",
            element: <AdminRoute><div>Dashboard home</div></AdminRoute>
          },
          {
            path:"add-new-book",
            element: <AdminRoute><div>add a new book</div></AdminRoute>

          },
          {
            path:"edit-book/:id",
            element: <AdminRoute><div>edit book</div></AdminRoute>

          },
          {
            path:"manage-books",
            element: <AdminRoute><div>manage book</div></AdminRoute>

          },
        ]
      }
    ],
  },
]);

export default router;
