package yecgroup.social_app.business.concretes;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import yecgroup.social_app.business.abstracts.ReplyService;
import yecgroup.social_app.business.requests.replyRequests.AddReplyRequest;
import yecgroup.social_app.business.responses.replyResponses.GetReplyResponse;
import yecgroup.social_app.core.utilities.mapper.modelMapper.ModelMapperService;
import yecgroup.social_app.dataAccess.abstracts.ReplyRepository;
import yecgroup.social_app.entities.concretes.Reply;

@Service
@AllArgsConstructor
public class ReplyManager implements ReplyService {

    private ReplyRepository replyRepository;
    private ModelMapperService modelMapperService;

    @Override
    public GetReplyResponse getById(int id) {
        Reply target = replyRepository.findById(id).orElseThrow();

        GetReplyResponse replyResponse = modelMapperService.forResponse().map(target,GetReplyResponse.class);

        return replyResponse;

    }

    @Override
    public void add(AddReplyRequest addReplyRequest) {

        Reply reply = modelMapperService.forRequest().map(addReplyRequest,Reply.class);

        replyRepository.save(reply);

    }

    @Override
    public void delete(int id) {

        replyRepository.deleteById(id);
    }
}
