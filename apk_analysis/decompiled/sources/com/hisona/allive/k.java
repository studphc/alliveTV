package com.hisona.allive;

import com.hisona.allive.Utils;

/* loaded from: classes2.dex */
public abstract /* synthetic */ class k {
    public static final /* synthetic */ int[] a;
    public static final /* synthetic */ int[] b;

    static {
        int[] iArr = new int[Utils.Code.values().length];
        b = iArr;
        try {
            iArr[Utils.Code.ServiceIntent_OK.ordinal()] = 1;
        } catch (NoSuchFieldError unused) {
        }
        try {
            b[Utils.Code.ServiceIntent_Fail.ordinal()] = 2;
        } catch (NoSuchFieldError unused2) {
        }
        try {
            b[Utils.Code.ServiceIntent_Profile.ordinal()] = 3;
        } catch (NoSuchFieldError unused3) {
        }
        int[] iArr2 = new int[Utils.SiteType.values().length];
        a = iArr2;
        try {
            iArr2[Utils.SiteType.Wavve.ordinal()] = 1;
        } catch (NoSuchFieldError unused4) {
        }
        try {
            a[Utils.SiteType.Tving.ordinal()] = 2;
        } catch (NoSuchFieldError unused5) {
        }
    }
}
