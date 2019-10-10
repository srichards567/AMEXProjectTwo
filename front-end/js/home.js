// =========== SEE ALL POSTS ==================
//
const getAllPosts = function() {
  const postsContainer = document.querySelector('.posts');
  fetch('http://localhost:8181/post/list/all', {
    headers: {
      'Authorization': 'Bearer ' + localStorage.getItem('user'),
      'Content-Type': 'application/json'
    }
  })
  .then((response) => {
    return response.json();
  })
  .then((response) => {
    postsContainer.innerHTML = "";
    for(let i = 0; i < response.length; i++) {
      const newPost = document.createElement('div');
      newPost.classList = 'allPosts';

      const deleteBtn = document.createElement('i');
      deleteBtn.setAttribute("postid", response[i].id);
      deleteBtn.classList = "fa fa-times";
      newPost.append(deleteBtn);


      const title = document.createElement('h2');
      title.innerText = response[i].title;
      newPost.appendChild(title);
      const body = document.createElement('p');
      body.innerText = response[i].body;
      newPost.appendChild(body);
      postsContainer.appendChild(newPost);
    }
  })
  .catch((err) => {
    console.log(err);
  })
}

// =========== DELETE A POST ==================

function requestDeletePost(id) {
  fetch(`http://localhost:8181/post/${id}`, {
      method: 'DELETE',
      headers: {
            "Authorization": "Bearer " + localStorage.getItem('user'),
            "Content-Type": "application/json"
          }
        })
    .then((res) => {
      getAllPosts()
    })
    .catch((error) => {
    console.log(id);
    })
}

// =========== DELETE A COMMENT ==================

function deleteComment() {
  fetch(`http://localhost:8181/comment/{comment_id}`, {
    method: 'DELETE',
    headers: {
      "Authorization" : "Bearer " + localStorage.getItem('user'),
      "Content-Type" : "application/json"
    },
  })
    .then((response) => {
      return response.json();
    })
    .then((response) => {
      const comment = document.querySelector('.comment')
      comment.remove();
    })
    .catch((err) => {
      console.log(err);
    })
}

// =========== LIST MY COMMENTS ==================

const makeCall1 = function() {
fetch(`http://localhost:8181/comment/list`)
  .then((response) => {
    return response.json();
  })
  .then((response) => {
    const list = document.querySelector('.userComments')
    for (let i = 0; i < response.length; i ++) {
      const body = document.createElement('p');

      document.querySelector('.userComments').appendChild(body);
    }
  })
  .catch((err) => {
    console.log(err);
  })
}

const getData1 = function(data) {
  const body = data.commentBody;
}

// =========== DOM MANIPULATION ==================

function showMakeProfile() {
  document.querySelector('.makeProfile').style.display="inline";
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

function showUserProfile() {
  document.querySelector('.userProfile').style.display="inline";
}

function eraseText() {
  document.querySelector('.makePostTitle').value = "";
  document.querySelector('.makePostBody').value = "";
}
// =========== MANIPULATE DOM WITH PROMISE VALUES ==================
function manipulateDom(htmlElementId, res) {
  const targetElement = document.getElementById(htmlElementId);

}
// =========== CREATE A PROFILE ==================
function postUserProfile() {
  const altEmail = document.querySelector('.makeProfileEmail').value;
  const mobile = document.querySelector('.makeProfileMobile').value;
  const address = document.querySelector('.makeProfileAddress').value;

  fetch ('http://localhost:8181/profile', {
    method: 'POST',
    headers : {
      "Authorization" : "Bearer " + localStorage.getItem('user'),
      "Content-Type" : "application/json"
    },
    body: JSON.stringify({
      mobile: mobile,
      address: address,
      altEmail: altEmail
    })
  })
  .then((res) => {
    alert('You have successfully created a profile');
    console.log(res);
  })
  .catch((error) => {
    console.log(error);
  })
}

// =========== GET A PROFILE ==================
function getUserProfile() {
  const userProfile = document.querySelector('.userProfile');

  fetch ('http://localhost:8181/profile', {
    headers : {
      "Authorization" : "Bearer " + localStorage.getItem('user'),
      "Content-Type" : "application/json"
    }
  })
  .then((res) => {
    return(res.json());
  })
  .then((res) => {
    const userAltEmail = document.createElement('p');
    userAltEmail.innerText = "Alt Email: " + res.altEmail;

    const userAddress = document.createElement('p');
    userAddress.innerText = "Address: " + res.address;

    const userMobile = document.createElement('p');
    userMobile.innerText = "Mobile: " + res.mobile;

    userProfile.appendChild(userAltEmail);
    userProfile.appendChild(userAddress);
    userProfile.appendChild(userMobile);
  })
  .catch((error) => {
    console.log(error);
  })
}


// =========== MAKE A POST ==================
function makeUserPost() {
  const postTitle = document.querySelector('.makePostTitle').value;
  const postBody = document.querySelector('.makePostBody').value;

  fetch('http://localhost:8181/post', {
    method: 'POST',
    headers: {
      'Authorization': 'Bearer ' + localStorage.getItem('user'),
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      title: postTitle,
      body: postBody
    })
  })
  .then((res) => {
    alert('Your post was successfuly made!');
    getAllPosts();
  })
  .then((err) => {
    console.log(err);
  })
}
// =========== UPDATE A PROFILE ==================
// =========== SEE USER POSTS ====================
// =========== SEE USER COMMENTS =================
