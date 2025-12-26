package p000;

import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;

/* loaded from: classes.dex */
public final /* synthetic */ class nm1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f23403a;

    /* renamed from: b */
    public final /* synthetic */ MediaSourceEventListener.EventDispatcher f23404b;

    /* renamed from: c */
    public final /* synthetic */ MediaSourceEventListener f23405c;

    /* renamed from: d */
    public final /* synthetic */ Object f23406d;

    /* renamed from: e */
    public final /* synthetic */ MediaLoadData f23407e;

    public /* synthetic */ nm1(MediaSourceEventListener.EventDispatcher eventDispatcher, MediaSourceEventListener mediaSourceEventListener, Object obj, MediaLoadData mediaLoadData, int i) {
        this.f23403a = i;
        this.f23404b = eventDispatcher;
        this.f23405c = mediaSourceEventListener;
        this.f23406d = obj;
        this.f23407e = mediaLoadData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f23403a) {
            case 0:
                MediaSourceEventListener.EventDispatcher eventDispatcher = this.f23404b;
                this.f23405c.onLoadCompleted(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, (LoadEventInfo) this.f23406d, this.f23407e);
                return;
            case 1:
                MediaSourceEventListener.EventDispatcher eventDispatcher2 = this.f23404b;
                this.f23405c.onLoadCanceled(eventDispatcher2.windowIndex, eventDispatcher2.mediaPeriodId, (LoadEventInfo) this.f23406d, this.f23407e);
                return;
            case 2:
                MediaSourceEventListener.EventDispatcher eventDispatcher3 = this.f23404b;
                this.f23405c.onLoadStarted(eventDispatcher3.windowIndex, eventDispatcher3.mediaPeriodId, (LoadEventInfo) this.f23406d, this.f23407e);
                return;
            default:
                this.f23405c.onUpstreamDiscarded(this.f23404b.windowIndex, (MediaSource.MediaPeriodId) this.f23406d, this.f23407e);
                return;
        }
    }
}
