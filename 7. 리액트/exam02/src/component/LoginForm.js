import { useState } from 'react';

const LoginForm = () => {
  const [form, setForm] = useState({});

  const onChange = (e) =>
    setForm({ ...form, [e.currentTarget.name]: e.currentTarget.value });

  const onSubmit = (e) => {
    e.preventDefault();
  };

  return (
    <form autoComplete="off" onSubmit={onSubmit}>
      <div>
        userId : {form.userId}, userPw : {form.userPw}
      </div>
      <dl>
        <dt>아이디</dt>
        <dd>
          <input
            type="text"
            name="userId"
            value={form.userId}
            onChange={onChange}
          />
        </dd>
      </dl>
      <dl>
        <dt>비밀번호</dt>
        <dd>
          <input
            type="password"
            name="userPw"
            value={form.userPw}
            onChange={onChange}
          />
        </dd>
      </dl>
      <button type="submit">로그인</button>
    </form>
  );
};

export default LoginForm;
