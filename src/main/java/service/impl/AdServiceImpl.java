package service.impl;

import utils.APIUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.AdDAO;
import entity.Ad;
import exception.PropertiesNotFoundException;
import response.AdResponse;
import service.AdService;
import utils.ObjectMapperUtils;
import utils.ReadFileUtils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class AdServiceImpl implements AdService {
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
//        try {
//            ObjectMapper mapper = ObjectMapperUtils.getInstance();
//            String url = ReadFileUtils.getPropValues("url.properties", "ad-url");
//            List<Ad> ads = mapper.readValue(APIUtils.get(myArgs, url, accessToken), AdResponse.class).getAdList().getAds();
//            AdDAO dao = AdDAO.getInstance();
//            dao.save(ads);
//        } catch (IOException | URISyntaxException | PropertiesNotFoundException e) {
//            e.printStackTrace();
//        }
    }
}
