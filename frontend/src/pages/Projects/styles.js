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

export const ProjectsBox = styled.div`
  min-height: 8rem;
  max-height: 18rem;
  width: 85%;
  margin-top: 2rem;
  background-color: #fff;
  border: 3px solid #999999;
  border-radius: 10px;

  p {
    padding: 0.5rem 1rem;
    overflow-wrap: break-word;
    word-wrap: break-word;
    -webkit-hyphens: auto;
    -ms-hyphens: auto;
    -moz-hyphens: auto;
    hyphens: auto;
  }
`;

export const DivTitleBox = styled.div`
  width: 100%;
  display: flex;
  align-items: center;
  justify-content: space-between;
`;

export const TitleBox = styled.p`
  font-size: 20px;
  font-weight: 500;
  font-family: "Oswald";
  padding-left: 1rem;
`;

export const DivSituation = styled.div`
  width: 17rem;
  height: 2rem;
  display: flex;
  align-items: center;
  margin-right: 1rem;
`;

export const ColorSituationBox = styled.div`
  height: 10px;
  width: 10px;
  background-color: red;
  border-radius: 50%;
`;

export const SituationBox = styled.p`
  font-size: 15px;
`

export const Separator = styled.div`
  border-top: 1px solid gray;
`;

export const DeleteProject = styled.button`
  padding: 0.5rem;
  background-color: #000000;
  color: #fff;
  font-weight: bold;
  border: none;
  border-radius: 10px;
  font-size: 13px;
  cursor: pointer;

  :hover{
    background-color: #fff;
    color: #000;
    transition: .6s;
    border: 1px solid black;
  }
`;

export const DivButton = styled.div`
  margin-top: 2rem;
  margin-right: 37rem;
  display: flex;
`;

export const NavLink = styled(Link)`
  text-decoration: none;
`;