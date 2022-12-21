import { DivNavbar, Menu, NavLink, TextLogo, DivMenu, Profile } from "./styles";

export default function Navbar() {
  return (
    <DivNavbar>
      <Menu>
        <TextLogo to="/">Project Management</TextLogo>
        <DivMenu>
          <NavLink to="/projects">Projects</NavLink>
          <NavLink to="/contact">Contact</NavLink>
          <NavLink to="/about">About Us</NavLink>
        </DivMenu>
      </Menu>
      <NavLink disabled={true} to="/contact">
        <Profile />
      </NavLink>
    </DivNavbar>
  );
}
