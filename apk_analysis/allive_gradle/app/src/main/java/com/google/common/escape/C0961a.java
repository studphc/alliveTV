package com.google.common.escape;

import com.google.common.escape.Escapers;
import java.util.HashMap;

/* renamed from: com.google.common.escape.a */
/* loaded from: classes.dex */
public final class C0961a extends ArrayBasedCharEscaper {

    /* renamed from: f */
    public final char[] f15018f;

    public C0961a(Escapers.Builder builder, HashMap hashMap, char c, char c2) {
        super(hashMap, c, c2);
        char[] cArr;
        String str = builder.f15017d;
        if (str != null) {
            cArr = str.toCharArray();
        } else {
            cArr = null;
        }
        this.f15018f = cArr;
    }

    @Override // com.google.common.escape.ArrayBasedCharEscaper
    public final char[] escapeUnsafe(char c) {
        return this.f15018f;
    }
}
