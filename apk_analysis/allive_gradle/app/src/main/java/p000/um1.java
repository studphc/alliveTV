package p000;

import android.os.Handler;
import com.google.android.exoplayer2.C0672f;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.source.MaskingMediaPeriod;
import com.google.android.exoplayer2.source.MaskingMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class um1 {

    /* renamed from: a */
    public final PlayerId f27363a;

    /* renamed from: e */
    public final C0672f f27367e;

    /* renamed from: f */
    public final MediaSourceEventListener.EventDispatcher f27368f;

    /* renamed from: g */
    public final DrmSessionEventListener.EventDispatcher f27369g;

    /* renamed from: h */
    public final HashMap f27370h;

    /* renamed from: i */
    public final HashSet f27371i;

    /* renamed from: k */
    public boolean f27373k;

    /* renamed from: l */
    public TransferListener f27374l;

    /* renamed from: j */
    public ShuffleOrder f27372j = new ShuffleOrder.DefaultShuffleOrder(0);

    /* renamed from: c */
    public final IdentityHashMap f27365c = new IdentityHashMap();

    /* renamed from: d */
    public final HashMap f27366d = new HashMap();

    /* renamed from: b */
    public final ArrayList f27364b = new ArrayList();

    public um1(C0672f c0672f, AnalyticsCollector analyticsCollector, Handler handler, PlayerId playerId) {
        this.f27363a = playerId;
        this.f27367e = c0672f;
        MediaSourceEventListener.EventDispatcher eventDispatcher = new MediaSourceEventListener.EventDispatcher();
        this.f27368f = eventDispatcher;
        DrmSessionEventListener.EventDispatcher eventDispatcher2 = new DrmSessionEventListener.EventDispatcher();
        this.f27369g = eventDispatcher2;
        this.f27370h = new HashMap();
        this.f27371i = new HashSet();
        eventDispatcher.addEventListener(handler, analyticsCollector);
        eventDispatcher2.addEventListener(handler, analyticsCollector);
    }

    /* renamed from: a */
    public final Timeline m7749a(int i, ArrayList arrayList, ShuffleOrder shuffleOrder) {
        if (!arrayList.isEmpty()) {
            this.f27372j = shuffleOrder;
            for (int i2 = i; i2 < arrayList.size() + i; i2++) {
                tm1 tm1Var = (tm1) arrayList.get(i2 - i);
                ArrayList arrayList2 = this.f27364b;
                if (i2 > 0) {
                    tm1 tm1Var2 = (tm1) arrayList2.get(i2 - 1);
                    tm1Var.f26879d = tm1Var2.f26876a.getTimeline().getWindowCount() + tm1Var2.f26879d;
                    tm1Var.f26880e = false;
                    tm1Var.f26878c.clear();
                } else {
                    tm1Var.f26879d = 0;
                    tm1Var.f26880e = false;
                    tm1Var.f26878c.clear();
                }
                int windowCount = tm1Var.f26876a.getTimeline().getWindowCount();
                for (int i3 = i2; i3 < arrayList2.size(); i3++) {
                    ((tm1) arrayList2.get(i3)).f26879d += windowCount;
                }
                arrayList2.add(i2, tm1Var);
                this.f27366d.put(tm1Var.f26877b, tm1Var);
                if (this.f27373k) {
                    m7753e(tm1Var);
                    if (this.f27365c.isEmpty()) {
                        this.f27371i.add(tm1Var);
                    } else {
                        sm1 sm1Var = (sm1) this.f27370h.get(tm1Var);
                        if (sm1Var != null) {
                            sm1Var.f26489a.disable(sm1Var.f26490b);
                        }
                    }
                }
            }
        }
        return m7750b();
    }

    /* renamed from: b */
    public final Timeline m7750b() {
        ArrayList arrayList = this.f27364b;
        if (arrayList.isEmpty()) {
            return Timeline.EMPTY;
        }
        int i = 0;
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            tm1 tm1Var = (tm1) arrayList.get(i2);
            tm1Var.f26879d = i;
            i += tm1Var.f26876a.getTimeline().getWindowCount();
        }
        return new l62(arrayList, this.f27372j);
    }

    /* renamed from: c */
    public final void m7751c() {
        Iterator it = this.f27371i.iterator();
        while (it.hasNext()) {
            tm1 tm1Var = (tm1) it.next();
            if (tm1Var.f26878c.isEmpty()) {
                sm1 sm1Var = (sm1) this.f27370h.get(tm1Var);
                if (sm1Var != null) {
                    sm1Var.f26489a.disable(sm1Var.f26490b);
                }
                it.remove();
            }
        }
    }

    /* renamed from: d */
    public final void m7752d(tm1 tm1Var) {
        if (tm1Var.f26880e && tm1Var.f26878c.isEmpty()) {
            sm1 sm1Var = (sm1) Assertions.checkNotNull((sm1) this.f27370h.remove(tm1Var));
            sm1Var.f26489a.releaseSource(sm1Var.f26490b);
            rm1 rm1Var = sm1Var.f26491c;
            MediaSource mediaSource = sm1Var.f26489a;
            mediaSource.removeEventListener(rm1Var);
            mediaSource.removeDrmEventListener(rm1Var);
            this.f27371i.remove(tm1Var);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.android.exoplayer2.source.MediaSource$MediaSourceCaller, qm1] */
    /* renamed from: e */
    public final void m7753e(tm1 tm1Var) {
        MaskingMediaSource maskingMediaSource = tm1Var.f26876a;
        ?? r1 = new MediaSource.MediaSourceCaller() { // from class: qm1
            @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
            public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
                um1.this.f27367e.onPlaylistUpdateRequested();
            }
        };
        rm1 rm1Var = new rm1(this, tm1Var);
        this.f27370h.put(tm1Var, new sm1(maskingMediaSource, r1, rm1Var));
        maskingMediaSource.addEventListener(Util.createHandlerForCurrentOrMainLooper(), rm1Var);
        maskingMediaSource.addDrmEventListener(Util.createHandlerForCurrentOrMainLooper(), rm1Var);
        maskingMediaSource.prepareSource(r1, this.f27374l, this.f27363a);
    }

    /* renamed from: f */
    public final void m7754f(MediaPeriod mediaPeriod) {
        IdentityHashMap identityHashMap = this.f27365c;
        tm1 tm1Var = (tm1) Assertions.checkNotNull((tm1) identityHashMap.remove(mediaPeriod));
        tm1Var.f26876a.releasePeriod(mediaPeriod);
        tm1Var.f26878c.remove(((MaskingMediaPeriod) mediaPeriod).f10968id);
        if (!identityHashMap.isEmpty()) {
            m7751c();
        }
        m7752d(tm1Var);
    }

    /* renamed from: g */
    public final void m7755g(int i, int i2) {
        for (int i3 = i2 - 1; i3 >= i; i3--) {
            ArrayList arrayList = this.f27364b;
            tm1 tm1Var = (tm1) arrayList.remove(i3);
            this.f27366d.remove(tm1Var.f26877b);
            int i4 = -tm1Var.f26876a.getTimeline().getWindowCount();
            for (int i5 = i3; i5 < arrayList.size(); i5++) {
                ((tm1) arrayList.get(i5)).f26879d += i4;
            }
            tm1Var.f26880e = true;
            if (this.f27373k) {
                m7752d(tm1Var);
            }
        }
    }
}
