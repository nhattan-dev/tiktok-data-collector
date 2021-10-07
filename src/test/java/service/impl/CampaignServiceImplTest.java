package service.impl;

import exception.CustomRuntimeException;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import response.CampaignResponse;
import utils.APIUtils;
import utils.ObjectMapperUtils;

import static org.junit.jupiter.api.Assertions.*;

class CampaignServiceImplTest {

    CampaignServiceImpl s1 = CampaignServiceImpl.getInstance();

    @Test
    void getInstance() {
        CampaignServiceImpl s2 = CampaignServiceImpl.getInstance();
        assertEquals(s1, s2);
    }

    @Test
    void url() {
        assertTrue(s1.url().contains("campaign"));
    }

    @Test
    void convert_fail_then_throw_exception() {
        String responseString = "will be throw exception";
        Exception exception = assertThrows(CustomRuntimeException.class,
                () -> s1.convert(ObjectMapperUtils.getInstance(), responseString));
        assertEquals("Convert to CampaignResponse failure.", exception.getMessage());
    }

    @Test
    void convert_success_then_return_object() {
        CampaignResponse response = s1.convert(ObjectMapperUtils.getInstance(), campaignResponse);
        assertEquals(response.getCampaignList().getCampaigns().get(0).getAdvertiserId() + "", advertiser_id);
    }

    @Test
    void getTotalPage() {CampaignResponse response = s1.convert(ObjectMapperUtils.getInstance(), campaignResponse);
        assertEquals(1, s1.getTotalPage(response));
    }

    @Test
    void getList() {
        CampaignResponse response = s1.convert(ObjectMapperUtils.getInstance(), campaignResponse);
        assertEquals(10, s1.getList(response).size());
    }

