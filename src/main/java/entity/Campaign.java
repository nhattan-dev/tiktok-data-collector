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
@Table(name = "tk_campaign", schema = "public", catalog = "tiktok_data_collector")
public class Campaign {
    @Id
    @Column(name = "campaign_id")
    @JsonProperty("campaign_id")
    private Long campaignId;

    @Basic
    @Column(name = "budget")
    @JsonProperty("budget")
    private Float budget;

    @Basic
    @Column(name = "budget_optimize_switch")
    @JsonProperty("budget_optimize_switch")
    private Long budgetOptimizeSwitch;

    @Basic
    @Column(name = "advertiser_id")
    @JsonProperty("advertiser_id")
    private Long advertiserId;

    @Basic
    @Column(name = "campaign_name")
    @JsonProperty("campaign_name")
    private String campaignName;

    @Basic
    @Column(name = "create_time")
    @JsonProperty("create_time")
    private String createTime;
    
    @Basic
    @Column(name = "modify_time")
    @JsonProperty("modify_time")
    private String modifyTime;

    @Basic
    @Column(name = "objective")
    @JsonProperty("objective")
    private String objective;

    @Basic
    @Column(name = "objective_type")
    @JsonProperty("objective_type")
    private String objectiveType;

    @Basic
    @Column(name = "opt_status")
    @JsonProperty("opt_status")
    private String optStatus;

    @Basic
    @Column(name = "optimize_goal")
    @JsonProperty("optimize_goal")
    private String optimizeGoal;

    @Basic
    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    @Basic
    @Column(name = "bid_type")
    @JsonProperty("bid_type")
    private String bidType;

    @Basic
    @Column(name = "budget_mode")
    @JsonProperty("budget_mode")
    private String budgetMode;
}
