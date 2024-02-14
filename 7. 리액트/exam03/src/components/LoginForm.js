import React, { useState, useCallback } from 'react';
import { BigButton as Loginbutton } from './commons/StyledButton';
import { FiLogIn,FiSquare, FiCheckSquare } from "react-icons/fi";

const LoginForm = () => {
    const [saveId, setSaveId] = useState(false);
    const onToggle = useCallback(() => setSaveId((saveId) => !saveId), []);
  return (
    <>
      <h1>로그인</h1>
      <form>
        <input type="text" name="userId" placeholder="아이디" />
        <input type="password" name="password" placeholder="비밀번호" />
        <div onClick={onToggle}>
            {saveId ? <FiCheckSquare/>:<FiSquare/>}아이디 저장
        </div>
        <Loginbutton type="submit" bcolor="primary" color="#fff">
            <FiLogIn/>
          로그인
        </Loginbutton>
      </form>
    </>
  );
};

export default React.memo(LoginForm);
