package callbus.zaritalk.service;

import callbus.zaritalk.dataaccesslayer.entity.Community;
import callbus.zaritalk.dataaccesslayer.payload.request.CommunityWriteRequest;
import callbus.zaritalk.dataaccesslayer.payload.response.MessageResponse;
import callbus.zaritalk.dataaccesslayer.repository.CommunityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommunityService {
    CommunityRepository communityRepository;

    public List<Community> getCommunityList() {
        return communityRepository.findAll();
    }

    public MessageResponse save(CommunityWriteRequest request) {
        communityRepository.save(Community.builder()
                .communityTitle(request.getTitle())
                .communityContent(request.getContent())
                //.userId(user)
                .build());

        return new MessageResponse("Community Writer Ok");
    }

}
