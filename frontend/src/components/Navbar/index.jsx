import { useState } from "react";
import {
  DivNavbar,
  Menu,
  NavLink,
  TextLogo,
  DivMenu,
  Profile,
  NavToggler,
  NavTogglerClose,
} from "./styles";

export default function Navbar() {
  const [active, setActive] = useState();
  const showActive = () => setActive(!active);

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
      <NavLink disabled to="/signout">
        <Profile />
      </NavLink>
      {!active ? (
        <NavToggler onClick={showActive} />
      ) : (
        <NavTogglerClose onClick={showActive} />
      )}
    </DivNavbar>
  );
}
