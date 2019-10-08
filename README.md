# AMEXProjectTwo

# Team Members
Christine Le (<a href="https://github.com/le-christine">@le-christine</a>)<br/>
Samantha Richards (<a href="https://github.com/srichards567">@srichards567</a>)

# Technologies Used
- PostgreSQL
- Springboot
- Java
- HTML/CSS/JavaScript

# General Approach


# Unsolved Problems

# Planning
<img src = "images/erd-v4.png" width="500"/><br/>
Six models are persisted to a PostgreSQL database.<br/>
The `user` model has the fields: id, username, password, email, and user_profile_id.<br/>
The `user_profile` model has the fields: id, mobile, address, and altEmail. <br/>
The `user` maps `user_profile` one-to-one and vice versa because each user has only one user profile.<br/>
The `post` model has the fields id, title, user_id and body. This model maps to `user` many-to-one on user.user_profile_id = post.user_id because many posts can belong to one user.<br/>
The `comment` model has the fields id, body, post_id, and user_id. This model maps `user` many-to-one because many comments can have one user. `User` maps `comment` one-to-one because only one user belongs to a comment. `Comment` maps `post` many-to-one because one post can have many comments. <br/>

We used Trello to break down the project and set tasks for ourselves on a daily basis.
Link to Trello Board: https://trello.com/b/AlYHVCIu/project-2
# Installation Instructions

# User Stories
