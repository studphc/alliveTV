package p000;

import androidx.core.location.C0184d;
import androidx.core.location.C0185e;
import androidx.profileinstaller.DeviceProfileWriter;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.C0736a;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.common.util.concurrent.AbstractC1022u;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.Serializable;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

/* renamed from: f7 */
/* loaded from: classes2.dex */
public final /* synthetic */ class RunnableC1185f7 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f17148a;

    /* renamed from: b */
    public final /* synthetic */ int f17149b;

    /* renamed from: c */
    public final /* synthetic */ Object f17150c;

    /* renamed from: d */
    public final /* synthetic */ Object f17151d;

    public /* synthetic */ RunnableC1185f7(Object obj, int i, Object obj2, int i2) {
        this.f17148a = i2;
        this.f17150c = obj;
        this.f17149b = i;
        this.f17151d = obj2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f17148a) {
            case 0:
                ListenableFuture listenableFuture = (ListenableFuture) this.f17151d;
                int i = this.f17149b;
                AbstractC1022u abstractC1022u = (AbstractC1022u) this.f17150c;
                try {
                    if (listenableFuture.isCancelled()) {
                        abstractC1022u.f15430l = null;
                        abstractC1022u.cancel(false);
                    } else {
                        try {
                            try {
                                abstractC1022u.mo4357j(i, Futures.getDone(listenableFuture));
                            } catch (ExecutionException e) {
                                abstractC1022u.m4360m(e.getCause());
                            }
                        } catch (Throwable th) {
                            abstractC1022u.m4360m(th);
                        }
                    }
                    return;
                } finally {
                    abstractC1022u.m4358k(null);
                }
            case 1:
                ((DeviceProfileWriter) this.f17150c).f6895c.onResultReceived(this.f17149b, (Serializable) this.f17151d);
                return;
            case 2:
                DrmSessionEventListener.EventDispatcher eventDispatcher = (DrmSessionEventListener.EventDispatcher) this.f17150c;
                int i2 = eventDispatcher.windowIndex;
                MediaSource.MediaPeriodId mediaPeriodId = eventDispatcher.mediaPeriodId;
                DrmSessionEventListener drmSessionEventListener = (DrmSessionEventListener) this.f17151d;
                drmSessionEventListener.onDrmSessionAcquired(i2, mediaPeriodId);
                drmSessionEventListener.onDrmSessionAcquired(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, this.f17149b);
                return;
            case 3:
                Iterator it = ((CopyOnWriteArraySet) this.f17150c).iterator();
                while (it.hasNext()) {
                    C0736a c0736a = (C0736a) it.next();
                    if (!c0736a.f12787d) {
                        int i3 = this.f17149b;
                        if (i3 != -1) {
                            c0736a.f12785b.add(i3);
                        }
                        c0736a.f12786c = true;
                        ((ListenerSet.Event) this.f17151d).invoke(c0736a.f12784a);
                    }
                }
                return;
            case 4:
                hd1 hd1Var = (hd1) this.f17150c;
                Executor executor = (Executor) this.f17151d;
                int i4 = this.f17149b;
                if (hd1Var.f18030b == executor) {
                    hd1Var.f18029a.onStatusChanged(i4);
                    return;
                }
                return;
            case 5:
                C0184d c0184d = (C0184d) this.f17150c;
                Executor executor2 = (Executor) this.f17151d;
                int i5 = this.f17149b;
                if (c0184d.f3700c == executor2) {
                    c0184d.f3699b.onFirstFix(i5);
                    return;
                }
                return;
            default:
                C0185e c0185e = (C0185e) this.f17150c;
                Executor executor3 = (Executor) this.f17151d;
                int i6 = this.f17149b;
                if (c0185e.f3702b == executor3) {
                    c0185e.f3701a.onFirstFix(i6);
                    return;
                }
                return;
        }
    }

    public /* synthetic */ RunnableC1185f7(Object obj, Object obj2, int i, int i2) {
        this.f17148a = i2;
        this.f17150c = obj;
        this.f17151d = obj2;
        this.f17149b = i;
    }
}
