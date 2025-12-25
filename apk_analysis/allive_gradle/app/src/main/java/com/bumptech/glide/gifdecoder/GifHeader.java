package com.bumptech.glide.gifdecoder;

import java.util.ArrayList;
import p000.ww0;

/* loaded from: classes.dex */
public class GifHeader {
    public static final int NETSCAPE_LOOP_COUNT_DOES_NOT_EXIST = -1;
    public static final int NETSCAPE_LOOP_COUNT_FOREVER = 0;

    /* renamed from: d */
    public ww0 f8578d;

    /* renamed from: f */
    public int f8580f;

    /* renamed from: g */
    public int f8581g;

    /* renamed from: h */
    public boolean f8582h;

    /* renamed from: i */
    public int f8583i;

    /* renamed from: j */
    public int f8584j;

    /* renamed from: k */
    public int f8585k;

    /* renamed from: a */
    public int[] f8575a = null;

    /* renamed from: b */
    public int f8576b = 0;

    /* renamed from: c */
    public int f8577c = 0;

    /* renamed from: e */
    public final ArrayList f8579e = new ArrayList();

    /* renamed from: l */
    public int f8586l = -1;

    public int getHeight() {
        return this.f8581g;
    }

    public int getNumFrames() {
        return this.f8577c;
    }

    public int getStatus() {
        return this.f8576b;
    }

    public int getWidth() {
        return this.f8580f;
    }
}
