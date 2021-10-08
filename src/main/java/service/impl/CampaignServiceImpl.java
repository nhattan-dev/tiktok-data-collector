package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.CampaignDAO;
import entity.Campaign;
import exception.CustomRuntimeException;
import org.apache.log4j.Logger;
import response.CampaignResponse;
import service.AbstractService;
import service.CampaignService;
import utils.ReadFileUtils;

import java.util.List;

public class CampaignServiceImpl extends AbstractService<Campaign, CampaignResponse> implements CampaignService {

    private static final Logger logger = Logger.getLogger(CampaignServiceImpl.class);

    private static CampaignServiceImpl service;

    private CampaignServiceImpl() {
    }

    public static CampaignServiceImpl getInstance() {
        if (service == null)
            service = new CampaignServiceImpl();
        return service;
    }

    @Override
    protected String url() {
        return ReadFileUtils.getPropValues("url.properties", "campaign-url");
    }

    @Override
    protected CampaignResponse convert(ObjectMapper mapper, String responseString) {
        try {
            return mapper.readValue(responseString, CampaignResponse.class);
        } catch (JsonProcessingException e) {
            logger.error("Convert to CampaignResponse failure.");
            throw new CustomRuntimeException("Convert to CampaignResponse failure.");
        }
    }

    @Override
    protected int getTotalPage(CampaignResponse response) {
        return response.getCampaignList().getPage_info().getTotal_page();
    }

    @Override
    protected List<Campaign> getList(CampaignResponse response) {
        return response.getCampaignList().getCampaigns();
    }

    @Override
    public void readData(String accessToken, String advertiser_id) {
        List<Campaign> campaigns = getList(advertiser_id, accessToken);
        CampaignDAO dao = CampaignDAO.getInstance();
        dao.save(campaigns);
    }
}
