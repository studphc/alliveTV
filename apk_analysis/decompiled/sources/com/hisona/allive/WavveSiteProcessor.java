package com.hisona.allive;

import android.content.Context;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.reactivex.rxjava3.annotations.SchedulerSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class WavveSiteProcessor extends SiteProcessor {
    public WavveSiteProcessor(Context context) {
        super(context);
        this.mProfile = "";
        this.mChannelDatas.clear();
    }

    public final boolean a(SettingsData settingsData) {
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

    public final boolean b() {
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
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean doProcess(com.hisona.allive.SettingsData r39) {
        /*
            Method dump skipped, instructions count: 1262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisona.allive.WavveSiteProcessor.doProcess(com.hisona.allive.SettingsData):boolean");
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
