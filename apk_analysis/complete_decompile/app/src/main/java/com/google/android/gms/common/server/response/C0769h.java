package com.google.android.gms.common.server.response;

import java.io.BufferedReader;
import java.math.BigDecimal;

/* renamed from: com.google.android.gms.common.server.response.h */
/* loaded from: classes.dex */
public final class C0769h implements InterfaceC0770i {
    @Override // com.google.android.gms.common.server.response.InterfaceC0770i
    /* renamed from: a */
    public final Object mo3199a(FastParser fastParser, BufferedReader bufferedReader) {
        char[] cArr = fastParser.f13596c;
        int m3183d = fastParser.m3183d(bufferedReader, cArr);
        if (m3183d == 0) {
            return null;
        }
        return new BigDecimal(new String(cArr, 0, m3183d));
    }
}
