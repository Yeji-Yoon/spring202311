import React, { useState } from 'react';
import { Link } from 'react-router-dom';

const Home = () => {
  const [visiable, setVisible] = useState(false);

  const onClick = () => setVisible(true);

  return (
    <>
      <h1>Home!</h1>
      <Link to="/about">About 페이지 이동</Link>
      <button type="button" onClick={onclick}>
        클릭
      </button>
      {visiable && SVGFEPointLightElement.th}
    </>
  );
};

export default React.memo(Home);
