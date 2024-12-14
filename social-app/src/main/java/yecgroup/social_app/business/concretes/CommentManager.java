package yecgroup.social_app.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yecgroup.social_app.business.abstracts.CommentService;
import yecgroup.social_app.business.requests.commentRequests.AddCommentRequest;
import yecgroup.social_app.business.responses.commentResponses.GetCommentResponse;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.dataAccess.abstracts.CommentRepository;
import yecgroup.social_app.entities.concretes.Comment;

@Service
@AllArgsConstructor
public class CommentManager implements CommentService {

    private CommentRepository commentRepository;
    private ModelMapperService modelMapperService;

    @Override
    public GetCommentResponse getById(int id) {
        Comment target = commentRepository.findById(id).orElseThrow();

        GetCommentResponse commentResponse = modelMapperService.forResponse().map(target,GetCommentResponse.class);

        return commentResponse;

    }

    @Override
    public void add(AddCommentRequest addCommentRequest) {

        Comment comment = modelMapperService.forRequest().map(addCommentRequest,Comment.class);

        commentRepository.save(comment);

    }

    @Override
    public void delete(int id) {

        commentRepository.deleteById(id);

    }
}
