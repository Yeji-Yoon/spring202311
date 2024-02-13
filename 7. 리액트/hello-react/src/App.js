import { Fragment } from "react";

function App() {
  //const name = undefined;

  const style = {
    backgroundColor : 'orange',
    fontSize: '3rem',
  };

  const name = "이이름";
  return (
    <>
      <h1 class="title" 
      //style={style}
      >안녕하세요!,{name || '기본이름' }</h1>
      {/*name && <h2>반갑습니다.</h2>*/}
      <input type="text"/>
    </>
  );
}

export default App;
