package com.hisona.allive;

import android.app.Activity;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hisona.allive.BackgroundTask;
import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import io.reactivex.rxjava3.core.ObservableEmitter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/* loaded from: classes2.dex */
public final class u extends BackgroundTask {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public Date f;
    public int g;

    public final String a(ChannelData channelData) {
        int siteType = channelData.getSiteType();
        int qualityType = channelData.getQualityType();
        if (siteType == Utils.SiteType.Wavve.ordinal()) {
            int i = t.b[SettingsData.WavveQualityType.values()[qualityType].ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return getString(R.string.WAVVE_SD_QUALITY_TAG);
                        }
                        return getString(R.string.WAVVE_FHD_QUALITY_TAG);
                    }
                    return getString(R.string.WAVVE_HD_QUALITY_TAG);
                }
                return getString(R.string.WAVVE_SD_QUALITY_TAG);
            }
            return getString(R.string.WAVVE_MOBILE_QUALITY_TAG);
        }
        if (siteType == Utils.SiteType.Tving.ordinal()) {
            int i2 = t.c[SettingsData.TvingQualityType.values()[qualityType].ordinal()];
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 != 4) {
                            return getString(R.string.TVING_HD_QUALITY_TAG);
                        }
                        return getString(R.string.TVING_FHD_QUALITY_TAG);
                    }
                    return getString(R.string.TVING_HD_QUALITY_TAG);
                }
                return getString(R.string.TVING_SD_QUALITY_TAG);
            }
            return getString(R.string.TVING_MD_QUALITY_TAG);
        }
        return "";
    }

    @Override // com.hisona.allive.BackgroundTask
    public final void doInBackground(ObservableEmitter observableEmitter) {
        int ordinal;
        String str;
        String str2;
        String str3;
        JsonElement jsonElement;
        int ordinal2;
        ArrayList arrayList = PlayerActivity.e0;
        int i = this.g;
        if (i < 0) {
            observableEmitter.onNext(new BackgroundTask.ProgressOrResult(-1, Utils.Code.NoVideoUrl_err.ordinal()));
            return;
        }
        ChannelData channelData = (ChannelData) arrayList.get(i);
        if (channelData.getSiteType() == Utils.SiteType.Wavve.ordinal()) {
            String str4 = (String) PlayerActivity.f0.get(0);
            this.a = str4;
            if (str4 != null && str4.length() >= 10) {
                try {
                    HttpRequest header = HttpRequest.get((CharSequence) "https://delivery.wavve.com/v1/streaming/live", true, "device", "pc", "partner", "pooq", "apikey", "E5F3E0D30947AA5440556471321BB6D9", NotificationCompat.CATEGORY_SERVICE, "wavve", "pooqzone", SchedulerSupport.NONE, "region", "kor", "drm", "wm", "targetage", "all", "contentid", channelData.getId(), "audioChannel", "2ch", "hdr", "sdr", "videocodec", "avc", "audiocodec", "aac", "issurround", "n", "format", "normal", "withinsubtitle", "n", "contenttype", "live", "action", "hls", "protocol", "hls", "quality", a(channelData), "deviceModelId", "mobile", "guid", PlayerActivity.g0, "lastplayid", PlayerActivity.h0, "authtype", "cookie", "isabr", "y", "ishevc", "n").trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getString(R.string.USERAGENT)).header("wavve-credential", this.a);
                    if (header != null && !header.badRequest() && !header.isBodyEmpty()) {
                        JsonObject asJsonObject = JsonParser.parseString(header.body()).getAsJsonObject();
                        String asString = asJsonObject.get("playurl").getAsString();
                        this.b = asString;
                        if (asString != null && !asString.equals("null") && this.b.length() != 0) {
                            this.c = asJsonObject.get("awscookie").getAsString();
                            if (!this.b.contains("AVC-FHD") && !this.b.contains("live5000")) {
                                if (!this.b.contains("AVC-HD") && !this.b.contains("live2000")) {
                                    if (!this.b.contains("AVC-SD") && !this.b.contains("live1000")) {
                                        channelData.setResolution("MD");
                                        PlayerActivity.h0 = asJsonObject.get("playid").getAsString();
                                        ordinal2 = Utils.Code.FetchVideoUrl_OK.ordinal();
                                    }
                                    channelData.setResolution("SD");
                                    PlayerActivity.h0 = asJsonObject.get("playid").getAsString();
                                    ordinal2 = Utils.Code.FetchVideoUrl_OK.ordinal();
                                }
                                channelData.setResolution("HD");
                                PlayerActivity.h0 = asJsonObject.get("playid").getAsString();
                                ordinal2 = Utils.Code.FetchVideoUrl_OK.ordinal();
                            }
                            channelData.setResolution("FHD");
                            PlayerActivity.h0 = asJsonObject.get("playid").getAsString();
                            ordinal2 = Utils.Code.FetchVideoUrl_OK.ordinal();
                        }
                        ordinal2 = Utils.Code.NoVideoUrl_err.ordinal();
                    }
                    ordinal2 = Utils.Code.NoVideoUrl_err.ordinal();
                } catch (Exception unused) {
                    ordinal2 = Utils.Code.NoVideoUrl_err.ordinal();
                }
            } else {
                ordinal2 = Utils.Code.NoAuthKey_err.ordinal();
            }
            observableEmitter.onNext(new BackgroundTask.ProgressOrResult(-1, ordinal2));
            return;
        }
        if (channelData.getSiteType() == Utils.SiteType.Tving.ordinal()) {
            String str5 = (String) PlayerActivity.f0.get(1);
            this.a = str5;
            if (str5 != null && str5.length() >= 10) {
                try {
                    String l = Long.toString(System.currentTimeMillis() / 1000);
                    String id = channelData.getId();
                    HttpRequest header2 = HttpRequest.get((CharSequence) "https://api.tving.com/v2/media/stream/info", true, "apiKey", "1e7952d0917d6aab1f0293a063697610", "info", "Y", "networkCode", "CSND0900", "osCode", "CSOD0900", "teleCode", "CSCD0900", "mediaCode", id, "screenCode", "CSSD0100", "streamCode", a(channelData), "noCache", l, "callingFrom", "HTML5", "adReq", SchedulerSupport.NONE, "ooc", "").trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getString(R.string.USERAGENT)).header(HttpHeaders.COOKIE, this.a);
                    if (header2 != null && !header2.badRequest() && !header2.isBodyEmpty()) {
                        JsonObject asJsonObject2 = JsonParser.parseString(header2.body()).getAsJsonObject().getAsJsonObject("body");
                        if (!asJsonObject2.getAsJsonObject("result").get("code").getAsString().equals("000")) {
                            ordinal = Utils.Code.NoRight_err.ordinal();
                        } else {
                            JsonElement jsonElement2 = asJsonObject2.get("stream");
                            if (!jsonElement2.isJsonNull()) {
                                str = "SD";
                                str2 = "MD";
                                if (jsonElement2.getAsJsonObject().get("drm_yn").getAsString().equals("Y")) {
                                    str3 = asJsonObject2.getAsJsonObject("stream").getAsJsonObject("broadcast").getAsJsonObject("widevine").get("broad_url").getAsString();
                                    this.e = asJsonObject2.getAsJsonObject("stream").get("drm_license_assertion").getAsString();
                                    this.d = asJsonObject2.getAsJsonObject("stream").getAsJsonArray("drm_license_server_list").get(2).getAsString();
                                } else {
                                    str3 = jsonElement2.getAsJsonObject().getAsJsonObject("broadcast").get("broad_url").getAsString();
                                }
                            } else {
                                str = "SD";
                                str2 = "MD";
                                str3 = "";
                            }
                            JsonObject asJsonObject3 = asJsonObject2.getAsJsonObject(FirebaseAnalytics.Param.CONTENT).getAsJsonObject("info").getAsJsonObject("schedule");
                            String asString2 = asJsonObject3.get("broadcast_url").getAsJsonArray().get(0).getAsJsonObject().get("preview_url").getAsString();
                            if (asString2.contains("/manifest")) {
                                this.b = asString2.concat(".mpd?content_type=LIVE");
                                if (channelData.getQualityType() == SettingsData.TvingQualityType.FHD.ordinal()) {
                                    if (this.b.contains("live2000")) {
                                        this.b = this.b.replace("live2000", "live5000");
                                    } else if (this.b.contains("live1500")) {
                                        this.b = this.b.replace("live1500", "live5000");
                                    }
                                }
                            } else {
                                try {
                                    String[] tvingDecrypt = PlayerActivity.tvingDecrypt(id, str3);
                                    this.b = tvingDecrypt[0];
                                    this.c = tvingDecrypt[1];
                                } catch (Exception unused2) {
                                    this.b = "";
                                    this.c = "";
                                }
                            }
                            String str6 = this.b;
                            if (str6 != null && !str6.equals("null") && this.b.length() != 0) {
                                if (this.b.contains("live500.smil")) {
                                    channelData.setResolution(str2);
                                } else if (this.b.contains("live1000.smil")) {
                                    channelData.setResolution(str);
                                } else if (!this.b.contains("live1500.smil") && !this.b.contains("live2000.smil")) {
                                    channelData.setResolution("FHD");
                                } else {
                                    channelData.setResolution("HD");
                                }
                                if (channelData.getEPG().size() <= 1 && (jsonElement = asJsonObject3.get("episode")) != null && !jsonElement.isJsonNull()) {
                                    String asString3 = asJsonObject2.getAsJsonObject(FirebaseAnalytics.Param.CONTENT).get("broadcast_start_date").getAsString();
                                    String asString4 = asJsonObject2.getAsJsonObject(FirebaseAnalytics.Param.CONTENT).get("broadcast_end_date").getAsString();
                                    String removeHTMLTag = Utils.removeHTMLTag(jsonElement.getAsJsonObject().getAsJsonObject(AppMeasurementSdk.ConditionalUserProperty.NAME).get("ko").getAsString());
                                    channelData.setProgramName(removeHTMLTag);
                                    try {
                                        Locale locale = Locale.US;
                                        Date parse = new SimpleDateFormat("yyyyMMddHHmmss", locale).parse(asString3);
                                        Date parse2 = new SimpleDateFormat("yyyyMMddHHmmss", locale).parse(asString4);
                                        EPGData ePGData = new EPGData();
                                        ePGData.setProgramName(removeHTMLTag);
                                        ePGData.setStartTime(parse);
                                        ePGData.setEndTime(parse2);
                                        channelData.getEPG().clear();
                                        channelData.getEPG().add(ePGData);
                                        this.f = parse;
                                    } catch (ParseException e) {
                                        e.printStackTrace();
                                    }
                                }
                                ordinal = Utils.Code.FetchVideoUrl_OK.ordinal();
                            }
                            ordinal = Utils.Code.NoVideoUrl_err.ordinal();
                        }
                    }
                    ordinal = Utils.Code.NoVideoUrl_err.ordinal();
                } catch (Exception unused3) {
                    ordinal = Utils.Code.NoVideoUrl_err.ordinal();
                }
            } else {
                ordinal = Utils.Code.NoAuthKey_err.ordinal();
            }
            observableEmitter.onNext(new BackgroundTask.ProgressOrResult(-1, ordinal));
            return;
        }
        observableEmitter.onNext(new BackgroundTask.ProgressOrResult(-1, Utils.Code.NoVideoUrl_err.ordinal()));
    }

    @Override // com.hisona.allive.BackgroundTask
    public final void onPostExecute(BackgroundTask.ProgressOrResult progressOrResult) {
        Activity activity = this.mWeakReference.get();
        if (activity != null && !activity.isFinishing()) {
            Bundle bundle = new Bundle();
            bundle.putString(ImagesContract.URL, this.b);
            bundle.putString("cookie", this.c);
            bundle.putString("drmserver", this.d);
            bundle.putString("drmassert", this.e);
            Date date = this.f;
            if (date != null) {
                bundle.putLong("starttime", date.getTime());
            }
            this.mResultListener.onTaskTerminate(0, progressOrResult.result, bundle);
        }
    }
}
