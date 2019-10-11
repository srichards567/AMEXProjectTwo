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

We used Trello to break down the project and set tasks for ourselves on a daily basis.<br/>
Link to Trello Board: https://trello.com/b/AlYHVCIu/project-2
# Installation Instructions

# User Stories
1. As Paul, I want to make an account on Tea Room so I can be a member of the online community. 
2. As a psych major, I want to read users' opinions on the latest topics so I can get inspiration for my research.
3. As Sally, I want to create a comment in response to a post so I can get clarification on what the author meant.
4. As a job seeker I want to delete a post so that my potential employer does not see my NSFW posts.


