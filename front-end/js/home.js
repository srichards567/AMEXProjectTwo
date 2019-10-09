//to list all posts
const makeCall = function() {
  fetch(`http://localhost:8181/post/list/all`)
    .then((response) => {
      return response.json();
    })
    .then((response) => {
      const list = document.querySelector('.allPosts')
      for (let i = 0; i < response.length; i++) {
        const title = document.createElement('h2');
        const body = document.createElement('p');
        const comment = document.createElement('input');
        const addComment = document.createElement('button');
        const deleteComment = document.createElement('button');
        const deletePost = document.createElement('button');

        document.querySelector('.allPosts').appendChild(title);
        document.querySelector('.allPosts').appendChild(body);
        document.querySelector('.allPosts').appendChild(comment);
        document.querySelector('.allPost').appendChild(addComment);
        document.querySelector('.allPosts').appendChild(deleteComment);
        document.querySelector('.allPosts').appendChild(deletePost);

        addComment.setAttribute("type", "submit");
        addComment.setAttribute("value", "add");
        deleteComment.setAttribute("type", "submit");
        deleteComment.setAttribute("value", "delete");
      }
    })
    .catch((err) => {
      console.log(err);
    })
}

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

const button = document.querySelector('button');
button.addEventListener('click', makeCall)

//to delete comments
function deleteComment() {
  fetch(`http://localhost:8181/comment/{comment_id}`, {
    method: 'DELETE',
  },
)
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
const makeCall = function() {
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

const getData = function(data) {
  const body = data.commentBody;
}
