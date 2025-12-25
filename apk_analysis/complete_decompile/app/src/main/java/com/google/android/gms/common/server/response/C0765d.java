package com.google.android.gms.common.server.response;

import java.io.BufferedReader;

/* renamed from: com.google.android.gms.common.server.response.d */
/* loaded from: classes.dex */
public final class C0765d implements InterfaceC0770i {
    @Override // com.google.android.gms.common.server.response.InterfaceC0770i
    /* renamed from: a */
    public final Object mo3199a(FastParser fastParser, BufferedReader bufferedReader) {
        double parseDouble;
        char[] cArr = fastParser.f13596c;
        int m3183d = fastParser.m3183d(bufferedReader, cArr);
        if (m3183d == 0) {
            parseDouble = 0.0d;
        } else {
            parseDouble = Double.parseDouble(new String(cArr, 0, m3183d));
        }
        return Double.valueOf(parseDouble);
    }
}
