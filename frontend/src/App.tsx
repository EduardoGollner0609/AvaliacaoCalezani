import './App.css'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import Page from './routes/page'
import HomePage from './routes/page/homepage'

function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Page />}>
          <Route index element={<HomePage />} />
        </Route>
      </Routes>
    </BrowserRouter>
  )
}

export default App
