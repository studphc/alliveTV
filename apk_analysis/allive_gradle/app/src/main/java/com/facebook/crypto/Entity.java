package com.facebook.crypto;

import com.google.android.exoplayer2.C0643C;
import java.nio.charset.Charset;

/* loaded from: classes.dex */
public class Entity {

    /* renamed from: b */
    public static final Charset f9206b = Charset.forName(C0643C.UTF16_NAME);

    /* renamed from: c */
    public static final Charset f9207c = Charset.forName("UTF-8");

    /* renamed from: a */
    public byte[] f9208a;

    @Deprecated
    public Entity(String str) {
        this.f9208a = str.getBytes(f9206b);
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.facebook.crypto.Entity, java.lang.Object] */
    public static Entity create(String str) {
        byte[] bytes = str.getBytes(f9207c);
        ?? obj = new Object();
        obj.f9208a = bytes;
        return obj;
    }

    @Deprecated
    public static Entity utf16(String str) {
        return new Entity(str);
    }

    public byte[] getBytes() {
        return this.f9208a;
    }
}
