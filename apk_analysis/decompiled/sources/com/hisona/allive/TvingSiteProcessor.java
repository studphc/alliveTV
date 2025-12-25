package com.hisona.allive;

import android.content.Context;
import android.util.Log;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes2.dex */
public class TvingSiteProcessor extends SiteProcessor {
    public TvingSiteProcessor(Context context) {
        super(context);
        this.mChannelDatas.clear();
    }

    public boolean doLogin(SettingsData settingsData) {
        this.mAuthKey = "";
        this.mQualityType = settingsData.mTvingSettings.mQualityType.ordinal();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:224:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x06dd  */
    /* JADX WARN: Type inference failed for: r0v15, types: [java.util.ArrayList] */
    /* JADX WARN: Type inference failed for: r4v46 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7, types: [int] */
    @Override // com.hisona.allive.SiteProcessor
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean doProcess(com.hisona.allive.SettingsData r55) {
        /*
            Method dump skipped, instructions count: 1773
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hisona.allive.TvingSiteProcessor.doProcess(com.hisona.allive.SettingsData):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean getEPGList() {
        String stringById;
        ChannelData channelData;
        JsonElement jsonElement;
        String[] strArr;
        String[] strArr2 = {"C06941,C07381,C07382,C04601,C00551,C00579,C00590,C01141,C00575,C01142,C01143,C00544,C01381,C01482,C01361,C06541,C15152,C00593,C01723,C01101", "C15347,C01583,C17141,C01581,C00585,C17341,C00611,C01582,C15741,C00588,C00805,C00708,C17142,C05661,C22041"};
        int i = 2;
        int i2 = 0;
        boolean z = true;
        String[] strArr3 = {"", ""};
        String[] strArr4 = {"", ""};
        String[] strArr5 = {"", ""};
        Locale locale = Locale.US;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd", locale);
        SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat("HH0000", locale);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() + (32400000 - calendar.getTimeZone().getRawOffset()));
        strArr3[0] = simpleDateFormat.format(calendar.getTime());
        strArr4[0] = simpleDateFormat2.format(calendar.getTime());
        char c = 11;
        char c2 = 3;
        calendar.add(11, 3);
        strArr5[0] = simpleDateFormat2.format(calendar.getTime());
        strArr3[1] = simpleDateFormat.format(calendar.getTime());
        strArr4[1] = strArr5[0];
        calendar.add(11, 3);
        strArr5[1] = simpleDateFormat2.format(calendar.getTime());
        int i3 = 0;
        while (i3 < i) {
            int i4 = i2;
            while (i4 < i) {
                try {
                    String l = Long.toString(System.currentTimeMillis());
                    String str = strArr3[i3];
                    String str2 = strArr4[i3];
                    String str3 = strArr5[i3];
                    String str4 = strArr2[i4];
                    Object[] objArr = new Object[34];
                    objArr[i2] = "pageNo";
                    objArr[z ? 1 : 0] = IcyHeaders.REQUEST_HEADER_ENABLE_METADATA_VALUE;
                    objArr[i] = "pageSize";
                    objArr[c2] = "20";
                    objArr[4] = "order";
                    objArr[5] = "chno";
                    objArr[6] = "scope";
                    objArr[7] = "all";
                    objArr[8] = "adult";
                    objArr[9] = "n";
                    objArr[10] = "free";
                    objArr[11] = "all";
                    objArr[12] = "broadDate";
                    objArr[13] = str;
                    objArr[14] = "broadcastDate";
                    objArr[15] = str;
                    objArr[16] = "startBroadTime";
                    objArr[17] = str2;
                    objArr[18] = "endBroadTime";
                    objArr[19] = str3;
                    objArr[20] = "channelCode";
                    objArr[21] = str4;
                    objArr[22] = "screenCode";
                    objArr[23] = "CSSD0100";
                    objArr[24] = "networkCode";
                    objArr[25] = "CSND0900";
                    objArr[26] = "osCode";
                    objArr[27] = "CSOD0900";
                    objArr[28] = "teleCode";
                    objArr[29] = "CSCD0900";
                    objArr[30] = "apiKey";
                    objArr[31] = "1e7952d0917d6aab1f0293a063697610";
                    objArr[32] = "_";
                    objArr[33] = l;
                    HttpRequest userAgent = HttpRequest.get("https://api.tving.com/v2/media/schedules", z, objArr).trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getStringById(R.string.USERAGENT));
                    if (userAgent == null || userAgent.badRequest() || userAgent.isBodyEmpty()) {
                        return i2;
                    }
                    Iterator<JsonElement> it = JsonParser.parseString(userAgent.body()).getAsJsonObject().getAsJsonObject("body").getAsJsonArray("result").iterator();
                    while (it.hasNext()) {
                        JsonObject asJsonObject = it.next().getAsJsonObject();
                        if (asJsonObject != null && !asJsonObject.isJsonNull()) {
                            String asString = asJsonObject.get("channel_code").getAsString();
                            int i5 = i2;
                            while (true) {
                                if (i5 < this.mChannelDatas.size()) {
                                    if (this.mChannelDatas.get(i5).getId().equals(asString)) {
                                        channelData = this.mChannelDatas.get(i5);
                                        break;
                                    }
                                    i5 += z ? 1 : 0;
                                } else {
                                    channelData = null;
                                    break;
                                }
                            }
                            if (channelData != null && (jsonElement = asJsonObject.get("schedules")) != null && !jsonElement.isJsonNull()) {
                                ArrayList<EPGData> epg = channelData.getEPG();
                                if (i3 == 0) {
                                    epg.clear();
                                }
                                Iterator<JsonElement> it2 = jsonElement.getAsJsonArray().iterator();
                                while (it2.hasNext()) {
                                    JsonObject asJsonObject2 = it2.next().getAsJsonObject();
                                    String asString2 = asJsonObject2.get("broadcast_start_time").getAsString();
                                    String asString3 = asJsonObject2.get("broadcast_end_time").getAsString();
                                    boolean equals = asJsonObject2.get("free_yn").getAsString().equals("Y");
                                    try {
                                        strArr = strArr2;
                                        try {
                                            Locale locale2 = Locale.US;
                                            Date parse = new SimpleDateFormat("yyyyMMddHHmmss", locale2).parse(asString2);
                                            Date parse2 = new SimpleDateFormat("yyyyMMddHHmmss", locale2).parse(asString3);
                                            String asString4 = asJsonObject2.get("program").getAsJsonObject().get(AppMeasurementSdk.ConditionalUserProperty.NAME).getAsJsonObject().get("ko").getAsString();
                                            JsonElement jsonElement2 = asJsonObject2.get("episode");
                                            if (!jsonElement2.isJsonNull()) {
                                                asString4 = asString4 + ", " + jsonElement2.getAsJsonObject().get("frequency").getAsString() + "화";
                                            }
                                            String removeHTMLTag = Utils.removeHTMLTag(asString4);
                                            int size = epg.size();
                                            if (size == 0 || parse.compareTo(epg.get(size - 1).getEndTime()) >= 0) {
                                                epg.add(new EPGData(removeHTMLTag, parse, parse2, Boolean.FALSE, Boolean.valueOf(equals)));
                                            }
                                        } catch (ParseException e) {
                                            e = e;
                                            e.printStackTrace();
                                            strArr2 = strArr;
                                            i2 = 0;
                                            z = true;
                                        }
                                    } catch (ParseException e2) {
                                        e = e2;
                                        strArr = strArr2;
                                    }
                                    strArr2 = strArr;
                                    i2 = 0;
                                    z = true;
                                }
                            }
                        }
                    }
                    i4 += z ? 1 : 0;
                    c = 11;
                    strArr2 = strArr2;
                    i = 2;
                    i2 = 0;
                    c2 = 3;
                } catch (Exception e3) {
                    Log.e("TvingSiteProcessor", "getEPGList error: " + e3.toString());
                    if (e3.getCause() != null) {
                        stringById = e3.getCause().getLocalizedMessage();
                    } else {
                        stringById = getStringById(R.string.network_error);
                    }
                    setErrorCode(1);
                    setErrorMessage(stringById);
                    return false;
                }
            }
            i3 += z ? 1 : 0;
            strArr2 = strArr2;
            i = 2;
            c2 = 3;
        }
        return z;
    }

    @Override // com.hisona.allive.SiteProcessor
    public boolean updateProcess() {
        return getEPGList();
    }
}
