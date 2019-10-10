//to list all posts
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
    for(let i = 0; i < response.length; i++) {
      const newPost = document.createElement('div');
      newPost.classList = 'allPosts';
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
        //         const list = document.querySelector('.allPosts')
        //         for (let i = 0; i < response.length; i++) {
        //           const title = document.createElement('h2');
        //           const body = document.createElement('p');
        //           const comment = document.createElement('input');
        //           const addComment = document.createElement('button');
        //           const deleteComment = document.createElement('button');
        //           const deletePost = document.createElement('button');
        //
        //           document.querySelector('.allPosts').appendChild(title);
        //           document.querySelector('.allPosts').appendChild(body);
        //           document.querySelector('.allPosts').appendChild(comment);
        //           document.querySelector('.allPost').appendChild(addComment);
        //           document.querySelector('.allPosts').appendChild(deleteComment);
        //           document.querySelector('.allPosts').appendChild(deletePost);
        //
        //           addComment.setAttribute("type", "submit");
        //           addComment.setAttribute("value", "add");
        //           deleteComment.setAttribute("type", "submit");
        //           deleteComment.setAttribute("value", "delete");



const getData = function(data) {
  const title = data.title;
  const body = data.body;
}

function updateDOM(data) {
  const title = document.querySelector('.title');
  const body = document.querySelector('.body');
  const comment = document.querySelector('.comment');

  title.innerText = `Title: ${data.title}`;
  body.innerText = `Body: ${data.body}`;
  comment.innerText = `Comment: ${data.comment}`;
}


//to delete comments
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

//to list user comments
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
// const makeCall = function() {
// fetch(`http://localhost:8181/comment/list`)
//   .then((response) => {
//     return response.json();
//   })
//   .then((response) => {
//     const list = document.querySelector('.userComments')
//     for (let i = 0; i < response.length; i ++) {
//       const body = document.createElement('p');
//
//       document.querySelector('.userComments').appendChild(body);
//     }
//   })
//   .catch((err) => {
//     console.log(err);
//   })
// }
//
// const getData = function(data) {
//   const body = data.commentBody;
// }

// =========== DOM MANIPULATION ==================
//
// function showMakeProfile() {
//   document.querySelector('.makeProfile').style.display="inline";
// }
//
// function hideMakeProfile() {
//   document.querySelector('.makeProfile').style.display="none";
//   showViewProfileBtn();
//   hideCreateProfileBtn();
// }
//
// function showViewProfileBtn() {
//   document.querySelector('.viewProfileBtn').style.display="inline";
// }
//
// function hideCreateProfileBtn() {
//   document.querySelector('.createProfileBtn').style.display="none";
// }
//
// function showViewerProfile() {
//   document.querySelector('.userProfile').style.display = "block";
//   showUpdateProfileBtn();
// }
//
// function hideUserProfile() {
//   document.querySelector('.userProfile').style.display = "none";
//   document.querySelector('.updateUserProfile').style.display="none";
// }
//
// function showUpdateUserProfile() {
//   document.querySelector('.updateUserProfile').style.display="block";
// }
//
// function hideUpdateProfileBtn() {
//   document.querySelector('.updateProfileBtn').style.display="none";
// }
//
// function showUpdateProfileBtn() {
//   document.querySelector('.updateProfileBtn').style.display="inline";
// }

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
    console.log(res);
  })
  .catch((error) => {
    console.log(error);
  })
}

// =========== GET A PROFILE ==================
function getUserProfile() {
  const userProfile = document.querySelector('.fetchedUserProfile');

  fetch ('http://localhost:8181/profile', {
    method: 'GET',
    headers : {
      "Authorization" : "Bearer " + localStorage.getItem('user'),
      "Content-Type" : "application/json"
    }
  })
  .then((res) => {
    return res.json();
  })
  .then((res) => {
    console.log(res);
  })
  .catch((error) => {
    console.log(error);
  })
}



// =========== UPDATE A PROFILE ==================
// =========== SEE USER POSTS ====================
// =========== SEE USER COMMENTS =================
