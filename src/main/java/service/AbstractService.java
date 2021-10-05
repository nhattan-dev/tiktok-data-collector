package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import utils.APIUtils;
import utils.ObjectMapperUtils;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractService<T, K> {
    private static final long PAGE_SIZE = 20;

    protected List<T> getList(String advertiser_id, String accessToken) {
        int currentPage = 1;
        int totalPage;
        List<T> result = new ArrayList<>();
        ObjectMapper mapper = ObjectMapperUtils.getInstance();
        do {
            String args = String.format("{\"advertiser_id\": \"%s\", \"page_size\": \"%s\", \"page\": \"%s\"}"
                    , advertiser_id, PAGE_SIZE, currentPage);
            String responseString = "";
            responseString = APIUtils.get(args, url(), accessToken);
            K response = convert(mapper, responseString);
            totalPage = getTotalPage(response);
            result.addAll(getList(response));
            currentPage++;
        } while (currentPage <= totalPage);
        return result;
    }

    protected abstract String url();

    protected abstract K convert(ObjectMapper mapper, String responseString);

    protected abstract int getTotalPage(K k);

    protected abstract List<T> getList(K k);
}