    @Test
    void readData() {
        try (MockedStatic<APIUtils> apiUtilsMockedStatic = Mockito.mockStatic(APIUtils.class)) {
            apiUtilsMockedStatic
                    .when(() -> APIUtils.get(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                    .thenReturn(campaignResponse);
            CampaignServiceImpl.getInstance().readData(accessToken, advertiser_id);
        }
    }

    private final String accessToken = "";
    private final String advertiser_id = "6791983391823626245";
    private final String campaignResponse = "{\"message\":\"OK\",\"code\":0,\"data\":{\"page_info\":{\"total_number\":10,\"page\":1,\"page_size\":10,\"total_page\":1},\"list\":[{\"budget_mode\":\"BUDGET_MODE_TOTAL\",\"status\":\"CAMPAIGN_STATUS_DISABLE\",\"split_test_variable\":null,\"is_new_structure\":true,\"objective_type\":\"REACH\",\"budget\":50,\"campaign_type\":\"REGULAR_CAMPAIGN\",\"advertiser_id\":6791983391823626245,\"create_time\":\"2021-09-16 21:30:33\",\"modify_time\":\"2021-10-07 07:13:34\",\"objective\":\"LANDING_PAGE\",\"campaign_name\":\"[OPTIMIZER REGRESSION] Impressions 2\",\"opt_status\":\"DISABLE\",\"campaign_id\":1711095423090689},{\"budget_mode\":\"BUDGET_MODE_TOTAL\",\"status\":\"CAMPAIGN_STATUS_DISABLE\",\"split_test_variable\":null,\"is_new_structure\":true,\"objective_type\":\"VIDEO_VIEWS\",\"budget\":100,\"campaign_type\":\"REGULAR_CAMPAIGN\",\"advertiser_id\":6791983391823626245,\"create_time\":\"2021-05-12 01:24:11\",\"modify_time\":\"2021-09-21 10:01:00\",\"objective\":\"LANDING_PAGE\",\"campaign_name\":\"Video Views20210511212239\",\"opt_status\":\"DISABLE\",\"campaign_id\":1699513776212018},{\"budget_mode\":\"BUDGET_MODE_INFINITE\",\"status\":\"CAMPAIGN_STATUS_ENABLE\",\"split_test_variable\":null,\"is_new_structure\":true,\"objective_type\":\"CONVERSIONS\",\"budget\":0,\"campaign_type\":\"REGULAR_CAMPAIGN\",\"advertiser_id\":6791983391823626245,\"create_time\":\"2021-04-08 13:06:21\",\"modify_time\":\"2021-04-08 13:06:21\",\"objective\":\"LANDING_PAGE\",\"campaign_name\":\"[Saigon](Conversion) iOS 14 check\",\"opt_status\":\"ENABLE\",\"campaign_id\":1696477648877570},{\"budget_mode\":\"BUDGET_MODE_TOTAL\",\"status\":\"CAMPAIGN_STATUS_DISABLE\",\"split_test_variable\":null,\"is_new_structure\":true,\"objective_type\":\"REACH\",\"budget\":50,\"campaign_type\":\"REGULAR_CAMPAIGN\",\"advertiser_id\":6791983391823626245,\"create_time\":\"2021-04-07 17:06:54\",\"modify_time\":\"2021-09-15 03:51:05\",\"objective\":\"LANDING_PAGE\",\"campaign_name\":\"[Saigon](Reach) Update new endpoint\",\"opt_status\":\"DISABLE\",\"campaign_id\":1696402182206514},{\"budget_mode\":\"BUDGET_MODE_TOTAL\",\"status\":\"CAMPAIGN_STATUS_ENABLE\",\"split_test_variable\":null,\"is_new_structure\":true,\"objective_type\":\"APP_INSTALL\",\"budget\":50,\"campaign_type\":\"REGULAR_CAMPAIGN\",\"advertiser_id\":6791983391823626245,\"create_time\":\"2021-03-25 15:27:49\",\"modify_time\":\"2021-03-25 15:27:49\",\"objective\":\"APP\",\"campaign_name\":\"IHM App Install Test Campaign\",\"opt_status\":\"ENABLE\",\"campaign_id\":1695218209136674},{\"budget_mode\":\"BUDGET_MODE_DAY\",\"status\":\"CAMPAIGN_STATUS_DISABLE\",\"split_test_variable\":null,\"is_new_structure\":true,\"objective_type\":\"REACH\",\"budget\":50,\"campaign_type\":\"REGULAR_CAMPAIGN\",\"advertiser_id\":6791983391823626245,\"create_time\":\"2021-03-11 11:39:30\",\"modify_time\":\"2021-09-21 10:00:47\",\"objective\":\"LANDING_PAGE\",\"campaign_name\":\"[OPTIMIZER REGRESSION] Media Budget Test_new\",\"opt_status\":\"DISABLE\",\"campaign_id\":1693935468014609},{\"budget_mode\":\"BUDGET_MODE_DAY\",\"status\":\"CAMPAIGN_STATUS_DISABLE\",\"split_test_variable\":null,\"is_new_structure\":true,\"objective_type\":\"REACH\",\"budget\":50,\"campaign_type\":\"REGULAR_CAMPAIGN\",\"advertiser_id\":6791983391823626245,\"create_time\":\"2021-02-28 14:57:47\",\"modify_time\":\"2021-09-21 10:09:14\",\"objective\":\"LANDING_PAGE\",\"campaign_name\":\"[OPTIMIZER REGRESSION] Impressions Test\",\"opt_status\":\"DISABLE\",\"campaign_id\":1692951394653217},{\"budget_mode\":\"BUDGET_MODE_DAY\",\"status\":\"CAMPAIGN_STATUS_DISABLE\",\"split_test_variable\":null,\"is_new_structure\":true,\"objective_type\":\"REACH\",\"budget\":50,\"campaign_type\":\"REGULAR_CAMPAIGN\",\"advertiser_id\":6791983391823626245,\"create_time\":\"2021-02-28 14:53:35\",\"modify_time\":\"2021-09-15 03:51:03\",\"objective\":\"LANDING_PAGE\",\"campaign_name\":\"[OPTIMIZER REGRESSION] Media Budget Test\",\"opt_status\":\"DISABLE\",\"campaign_id\":1692951105318945},{\"budget_mode\":\"BUDGET_MODE_DAY\",\"status\":\"CAMPAIGN_STATUS_ENABLE\",\"split_test_variable\":null,\"is_new_structure\":true,\"objective_type\":\"CONVERSIONS\",\"budget\":50,\"campaign_type\":\"REGULAR_CAMPAIGN\",\"advertiser_id\":6791983391823626245,\"create_time\":\"2020-12-07 03:42:16\",\"modify_time\":\"2020-12-07 03:42:16\",\"objective\":\"LANDING_PAGE\",\"campaign_name\":\"Red-Conversions20201206222133\",\"opt_status\":\"ENABLE\",\"campaign_id\":1685389349052433},{\"budget_mode\":\"BUDGET_MODE_TOTAL\",\"status\":\"CAMPAIGN_STATUS_ENABLE\",\"split_test_variable\":null,\"is_new_structure\":true,\"objective_type\":\"CONVERSIONS\",\"budget\":100,\"campaign_type\":\"REGULAR_CAMPAIGN\",\"advertiser_id\":6791983391823626245,\"create_time\":\"2020-12-02 09:53:16\",\"modify_time\":\"2020-12-09 18:14:57\",\"objective\":\"LANDING_PAGE\",\"campaign_name\":\"[Red] Conversions 2020.12.02\",\"opt_status\":\"ENABLE\",\"campaign_id\":1684959703362578}]},\"request_id\":\"202110070916490102452460361CBA6C7C\"}";
}