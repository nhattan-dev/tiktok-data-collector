import service.AdGroupService;
import service.AdService;
import service.CampaignService;
import service.impl.AdGroupServiceImpl;
import service.impl.AdServiceImpl;
import service.impl.CampaignServiceImpl;

import java.io.IOException;

public class main {

    public static void main(String[] args) throws IOException {
        if (args.length == 2) {

            AdService adService = AdServiceImpl.getInstance();
            adService.readData(args[1], args[0]);

            AdGroupService adGroupService = AdGroupServiceImpl.getInstance();
            adGroupService.readData(args[1], args[0]);

            CampaignService campaignService = CampaignServiceImpl.getInstance();
            campaignService.readData(args[1], args[0]);
        } else {
            System.out.println("Required two args.");
        }
    }
}
