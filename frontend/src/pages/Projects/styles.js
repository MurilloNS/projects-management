import styled from "styled-components";
import { NavLink as Link } from "react-router-dom";

export const Container = styled.div`
  height: 100vh;
  width: 100vw;
  padding-left: 15rem;
  background-color: #d5d8dc;
  display: flex;
  flex-direction: column;
  padding-top: 4rem;
`;

export const DivButton = styled.div`
  margin-top: 2rem;
  margin-right: 37rem;
  display: flex;
`;

export const NavLink = styled(Link)`
  text-decoration: none;
`;