package com.hisona.allive;

import android.content.Context;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.metadata.icy.IcyHeaders;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.common.net.HttpHeaders;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.hisona.allive.Utils;
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
    */
    public boolean doProcess(SettingsData settingsData) {
        boolean z;
        String str;
        String stringById;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        String str18;
        String str19;
        String str20;
        String str21;
        String str22;
        boolean z2;
        boolean z3;
        String stringById2;
        String num;
        Object[] objArr;
        String str23;
        String asString;
        String str24;
        String str25 = "scope";
        String str26 = "guest";
        String str27 = "free";
        String str28 = "all";
        String str29 = "adult";
        String str30 = "order";
        int i = 26;
        String str31 = "TvingSiteProcessor";
        String str32 = this.mAuthKey;
        if ((str32 == null || str32.length() == 0) && !doLogin(settingsData)) {
            return false;
        }
        String str33 = NotificationCompat.CATEGORY_STATUS;
        String str34 = "header";
        String str35 = HttpHeaders.COOKIE;
        String str36 = "https://api.tving.com/v2/media/lives";
        String str37 = this.mAuthKey;
        if (str37 != null && str37.length() != 0) {
            this.mQualityType = settingsData.mTvingSettings.mQualityType.ordinal();
            this.mChannelDatas.clear();
            this.mCategoryDatas.clear();
            ArrayList arrayList = new ArrayList();
            int i2 = 1;
            while (true) {
                try {
                    String num2 = Integer.toString(i2);
                    Object[] objArr2 = new Object[i];
                    try {
                        objArr2[0] = "pageSize";
                        objArr2[1] = "20";
                        objArr2[2] = "pageNo";
                        objArr2[3] = num2;
                        objArr2[4] = str30;
                        objArr2[5] = "chno";
                        objArr2[6] = str29;
                        objArr2[7] = str28;
                        objArr2[8] = str27;
                        objArr2[9] = str28;
                        objArr2[10] = str26;
                        objArr2[11] = str28;
                        objArr2[12] = str25;
                        objArr2[13] = str28;
                        objArr2[14] = "channelType";
                        objArr2[15] = "CPCS0100,CPCS0400";
                        objArr2[16] = "screenCode";
                        objArr2[17] = "CSSD0100";
                        objArr2[18] = "networkCode";
                        objArr2[19] = "CSND0900";
                        objArr2[20] = "osCode";
                        objArr2[21] = "CSOD0900";
                        objArr2[22] = "teleCode";
                        objArr2[23] = "CSCD0900";
                        objArr2[24] = "apiKey";
                        objArr2[25] = "1e7952d0917d6aab1f0293a063697610";
                        str2 = str31;
                    } catch (Exception e) {
                        e = e;
                        str = str31;
                        z = false;
                        Log.e(str, "getLiveTvList error: " + e.toString());
                        this.mChannelDatas.clear();
                        this.mCategoryDatas.clear();
                        if (e.getCause() == null) {
                            stringById = e.getCause().getLocalizedMessage();
                        } else {
                            stringById = getStringById(R.string.network_error);
                        }
                        setErrorCode(1);
                        setErrorMessage(stringById);
                        return z;
                    }
                    try {
                        HttpRequest header = HttpRequest.get((CharSequence) str36, true, objArr2).trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getStringById(R.string.USERAGENT)).header(str35, this.mAuthKey);
                        if (header == null || header.badRequest() || header.isBodyEmpty()) {
                            break;
                        }
                        JsonObject asJsonObject = JsonParser.parseString(header.body()).getAsJsonObject();
                        int asInt = asJsonObject.getAsJsonObject(str34).get(str33).getAsInt();
                        String str38 = "category_name";
                        str3 = str33;
                        String str39 = "category_code";
                        str4 = str34;
                        String str40 = "code";
                        str5 = str35;
                        str6 = "result";
                        str7 = str36;
                        str8 = "Y";
                        str9 = str25;
                        str10 = "has_more";
                        str11 = str26;
                        str12 = "body";
                        str13 = str27;
                        str14 = str28;
                        str15 = str29;
                        String str41 = "channel";
                        str16 = str30;
                        String str42 = "schedule";
                        String str43 = "program";
                        if (asInt != 200) {
                            str17 = "category_code";
                            str18 = "category_name";
                            str19 = "channel";
                            str20 = "code";
                            str21 = "schedule";
                            str22 = str43;
                            break;
                        }
                        JsonObject asJsonObject2 = asJsonObject.getAsJsonObject("body");
                        JsonPrimitive asJsonPrimitive = asJsonObject2.getAsJsonPrimitive("has_more");
                        boolean equals = asJsonPrimitive != null ? asJsonPrimitive.getAsString().equals("Y") : false;
                        Iterator<JsonElement> it = asJsonObject2.getAsJsonArray("result").iterator();
                        while (it.hasNext()) {
                            JsonObject asJsonObject3 = it.next().getAsJsonObject();
                            if (!asJsonObject3.get(str42).isJsonNull()) {
                                JsonObject asJsonObject4 = asJsonObject3.getAsJsonObject(str42);
                                if (!asJsonObject4.get(str41).isJsonNull()) {
                                    Iterator<JsonElement> it2 = it;
                                    JsonObject asJsonObject5 = asJsonObject4.getAsJsonObject(str41);
                                    String str44 = str40;
                                    String asString2 = asJsonObject5.get(str40).getAsString();
                                    String str45 = str41;
                                    String asString3 = asJsonObject5.getAsJsonObject(AppMeasurementSdk.ConditionalUserProperty.NAME).get("ko").getAsString();
                                    String str46 = str39;
                                    String str47 = str42;
                                    String substring = asJsonObject5.get(str39).getAsString().substring(2);
                                    String asString4 = asJsonObject5.getAsJsonObject(str38).get("ko").getAsString();
                                    String str48 = str38;
                                    int i3 = 0;
                                    while (true) {
                                        if (i3 < arrayList.size()) {
                                            if (asString2.equals(((ChannelData) arrayList.get(i3)).getId())) {
                                                break;
                                            }
                                            i3++;
                                        } else {
                                            int parseInt = Integer.parseInt(substring);
                                            int i4 = 0;
                                            while (true) {
                                                if (i4 < this.mCategoryDatas.size()) {
                                                    if (this.mCategoryDatas.get(i4).getId() == parseInt) {
                                                        break;
                                                    }
                                                    i4++;
                                                } else {
                                                    CategoryData categoryData = new CategoryData();
                                                    categoryData.setId(parseInt);
                                                    categoryData.setTitle(asString4 + " (실시간)");
                                                    this.mCategoryDatas.add(categoryData);
                                                    break;
                                                }
                                            }
                                            String str49 = str43;
                                            if (!asJsonObject4.get(str49).isJsonNull()) {
                                                String asString5 = asJsonObject4.getAsJsonObject(str49).getAsJsonObject(AppMeasurementSdk.ConditionalUserProperty.NAME).get("ko").getAsString();
                                                ChannelData channelData = new ChannelData();
                                                channelData.setSiteType(Utils.SiteType.Tving.ordinal());
                                                channelData.setQualityType(this.mQualityType);
                                                channelData.setTitle(asString3);
                                                channelData.setProgramName(asString5);
                                                channelData.setStillImageUrl("http://stillshot.tving.com/thumbnail/" + asString2 + "_0_320x180.jpg");
                                                channelData.setId(asString2);
                                                channelData.setCategoryId(parseInt);
                                                channelData.setAudioChannel(Boolean.FALSE);
                                                arrayList.add(channelData);
                                            }
                                            str43 = str49;
                                        }
                                    }
                                    it = it2;
                                    str41 = str45;
                                    str40 = str44;
                                    str42 = str47;
                                    str39 = str46;
                                    str38 = str48;
                                }
                            }
                        }
                        str17 = str39;
                        str18 = str38;
                        str19 = str41;
                        str20 = str40;
                        str21 = str42;
                        str22 = str43;
                        if (!equals) {
                            break;
                        }
                        i2++;
                        str31 = str2;
                        str33 = str3;
                        str36 = str7;
                        str25 = str9;
                        str26 = str11;
                        str27 = str13;
                        str28 = str14;
                        str29 = str15;
                        str30 = str16;
                        str35 = str5;
                        str34 = str4;
                        i = 26;
                    } catch (Exception e2) {
                        e = e2;
                        str = str2;
                        z = false;
                        Log.e(str, "getLiveTvList error: " + e.toString());
                        this.mChannelDatas.clear();
                        this.mCategoryDatas.clear();
                        if (e.getCause() == null) {
                        }
                        setErrorCode(1);
                        setErrorMessage(stringById);
                        return z;
                    }
                } catch (Exception e3) {
                    e = e3;
                    str = str31;
                }
            }
            Iterator<CategoryData> it3 = this.mCategoryDatas.iterator();
            while (it3.hasNext()) {
                CategoryData next = it3.next();
                for (int i5 = 0; i5 < arrayList.size(); i5++) {
                    ChannelData channelData2 = (ChannelData) arrayList.get(i5);
                    if (next.getId() == channelData2.getCategoryId()) {
                        this.mChannelDatas.add(channelData2);
                    }
                }
            }
            String str50 = this.mAuthKey;
            if (str50 != null && str50.length() != 0) {
                this.mQualityType = settingsData.mTvingSettings.mQualityType.ordinal();
                ?? arrayList2 = new ArrayList();
                int i6 = 1;
                while (true) {
                    try {
                        num = Integer.toString(i6);
                        objArr = new Object[26];
                        z2 = false;
                    } catch (Exception e4) {
                        e = e4;
                        z2 = false;
                    }
                    try {
                        objArr[0] = "pageSize";
                        objArr[1] = "20";
                        objArr[2] = "pageNo";
                        objArr[3] = num;
                        objArr[4] = str16;
                        objArr[5] = "rating";
                        objArr[6] = str15;
                        objArr[7] = str14;
                        objArr[8] = str13;
                        objArr[9] = str14;
                        objArr[10] = str11;
                        objArr[11] = str14;
                        objArr[12] = str9;
                        objArr[13] = str14;
                        objArr[14] = "channelType";
                        objArr[15] = "CPCS0300";
                        objArr[16] = "screenCode";
                        objArr[17] = "CSSD0100";
                        objArr[18] = "networkCode";
                        objArr[19] = "CSND0900";
                        objArr[20] = "osCode";
                        objArr[21] = "CSOD0900";
                        objArr[22] = "teleCode";
                        objArr[23] = "CSCD0900";
                        objArr[24] = "apiKey";
                        objArr[25] = "1e7952d0917d6aab1f0293a063697610";
                        String str51 = str7;
                        String str52 = str5;
                        HttpRequest header2 = HttpRequest.get((CharSequence) str51, true, objArr).trustAllHosts().trustAllCerts().connectTimeout(5000).userAgent(getStringById(R.string.USERAGENT)).header(str52, this.mAuthKey);
                        if (header2 == null || header2.badRequest() || header2.isBodyEmpty()) {
                            break;
                        }
                        JsonObject asJsonObject6 = JsonParser.parseString(header2.body()).getAsJsonObject();
                        String str53 = str4;
                        str7 = str51;
                        String str54 = str3;
                        str3 = str54;
                        if (asJsonObject6.getAsJsonObject(str53).get(str54).getAsInt() != 200) {
                            z2 = false;
                            break;
                        }
                        JsonObject asJsonObject7 = asJsonObject6.getAsJsonObject(str12);
                        JsonPrimitive asJsonPrimitive2 = asJsonObject7.getAsJsonPrimitive(str10);
                        boolean equals2 = asJsonPrimitive2 != null ? asJsonPrimitive2.getAsString().equals(str8) : false;
                        Iterator<JsonElement> it4 = asJsonObject7.getAsJsonArray(str6).iterator();
                        while (it4.hasNext()) {
                            JsonObject asJsonObject8 = it4.next().getAsJsonObject();
                            String str55 = str10;
                            String str56 = str21;
                            if (asJsonObject8.get(str56).isJsonNull()) {
                                str21 = str56;
                            } else {
                                JsonObject asJsonObject9 = asJsonObject8.getAsJsonObject(str56);
                                str21 = str56;
                                String str57 = str19;
                                if (asJsonObject9.get(str57).isJsonNull()) {
                                    str19 = str57;
                                } else {
                                    String str58 = str8;
                                    JsonObject asJsonObject10 = asJsonObject9.getAsJsonObject(str57);
                                    str19 = str57;
                                    String str59 = str20;
                                    str20 = str59;
                                    String asString6 = asJsonObject10.get(str59).getAsString();
                                    String str60 = str12;
                                    String asString7 = asJsonObject10.getAsJsonObject(AppMeasurementSdk.ConditionalUserProperty.NAME).get("ko").getAsString();
                                    Iterator<JsonElement> it5 = it4;
                                    String str61 = str17;
                                    str17 = str61;
                                    String str62 = str52;
                                    String substring2 = asJsonObject10.get(str61).getAsString().substring(2);
                                    String str63 = str18;
                                    String asString8 = asJsonObject10.getAsJsonObject(str63).get("ko").getAsString();
                                    str18 = str63;
                                    String str64 = str53;
                                    int i7 = 0;
                                    while (true) {
                                        if (i7 < arrayList2.size()) {
                                            if (asString6.equals(((ChannelData) arrayList2.get(i7)).getId())) {
                                                it4 = it5;
                                                str10 = str55;
                                                str8 = str58;
                                                str12 = str60;
                                                str52 = str62;
                                                str53 = str64;
                                                break;
                                            }
                                            i7++;
                                        } else {
                                            int parseInt2 = Integer.parseInt(substring2) + 1;
                                            String str65 = str6;
                                            int i8 = 0;
                                            while (true) {
                                                if (i8 < this.mCategoryDatas.size()) {
                                                    if (this.mCategoryDatas.get(i8).getId() == parseInt2) {
                                                        break;
                                                    }
                                                    i8++;
                                                } else {
                                                    CategoryData categoryData2 = new CategoryData();
                                                    categoryData2.setId(parseInt2);
                                                    categoryData2.setTitle(asString8 + " (TVING)");
                                                    this.mCategoryDatas.add(categoryData2);
                                                    break;
                                                }
                                            }
                                            str23 = "";
                                            if (substring2.equals("100")) {
                                                if (!asJsonObject9.get("movie").isJsonNull()) {
                                                    JsonObject asJsonObject11 = asJsonObject9.get("movie").getAsJsonObject();
                                                    asString = asJsonObject11.getAsJsonObject(AppMeasurementSdk.ConditionalUserProperty.NAME).get("ko").getAsString();
                                                    JsonArray asJsonArray = asJsonObject11.getAsJsonArray(MimeTypes.BASE_TYPE_IMAGE);
                                                    str24 = asJsonArray != null ? asJsonArray.get(0).getAsJsonObject().get(ImagesContract.URL).getAsString() : "";
                                                    str23 = asString;
                                                }
                                                str24 = "";
                                            } else {
                                                if (!asJsonObject9.get(str22).isJsonNull()) {
                                                    JsonObject asJsonObject12 = asJsonObject9.getAsJsonObject(str22);
                                                    asString = asJsonObject12.getAsJsonObject(AppMeasurementSdk.ConditionalUserProperty.NAME).get("ko").getAsString();
                                                    JsonArray asJsonArray2 = asJsonObject12.getAsJsonArray(MimeTypes.BASE_TYPE_IMAGE);
                                                    if (asJsonArray2 != null) {
                                                        str23 = asJsonArray2.get(0).getAsJsonObject().get(ImagesContract.URL).getAsString();
                                                    }
                                                    str24 = str23;
                                                    str23 = asString;
                                                }
                                                str24 = "";
                                            }
                                            ChannelData channelData3 = new ChannelData();
                                            channelData3.setSiteType(Utils.SiteType.Tving.ordinal());
                                            channelData3.setQualityType(this.mQualityType);
                                            channelData3.setTitle(asString7);
                                            channelData3.setProgramName(str23);
                                            channelData3.setStillImageUrl("https://image.tving.com" + str24 + "/dims/resize/400");
                                            channelData3.setId(asString6);
                                            channelData3.setCategoryId(parseInt2);
                                            channelData3.setAudioChannel(Boolean.FALSE);
                                            arrayList2.add(channelData3);
                                            it4 = it5;
                                            str10 = str55;
                                            str8 = str58;
                                            str12 = str60;
                                            str52 = str62;
                                            str53 = str64;
                                            str6 = str65;
                                        }
                                    }
                                }
                            }
                            str10 = str55;
                        }
                        String str66 = str10;
                        String str67 = str8;
                        String str68 = str12;
                        String str69 = str52;
                        String str70 = str53;
                        String str71 = str6;
                        z2 = false;
                        if (!equals2) {
                            break;
                        }
                        i6++;
                        str10 = str66;
                        str8 = str67;
                        str12 = str68;
                        str5 = str69;
                        str4 = str70;
                        str6 = str71;
                    } catch (Exception e5) {
                        e = e5;
                        Log.e(str2, "getTvingTvList error: " + e.toString());
                        if (e.getCause() != null) {
                            stringById2 = e.getCause().getLocalizedMessage();
                        } else {
                            stringById2 = getStringById(R.string.network_error);
                        }
                        setErrorCode(1);
                        setErrorMessage(stringById2);
                        z3 = z2;
                        return z3;
                    }
                }
                Iterator<CategoryData> it6 = this.mCategoryDatas.iterator();
                while (it6.hasNext()) {
                    CategoryData next2 = it6.next();
                    for (?? r4 = z2; r4 < arrayList2.size(); r4++) {
                        ChannelData channelData4 = (ChannelData) arrayList2.get(r4);
                        if (next2.getId() == channelData4.getCategoryId()) {
                            this.mChannelDatas.add(channelData4);
                        }
                    }
                }
                z3 = true;
                return z3;
            }
            z2 = false;
            z3 = z2;
            return z3;
        }
        z = false;
        return z;
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
