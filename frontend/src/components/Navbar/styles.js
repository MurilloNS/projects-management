import { NavLink as Link } from "react-router-dom";
import styled from "styled-components";
import { FiLogOut } from "react-icons/fi";

export const DivNavbar = styled.div`
  height: 4em;
  width: 100vw;
  background-color: #2f2626;
  display: flex;
  justify-content: center;
  align-items: center;
  padding-right: 3em;
`;

export const Menu = styled.div`
  height: 3em;
  width: 80%;
  display: flex;
  flex-direction: row;
  align-items: center;
`;

export const TextLogo = styled(Link)`
  color: #ffffff;
  font-size: 1.2em;
  font-weight: bold;
  margin-right: 4rem;
  text-decoration: none;
`;

export const DivMenu = styled.div`
  height: 3em;
  width: 60%;
  display: flex;
  flex-direction: row;
  align-items: center;
`;

export const NavLink = styled(Link)`
  color: #ffffff;
  text-decoration: none;
  font-weight: bold;
  ${(props) => (props.disabled ? "padding-left: 0" : "padding-left: 4rem")};

  &.active {
    color: #f39c12;
  }
`;

export const Profile = styled(FiLogOut)`
  height: 1.8em;
  width: 1.8em;
  color: #ffffff;
  cursor: pointer;
`;
