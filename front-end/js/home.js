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
      const author = document.createElement('h3');
      author.innerText = "Posted by: " + response[i].user.username;


      const createComment = document.createElement('div');
      createComment.classList = "createCommentBtn";
      createComment.addEventListener("click", function(event) {
        event.preventDefault();
        showMakeComment(event);
      });


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

      newPost.append(createComment, title, author, body);

      if (response[i].comments.length) {
        for (let j = 0; j<response[i].comments.length; j++) {
          const commentsBox = document.createElement('div');
          commentsBox.classList = "postsComments";
          commentsBox.setAttribute("commentId", response[i].comments[j].id);
          if (response[i].comments[j].body) {
            commentsBox.innerText = `[${response[i].comments[j].user.username}] : ${response[i].comments[j].body}`;
          }
          if (response[i].comments[j].user.username==localStorage.getItem('username')) {
            const deleteBtn = document.createElement('i');
            deleteBtn.classList = "commentDelete fa fa-times";
            deleteBtn.addEventListener('click', function(event) {
              event.preventDefault();
              requestDeleteComment(event);
            });
            commentsBox.appendChild(deleteBtn);
          }
          newPost.appendChild(commentsBox);
        }
      }


      const commentArea = document.createElement('div');
      commentArea.classList.add('commentHere');
      commentArea.setAttribute("postCommentId", response[i].id);

      const commentBox = document.createElement('textarea');
      const triangle = document.createElement('div');

      commentBox.classList.add("makeComment");

      const submitPostComment = document.createElement('button');
      submitPostComment.classList = "submitComment";
      submitPostComment.innerText = "Comment!";
      submitPostComment.addEventListener("click", function(event) {
        event.preventDefault();
        requestPostComment(event);
      });
      triangle.classList = "triangle";

      commentArea.append(triangle, commentBox, submitPostComment);
      postsContainer.append(newPost, commentArea);
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

const listUserComments = function() {
  const commentsContainer = document.querySelector('.posts')
fetch(`http://localhost:8181/comment/list`, {
  headers: {
    'Authorization': 'Bearer ' + localStorage.getItem('user'),
    'Content-Type': 'application/json'
  }
})
  .then((response) => {
    return response.json();
  })
  .then((response) => {
    commentsContainer.innerHTML = "";
    for(let i = 0; i < response.length; i ++) {

      const newComment = document.createElement('div');
      newComment.classList = 'userComments';
      newComment.setAttribute('commentid', response[i].id);

      const body = document.createElement('ul');
      body.innerText = response[i].body;

        newComment.appendChild(body);
        commentsContainer.appendChild(newComment);

      }
  })
  .catch((err) => {
    console.log(err);
  })
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

function showMakeComment(event) {
  const commentBoxId = event.target.parentNode.getAttribute('postid');
  // document.querySelector((`[commentBoxId="${postId}"]`)).innerHTML="";
  document.querySelector((`[postid="${commentBoxId}"]`)).style.width = "500px";
  document.querySelector((`[postcommentid ="${commentBoxId}"]`)).style.display="inline-block"
  // document.querySelector(`.makeComment ${commentBoxId}`).style.display = 'inline-block';
  document.querySelector('.triangle').style.display = 'inline-block';
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
    return res.json();
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

const listUserPosts = function() {
  const userPostsContainer = document.querySelector('.posts')
  fetch('http://localhost:8181/post/list', {
    headers: {
      'Authorization': 'Bearer ' + localStorage.getItem('user'),
      'Content-Type': 'application/json'
    }
  })
  .then((response) => {
    return response.json();
  })
  .then((response) => {
    userPostsContainer.innerHTML = "";
    for(let i = 0; i < response.length; i ++) {

      const userPost = document.createElement('div');
      userPost.classList = 'userPosts';
      userPost.setAttribute('postId', response[i].id);

      const postTitle = document.createElement('h2');
      postTitle.innerText = response[i].title;

      const postBody = document.createElement('p');
      postBody.innerText = response[i].body;

      userPost.appendChild(postTitle);
      userPost.appendChild(postBody);

      userPostsContainer.appendChild(userPost);
    }
  })
  .catch((err) => {
    console.log(err);
  })
}

// =========== MAKE COMMENT =================

function requestPostComment(event) {
  const postId = event.target.parentNode.getAttribute('postCommentId');
  const postComment = event.target.parentNode.children[1].value;

  fetch(`http://localhost:8181/comment/${postId}`, {
    method: 'POST',
    headers: {
      'Authorization': 'Bearer ' + localStorage.getItem('user'),
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      body: postComment
    })
  })
  .then((res) => {
    getAllPosts();
  })
  .catch((err) => {
    console.log(err);
  })
}

// =========== DELETE A COMMENT =================
function requestDeleteComment(event) {
  const commentIdToDelete = event.target.parentNode.getAttribute('commentid');

  fetch(`http://localhost:8181/comment/${commentIdToDelete}`, {
    method: 'DELETE',
    headers: {
      'Authorization': 'Bearer ' + localStorage.getItem('user'),
      'Content-Type': 'application/json'
    }
  })
  .then((res) => {
    alert('Your comment has been deleted!');
    getAllPosts();
  })
  .catch((err) => {
    console.log(err);
  })
}
