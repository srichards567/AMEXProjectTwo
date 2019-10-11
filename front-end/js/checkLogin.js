window.onload = (event) => {
  checkLogin();
};

function checkLogin() {
  if (localStorage.getItem('user') != null) {
    const navBar = document.querySelector('nav');
    const navItem = navBar.lastElementChild;
    navItem.innerText = "Welcome, " + localStorage.getItem('username');
    navItem.href = "home.html";

    const logout = document.createElement('a');
    logout.href="#";
    logout.innerText = "Log Out";
    logout.addEventListener("click", removeUserInfo);
    navBar.appendChild(logout);
  }
}

function removeUserInfo() {
  if (confirm("Are you sure you want to log out?")) {
    localStorage.removeItem('user');
    localStorage.removeItem('username');
    localStorage.removeItem('userId');
    window.location.href = "index.html";
  }
}
