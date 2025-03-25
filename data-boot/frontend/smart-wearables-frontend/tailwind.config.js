/** @type {import('tailwindcss').Config} */
export default {
  content: [
    "./src/**/*.{js,vue,ts}",
    // other paths
  ],
  theme: {
    extend: {},
  },
  plugins: [require('tailwindcss-primeui')]
}