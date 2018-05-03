
package aiss.model.musicxmatch;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "lyrics_id",
    "can_edit",
    "locked",
    "published_status",
    "action_requested",
    "verified",
    "restricted",
    "instrumental",
    "explicit",
    "lyrics_body",
    "lyrics_language",
    "lyrics_language_description",
    "script_tracking_url",
    "pixel_tracking_url",
    "html_tracking_url",
    "lyrics_copyright",
    "writer_list",
    "publisher_list",
    "backlink_url",
    "updated_time"
})
public class Lyrics {

    @JsonProperty("lyrics_id")
    private Integer lyricsId;
    @JsonProperty("can_edit")
    private Integer canEdit;
    @JsonProperty("locked")
    private Integer locked;
    @JsonProperty("published_status")
    private Integer publishedStatus;
    @JsonProperty("action_requested")
    private String actionRequested;
    @JsonProperty("verified")
    private Integer verified;
    @JsonProperty("restricted")
    private Integer restricted;
    @JsonProperty("instrumental")
    private Integer instrumental;
    @JsonProperty("explicit")
    private Integer explicit;
    @JsonProperty("lyrics_body")
    private String lyricsBody;
    @JsonProperty("lyrics_language")
    private String lyricsLanguage;
    @JsonProperty("lyrics_language_description")
    private String lyricsLanguageDescription;
    @JsonProperty("script_tracking_url")
    private String scriptTrackingUrl;
    @JsonProperty("pixel_tracking_url")
    private String pixelTrackingUrl;
    @JsonProperty("html_tracking_url")
    private String htmlTrackingUrl;
    @JsonProperty("lyrics_copyright")
    private String lyricsCopyright;
    @JsonProperty("writer_list")
    private List<Object> writerList = null;
    @JsonProperty("publisher_list")
    private List<Object> publisherList = null;
    @JsonProperty("backlink_url")
    private String backlinkUrl;
    @JsonProperty("updated_time")
    private String updatedTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("lyrics_id")
    public Integer getLyricsId() {
        return lyricsId;
    }

    @JsonProperty("lyrics_id")
    public void setLyricsId(Integer lyricsId) {
        this.lyricsId = lyricsId;
    }

    @JsonProperty("can_edit")
    public Integer getCanEdit() {
        return canEdit;
    }

    @JsonProperty("can_edit")
    public void setCanEdit(Integer canEdit) {
        this.canEdit = canEdit;
    }

    @JsonProperty("locked")
    public Integer getLocked() {
        return locked;
    }

    @JsonProperty("locked")
    public void setLocked(Integer locked) {
        this.locked = locked;
    }

    @JsonProperty("published_status")
    public Integer getPublishedStatus() {
        return publishedStatus;
    }

    @JsonProperty("published_status")
    public void setPublishedStatus(Integer publishedStatus) {
        this.publishedStatus = publishedStatus;
    }

    @JsonProperty("action_requested")
    public String getActionRequested() {
        return actionRequested;
    }

    @JsonProperty("action_requested")
    public void setActionRequested(String actionRequested) {
        this.actionRequested = actionRequested;
    }

    @JsonProperty("verified")
    public Integer getVerified() {
        return verified;
    }

    @JsonProperty("verified")
    public void setVerified(Integer verified) {
        this.verified = verified;
    }

    @JsonProperty("restricted")
    public Integer getRestricted() {
        return restricted;
    }

    @JsonProperty("restricted")
    public void setRestricted(Integer restricted) {
        this.restricted = restricted;
    }

    @JsonProperty("instrumental")
    public Integer getInstrumental() {
        return instrumental;
    }

    @JsonProperty("instrumental")
    public void setInstrumental(Integer instrumental) {
        this.instrumental = instrumental;
    }

    @JsonProperty("explicit")
    public Integer getExplicit() {
        return explicit;
    }

    @JsonProperty("explicit")
    public void setExplicit(Integer explicit) {
        this.explicit = explicit;
    }

    @JsonProperty("lyrics_body")
    public String getLyricsBody() {
        return lyricsBody;
    }

    @JsonProperty("lyrics_body")
    public void setLyricsBody(String lyricsBody) {
        this.lyricsBody = lyricsBody;
    }

    @JsonProperty("lyrics_language")
    public String getLyricsLanguage() {
        return lyricsLanguage;
    }

    @JsonProperty("lyrics_language")
    public void setLyricsLanguage(String lyricsLanguage) {
        this.lyricsLanguage = lyricsLanguage;
    }

    @JsonProperty("lyrics_language_description")
    public String getLyricsLanguageDescription() {
        return lyricsLanguageDescription;
    }

    @JsonProperty("lyrics_language_description")
    public void setLyricsLanguageDescription(String lyricsLanguageDescription) {
        this.lyricsLanguageDescription = lyricsLanguageDescription;
    }

    @JsonProperty("script_tracking_url")
    public String getScriptTrackingUrl() {
        return scriptTrackingUrl;
    }

    @JsonProperty("script_tracking_url")
    public void setScriptTrackingUrl(String scriptTrackingUrl) {
        this.scriptTrackingUrl = scriptTrackingUrl;
    }

    @JsonProperty("pixel_tracking_url")
    public String getPixelTrackingUrl() {
        return pixelTrackingUrl;
    }

    @JsonProperty("pixel_tracking_url")
    public void setPixelTrackingUrl(String pixelTrackingUrl) {
        this.pixelTrackingUrl = pixelTrackingUrl;
    }

    @JsonProperty("html_tracking_url")
    public String getHtmlTrackingUrl() {
        return htmlTrackingUrl;
    }

    @JsonProperty("html_tracking_url")
    public void setHtmlTrackingUrl(String htmlTrackingUrl) {
        this.htmlTrackingUrl = htmlTrackingUrl;
    }

    @JsonProperty("lyrics_copyright")
    public String getLyricsCopyright() {
        return lyricsCopyright;
    }

    @JsonProperty("lyrics_copyright")
    public void setLyricsCopyright(String lyricsCopyright) {
        this.lyricsCopyright = lyricsCopyright;
    }

    @JsonProperty("writer_list")
    public List<Object> getWriterList() {
        return writerList;
    }

    @JsonProperty("writer_list")
    public void setWriterList(List<Object> writerList) {
        this.writerList = writerList;
    }

    @JsonProperty("publisher_list")
    public List<Object> getPublisherList() {
        return publisherList;
    }

    @JsonProperty("publisher_list")
    public void setPublisherList(List<Object> publisherList) {
        this.publisherList = publisherList;
    }

    @JsonProperty("backlink_url")
    public String getBacklinkUrl() {
        return backlinkUrl;
    }

    @JsonProperty("backlink_url")
    public void setBacklinkUrl(String backlinkUrl) {
        this.backlinkUrl = backlinkUrl;
    }

    @JsonProperty("updated_time")
    public String getUpdatedTime() {
        return updatedTime;
    }

    @JsonProperty("updated_time")
    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
