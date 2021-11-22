package com.oburnett127.lms.services;

import com.oburnett127.MyEcomm.model.Comment;

import java.util.List;

public interface CommentOperations {

	Comment createComment(Comment Comment);

	List<Comment> getComments();

	Comment getComment(Integer id);

	Comment updateComment(Comment Comment);

	void deleteComment(Integer id);

}