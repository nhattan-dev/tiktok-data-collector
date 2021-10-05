package service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.AdDAO;
import entity.Ad;
import exception.PropertiesNotFoundException;
import response.AdResponse;
import service.AdService;
import utils.APIUtils;
import utils.ObjectMapperUtils;
import utils.ReadFileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class AdServiceImpl implements AdService {
    private static final long PAGE_SIZE = 20;
    private static AdServiceImpl service;

    private AdServiceImpl() {
    }

    public static AdServiceImpl getInstance() {
        if (service == null)
            service = new AdServiceImpl();
        return service;
    }

    @Override
    public void readData(String accessToken, String advertiser_id) {
        try {
            String url = ReadFileUtils.getPropValues("url.properties", "ad-url");
            List<Ad> ads = getAdList(advertiser_id, accessToken, url);
            AdDAO dao = AdDAO.getInstance();
            dao.save(ads);
        } catch (IOException | PropertiesNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<Ad> getAdList(String advertiser_id, String accessToken, String url) {
        int currentPage = 1;
        int totalPage = 1;
        List<Ad> result = new ArrayList<>();
        ObjectMapper mapper = ObjectMapperUtils.getInstance();
        do {
            String args = String.format("{\"advertiser_id\": \"%s\", \"page_size\": \"%s\", \"page\": \"%s\"}"
                    , advertiser_id, PAGE_SIZE, currentPage);
            try {
                AdResponse response = mapper.readValue(APIUtils.get(args, url, accessToken), AdResponse.class);
                totalPage = response.getAdList().getPage_info().getTotal_page();
                result.addAll(response.getAdList().getAds());
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
            currentPage++;
        } while (currentPage <= totalPage);
        return result;
    }
}
