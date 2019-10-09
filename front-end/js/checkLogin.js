window.onload = (event) => {
  checkLogin();
};

function checkLogin() {
  if (localStorage.getItem('user') != null) {
    const navItem = document.querySelector('nav').lastElementChild;
    navItem.innerText = "Welcome, " + localStorage.getItem('username');
    navItem.href = "home.html";
  }
}
