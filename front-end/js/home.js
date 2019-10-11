// =========== SEE ALL POSTS ==================
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
      if (response[i].user.username == localStorage.getItem('username')) {
        localStorage.setItem('userId', response[i].user.id);
      }

      const newPost = document.createElement('div');
      newPost.classList = 'allPosts';
      newPost.setAttribute('postid', response[i].id);


      const title = document.createElement('h2');
      title.innerText = response[i].title;

      const body = document.createElement('p');
      body.innerText = response[i].body;

      const createComment = document.createElement('div');
      createComment.classList = "createCommentBtn";
      createComment.addEventListener("click", showMakeComment);


      if (response[i].user.id == localStorage.getItem('userId')
    || response[i].user == localStorage.getItem('userId')) {
      const deleteBtn = document.createElement('i');
      deleteBtn.classList = "fa fa-times";

      deleteBtn.addEventListener('click', function(event) {
          event.preventDefault();
            requestDeletePost(event);
          })
      newPost.append(deleteBtn);
      }

      newPost.appendChild(createComment);

      newPost.appendChild(title);
      newPost.appendChild(body);

      if (response[i].comments.length) {
        for (let j = 0; j<response[i].comments.length; j++) {
          const commentsBox = document.createElement('div');
          commentsBox.classList = "postsComments";
          commentsBox.innerText = response[i].comments[j].body;
          newPost.appendChild(commentsBox);
        }
      }

      const commentArea = document.createElement('div');
      commentArea.classList.add('commentHere');
      commentArea.classList.add(response[i].id);

      const commentBox = document.createElement('textarea');
      const triangle = document.createElement('div');

      commentBox.classList.add("makeComment");

      const submitPostComment = document.createElement('button');
      submitPostComment.classList = "submitComment";
      submitPostComment.innerText = "Comment!";
      triangle.classList = "triangle";

      commentArea.append(commentBox, submitPostComment);
      postsContainer.append(newPost,triangle,commentArea);
    }
  })
  .catch((err) => {
    console.log(err);
  })
}

// =========== DELETE A POST ==================

function requestDeletePost(event) {
  const id = event.target.parentNode.getAttribute('postid');
  fetch(`http://localhost:8181/post/${id}`, {
      method: 'DELETE',
      headers: {
            "Authorization": "Bearer " + localStorage.getItem('user'),
            "Content-Type": "application/json"
          }
        })
    .then((res) => {
      getAllPosts();
    })
    .catch((error) => {
      console.log(error);
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

function showMakeComment() {

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
  .catch((err) => {
    console.log(err);
  })
}
// =========== UPDATE A PROFILE ==================
// =========== SEE USER POSTS ====================
