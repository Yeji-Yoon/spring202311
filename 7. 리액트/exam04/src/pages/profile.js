import React from 'react';
import { useParams } from 'react-router-dom';

const profiles = {
  user01: {
    name: '이이름',
    age: 30,
  },
  user02: {
    name: '김이름',
    age: 20,
  },
};

const Profile = () => {
  const { username } = useParams();
  const { name, age } = profiles[username];
  return (
    <>
      <div>이름 : {name}</div>
      <div>나이 : {age}</div>
    </>
  );
};

export default React.memo(Profile);
