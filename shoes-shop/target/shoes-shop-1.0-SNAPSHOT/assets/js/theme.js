/** @format */

const lightTheme = document.getElementById('light');
const darkTheme = document.getElementById('dark');
const body = document.body;

lightTheme.addEventListener('click', changeBodyThemeLight);
darkTheme.addEventListener('click', changeBodyThemeDark);

function changeBodyThemeLight() {
  body.classList.replace('dark', 'light');
}

function changeBodyThemeDark() {
  body.classList.replace('light', 'dark');
}