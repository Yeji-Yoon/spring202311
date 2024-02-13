import { useState, useEffect } from 'react';
import ColorSelect from './ColorSelect';

const Color = () => {
  const [color, setColor] = useState('gray');

  useEffect(() => {
    console.log('색상 변경:', color);

    return () => {
      console.log('렌더링 전 뒷정리...');
    };
  }, [color]);

  const boxStyle = {
    width: '200px',
    height: '200px',
    backgroundColor: color,
  };

  return (
    <>
      <div style={boxStyle}></div>
      <ColorSelect setColor={setColor} />
    </>
  );
};

export default Color;
