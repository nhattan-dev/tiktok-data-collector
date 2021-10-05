import service.impl.AdGroupServiceImpl;
import service.impl.AdServiceImpl;
import service.impl.CampaignServiceImpl;

public class main {

    public static void main(String[] args) {
        if (args.length == 2) {

            AdServiceImpl adService = AdServiceImpl.getInstance();
            adService.readData(args[1], args[0]);

            AdGroupServiceImpl adGroupService = AdGroupServiceImpl.getInstance();
            adGroupService.readData(args[1], args[0]);

            CampaignServiceImpl campaignService = CampaignServiceImpl.getInstance();
            campaignService.readData(args[1], args[0]);



//            AdService adService = AdServiceImpl.getInstance();
//            adService.readData(args[1], args[0]);
//
//            AdGroupService adGroupService = AdGroupServiceImpl.getInstance();
//            adGroupService.readData(args[1], args[0]);
//
//            CampaignService campaignService = CampaignServiceImpl.getInstance();
//            campaignService.readData(args[1], args[0]);
        } else {
            System.out.println("Required two args.");
        }
    }
}
