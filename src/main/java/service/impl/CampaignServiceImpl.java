package service.impl;

import utils.APIUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.CampaignDAO;
import entity.Campaign;
import response.CampaignResponse;
import service.CampaignService;
import utils.ObjectMapperUtils;
import utils.ReadFileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class CampaignServiceImpl implements CampaignService {
    private static CampaignServiceImpl service;

    private CampaignServiceImpl() {
    }

    public static CampaignServiceImpl getInstance() {
        if (service == null)
            service = new CampaignServiceImpl();
        return service;
    }

    @Override
    public void readData(String accessToken, String advertiser_id) {
//        try {
//            ObjectMapper mapper = ObjectMapperUtils.getInstance();
//            String url = ReadFileUtils.getPropValues("url.properties", "campaign-url");
//            List<Campaign> campaigns = mapper.readValue(APIUtils.get(myArgs, url, accessToken), CampaignResponse.class)
//                    .getCampaignList().getCampaigns();
//            CampaignDAO dao = CampaignDAO.getInstance();
//            dao.save(campaigns);
//        } catch (IOException | URISyntaxException e) {
//            e.printStackTrace();
//        }
    }
}
