package com.hisona.allive;

import com.hisona.allive.SettingsData;
import com.hisona.allive.Utils;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class t {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;
    public static final /* synthetic */ int[] c;

    static {
        int[] iArr = new int[SettingsData.TvingQualityType.values().length];
        c = iArr;
        try {
            iArr[SettingsData.TvingQualityType.MD.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            c[SettingsData.TvingQualityType.SD.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            c[SettingsData.TvingQualityType.HD.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        try {
            c[SettingsData.TvingQualityType.FHD.ordinal()] = 4;
        } catch (NoSuchFieldError unused4) {
        }
        int[] iArr2 = new int[SettingsData.WavveQualityType.values().length];
        b = iArr2;
        try {
            iArr2[SettingsData.WavveQualityType.MD.ordinal()] = 1;
        } catch (NoSuchFieldError unused5) {
        }
        try {
            b[SettingsData.WavveQualityType.SD.ordinal()] = 2;
        } catch (NoSuchFieldError unused6) {
        }
        try {
            b[SettingsData.WavveQualityType.HD.ordinal()] = 3;
        } catch (NoSuchFieldError unused7) {
        }
        try {
            b[SettingsData.WavveQualityType.FHD.ordinal()] = 4;
        } catch (NoSuchFieldError unused8) {
        }
        int[] iArr3 = new int[Utils.Code.values().length];
        a = iArr3;
        try {
            iArr3[Utils.Code.NoAuthKey_err.ordinal()] = 1;
        } catch (NoSuchFieldError unused9) {
        }
        try {
            a[Utils.Code.NoVideoUrl_err.ordinal()] = 2;
        } catch (NoSuchFieldError unused10) {
        }
        try {
            a[Utils.Code.NoRight_err.ordinal()] = 3;
        } catch (NoSuchFieldError unused11) {
        }
        try {
            a[Utils.Code.FetchVideoUrl_OK.ordinal()] = 4;
        } catch (NoSuchFieldError unused12) {
        }
    }
}
