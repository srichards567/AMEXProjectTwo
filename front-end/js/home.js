// =========== DOM MANIPULATION ==================

function showMakeProfile() {
  document.querySelector('.makeProfile').style.display="block";
}

function hideMakeProfile() {
  document.querySelector('.makeProfile').style.display="none";
  showViewProfileBtn();
  hideCreateProfileBtn();
}

function showViewProfileBtn() {
  document.querySelector('.viewProfileBtn').style.display="inline";
}

function hideCreateProfileBtn() {
  document.querySelector('.createProfileBtn').style.display="none";
}

function showViewerProfile() {
  document.querySelector('.userProfile').style.display = "block";
  showUpdateProfileBtn();
}

function hideUserProfile() {
  document.querySelector('.userProfile').style.display = "none";
  document.querySelector('.updateUserProfile').style.display="none";
}

function showUpdateUserProfile() {
  document.querySelector('.updateUserProfile').style.display="block";
}

function hideUpdateProfileBtn() {
  document.querySelector('.updateProfileBtn').style.display="none";
}

function showUpdateProfileBtn() {
  document.querySelector('.updateProfileBtn').style.display="inline";
}

// =========== CREATE A PROFILE ==================
function postUserProfile() {
  const altEmail = document.querySelector('.altEmail');
  const mobile = document.querySelector('.mobile');
  const address = document.querySelector('.address');


  fetch('localhost:8181/profile', {
    method: 'POST',
    headers: {
      "Authorization": "Bearer " + localStorage.getItem('user'),
      "Content-Type": "application/json"
    },
    body: JSON.stringify({
        additionalEmail: altEmail.value,
        mobile: mobile.value,
        address: address.value
    })
  })
  .then((res) =>{
    alert('You have successfully created a profile');
    document.querySelector('.fetchedUserProfile').innerText = res;
    //displayProfile();
  })
  .catch((error) => {
  console.log(error)
  })
}

// =========== UPDATE A PROFILE ==================
// =========== SEE USER POSTS ====================
// =========== SEE USER COMMENTS =================
