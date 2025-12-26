package com.google.android.exoplayer2.drm;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.HashSet;
import p000.C1540m9;
import p000.RunnableC0006a5;
import p000.m00;

/* renamed from: com.google.android.exoplayer2.drm.e */
/* loaded from: classes.dex */
public final class C0663e implements DefaultDrmSession$ReferenceCountListener {

    /* renamed from: a */
    public final /* synthetic */ DefaultDrmSessionManager f10032a;

    public C0663e(DefaultDrmSessionManager defaultDrmSessionManager) {
        this.f10032a = defaultDrmSessionManager;
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$ReferenceCountListener
    public final void onReferenceCountDecremented(C0660b c0660b, int i) {
        DefaultDrmSessionManager defaultDrmSessionManager = this.f10032a;
        if (i == 1 && defaultDrmSessionManager.f9952o > 0) {
            long j = defaultDrmSessionManager.f9948k;
            if (j != C0643C.TIME_UNSET) {
                defaultDrmSessionManager.f9951n.add(c0660b);
                ((Handler) Assertions.checkNotNull(defaultDrmSessionManager.f9957t)).postAtTime(new RunnableC0006a5(9, c0660b), c0660b, SystemClock.uptimeMillis() + j);
                defaultDrmSessionManager.m2515f();
            }
        }
        if (i == 0) {
            defaultDrmSessionManager.f9949l.remove(c0660b);
            if (defaultDrmSessionManager.f9954q == c0660b) {
                defaultDrmSessionManager.f9954q = null;
            }
            if (defaultDrmSessionManager.f9955r == c0660b) {
                defaultDrmSessionManager.f9955r = null;
            }
            C1540m9 c1540m9 = defaultDrmSessionManager.f9945h;
            HashSet hashSet = (HashSet) c1540m9.f22854b;
            hashSet.remove(c0660b);
            if (((C0660b) c1540m9.f22855c) == c0660b) {
                c1540m9.f22855c = null;
                if (!hashSet.isEmpty()) {
                    C0660b c0660b2 = (C0660b) hashSet.iterator().next();
                    c1540m9.f22855c = c0660b2;
                    c0660b2.f10026x = c0660b2.f10004b.getProvisionRequest();
                    HandlerC0659a handlerC0659a = (HandlerC0659a) Util.castNonNull(c0660b2.f10020r);
                    Object checkNotNull = Assertions.checkNotNull(c0660b2.f10026x);
                    handlerC0659a.getClass();
                    handlerC0659a.obtainMessage(0, new m00(LoadEventInfo.getNewId(), true, SystemClock.elapsedRealtime(), checkNotNull)).sendToTarget();
                }
            }
            if (defaultDrmSessionManager.f9948k != C0643C.TIME_UNSET) {
                ((Handler) Assertions.checkNotNull(defaultDrmSessionManager.f9957t)).removeCallbacksAndMessages(c0660b);
                defaultDrmSessionManager.f9951n.remove(c0660b);
            }
        }
        defaultDrmSessionManager.m2515f();
    }

    @Override // com.google.android.exoplayer2.drm.DefaultDrmSession$ReferenceCountListener
    public final void onReferenceCountIncremented(C0660b c0660b, int i) {
        DefaultDrmSessionManager defaultDrmSessionManager = this.f10032a;
        if (defaultDrmSessionManager.f9948k != C0643C.TIME_UNSET) {
            defaultDrmSessionManager.f9951n.remove(c0660b);
            ((Handler) Assertions.checkNotNull(defaultDrmSessionManager.f9957t)).removeCallbacksAndMessages(c0660b);
        }
    }
}
