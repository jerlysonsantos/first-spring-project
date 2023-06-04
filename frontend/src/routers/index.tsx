import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import { Login } from "../pages/Login";
import { NotFound } from "../pages/NotFound/NotFound";
import { PrivateRouter } from "./PrivateRouter/PrivateRouter";

export const AppRouter = () => (
  <Router>
    <Routes>
      <Route index element={<Login />} />
      <Route
        path="/timesheet"
        element={
          <PrivateRouter>
            <h1></h1>
          </PrivateRouter>
        }
      />
      <Route path="*" element={<NotFound />} />
    </Routes>
  </Router>
);
