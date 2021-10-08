package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.AdDAO;
import entity.Ad;
import exception.CustomRuntimeException;
import org.apache.log4j.Logger;
import response.AdResponse;
import service.AbstractService;
import service.AdService;
import utils.ReadFileUtils;

import java.util.List;

public class AdServiceImpl extends AbstractService<Ad, AdResponse> implements AdService {

    private static final Logger logger = Logger.getLogger(AdServiceImpl.class);

    private static AdServiceImpl service;

    private AdServiceImpl() {
    }

    public static AdServiceImpl getInstance() {
        if (service == null)
            service = new AdServiceImpl();
        return service;
    }

    @Override
    protected String url() {
        return ReadFileUtils.getPropValues("url.properties", "ad-url");
    }

    @Override
    protected AdResponse convert(ObjectMapper mapper, String responseString) {
        try {
            return mapper.readValue(responseString, AdResponse.class);
        } catch (JsonProcessingException e) {
            logger.error("Convert to AdResponse failure.");
            throw new CustomRuntimeException("Convert to AdResponse failure.");
        }
    }

    @Override
    protected int getTotalPage(AdResponse response) {
        return response.getAdList().getPage_info().getTotal_page();
    }

    @Override
    protected List<Ad> getList(AdResponse response) {
        return response.getAdList().getAds();
    }

    @Override
    public void readData(String accessToken, String advertiser_id) {
        List<Ad> ads = getList(advertiser_id, accessToken);
        AdDAO dao = AdDAO.getInstance();
        dao.save(ads);
    }
}
