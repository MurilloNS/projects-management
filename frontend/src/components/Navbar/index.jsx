import { useState } from "react";
import {
  DivNavbar,
  Menu,
  NavLink,
  TextLogo,
  DivMenu,
  Profile,
  User,
  NavToggler,
  NavTogglerClose,
} from "./styles";

export default function Navbar() {
  const [active, setActive] = useState();
  const showActive = () => setActive(!active);

  const logout = () => {
    localStorage.clear();
    window.location.reload(true);
  };

  return (
    <DivNavbar>
      <Menu>
        <TextLogo to="/">Project Management</TextLogo>
        <DivMenu show={active}>
          <NavLink to="/projects">Projects</NavLink>
          <NavLink to="/contact">Contact</NavLink>
          <NavLink to="/about">About Us</NavLink>
        </DivMenu>
      </Menu>
      {localStorage.getItem("token") ? (
        <Profile type="button" onClick={logout} />
      ) : (
        <NavLink to="/login">
          <User />
        </NavLink>
      )}
      {!active ? (
        <NavToggler onClick={showActive} />
      ) : (
        <NavTogglerClose onClick={showActive} />
      )}
    </DivNavbar>
  );
}
