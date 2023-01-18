import styled from "styled-components";
import { NavLink as Link } from "react-router-dom";

export const Button = styled(Link)`
  height: 2.5rem;
  width: 10rem;
  background-color: #f39c12;
  color: #000;
  display: flex;
  align-items: center;
  justify-content: center;
  text-decoration: none;
  font-weight: bold;
  font-size: 18px;
  border-radius: 5px;

  :hover {
    background-color: #000;
    color: #f39c12;
    transition: .2s;
    height: 2.7rem;
    width: 11rem;
    border-radius: 20px;
  }
`;
