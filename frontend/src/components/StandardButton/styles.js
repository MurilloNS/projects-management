import styled from "styled-components";

export const Button = styled.button`
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
  cursor: pointer;
  border: none;

  :hover {
    background-color: #000;
    color: #f39c12;
    transition: 0.2s;
    height: 2.7rem;
    width: 11rem;
    border-radius: 20px;
  }
`;
