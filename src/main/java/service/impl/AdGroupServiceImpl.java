package service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import dao.impl.AdGroupDAO;
import entity.AdGroup;
import exception.CustomRuntimeException;
import response.AdGroupResponse;
import service.AbstractService;
import service.AdGroupService;
import utils.ReadFileUtils;

import java.util.List;

public class AdGroupServiceImpl extends AbstractService<AdGroup, AdGroupResponse> implements AdGroupService {
    private static AdGroupServiceImpl service;

    private AdGroupServiceImpl() {
    }

    public static AdGroupServiceImpl getInstance() {
        if (service == null)
            service = new AdGroupServiceImpl();
        return service;
    }

    @Override
    protected String url() {
        return ReadFileUtils.getPropValues("url.properties", "adgroup-url");
    }

    @Override
    protected AdGroupResponse convert(ObjectMapper mapper, String responseString) {
        try {
            return mapper.readValue(responseString, AdGroupResponse.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new CustomRuntimeException("Convert to AdGroupResponse failure.");
        }
    }

    @Override
    protected int getTotalPage(AdGroupResponse response) {
        return response.getAdGroupList().getPage_info().getTotal_page();
    }

    @Override
    protected List<AdGroup> getList(AdGroupResponse response) {
        return response.getAdGroupList().getAdGroups();
    }

    @Override
    public void readData(String accessToken, String advertiser_id) {
        List<AdGroup> adGroups = getList(advertiser_id, accessToken);
        AdGroupDAO dao = AdGroupDAO.getInstance();
        dao.save(adGroups);
    }
}
