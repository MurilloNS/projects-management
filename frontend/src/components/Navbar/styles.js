import { NavLink as Link } from "react-router-dom";
import styled from "styled-components";
import { FiLogOut } from "react-icons/fi";
import { BsList, BsXLg } from "react-icons/bs";

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

  @media screen and (max-width: 370px){
    font-size: 1em;
  }
`;

export const DivMenu = styled.div`
  height: 3em;
  width: 60%;
  display: flex;
  flex-direction: row;
  align-items: center;

  @media screen and (max-width: 900px) {
    position: fixed;
    top: 7vh;
    right: 0;
    width: 50%;
    height: 93vh;
    background-color: #1c2833;
    flex-direction: column;
    transform: ${(props) =>
      props.show ? "translateX(0)" : "translateX(100%)"};
    transition: 0.3s;
  }
`;

export const NavLink = styled(Link)`
  color: #ffffff;
  text-decoration: none;
  font-weight: bold;
  ${(props) => (props.disabled ? "padding-left: 0" : "padding-left: 4rem")};

  &.active {
    color: #f39c12;
  }

  @media screen and (max-width: 900px) {
    margin-top: 2vh;
    padding-left: 0;
  }
`;

export const Profile = styled(FiLogOut)`
  height: 1.8em;
  width: 1.8em;
  color: #ffffff;
  cursor: pointer;

  @media screen and (max-width: 900px){
    margin-left: -1em;
    margin-bottom: 1.5em;
  }
`;

export const NavToggler = styled(BsList)`
  color: #fff;
  height: 2rem;
  width: 2rem;
  cursor: pointer;
  display: none;

  @media screen and (max-width: 900px) {
    display: block;
    position: absolute;
    top: 0;
    right: 0;
    transform: translate(-100%, 75%);
    cursor: pointer;
    margin-top: -0.5em;
  }
`;

export const NavTogglerClose = styled(BsXLg)`
  color: #fff;
  height: 1.4rem;
  width: 1.4rem;
  cursor: pointer;
  display: none;

  @media screen and (max-width: 900px) {
    display: block;
    position: absolute;
    top: 0;
    right: 0;
    transform: translate(-170%, 125%);
    cursor: pointer;
  }
`;
