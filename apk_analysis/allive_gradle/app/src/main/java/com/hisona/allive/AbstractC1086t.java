package com.hisona.allive;

import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;

/* renamed from: com.hisona.allive.t */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1086t {

    /* renamed from: a */
    public static final /* synthetic */ int[] f16005a;

    /* renamed from: b */
    public static final /* synthetic */ int[] f16006b;

    /* renamed from: c */
    public static final /* synthetic */ int[] f16007c;

    static {
        int[] iArr = new int[SettingsData.TvingQualityType.values().length];
        f16007c = iArr;
        try {
            iArr[SettingsData.TvingQualityType.MD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f16007c[SettingsData.TvingQualityType.SD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f16007c[SettingsData.TvingQualityType.HD.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            f16007c[SettingsData.TvingQualityType.FHD.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[SettingsData.WavveQualityType.values().length];
        f16006b = iArr2;
        try {
            iArr2[SettingsData.WavveQualityType.MD.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            f16006b[SettingsData.WavveQualityType.SD.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            f16006b[SettingsData.WavveQualityType.HD.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            f16006b[SettingsData.WavveQualityType.FHD.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        int[] iArr3 = new int[Utils.Code.values().length];
        f16005a = iArr3;
        try {
            iArr3[Utils.Code.NoAuthKey_err.ordinal()] = 1;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            f16005a[Utils.Code.NoVideoUrl_err.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            f16005a[Utils.Code.NoRight_err.ordinal()] = 3;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            f16005a[Utils.Code.FetchVideoUrl_OK.ordinal()] = 4;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
