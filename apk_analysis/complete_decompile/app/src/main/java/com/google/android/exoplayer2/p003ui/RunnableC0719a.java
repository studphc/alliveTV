package com.google.android.exoplayer2.p003ui;

import com.google.android.exoplayer2.p003ui.AspectRatioFrameLayout;

/* renamed from: com.google.android.exoplayer2.ui.a */
/* loaded from: classes.dex */
public final class RunnableC0719a implements Runnable {

    /* renamed from: a */
    public float f12324a;

    /* renamed from: b */
    public float f12325b;

    /* renamed from: c */
    public boolean f12326c;

    /* renamed from: d */
    public boolean f12327d;

    /* renamed from: e */
    public final /* synthetic */ AspectRatioFrameLayout f12328e;

    public RunnableC0719a(AspectRatioFrameLayout aspectRatioFrameLayout) {
        this.f12328e = aspectRatioFrameLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f12327d = false;
        AspectRatioFrameLayout.AspectRatioListener aspectRatioListener = this.f12328e.f12002b;
        if (aspectRatioListener == null) {
            return;
        }
        aspectRatioListener.onAspectRatioUpdated(this.f12324a, this.f12325b, this.f12326c);
    }
}
