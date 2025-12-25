package com.google.android.gms.common.server.response;

import androidx.recyclerview.widget.RecyclerView;
import java.io.BufferedReader;

/* renamed from: com.google.android.gms.common.server.response.c */
/* loaded from: classes.dex */
public final class C0764c implements InterfaceC0770i {
    @Override // com.google.android.gms.common.server.response.InterfaceC0770i
    /* renamed from: a */
    public final Object mo3199a(FastParser fastParser, BufferedReader bufferedReader) {
        float parseFloat;
        char[] cArr = fastParser.f13596c;
        int m3183d = fastParser.m3183d(bufferedReader, cArr);
        if (m3183d == 0) {
            parseFloat = RecyclerView.f7068F0;
        } else {
            parseFloat = Float.parseFloat(new String(cArr, 0, m3183d));
        }
        return Float.valueOf(parseFloat);
    }
}
