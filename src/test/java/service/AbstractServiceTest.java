package service;

import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import service.impl.AdServiceImpl;
import utils.APIUtils;

import static org.junit.jupiter.api.Assertions.*;

class AbstractServiceTest {

    @Test
    void getList() {
        try (MockedStatic<APIUtils> apiUtilsMockedStatic = Mockito.mockStatic(APIUtils.class)) {
            apiUtilsMockedStatic
                    .when(() -> APIUtils.get(Mockito.anyString(), Mockito.anyString(), Mockito.anyString()))
                    .thenReturn(adGroupResponse);
            AdServiceImpl adService = AdServiceImpl.getInstance();
            int actual = adService.getList(advertiser_id, accessToken).size();
            assertEquals(10, actual);
        }
    }

    private final String accessToken = "";
    private final String advertiser_id = "6791983391823626245";
    private final String adGroupResponse = "{\"message\":\"OK\",\"code\":0,\"data\":{\"page_info\":{\"total_number\":10,\"page\":1,\"page_size\":10,\"total_page\":1},\"list\":[{\"interest_keywords\":[],\"conversion_window\":null,\"scheduled_budget\":0,\"pixel_id\":null,\"optimize_goal\":\"REACH\",\"app_id\":null,\"keywords\":null,\"operation_system\":[],\"languages\":[\"ko\"],\"device_price\":[],\"include_custom_actions\":[],\"is_hfss\":false,\"location\":[6252001],\"app_download_url\":null,\"external_type\":\"WEBSITE_OR_DISPLAY\",\"opt_status\":\"DISABLE\",\"ios14_quota_type\":\"UNOCCUPIED\",\"billing_event\":\"CPM\",\"bid\":1.1,\"advertiser_id\":6791983391823626245,\"statistic_type\":null,\"deep_bid_type\":null,\"excluded_audience\":[],\"external_action\":null,\"is_share_disable\":false,\"is_comment_disable\":0,\"split_test_adgroup_ids\":[],\"gender\":\"GENDER_UNLIMITED\",\"video_download\":\"ALLOW_DOWNLOAD\",\"budget\":20,\"placement_type\":\"PLACEMENT_TYPE_NORMAL\",\"rf_buy_type\":null,\"audience\":[],\"frequency\":1,\"bid_type\":\"BID_TYPE_CUSTOM\",\"status\":\"ADGROUP_STATUS_CAMPAIGN_DISABLE\",\"campaign_id\":1711095423090689,\"exclude_custom_actions\":[],\"create_time\":\"2021-09-16 21:30:34\",\"pacing\":\"PACING_MODE_SMOOTH\",\"campaign_name\":\"[OPTIMIZER REGRESSION] Impressions 2\",\"buy_reach\":null,\"creative_material_mode\":\"CUSTOM\",\"adgroup_id\":1711095499718706,\"category\":0,\"buy_impression\":null,\"app_type\":null,\"adgroup_name\":\"Ad Group20210916171523\",\"frequency_schedule\":7,\"budget_mode\":\"BUDGET_MODE_DAY\",\"connection_type\":[],\"brand_safety_partner\":null,\"enable_inventory_filter\":false,\"deep_cpabid\":0,\"brand_safety\":\"NO_BRAND_SAFETY\",\"rf_predict_frequency\":null,\"device_models\":[],\"schedule_start_time\":\"2021-09-16 22:15:23\",\"schedule_end_time\":\"2021-10-16 22:15:23\",\"interest_category_v2\":[],\"is_new_structure\":true,\"placement\":[\"PLACEMENT_TIKTOK\"],\"skip_learning_phase\":0,\"deep_external_action\":null,\"age\":[\"AGE_18_24\"],\"conversion_bid\":0,\"schedule_type\":\"SCHEDULE_START_END\",\"action_v2\":[],\"modify_time\":\"2021-10-07 07:13:41\",\"rf_predict_cpr\":null,\"conversion_id\":0,\"dayparting\":null},{\"interest_keywords\":[],\"conversion_window\":null,\"scheduled_budget\":0,\"pixel_id\":null,\"optimize_goal\":\"VIDEO_VIEW\",\"app_id\":null,\"keywords\":null,\"operation_system\":[],\"languages\":[],\"device_price\":[],\"include_custom_actions\":[],\"is_hfss\":false,\"location\":[6252001],\"app_download_url\":null,\"external_type\":\"WEBSITE_OR_DISPLAY\",\"opt_status\":\"ENABLE\",\"ios14_quota_type\":\"UNOCCUPIED\",\"billing_event\":\"CPV\",\"bid\":0,\"advertiser_id\":6791983391823626245,\"statistic_type\":null,\"deep_bid_type\":null,\"excluded_audience\":[],\"external_action\":null,\"is_share_disable\":false,\"is_comment_disable\":0,\"split_test_adgroup_ids\":[],\"gender\":\"GENDER_UNLIMITED\",\"video_download\":\"ALLOW_DOWNLOAD\",\"budget\":20,\"placement_type\":\"PLACEMENT_TYPE_NORMAL\",\"rf_buy_type\":null,\"audience\":[],\"frequency\":null,\"bid_type\":\"BID_TYPE_NO_BID\",\"status\":\"ADGROUP_STATUS_CAMPAIGN_DISABLE\",\"campaign_id\":1699513776212018,\"exclude_custom_actions\":[],\"create_time\":\"2021-05-12 01:24:12\",\"pacing\":\"PACING_MODE_SMOOTH\",\"campaign_name\":\"Video Views20210511212239\",\"buy_reach\":null,\"creative_material_mode\":\"CUSTOM\",\"adgroup_id\":1699513776545809,\"category\":0,\"buy_impression\":null,\"app_type\":null,\"adgroup_name\":\"Ad Group20210511212242\",\"frequency_schedule\":null,\"cpv_video_duration\":\"SIX_SECONDS\",\"budget_mode\":\"BUDGET_MODE_DAY\",\"connection_type\":[],\"brand_safety_partner\":null,\"enable_inventory_filter\":false,\"deep_cpabid\":0,\"brand_safety\":\"NO_BRAND_SAFETY\",\"rf_predict_frequency\":null,\"device_models\":[],\"schedule_start_time\":\"2021-05-11 22:22:42\",\"schedule_end_time\":\"2021-10-16 02:22:42\",\"interest_category_v2\":[],\"is_new_structure\":true,\"placement\":[\"PLACEMENT_TIKTOK\"],\"skip_learning_phase\":0,\"deep_external_action\":null,\"age\":[\"AGE_18_24\",\"AGE_25_34\",\"AGE_35_44\",\"AGE_45_54\",\"AGE_55_100\"],\"conversion_bid\":0,\"schedule_type\":\"SCHEDULE_START_END\",\"action_v2\":[],\"modify_time\":\"2021-09-21 10:01:00\",\"rf_predict_cpr\":null,\"conversion_id\":0,\"dayparting\":null},{\"conversion_window\":null,\"scheduled_budget\":0,\"pixel_id\":6881312699276394497,\"automated_targeting\":\"OFF\",\"optimize_goal\":\"CONVERT\",\"app_id\":null,\"keywords\":null,\"operation_system\":[\"IOS\"],\"languages\":[],\"device_price\":[],\"include_custom_actions\":[],\"is_hfss\":false,\"location\":[1605651,6252001,1562822],\"app_download_url\":null,\"ios_osv\":\"14.5\",\"external_type\":\"WEBSITE\",\"opt_status\":\"ENABLE\",\"ios14_quota_type\":\"UNOCCUPIED\",\"billing_event\":\"OCPM\",\"bid\":0,\"advertiser_id\":6791983391823626245,\"statistic_type\":null,\"deep_bid_type\":null,\"excluded_audience\":[],\"external_action\":\"VIEW\",\"promotion_website_type\":\"UNSET\",\"is_share_disable\":false,\"is_comment_disable\":0,\"split_test_adgroup_ids\":[],\"gender\":\"GENDER_UNLIMITED\",\"video_download\":\"ALLOW_DOWNLOAD\",\"budget\":20,\"placement_type\":\"PLACEMENT_TYPE_NORMAL\",\"rf_buy_type\":null,\"audience\":[],\"frequency\":null,\"bid_type\":\"BID_TYPE_CUSTOM\",\"status\":\"ADGROUP_STATUS_TIME_DONE\",\"campaign_id\":1696477648877570,\"exclude_custom_actions\":[],\"create_time\":\"2021-04-08 13:06:21\",\"pacing\":\"PACING_MODE_SMOOTH\",\"campaign_name\":\"[Saigon](Conversion) iOS 14 check\",\"buy_reach\":null,\"creative_material_mode\":\"CUSTOM\",\"adgroup_id\":1696477648877586,\"category\":0,\"buy_impression\":null,\"app_type\":null,\"carriers\":[],\"adgroup_name\":\"[Saigon](Conversion) iOS 14 check\",\"frequency_schedule\":null,\"budget_mode\":\"BUDGET_MODE_DAY\",\"connection_type\":[],\"brand_safety_partner\":null,\"enable_inventory_filter\":false,\"deep_cpabid\":0,\"brand_safety\":\"NO_BRAND_SAFETY\",\"rf_predict_frequency\":null,\"device_models\":[],\"schedule_start_time\":\"2021-04-08 13:58:47\",\"schedule_end_time\":\"2021-05-10 13:58:47\",\"interest_category_v2\":[],\"is_new_structure\":true,\"placement\":[\"PLACEMENT_TIKTOK\",\"PLACEMENT_TOPBUZZ\",\"PLACEMENT_HELO\"],\"skip_learning_phase\":1,\"deep_external_action\":null,\"age\":[\"AGE_18_24\",\"AGE_25_34\",\"AGE_35_44\"],\"conversion_bid\":1,\"schedule_type\":\"SCHEDULE_START_END\",\"action_v2\":[],\"modify_time\":\"2021-04-18 18:01:32\",\"rf_predict_cpr\":null,\"conversion_id\":0,\"dayparting\":null},{\"conversion_window\":null,\"scheduled_budget\":0,\"pixel_id\":null,\"optimize_goal\":\"REACH\",\"app_id\":null,\"keywords\":null,\"operation_system\":[],\"languages\":[],\"device_price\":[],\"include_custom_actions\":[],\"is_hfss\":false,\"location\":[1605651,6252001,1562822],\"app_download_url\":null,\"external_type\":\"WEBSITE_OR_DISPLAY\",\"opt_status\":\"ENABLE\",\"ios14_quota_type\":\"UNOCCUPIED\",\"billing_event\":\"CPM\",\"bid\":0,\"advertiser_id\":6791983391823626245,\"statistic_type\":null,\"deep_bid_type\":null,\"excluded_audience\":[],\"external_action\":null,\"is_share_disable\":false,\"is_comment_disable\":0,\"split_test_adgroup_ids\":[],\"gender\":\"GENDER_UNLIMITED\",\"video_download\":\"ALLOW_DOWNLOAD\",\"budget\":20,\"placement_type\":\"PLACEMENT_TYPE_NORMAL\",\"rf_buy_type\":null,\"audience\":[],\"frequency\":1,\"bid_type\":\"BID_TYPE_NO_BID\",\"status\":\"ADGROUP_STATUS_CAMPAIGN_DISABLE\",\"campaign_id\":1696402182206514,\"exclude_custom_actions\":[],\"create_time\":\"2021-04-07 17:06:55\",\"pacing\":\"PACING_MODE_SMOOTH\",\"campaign_name\":\"[Saigon](Reach) Update new endpoint\",\"buy_reach\":null,\"creative_material_mode\":\"CUSTOM\",\"adgroup_id\":1696402193142818,\"category\":0,\"buy_impression\":null,\"app_type\":null,\"carriers\":[],\"adgroup_name\":\"[Saigon](Reach) Update new endpoint\",\"frequency_schedule\":1,\"budget_mode\":\"BUDGET_MODE_DAY\",\"connection_type\":[],\"brand_safety_partner\":null,\"enable_inventory_filter\":false,\"deep_cpabid\":0,\"brand_safety\":\"NO_BRAND_SAFETY\",\"rf_predict_frequency\":null,\"device_models\":[],\"schedule_start_time\":\"2021-04-07 16:01:19\",\"schedule_end_time\":\"2021-05-09 16:01:19\",\"interest_category_v2\":[],\"is_new_structure\":true,\"placement\":[\"PLACEMENT_TIKTOK\"],\"skip_learning_phase\":0,\"deep_external_action\":null,\"age\":[\"AGE_18_24\",\"AGE_25_34\",\"AGE_35_44\"],\"conversion_bid\":0,\"schedule_type\":\"SCHEDULE_START_END\",\"action_v2\":[],\"modify_time\":\"2021-09-15 03:51:05\",\"rf_predict_cpr\":null,\"conversion_id\":0,\"dayparting\":null},{\"conversion_window\":null,\"scheduled_budget\":0,\"pixel_id\":null,\"automated_targeting\":\"OFF\",\"optimize_goal\":\"CLICK\",\"app_id\":6943604388791353345,\"keywords\":null,\"operation_system\":[\"IOS\"],\"languages\":[],\"device_price\":[],\"include_custom_actions\":[],\"is_hfss\":false,\"location\":[6252001],\"app_download_url\":\"https:\\/\\/apps.apple.com\\/us\\/app\\/iheart-radio-music-podcasts\\/id290638154\",\"ios_osv\":\"14.1\",\"external_type\":\"APP_IOS\",\"opt_status\":\"ENABLE\",\"ios14_quota_type\":\"UNOCCUPIED\",\"billing_event\":\"CPC\",\"bid\":0,\"advertiser_id\":6791983391823626245,\"statistic_type\":null,\"deep_bid_type\":null,\"excluded_audience\":[],\"external_action\":null,\"is_share_disable\":false,\"is_comment_disable\":1,\"split_test_adgroup_ids\":[],\"gender\":\"GENDER_UNLIMITED\",\"video_download\":\"ALLOW_DOWNLOAD\",\"budget\":60,\"placement_type\":\"PLACEMENT_TYPE_AUTOMATIC\",\"rf_buy_type\":null,\"audience\":[],\"frequency\":null,\"bid_type\":\"BID_TYPE_NO_BID\",\"status\":\"ADGROUP_STATUS_TIME_DONE\",\"campaign_id\":1695218209136674,\"exclude_custom_actions\":[],\"create_time\":\"2021-03-25 15:27:50\",\"pacing\":\"PACING_MODE_SMOOTH\",\"campaign_name\":\"IHM App Install Test Campaign\",\"buy_reach\":null,\"creative_material_mode\":\"CUSTOM\",\"adgroup_id\":1695218200748081,\"category\":0,\"buy_impression\":null,\"app_type\":\"APP_IOS\",\"carriers\":[],\"adgroup_name\":\"IHM App Install Test Ad Group\",\"frequency_schedule\":null,\"budget_mode\":\"BUDGET_MODE_TOTAL\",\"connection_type\":[],\"brand_safety_partner\":null,\"enable_inventory_filter\":false,\"deep_cpabid\":0,\"brand_safety\":\"NO_BRAND_SAFETY\",\"rf_predict_frequency\":null,\"schedule_start_time\":\"2021-03-25 16:25:14\",\"schedule_end_time\":\"2021-03-28 16:25:14\",\"interest_category_v2\":[],\"is_new_structure\":true,\"placement\":null,\"skip_learning_phase\":0,\"package\":\"com.clearchannel.iheartradio\",\"deep_external_action\":null,\"age\":null,\"conversion_bid\":0,\"schedule_type\":\"SCHEDULE_START_END\",\"action_v2\":[],\"modify_time\":\"2021-03-26 02:49:26\",\"ios_target_device\":\"UNSET\",\"rf_predict_cpr\":null,\"conversion_id\":0,\"dayparting\":null},{\"interest_keywords\":[],\"conversion_window\":null,\"scheduled_budget\":0,\"pixel_id\":null,\"optimize_goal\":\"REACH\",\"app_id\":null,\"keywords\":null,\"operation_system\":[\"IOS\"],\"languages\":[\"th\",\"vi\",\"ko\",\"zh-Hant\",\"ja\"],\"device_price\":[],\"include_custom_actions\":[],\"is_hfss\":false,\"location\":[5242283],\"app_download_url\":null,\"external_type\":\"WEBSITE_OR_DISPLAY\",\"opt_status\":\"ENABLE\",\"ios14_quota_type\":\"UNOCCUPIED\",\"billing_event\":\"CPM\",\"bid\":0,\"advertiser_id\":6791983391823626245,\"statistic_type\":null,\"deep_bid_type\":null,\"excluded_audience\":[],\"external_action\":null,\"is_share_disable\":false,\"is_comment_disable\":0,\"split_test_adgroup_ids\":[],\"gender\":\"GENDER_UNLIMITED\",\"video_download\":\"ALLOW_DOWNLOAD\",\"budget\":20,\"placement_type\":\"PLACEMENT_TYPE_NORMAL\",\"rf_buy_type\":null,\"audience\":[],\"frequency\":1,\"bid_type\":\"BID_TYPE_NO_BID\",\"budget_mode\":\"BUDGET_MODE_DAY\",\"campaign_id\":1693935468014609,\"exclude_custom_actions\":[],\"create_time\":\"2021-03-11 11:39:30\",\"pacing\":\"PACING_MODE_SMOOTH\",\"campaign_name\":\"[OPTIMIZER REGRESSION] Media Budget Test_new\",\"buy_reach\":null,\"creative_material_mode\":\"CUSTOM\",\"adgroup_id\":1693935465921569,\"category\":0,\"buy_impression\":null,\"app_type\":null,\"adgroup_name\":\"[OPTIMIZER REGRESSION] Media Budget Test_new\",\"frequency_schedule\":7,\"connection_type\":[],\"brand_safety_partner\":null,\"enable_inventory_filter\":false,\"deep_cpabid\":0,\"brand_safety\":\"NO_BRAND_SAFETY\",\"rf_predict_frequency\":null,\"device_models\":[],\"schedule_start_time\":\"2021-03-11 11:34:37\",\"schedule_end_time\":\"2021-10-31 11:34:37\",\"interest_category_v2\":[22101],\"is_new_structure\":true,\"placement\":[\"PLACEMENT_TIKTOK\"],\"skip_learning_phase\":0,\"deep_external_action\":null,\"age\":[\"AGE_18_24\",\"AGE_25_34\"],\"conversion_bid\":0,\"schedule_type\":\"SCHEDULE_START_END\",\"action_v2\":[{\"action_categories\":[16,14],\"user_actions\":[\"LIKED\"],\"action_scene\":\"VIDEO_RELATED\",\"action_period\":7}],\"status\":\"ADGROUP_STATUS_CAMPAIGN_DISABLE\",\"modify_time\":\"2021-09-21 10:00:47\",\"rf_predict_cpr\":null,\"conversion_id\":0,\"dayparting\":null},{\"interest_keywords\":[],\"conversion_window\":null,\"scheduled_budget\":0,\"pixel_id\":null,\"optimize_goal\":\"REACH\",\"app_id\":null,\"keywords\":null,\"operation_system\":[],\"languages\":[\"th\",\"en\"],\"device_price\":[],\"include_custom_actions\":[],\"is_hfss\":false,\"location\":[1605651,6252001,1562822],\"app_download_url\":null,\"external_type\":\"WEBSITE_OR_DISPLAY\",\"opt_status\":\"ENABLE\",\"ios14_quota_type\":\"UNOCCUPIED\",\"billing_event\":\"CPM\",\"bid\":0,\"advertiser_id\":6791983391823626245,\"statistic_type\":null,\"deep_bid_type\":null,\"excluded_audience\":[],\"external_action\":null,\"is_share_disable\":false,\"is_comment_disable\":0,\"split_test_adgroup_ids\":[],\"gender\":\"GENDER_UNLIMITED\",\"video_download\":\"ALLOW_DOWNLOAD\",\"budget\":20,\"placement_type\":\"PLACEMENT_TYPE_NORMAL\",\"rf_buy_type\":null,\"audience\":[],\"frequency\":1,\"bid_type\":\"BID_TYPE_NO_BID\",\"budget_mode\":\"BUDGET_MODE_DAY\",\"campaign_id\":1692951394653217,\"exclude_custom_actions\":[],\"create_time\":\"2021-02-28 14:57:48\",\"pacing\":\"PACING_MODE_SMOOTH\",\"campaign_name\":\"[OPTIMIZER REGRESSION] Impressions Test\",\"buy_reach\":null,\"creative_material_mode\":\"CUSTOM\",\"adgroup_id\":1692951392901170,\"category\":0,\"buy_impression\":null,\"app_type\":null,\"adgroup_name\":\"[OPTIMIZER REGRESSION] Impressions Test\",\"frequency_schedule\":7,\"connection_type\":[],\"brand_safety_partner\":null,\"enable_inventory_filter\":false,\"deep_cpabid\":0,\"brand_safety\":\"NO_BRAND_SAFETY\",\"rf_predict_frequency\":null,\"device_models\":[],\"schedule_start_time\":\"2021-02-28 14:56:45\",\"schedule_end_time\":\"2021-10-17 14:49:55\",\"interest_category_v2\":[],\"is_new_structure\":true,\"placement\":[\"PLACEMENT_TIKTOK\"],\"skip_learning_phase\":0,\"deep_external_action\":null,\"age\":[\"AGE_18_24\",\"AGE_25_34\"],\"conversion_bid\":0,\"schedule_type\":\"SCHEDULE_START_END\",\"action_v2\":[{\"action_categories\":[14],\"user_actions\":[\"LIKED\"],\"action_scene\":\"VIDEO_RELATED\",\"action_period\":7}],\"status\":\"ADGROUP_STATUS_CAMPAIGN_DISABLE\",\"modify_time\":\"2021-09-21 10:09:14\",\"rf_predict_cpr\":null,\"conversion_id\":0,\"dayparting\":null},{\"conversion_window\":null,\"scheduled_budget\":0,\"pixel_id\":null,\"optimize_goal\":\"REACH\",\"app_id\":null,\"keywords\":null,\"operation_system\":[],\"languages\":[\"vi\"],\"device_price\":[],\"include_custom_actions\":[],\"is_hfss\":false,\"location\":[1605651,6252001,1562822],\"app_download_url\":null,\"external_type\":\"WEBSITE_OR_DISPLAY\",\"opt_status\":\"ENABLE\",\"ios14_quota_type\":\"UNOCCUPIED\",\"billing_event\":\"CPM\",\"bid\":0,\"advertiser_id\":6791983391823626245,\"statistic_type\":null,\"deep_bid_type\":null,\"excluded_audience\":[],\"external_action\":null,\"is_share_disable\":false,\"is_comment_disable\":0,\"split_test_adgroup_ids\":[],\"gender\":\"GENDER_UNLIMITED\",\"video_download\":\"ALLOW_DOWNLOAD\",\"budget\":20,\"placement_type\":\"PLACEMENT_TYPE_NORMAL\",\"rf_buy_type\":null,\"audience\":[],\"frequency\":1,\"bid_type\":\"BID_TYPE_NO_BID\",\"budget_mode\":\"BUDGET_MODE_DAY\",\"campaign_id\":1692951105318945,\"exclude_custom_actions\":[],\"create_time\":\"2021-02-28 14:53:37\",\"pacing\":\"PACING_MODE_SMOOTH\",\"campaign_name\":\"[OPTIMIZER REGRESSION] Media Budget Test\",\"buy_reach\":null,\"creative_material_mode\":\"CUSTOM\",\"adgroup_id\":1692951104063490,\"category\":0,\"buy_impression\":null,\"app_type\":null,\"carriers\":[],\"adgroup_name\":\"[OPTIMIZER REGRESSION] Media Budget Test\",\"frequency_schedule\":7,\"connection_type\":[],\"brand_safety_partner\":null,\"enable_inventory_filter\":false,\"deep_cpabid\":0,\"brand_safety\":\"NO_BRAND_SAFETY\",\"rf_predict_frequency\":null,\"schedule_start_time\":\"2021-02-28 14:49:55\",\"schedule_end_time\":\"2021-06-30 14:49:55\",\"interest_category_v2\":[],\"is_new_structure\":true,\"placement\":[\"PLACEMENT_TIKTOK\"],\"skip_learning_phase\":0,\"deep_external_action\":null,\"age\":[\"AGE_18_24\",\"AGE_25_34\"],\"conversion_bid\":0,\"schedule_type\":\"SCHEDULE_START_END\",\"action_v2\":[{\"action_categories\":[14],\"user_actions\":[\"LIKED\"],\"action_scene\":\"VIDEO_RELATED\",\"action_period\":7}],\"status\":\"ADGROUP_STATUS_CAMPAIGN_DISABLE\",\"modify_time\":\"2021-09-15 03:51:03\",\"rf_predict_cpr\":null,\"conversion_id\":0,\"dayparting\":null},{\"conversion_window\":null,\"scheduled_budget\":0,\"pixel_id\":6881312699276394497,\"automated_targeting\":\"OFF\",\"optimize_goal\":\"CONVERT\",\"app_id\":null,\"keywords\":null,\"operation_system\":[],\"languages\":[],\"device_price\":[],\"include_custom_actions\":[],\"is_hfss\":false,\"location\":[6252001],\"app_download_url\":null,\"external_type\":\"WEBSITE\",\"opt_status\":\"ENABLE\",\"ios14_quota_type\":\"UNOCCUPIED\",\"billing_event\":\"OCPM\",\"bid\":0,\"advertiser_id\":6791983391823626245,\"statistic_type\":null,\"deep_bid_type\":null,\"excluded_audience\":[],\"external_action\":\"VIEW\",\"promotion_website_type\":\"UNSET\",\"is_share_disable\":false,\"is_comment_disable\":0,\"split_test_adgroup_ids\":[],\"gender\":\"GENDER_UNLIMITED\",\"video_download\":\"ALLOW_DOWNLOAD\",\"budget\":20,\"placement_type\":\"PLACEMENT_TYPE_AUTOMATIC\",\"rf_buy_type\":null,\"audience\":[],\"frequency\":null,\"bid_type\":\"BID_TYPE_CUSTOM\",\"budget_mode\":\"BUDGET_MODE_DAY\",\"campaign_id\":1684959703362578,\"exclude_custom_actions\":[],\"create_time\":\"2020-12-08 19:29:47\",\"pacing\":\"PACING_MODE_SMOOTH\",\"campaign_name\":\"[Red] Conversions 2020.12.02\",\"buy_reach\":null,\"creative_material_mode\":\"CUSTOM\",\"adgroup_id\":1685539556928545,\"category\":0,\"buy_impression\":null,\"app_type\":null,\"carriers\":[],\"adgroup_name\":\"Our Mark Conversions\",\"frequency_schedule\":null,\"connection_type\":[],\"brand_safety_partner\":null,\"enable_inventory_filter\":false,\"deep_cpabid\":0,\"brand_safety\":\"NO_BRAND_SAFETY\",\"rf_predict_frequency\":null,\"schedule_start_time\":\"2020-12-09 15:00:15\",\"schedule_end_time\":\"2020-12-10 13:27:15\",\"interest_category_v2\":[],\"is_new_structure\":true,\"placement\":null,\"skip_learning_phase\":1,\"deep_external_action\":null,\"age\":null,\"conversion_bid\":2,\"schedule_type\":\"SCHEDULE_START_END\",\"action_v2\":[{\"action_categories\":[16],\"user_actions\":[\"LIKED\"],\"action_scene\":\"VIDEO_RELATED\",\"action_period\":7}],\"status\":\"ADGROUP_STATUS_TIME_DONE\",\"modify_time\":\"2020-12-10 05:00:17\",\"rf_predict_cpr\":null,\"conversion_id\":0,\"dayparting\":null},{\"conversion_window\":null,\"scheduled_budget\":0,\"pixel_id\":6852753141281128454,\"automated_targeting\":\"OFF\",\"optimize_goal\":\"CONVERT\",\"app_id\":null,\"keywords\":null,\"operation_system\":[],\"languages\":[],\"device_price\":[],\"include_custom_actions\":[],\"is_hfss\":false,\"location\":[6252001],\"app_download_url\":null,\"external_type\":\"WEBSITE\",\"opt_status\":\"ENABLE\",\"ios14_quota_type\":\"UNOCCUPIED\",\"billing_event\":\"OCPM\",\"bid\":0,\"advertiser_id\":6791983391823626245,\"statistic_type\":null,\"deep_bid_type\":null,\"excluded_audience\":[],\"external_action\":\"ON_WEB_DETAIL\",\"promotion_website_type\":\"UNSET\",\"is_share_disable\":false,\"is_comment_disable\":0,\"split_test_adgroup_ids\":[],\"gender\":\"GENDER_UNLIMITED\",\"video_download\":\"ALLOW_DOWNLOAD\",\"budget\":30,\"placement_type\":\"PLACEMENT_TYPE_AUTOMATIC\",\"rf_buy_type\":null,\"audience\":[],\"frequency\":null,\"bid_type\":\"BID_TYPE_CUSTOM\",\"status\":\"ADGROUP_STATUS_TIME_DONE\",\"campaign_id\":1685389349052433,\"exclude_custom_actions\":[],\"create_time\":\"2020-12-07 03:42:16\",\"pacing\":\"PACING_MODE_SMOOTH\",\"campaign_name\":\"Red-Conversions20201206222133\",\"buy_reach\":null,\"creative_material_mode\":\"CUSTOM\",\"adgroup_id\":1685389349830674,\"category\":0,\"buy_impression\":null,\"app_type\":null,\"carriers\":[],\"adgroup_name\":\"Ad Group20201206223839\",\"frequency_schedule\":null,\"budget_mode\":\"BUDGET_MODE_DAY\",\"connection_type\":[],\"brand_safety_partner\":null,\"enable_inventory_filter\":false,\"deep_cpabid\":0,\"brand_safety\":\"NO_BRAND_SAFETY\",\"rf_predict_frequency\":null,\"schedule_start_time\":\"2020-12-07 03:38:39\",\"schedule_end_time\":\"2020-12-10 03:38:39\",\"interest_category_v2\":[],\"is_new_structure\":true,\"placement\":null,\"skip_learning_phase\":1,\"deep_external_action\":null,\"age\":null,\"conversion_bid\":5,\"schedule_type\":\"SCHEDULE_START_END\",\"action_v2\":[],\"modify_time\":\"2020-12-08 18:44:26\",\"rf_predict_cpr\":null,\"conversion_id\":0,\"dayparting\":null}]},\"request_id\":\"202110070841330102452441380CB2F8AB\"}";
}