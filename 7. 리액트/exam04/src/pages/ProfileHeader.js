import React from 'react';
import { Outlet } from 'react-router-dom';

const ProfileHeader = () => {
  return (
    <>
      <h1>프로필 상단 공통</h1>
      <Outlet />
    </>
  );
};

export default React.memo(ProfileHeader);
