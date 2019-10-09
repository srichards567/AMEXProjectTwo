function loginUser() {
    // LOGIN USER USING THE CREDENTIALS
    const userName = document.querySelector('.loginUsername').value;
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
                window.location.href = "index.html";
            }
        })
        .catch((error) => {
            console.log(error);
        })
}
