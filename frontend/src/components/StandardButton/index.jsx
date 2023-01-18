import { Button } from "./styles";

export default function StandardButton({ to, text }) {
  return <Button to={to}>{text}</Button>;
}
