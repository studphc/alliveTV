package com.google.android.gms.internal.measurement;

import com.google.android.exoplayer2.C0643C;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public final class zzmk {

    /* renamed from: a */
    public static final Charset f13887a;
    public static final byte[] zzb;

    static {
        Charset.forName(C0643C.ASCII_NAME);
        f13887a = Charset.forName("UTF-8");
        Charset.forName(C0643C.ISO88591_NAME);
        byte[] bArr = new byte[0];
        zzb = bArr;
        ByteBuffer.wrap(bArr);
    }

    public static int zza(boolean z) {
        return z ? 1231 : 1237;
    }
}
