package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.entity.Post;
import com.example.demo.repository.CommentRepository;
import com.example.demo.repository.PostRepository;
import com.example.demo.view.Response;
import com.example.demo.view.ResponseBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class PostCommentController {
    public final PostRepository postRepository;
    public final CommentRepository commentRepository;
    public PostCommentController(PostRepository postRepository, CommentRepository commentRepository) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }

    @PostMapping("posts")
    public Response createPost(@RequestBody Post post){

      return  ResponseBuilder.getSuccessResponse(HttpStatus.CREATED,"Post Created Successfully",postRepository.save(post)) ;

    }
    @PostMapping("comments")
    public Post createComment(@RequestBody Comment comment){


            int product_id = comment.getP_id();
            System.out.println(product_id);
        Optional<Post> post1 = postRepository.findById(comment.getP_id());
        Post  updatablePost = post1.get();
        System.out.println(comment.getP_id());
        updatablePost.getComments().add(comment) ;
        return postRepository.save(updatablePost);






//
//        updatablePost.setComment((List<Comment>) comment);

//            Optional<Post> post1 = postRepository.findById(comment.getP_id());
//        System.out.println(post1);
//
//                Post  updatablePost = post1.get();
//                commentRepository.save(comment);
//                updatablePost.setComment((List<Comment>) comment);
//        System.out.println(updatablePost);
//                return postRepository.save(updatablePost);




//        return   commentRepository.save(comment);

    }
}
