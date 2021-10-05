package service;

import java.io.IOException;

public interface Service {
    void readData(String accessToken, String advertiser_id) throws IOException;
}
