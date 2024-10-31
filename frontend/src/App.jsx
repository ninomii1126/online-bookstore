
import { Outlet } from 'react-router-dom'
import './App.css'
import Navbar from './components/navbar'


function App() {

  return (
    <>
      <Navbar/>
      <main className='min-h-screen max-w-screen-2x1 mx-auto px-4 py-6 font-primary' >
      <Outlet/>
      </main>
      <footer>footer</footer>
    </>
  )
}

export default App
