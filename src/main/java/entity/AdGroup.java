package entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@ToString
@Entity
@Table(name = "tk_adgroup", schema = "public", catalog = "tiktok_data_collector")
public class AdGroup {
    @Id
    @Column(name = "adgroup_id")
    @JsonProperty("adgroup_id")
    private Long adgroupId;

    @Basic
    @Column(name = "advertiser_id")
    @JsonProperty("advertiser_id")
    private Long advertiserId;

    @Basic
    @Column(name = "adgroup_name")
    @JsonProperty("adgroup_name")
    private String adgroupName;

    @Basic
    @Column(name = "age")
    @JsonProperty("age")
    private String age;

    @Basic
    @Column(name = "campaign_id")
    @JsonProperty("campaign_id")
    private Long campaignId;

    @Basic
    @Column(name = "campaign_name")
    @JsonProperty("campaign_name")
    private String campaignName;

    @Basic
    @Column(name = "gender")
    @JsonProperty("gender")
    private String gender;

    @Basic
    @Column(name = "location")
    @JsonProperty("location")
    private String location;

    @Basic
    @Column(name = "opt_status")
    @JsonProperty("opt_status")
    private String optStatus;

    @Basic
    @Column(name = "schedule_start_time")
    @JsonProperty("schedule_start_time")
    private Date scheduleStartTime;

    @Basic
    @Column(name = "languages")
    private String languages;

    @Basic
    @Column(name = "create_time")
    @JsonProperty("create_time")
    private String createTime;

    @Basic
    @Column(name = "modify_time")
    @JsonProperty("modify_time")
    private String modifyTime;

    @Basic
    @Column(name = "schedule_end_time")
    @JsonProperty("schedule_end_time")
    private Date scheduleEndTime;

    @Basic
    @Column(name = "status")
    @JsonProperty("status")
    private String status;

    public void setLocation(List<Long> location) {
        this.location = location.stream().map(String::valueOf).collect(Collectors.joining(","));
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages == null ? null : String.join(",", languages);
    }

    public void setAge(List<String> age) {
        this.age = age == null ? null : String.join(",", age);
    }
}
