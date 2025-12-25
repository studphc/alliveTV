package com.google.android.exoplayer2.drm;

import android.os.Handler;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import p000.RunnableC0006a5;

/* renamed from: com.google.android.exoplayer2.drm.d */
/* loaded from: classes.dex */
public final class C0662d implements DrmSessionManager.DrmSessionReference {

    /* renamed from: a */
    public final DrmSessionEventListener.EventDispatcher f10028a;

    /* renamed from: b */
    public DrmSession f10029b;

    /* renamed from: c */
    public boolean f10030c;

    /* renamed from: d */
    public final /* synthetic */ DefaultDrmSessionManager f10031d;

    public C0662d(DefaultDrmSessionManager defaultDrmSessionManager, DrmSessionEventListener.EventDispatcher eventDispatcher) {
        this.f10031d = defaultDrmSessionManager;
        this.f10028a = eventDispatcher;
    }

    @Override // com.google.android.exoplayer2.drm.DrmSessionManager.DrmSessionReference
    public final void release() {
        Util.postOrRun((Handler) Assertions.checkNotNull(this.f10031d.f9957t), new RunnableC0006a5(8, this));
    }
}
