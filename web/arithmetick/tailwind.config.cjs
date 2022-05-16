const config = {
  content: ["./src/**/*.{html,js,svelte,ts}"],

  theme: {
    extend: {
      colors: { 
        level3blue: {
          DEFAULT: '#0081B5',
          50: '#6ED5FF',
          100: '#59CFFF',
          200: '#30C4FF',
          300: '#08B8FF',
          400: '#009EDE',
          500: '#0081B5',
          600: '#00597D',
          700: '#003145',
          800: '#00090D',
          900: '#000000'
        },
        level3yellow: {  
          DEFAULT: '#DCE36E',  
          50: '#FFFFFF',  
          100: '#FDFDF7',  
          200: '#F5F7D5',  
          300: '#EDF0B2',  
          400: '#E4EA90', 
          500: '#DCE36E', 
          600: '#D1DA3F', 
          700: '#B3BC24', 
          800: '#878D1B', 
          900: '#5A5E12'},
      }
    },
  },

  plugins: [require("daisyui")],
};

module.exports = config;
