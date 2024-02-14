import styled from 'styled-components';
import { buttonSizes, fontSiezes } from '../../styles/size';

const { small, medium, big } = buttonSizes;
const { small: fSmall, medium: fMedium, big: fBig } = fontSiezes;

export const SmallButton = styled.button`
  width: ${small.width}px;
  height: ${small.height}px;
  font-size: ${fSmall}rem;
`;

export const MediumButton = styled.button`
  width: ${medium.width}px;
  height: ${medium.height}px;
  font-size: ${fMedium}rem;
`;

export const BigButton = styled.button`
  width: ${big.width}px;
  height: ${big.height}px;
  font-size: ${fBig}rem;
`;
