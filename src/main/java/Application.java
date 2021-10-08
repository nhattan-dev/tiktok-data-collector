import org.apache.log4j.Logger;
import service.impl.AdGroupServiceImpl;
import service.impl.AdServiceImpl;
import service.impl.CampaignServiceImpl;

public class Application {
    private static final Logger logger = Logger.getLogger(Application.class);
    public static void main(String[] args) {
        if (args.length == 2) {
            AdServiceImpl adService = AdServiceImpl.getInstance();
            adService.readData(args[1], args[0]);

            AdGroupServiceImpl adGroupService = AdGroupServiceImpl.getInstance();
            adGroupService.readData(args[1], args[0]);

            CampaignServiceImpl campaignService = CampaignServiceImpl.getInstance();
            campaignService.readData(args[1], args[0]);
        } else {
            logger.error("Required two args.");
        }
    }
}
