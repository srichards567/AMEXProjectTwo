function loginUser() {
    // LOGIN USER USING THE CREDENTIALS
    const userName = document.querySelector('.loginUsername').value;
    localStorage.setItem('username', userName);
    const userPassword = document.querySelector('.loginPassword').value;
    fetch('http://localhost:8181/login', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            username: userName,
            password: userPassword
        })
    })
    // CHECK IF USER EXISTS? IF NO, POST ERROR
    // ALSO REFRESH TO LANDING PAGE
        .then((res) => {
            return res.json();
        })
        .then((res) => {
            localStorage.setItem('user', res.token);
            if (res.token) { // DO I GET A RESPONSE? IF YES:
                console.log(localStorage.getItem('user'));
                window.location.href = "home.html";
            }
        })
        .catch((error) => {
            console.log(error);
        })
}

function comparePasswords() {
  const userPassword = document.querySelector('.signupPassword').value;
  const confirmPassword = document.querySelector('.reEnterPassword').value;
  if (userPassword == confirmPassword) {
    return confirmPassword;
  } else {
    alert("Passwords do not match. Please re-enter.")
  }
}

function userSignup() {
  const userEmail = document.querySelector('.signupEmail').value;
  const userName = document.querySelector('.signupUsername').value;

    localStorage.setItem('username', userName);
  // comparePasswords();
  const signupPassword = comparePasswords();

  fetch('http://localhost:8181/signup',{
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify({
        email: userEmail,
        username: userName,
        password: signupPassword
      })
  })
    .then((res) => {
      return res.json();
    })
    .then((res) => {
      localStorage.setItem('user', res.token);
      if (res.token) { // DO I GET A RESPONSE? IF YES:
          console.log(localStorage.getItem('user'));
          window.location.href = "index.html";
      }
  })
  .catch((error) => {
      console.log(error);
  })
}
