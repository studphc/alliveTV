package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import com.google.android.exoplayer2.upstream.BandwidthMeter;

/* renamed from: com.google.android.exoplayer2.upstream.a */
/* loaded from: classes.dex */
public final class C0733a {

    /* renamed from: a */
    public final Handler f12566a;

    /* renamed from: b */
    public final BandwidthMeter.EventListener f12567b;

    /* renamed from: c */
    public boolean f12568c;

    public C0733a(Handler handler, BandwidthMeter.EventListener eventListener) {
        this.f12566a = handler;
        this.f12567b = eventListener;
    }
}
