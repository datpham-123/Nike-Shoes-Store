/** @format */

const form_login = document.getElementById('form-login');
const username = document.getElementById('username');
const password1 = document.getElementById('password1');

form_login.addEventListener('submit', (e) => {
  e.preventDefault();
  checkInputs();
});

function checkInputs() {
  const username_value = username.value.trim();
  const password1_value = password1.value.trim();

  if (username_value === '') {
    // show error
    // add error class
    setErrorFor(username, 'user name cannot be blank');
  } else {
    // show success
    // add sucess class
    setSuccessFor(username);
  }

  if (password1_value === '') {
    // show error
    // add error class
    setErrorFor(password1, 'password cannot be blank');
  } else {
    // show success
    // add sucess class
    setSuccessFor(password1);
  }
}

function setErrorFor(input, message) {
  const form_control = input.parentElement;
  const small_text = form_control.querySelector('small');

  // set error text
  small_text.innerText = message;

  // add error class
  form_control.className = 'form-control error';
}

function setSuccessFor(input, message) {
  const form_control = input.parentElement;
  form_control.className = 'form-control success';
}