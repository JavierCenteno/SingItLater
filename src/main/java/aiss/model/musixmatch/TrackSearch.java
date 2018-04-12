package aiss.model.musixmatch;

import java.util.HashMap;
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
    "restricted",
    "instrumental",
    "lyrics_body",
    "lyrics_language",
    "script_tracking_url",
    "pixel_tracking_url",
    "html_tracking_url",
    "lyrics_copyright",
    "updated_time"
})
public class TrackSearch {

    @JsonProperty("lyrics_id")
    private Integer lyricsId;
    @JsonProperty("restricted")
    private Boolean restricted;
    @JsonProperty("instrumental")
    private Boolean instrumental;
    @JsonProperty("lyrics_body")
    private String lyricsBody;
    @JsonProperty("lyrics_language")
    private String lyricsLanguage;
    @JsonProperty("script_tracking_url")
    private String scriptTrackingUrl;
    @JsonProperty("pixel_tracking_url")
    private String pixelTrackingUrl;
    @JsonProperty("html_tracking_url")
    private String htmlTrackingUrl;
    @JsonProperty("lyrics_copyright")
    private String lyricsCopyright;
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

    @JsonProperty("restricted")
    public Boolean getRestricted() {
        return restricted;
    }

    @JsonProperty("restricted")
    public void setRestricted(Boolean restricted) {
        this.restricted = restricted;
    }

    @JsonProperty("instrumental")
    public Boolean getInstrumental() {
        return instrumental;
    }

    @JsonProperty("instrumental")
    public void setInstrumental(Boolean instrumental) {
        this.instrumental = instrumental;
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
