import { Routes, Route } from 'react-router-dom';
import About from './pages/About';
import Home from './pages/Home';
import profile from './pages/profile';

const App = () => {
  return (
    <Routes>
      <Route path="/" element={<Home />} />
      <Route path="/about" element={<About />} />
      <Route path="/profile/username" element={<profile />} />
    </Routes>
  );
};

export default App;
