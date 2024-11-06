/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./index.html",
    "./src/**/*.{js,ts,jsx,tsx}",
  ],
  theme: {
    extend: {
      colors:{
        'primary':'#8BC34A', 
        'secondary':'#0D0842',
        'blackBG':'#F3F3F3',
        'favorite':'#FF5841'
      },
      fontFamily:{
        'primary':["Open Sans", "serif"],
        'secondary':["Numans", "serif"]
      }
    },
  },
  plugins: [],
}

