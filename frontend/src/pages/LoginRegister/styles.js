import styled from "styled-components";

export const Container = styled.div`
  height: 100vh;
  width: 100vw;
  background-color: #d5d8dc;
  display: flex;
  align-items: center;
  justify-content: center;
`;

export const Box = styled.div`
  background-color: #fff;
  height: 60%;
  width: 60%;
  border-radius: 20px;
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-between;
`;

export const BoxLogin = styled.form`
  height: 100%;
  width: 45%;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 1em 2em;
`;

export const Title = styled.p`
  color: #212f3d;
  font-size: 2em;
  font-weight: bold;
  margin-bottom: 3em;
`;

export const Input = styled.input`
  height: 2.5em;
  width: 100%;
  border-radius: 10px;
  border: 1px solid #abb2b9;
  font-size: 1em;
  padding-left: 1em;
  margin-bottom: 2em;
`;

export const Forget = styled.p`
  font-size: 0.7em;
  color: #21618c;
  margin-bottom: 9em;
`;

export const Button = styled.button`
  height: 2em;
  width: 100%;
  cursor: pointer;
  background: hsla(213, 77%, 14%, 1);

  background: linear-gradient(
    45deg,
    hsla(213, 77%, 14%, 1) 0%,
    hsla(202, 27%, 45%, 1) 100%
  );

  background: -moz-linear-gradient(
    45deg,
    hsla(213, 77%, 14%, 1) 0%,
    hsla(202, 27%, 45%, 1) 100%
  );

  background: -webkit-linear-gradient(
    45deg,
    hsla(213, 77%, 14%, 1) 0%,
    hsla(202, 27%, 45%, 1) 100%
  );

  filter: progid: DXImageTransform.Microsoft.gradient( startColorstr="#08203E", endColorstr="#557C93", GradientType = 1);
  border-radius: 20px;
  border: none;
  color: #fff;
  font-size: 1.5em;
`;

export const Divisor = styled.div`
  height: 90%;
  width: 1px;
  background-color: #212f3d;
`;

export const DivisorRegister = styled.div`
  margin-bottom: 2.7em;
`;