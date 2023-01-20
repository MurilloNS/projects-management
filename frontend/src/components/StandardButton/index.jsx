import { Button } from "./styles";

export default function StandardButton({ text, type }) {
  return <Button type={type}>{text}</Button>;
}
