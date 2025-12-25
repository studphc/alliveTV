package com.hisona.allive;

import android.content.Context;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import kotlinx.coroutines.DebugKt;

/* loaded from: classes2.dex */
public class WavveSiteProcessor extends SiteProcessor {
    public WavveSiteProcessor(Context context) {
        super(context);
        this.mProfile = "";
        this.mChannelDatas.clear();
    }

    /* renamed from: a */
    public final boolean m4477a(SettingsData settingsData) {
        String stringById;
        if (this.mAuthKey == null) {
            return false;
        }
        try {
            HttpRequest send = HttpRequest.post((CharSequence) "https://apis.wavve.com/login", true, "apikey", "E5F3E0D30947AA5440556471321BB6D9", "credential", SchedulerSupport.NONE, "device", "pc", "drm", "wm", "partner", "pooq", "pooqzone", SchedulerSupport.NONE, "region", "kor", "targetage", "all").trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getStringById(R.string.USERAGENT)).acceptJson().contentType(HttpRequest.CONTENT_TYPE_JSON, "UTF-8").send("{ \"type\" : \"credential\", \"id\" : \"" + this.mAuthKey + "\", \"password\" : \"\", \"pushid\" : \"\", \"profile\" : \"" + settingsData.mWavveSettings.mProfile + "\" } ");
            if (send != null && !send.badRequest() && !send.isBodyEmpty()) {
                String body = send.body();
                if (body != null && !body.equals("null") && body.length() != 0) {
                    JsonObject asJsonObject = JsonParser.parseString(body).getAsJsonObject();
                    if (asJsonObject != null && !asJsonObject.isJsonNull()) {
                        JsonElement jsonElement = asJsonObject.get("credential");
                        if (jsonElement != null && !jsonElement.isJsonNull()) {
                            this.mAuthKey = jsonElement.getAsString();
                            this.mProfile = asJsonObject.get("profilename").getAsString();
                            return true;
                        }
                        this.mAuthKey = "";
                        JsonElement jsonElement2 = asJsonObject.get("resultmessage");
                        if (jsonElement2 != null && !jsonElement2.isJsonNull()) {
                            setErrorCode(1);
                            setErrorMessage(jsonElement2.getAsString());
                        }
                        return false;
                    }
                    setErrorCode(1);
                    setErrorMessage(getStringById(R.string.network_error));
                    return false;
                }
                setErrorCode(1);
                setErrorMessage(getStringById(R.string.network_error));
                return false;
            }
            setErrorCode(1);
            setErrorMessage(getStringById(R.string.network_error));
            return false;
        } catch (Exception e) {
            this.mAuthKey = "";
            if (e.getCause() != null) {
                stringById = e.getCause().getLocalizedMessage();
            } else {
                stringById = getStringById(R.string.network_error);
            }
            setErrorCode(1);
            setErrorMessage(stringById);
            return false;
        }
    }

    /* renamed from: b */
    public final boolean m4478b() {
        String stringById;
        String str = this.mAuthKey;
        if (str == null) {
            return false;
        }
        try {
            HttpRequest userAgent = HttpRequest.get((CharSequence) "https://apis.wavve.com/profiles", true, "limit", "10", TypedValues.CycleType.S_WAVE_OFFSET, "0", "orderby", "new", "apikey", "E5F3E0D30947AA5440556471321BB6D9", "credential", str, "device", "pc", "drm", "wm", "partner", "pooq", "pooqzone", SchedulerSupport.NONE, "region", "kor", "targetage", "all").trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getStringById(R.string.USERAGENT));
            if (userAgent != null && !userAgent.badRequest() && !userAgent.isBodyEmpty()) {
                String body = userAgent.body();
                if (body != null && !body.equals("null") && body.length() != 0) {
                    JsonObject asJsonObject = JsonParser.parseString(body).getAsJsonObject();
                    if (asJsonObject != null && !asJsonObject.isJsonNull()) {
                        JsonElement jsonElement = asJsonObject.get("list");
                        if (jsonElement != null && !jsonElement.isJsonNull()) {
                            setErrorMessage(body);
                            return true;
                        }
                        this.mAuthKey = "";
                        JsonElement jsonElement2 = asJsonObject.get("resultmessage");
                        if (jsonElement2 != null && !jsonElement2.isJsonNull()) {
                            setErrorCode(1);
                            setErrorMessage(jsonElement2.getAsString());
                        }
                        return false;
                    }
                    setErrorCode(1);
                    setErrorMessage(getStringById(R.string.network_error));
                    return false;
                }
                setErrorCode(1);
                setErrorMessage(getStringById(R.string.network_error));
                return false;
            }
            setErrorCode(1);
            setErrorMessage(getStringById(R.string.network_error));
            return false;
        } catch (Exception e) {
            this.mAuthKey = "";
            if (e.getCause() != null) {
                stringById = e.getCause().getLocalizedMessage();
            } else {
                stringById = getStringById(R.string.network_error);
            }
            setErrorCode(1);
            setErrorMessage(stringById);
            return false;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:42:0x0498, code lost:
    
        r0 = r39;
        r10 = r31;
        r3 = r32;
        r5 = r33;
        r7 = r34;
        r8 = r35;
        r9 = r36;
        r11 = r37;
     */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01ca A[RETURN] */
    @Override // com.hisona.allive.SiteProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean doProcess(SettingsData settingsData) {
        boolean z;
        String stringById;
        HttpRequest send;
        String stringById2;
        String str = "pooqzone";
        String str2 = "pooq";
        String str3 = "partner";
        String str4 = "wm";
        String str5 = "drm";
        String str6 = "credential";
        String str7 = this.mAuthKey;
        String str8 = "";
        if (str7 == null || str7.length() == 0) {
            this.mAuthKey = "";
            this.mQualityType = settingsData.mWavveSettings.mQualityType.ordinal();
            SettingsData.WavveSettingsData wavveSettingsData = settingsData.mWavveSettings;
            if (wavveSettingsData.mId != null && wavveSettingsData.mPassword != null) {
                String str9 = wavveSettingsData.mProfile;
                try {
                    send = HttpRequest.post((CharSequence) "https://apis.wavve.com/login", true, "apikey", "E5F3E0D30947AA5440556471321BB6D9", "credential", SchedulerSupport.NONE, "device", "pc", "drm", "wm", "partner", "pooq", "pooqzone", SchedulerSupport.NONE, "region", "kor", "targetage", "all").trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getStringById(R.string.USERAGENT)).acceptJson().contentType(HttpRequest.CONTENT_TYPE_JSON, "UTF-8").send("{ \"type\" : \"general\", \"id\" : \"" + settingsData.mWavveSettings.mId + "\", \"password\" : \"" + settingsData.mWavveSettings.mPassword + "\", \"pushid\" : \"\", \"profile\" : \"0\" } ");
                } catch (Exception e) {
                    this.mAuthKey = "";
                    if (e.getCause() != null) {
                        stringById = e.getCause().getLocalizedMessage();
                    } else {
                        stringById = getStringById(R.string.network_error);
                    }
                    setErrorCode(1);
                    setErrorMessage(stringById);
                }
                if (send != null && !send.badRequest() && !send.isBodyEmpty()) {
                    String body = send.body();
                    if (body != null && !body.equals("null") && body.length() != 0) {
                        JsonObject asJsonObject = JsonParser.parseString(body).getAsJsonObject();
                        if (asJsonObject != null && !asJsonObject.isJsonNull()) {
                            JsonElement jsonElement = asJsonObject.get("credential");
                            if (jsonElement != null && !jsonElement.isJsonNull()) {
                                this.mAuthKey = jsonElement.getAsString();
                                if (asJsonObject.get("profilecount").getAsInt() > 1) {
                                    if (str9 != null && !str9.equals("")) {
                                        z = m4477a(settingsData);
                                        if (!z) {
                                            return false;
                                        }
                                    }
                                    if (m4478b()) {
                                        setErrorCode(2);
                                    }
                                }
                                z = true;
                                if (!z) {
                                }
                            } else {
                                this.mAuthKey = "";
                                JsonElement jsonElement2 = asJsonObject.get("resultmessage");
                                if (jsonElement2 != null && !jsonElement2.isJsonNull()) {
                                    setErrorCode(1);
                                    setErrorMessage(jsonElement2.getAsString());
                                }
                            }
                        } else {
                            setErrorCode(1);
                            setErrorMessage(getStringById(R.string.network_error));
                        }
                    } else {
                        setErrorCode(1);
                        setErrorMessage(getStringById(R.string.network_error));
                    }
                }
                Log.e("WavveSiteProcessor", "post error");
                setErrorCode(1);
                setErrorMessage(getStringById(R.string.network_error));
            }
            z = false;
            if (!z) {
            }
        }
        String str10 = this.mAuthKey;
        if (str10 != null && str10.length() != 0) {
            this.mQualityType = settingsData.mWavveSettings.mQualityType.ordinal();
            try {
                HttpRequest userAgent = HttpRequest.get((CharSequence) "https://apis.wavve.com/filters", true, "type", "livegenre", "apikey", "E5F3E0D30947AA5440556471321BB6D9", "credential", this.mAuthKey, "device", "pc", "drm", "wm", "partner", "pooq", "pooqzone", SchedulerSupport.NONE, "region", "kor", "targetage", DebugKt.DEBUG_PROPERTY_VALUE_AUTO).trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getStringById(R.string.USERAGENT));
                if (userAgent != null && !userAgent.badRequest() && !userAgent.isBodyEmpty()) {
                    JsonArray asJsonArray = JsonParser.parseString(userAgent.body()).getAsJsonObject().getAsJsonArray("livegenre");
                    this.mChannelDatas.clear();
                    this.mCategoryDatas.clear();
                    Iterator<JsonElement> it = asJsonArray.iterator();
                    loop0: while (it.hasNext()) {
                        JsonObject asJsonObject2 = it.next().getAsJsonObject();
                        CategoryData categoryData = new CategoryData();
                        String asString = asJsonObject2.get("id").getAsString();
                        String asString2 = asJsonObject2.get(MimeTypes.BASE_TYPE_TEXT).getAsString();
                        String str11 = this.mProfile;
                        if (str11 != null && str11 != str8) {
                            asString2 = asString2 + "(" + this.mProfile + ")";
                        }
                        categoryData.setId(Integer.parseInt(asString));
                        categoryData.setTitle(asString2);
                        this.mCategoryDatas.add(categoryData);
                        int i = 0;
                        int i2 = 1;
                        while (true) {
                            Iterator<JsonElement> it2 = it;
                            String str12 = str8;
                            HttpRequest userAgent2 = HttpRequest.get((CharSequence) "https://apis.wavve.com/live/all-channels", true, "WeekDay", "all", "came", "live", "contenttype", "channel", "genre", asString, "limit", "20", TypedValues.CycleType.S_WAVE_OFFSET, Integer.toString(i), "page", Integer.toString(i2), "apikey", "E5F3E0D30947AA5440556471321BB6D9", str6, this.mAuthKey, "device", "pc", str5, str4, str3, str2, str, SchedulerSupport.NONE, "region", "kor", "targetage", DebugKt.DEBUG_PROPERTY_VALUE_AUTO).trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getStringById(R.string.USERAGENT));
                            if (userAgent2 == null || userAgent2.badRequest() || userAgent2.isBodyEmpty()) {
                                break loop0;
                            }
                            JsonObject asJsonObject3 = JsonParser.parseString(userAgent2.body()).getAsJsonObject();
                            int asInt = asJsonObject3.get("pagecount").getAsInt();
                            int asInt2 = asJsonObject3.get("count").getAsInt();
                            Iterator<JsonElement> it3 = asJsonObject3.getAsJsonArray("list").iterator();
                            while (it3.hasNext()) {
                                JsonObject asJsonObject4 = it3.next().getAsJsonObject();
                                Iterator<JsonElement> it4 = it3;
                                ChannelData channelData = new ChannelData();
                                String str13 = str;
                                String asString3 = asJsonObject4.get("channelname").getAsString();
                                String str14 = str2;
                                String asString4 = asJsonObject4.get("title").getAsString();
                                String str15 = str3;
                                String asString5 = asJsonObject4.get("channelid").getAsString();
                                String str16 = str6;
                                String asString6 = asJsonObject4.get("type").getAsString();
                                String str17 = str4;
                                StringBuilder sb = new StringBuilder();
                                String str18 = str5;
                                sb.append("http://");
                                sb.append(asJsonObject4.get(MimeTypes.BASE_TYPE_IMAGE).getAsString());
                                String sb2 = sb.toString();
                                channelData.setSiteType(Utils.SiteType.Wavve.ordinal());
                                channelData.setQualityType(this.mQualityType);
                                channelData.setTitle(asString3);
                                channelData.setProgramName(asString4);
                                channelData.setStillImageUrl(sb2);
                                channelData.setId(asString5);
                                channelData.setCategoryId(Integer.parseInt(asString));
                                channelData.setAudioChannel(Boolean.valueOf(!asString6.equals(MimeTypes.BASE_TYPE_VIDEO)));
                                this.mChannelDatas.add(channelData);
                                it3 = it4;
                                str = str13;
                                str2 = str14;
                                str3 = str15;
                                str6 = str16;
                                str4 = str17;
                                str5 = str18;
                            }
                            String str19 = str;
                            String str20 = str2;
                            String str21 = str3;
                            String str22 = str6;
                            String str23 = str4;
                            String str24 = str5;
                            if (asInt <= asInt2) {
                                break;
                            }
                            i += asInt2;
                            i2++;
                            it = it2;
                            str8 = str12;
                            str = str19;
                            str2 = str20;
                            str3 = str21;
                            str6 = str22;
                            str4 = str23;
                            str5 = str24;
                        }
                    }
                    return true;
                }
            } catch (Exception e2) {
                this.mChannelDatas.clear();
                this.mCategoryDatas.clear();
                if (e2.getCause() != null) {
                    stringById2 = e2.getCause().getLocalizedMessage();
                } else {
                    stringById2 = getStringById(R.string.network_error);
                }
                setErrorCode(1);
                setErrorMessage(stringById2);
            }
        }
        return false;
    }

    public boolean getEPGList() {
        String stringById;
        ChannelData channelData;
        Date parse;
        Date parse2;
        int size;
        char c = 11;
        char c2 = 3;
        try {
            String[] strArr = {"", ""};
            String[] strArr2 = {"", ""};
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:00", Locale.US);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
            strArr[0] = simpleDateFormat.format(calendar.getTime());
            calendar.add(11, 3);
            strArr2[0] = simpleDateFormat.format(calendar.getTime());
            calendar.add(11, 3);
            strArr[1] = strArr2[0];
            strArr2[1] = simpleDateFormat.format(calendar.getTime());
            int i = 0;
            while (i < 2) {
                String str = strArr2[i];
                String str2 = strArr[i];
                Object[] objArr = new Object[26];
                objArr[0] = "enddatetime";
                objArr[1] = str;
                objArr[2] = "genre";
                objArr[c2] = "all";
                objArr[4] = "limit";
                objArr[5] = "500";
                objArr[6] = TypedValues.CycleType.S_WAVE_OFFSET;
                objArr[7] = "0";
                objArr[8] = "startdatetime";
                objArr[9] = str2;
                objArr[10] = "apikey";
                objArr[c] = "E5F3E0D30947AA5440556471321BB6D9";
                objArr[12] = "credential";
                objArr[13] = SchedulerSupport.NONE;
                objArr[14] = "device";
                objArr[15] = "pc";
                objArr[16] = "drm";
                objArr[17] = "wm";
                objArr[18] = "partner";
                objArr[19] = "pooq";
                objArr[20] = "pooqzone";
                objArr[21] = SchedulerSupport.NONE;
                objArr[22] = "region";
                objArr[23] = "kor";
                objArr[24] = "targetage";
                objArr[25] = "all";
                HttpRequest userAgent = HttpRequest.get((CharSequence) "https://apis.wavve.com/live/epgs", true, objArr).trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getStringById(R.string.USERAGENT));
                if (userAgent != null && !userAgent.badRequest() && !userAgent.isBodyEmpty()) {
                    Iterator<JsonElement> it = JsonParser.parseString(userAgent.body()).getAsJsonObject().getAsJsonArray("list").iterator();
                    while (it.hasNext()) {
                        JsonObject asJsonObject = it.next().getAsJsonObject();
                        String asString = asJsonObject.get("channelid").getAsString();
                        int i2 = 0;
                        while (true) {
                            if (i2 < this.mChannelDatas.size()) {
                                if (this.mChannelDatas.get(i2).getId().equals(asString)) {
                                    channelData = this.mChannelDatas.get(i2);
                                    break;
                                }
                                i2++;
                            } else {
                                channelData = null;
                                break;
                            }
                        }
                        if (channelData != null) {
                            JsonArray asJsonArray = asJsonObject.getAsJsonArray("list");
                            ArrayList<EPGData> epg = channelData.getEPG();
                            if (i == 0) {
                                epg.clear();
                            }
                            Iterator<JsonElement> it2 = asJsonArray.iterator();
                            while (it2.hasNext()) {
                                JsonObject asJsonObject2 = it2.next().getAsJsonObject();
                                String removeHTMLTag = Utils.removeHTMLTag(asJsonObject2.get("title").getAsString());
                                String asString2 = asJsonObject2.get("starttime").getAsString();
                                String asString3 = asJsonObject2.get("endtime").getAsString();
                                try {
                                    Locale locale = Locale.US;
                                    parse = new SimpleDateFormat("yyyy-MM-dd HH:mm", locale).parse(asString2);
                                    parse2 = new SimpleDateFormat("yyyy-MM-dd HH:mm", locale).parse(asString3);
                                    size = epg.size();
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                                if (size != 0 && parse.compareTo(epg.get(size - 1).getEndTime()) < 0) {
                                }
                                epg.add(new EPGData(removeHTMLTag, parse, parse2, Boolean.FALSE, Boolean.TRUE));
                            }
                        }
                    }
                    i++;
                    c = 11;
                    c2 = 3;
                }
                return false;
            }
            return true;
        } catch (Exception e2) {
            if (e2.getCause() != null) {
                stringById = e2.getCause().getLocalizedMessage();
            } else {
                stringById = getStringById(R.string.network_error);
            }
            setErrorCode(1);
            setErrorMessage(stringById);
            return false;
        }
    }

    @Override // com.hisona.allive.SiteProcessor
    public boolean updateProcess() {
        return getEPGList();
    }
}
