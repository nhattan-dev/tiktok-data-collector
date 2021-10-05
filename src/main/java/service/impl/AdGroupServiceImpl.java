package service.impl;

import utils.APIUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.AdGroupDAO;
import entity.AdGroup;
import response.AdgroupResponse;
import service.AdGroupService;
import utils.ObjectMapperUtils;
import utils.ReadFileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class AdGroupServiceImpl<T> implements AdGroupService {
    private static final long PAGE_SIZE = 20;
    private static AdGroupServiceImpl service;

    private AdGroupServiceImpl() {
    }

    public static AdGroupServiceImpl getInstance() {
        if (service == null)
            service = new AdGroupServiceImpl();
        return service;
    }

    @Override
    public void readData(String accessToken, String advertiser_id) {
        try {
            String url = ReadFileUtils.getPropValues("url.properties", "adgroup-url");
            List<AdGroup> adGroups = getAdGroupList(advertiser_id, accessToken, url);
            AdGroupDAO dao = AdGroupDAO.getInstance();
            dao.save(adGroups);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private List<AdGroup> getAdGroupList(String advertiser_id, String accessToken, String url) {
        int currentPage = 1;
        int totalPage = 1;
        List<AdGroup> result = new ArrayList<>();
        ObjectMapper mapper = ObjectMapperUtils.getInstance();
        do {
            String args = String.format("{\"advertiser_id\": \"%s\", \"page_size\": \"%s\", \"page\": \"%s\"}"
                    , advertiser_id, PAGE_SIZE, currentPage);
            try {
                AdgroupResponse response = mapper.readValue(APIUtils.get(args, url, accessToken), AdgroupResponse.class);
                totalPage = response.getAdGroupList().getPage_info().getTotal_page();
                result.addAll(response.getAdGroupList().getAdGroups());
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
            currentPage++;
        } while (currentPage <= totalPage);
        return result;
    }
}
