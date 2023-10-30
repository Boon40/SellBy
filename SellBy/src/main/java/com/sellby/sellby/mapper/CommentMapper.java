package com.sellby.sellby.mapper;

import com.sellby.sellby.model.entity.Comment;
import com.sellby.sellby.model.request.CommentRequest;
import com.sellby.sellby.model.response.CommentResponse;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {
    public CommentResponse toResponse(Comment comment){
        return new CommentResponse(
            comment.GetId(),
            comment.GetRating(),
            comment.GetDescription(),
            comment.GetSender(),
            comment.GetReceiver()
        );
    }

    public Comment toEntity(CommentRequest request){
        return new Comment(
                request.getRating(),
                request.getDescription(),
                request.getSender(),
                request.getReceiver()
        );
    }
}
