package com.hisona.allive;

import com.hisona.allive.Utils;

/* renamed from: com.hisona.allive.k */
/* loaded from: classes2.dex */
public abstract /* synthetic */ class AbstractC1078k {

    /* renamed from: a */
    public static final /* synthetic */ int[] f15996a;

    /* renamed from: b */
    public static final /* synthetic */ int[] f15997b;

    static {
        int[] iArr = new int[Utils.Code.values().length];
        f15997b = iArr;
        try {
            iArr[Utils.Code.ServiceIntent_OK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            f15997b[Utils.Code.ServiceIntent_Fail.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            f15997b[Utils.Code.ServiceIntent_Profile.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[Utils.SiteType.values().length];
        f15996a = iArr2;
        try {
            iArr2[Utils.SiteType.Wavve.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            f15996a[Utils.SiteType.Tving.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
