package com.example.amexproject2.controller;

import com.example.amexproject2.model.Comment;
import com.example.amexproject2.service.CommentServiceStub;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CommentControllerTest {

    private CommentController commentController;

    @Before
    public void initializeCommentController() {
        commentController = new CommentController();
        commentController.setCommentService(new CommentServiceStub());
    }

    @Test
    public void createComment_SaveComment_Success(){
        Long dummyPostId = new Long(1);
        Comment comment = new Comment();
        comment.setBody("This is a comment.");

        Comment actualComment = commentController.createComment(dummyPostId, comment);

        Assert.assertNotNull(actualComment);
        Assert.assertEquals(comment.getBody(), actualComment.getBody());

    }
}
