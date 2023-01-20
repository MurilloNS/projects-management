import styled from "styled-components";

export const Container = styled.div`
  height: 100vh;
  width: 100vw;
  background-color: #d5d8dc;
  display: flex;
  flex-direction: column;
  align-items: center;
  padding-top: 4rem;
`;

export const Box = styled.form`
  min-height: 50%;
  max-height: 70%;
  width: 80%;
  background-color: #fff;
  margin-top: 2rem;
`;

export const Title = styled.p`
  font-size: 20px;
  color: orange;
  margin: 0.5rem 0 0 1rem;
`;

export const DivTitle = styled.div`
  min-height: 1rem;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top: 0.5rem;
`;

export const InputTitle = styled.input`
  font-size: 20px;
  color: gray;
  height: 2.5rem;
  width: 90%;
  border-radius: 10px;
  border: 1px solid;
  padding-left: 0.5rem;
  margin-bottom: 1rem;
  max-height: 20rem;
`;

export const InputBody = styled.textarea`
  font-size: 20px;
  color: gray;
  height: 15rem;
  width: 90%;
  border-radius: 10px;
  border: 1px solid;
  padding-left: 0.5rem;
  margin-bottom: 1rem;
`;

export const DivButton = styled.div`
  display: flex;
  justify-content: flex-end;
  align-items: center;
  height: 2rem;
  margin: 1rem 5rem 1rem 0;
`;