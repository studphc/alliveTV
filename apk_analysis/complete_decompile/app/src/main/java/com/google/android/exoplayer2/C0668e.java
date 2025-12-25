package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Renderer;

/* renamed from: com.google.android.exoplayer2.e */
/* loaded from: classes.dex */
public final class C0668e implements Renderer.WakeupListener {

    /* renamed from: a */
    public final /* synthetic */ C0672f f10036a;

    public C0668e(C0672f c0672f) {
        this.f10036a = c0672f;
    }

    @Override // com.google.android.exoplayer2.Renderer.WakeupListener
    public final void onSleep() {
        this.f10036a.f10596H = true;
    }

    @Override // com.google.android.exoplayer2.Renderer.WakeupListener
    public final void onWakeup() {
        this.f10036a.f10613h.sendEmptyMessage(2);
    }
}
