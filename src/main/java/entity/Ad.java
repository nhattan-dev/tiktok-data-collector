package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tk_ad", schema = "public", catalog = "tiktok_data_collector")
public class Ad {
    @Id
    @Column(name = "ad_id")
    @JsonProperty("ad_id")
    private Long adId;

    @Basic
    @Column(name = "ad_format")
    @JsonProperty("ad_format")
    private String adFormat;

    @Basic
    @Column(name = "ad_name")
    @JsonProperty("ad_name")
    private String adName;

    @Basic
    @Column(name = "ad_text")
    @JsonProperty("ad_text")
    private String adText;

    @Basic
    @Column(name = "adgroup_id")
    @JsonProperty("adgroup_id")
    private Long adgroupId;

    @Basic
    @Column(name = "adgroup_name")
    @JsonProperty("adgroup_name")
    private String adgroupName;

    @Basic
    @Column(name = "advertiser_id")
    @JsonProperty("advertiser_id")
    private Long advertiserId;

    @Basic
    @Column(name = "app_name")
    @JsonProperty("app_name")
    private String appName;

    @Basic
    @Column(name = "campaign_id")
    @JsonProperty("campaign_id")
    private Long campaignId;

    @Basic
    @Column(name = "campaign_name")
    @JsonProperty("campaign_name")
    private String campaignName;

    @Basic
    @Column(name = "opt_status")
    @JsonProperty("opt_status")
    private String optStatus;

    @Basic
    @Column(name = "status")
    @JsonProperty("status")
    private String status;
}
