package service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.CampaignDAO;
import entity.Campaign;
import response.CampaignResponse;
import service.CampaignService;
import utils.APIUtils;
import utils.ObjectMapperUtils;
import utils.ReadFileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class CampaignServiceImpl implements CampaignService {
    private static final long PAGE_SIZE = 20;
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
        try {
            String url = ReadFileUtils.getPropValues("url.properties", "campaign-url");
            List<Campaign> campaigns = getCampaignList(advertiser_id, accessToken, url);
            CampaignDAO dao = CampaignDAO.getInstance();
            dao.save(campaigns);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<Campaign> getCampaignList(String advertiser_id, String accessToken, String url) {
        int currentPage = 1;
        int totalPage = 1;
        List<Campaign> result = new ArrayList<>();
        ObjectMapper mapper = ObjectMapperUtils.getInstance();
        do {
            String args = String.format("{\"advertiser_id\": \"%s\", \"page_size\": \"%s\", \"page\": \"%s\"}"
                    , advertiser_id, PAGE_SIZE, currentPage);
            try {
                CampaignResponse response = mapper.readValue(APIUtils.get(args, url, accessToken), CampaignResponse.class);
                totalPage = response.getCampaignList().getPage_info().getTotal_page();
                result.addAll(response.getCampaignList().getCampaigns());
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
            currentPage++;
        } while (currentPage <= totalPage);
        return result;
    }
}
