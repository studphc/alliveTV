package com.google.android.gms.internal.common;

import org.jspecify.annotations.NullMarked;
import p000.ye0;

@NullMarked
/* loaded from: classes.dex */
public final class zzal {
    /* renamed from: a */
    public static void m3215a(int i, Object[] objArr) {
        for (int i2 = 0; i2 < i; i2++) {
            if (objArr[i2] == null) {
                throw new NullPointerException(ye0.m8291k(i2, "at index "));
            }
        }
    }
}
