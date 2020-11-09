/** @format */

const form_login = document.getElementById('form-login');
const username = document.getElementById('username');
const email = document.getElementById('email');
const password1 = document.getElementById('password1');
const password2 = document.getElementById('password2');

form_login.addEventListener('submit', (e) => {
  e.preventDefault();
  checkInputs();
});

function checkInputs() {
  const username_value = username.value.trim();
  const email_value = email.value.trim();
  const password1_value = password1.value.trim();
  const password2_value = password2.value.trim();

  if (username_value === '') {
    // show error
    // add error class
    setErrorFor(username, 'user name cannot be blank');
  } else {
    // show success
    // add sucess class
    setSuccessFor(username);
  }

  if (email_value === '') {
    // show error
    // add error class
    setErrorFor(email, 'email cannot be blank');
  } else {
    // show success
    // add sucess class
    setSuccessFor(email);
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

  if (password2_value === '') {
    // show error
    // add error class
    setErrorFor(password2, 'password cannot be blank');
  } else if (password1_value !== password2_value) {
    setErrorFor(password2, 'password does not match');
  } else {
    // show success
    // add sucess class
    setSuccessFor(password2);
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