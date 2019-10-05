# AMEXProjectTwo

# Team Members
Christine Le(<a href="https://github.com/le-christine">@le-christine</a>)<br/>
Samantha Richards(<a href="https://github.com/srichards567">@srichards567</a>)

# Technologies Used
- PostgreSQL
- Springboot
- Java
- HTML/CSS/JavaScript

# General Approach


# Unsolved Problems

# Planning
<img src = "images/erd-v2.jpg" width="500"/><br/>
Six models are persisted to a PostgreSQL database.<br/>
The `user` model has the fields: id, username, password, email, and user_profile_id.<br/>
The `user_profile` model has the fields: id, mobile, address, and altEmail. <br/>
The `user` maps `user_profile` one-to-one and vice versa because each user has only one user profile.<br/>
The `posts` model has the fields id, title, and body. <br/>
The model `user_post` joins user.id and posts.id and holds information about each post's creator. The `user_post` maps to `user` on a zero-or-one relationship because it will contain only one user's user_id whereas `user` maps to `user_post` on a zero-to-many relationship because a user may have zero or more than one post. <br/>
The `comments` model has the fields id, body.<br/>
There are two join models, `user_post` and `user_comment`.<br/>

# Installation Instructions

# User Stories
