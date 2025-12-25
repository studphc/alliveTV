package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.AbstractConcatenatedTimeline;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Set;
import p000.C1524lu;
import p000.C1561mu;
import p000.C1598nu;
import p000.C1663ou;

/* loaded from: classes.dex */
public final class ConcatenatingMediaSource extends CompositeMediaSource<C0696e> {

    /* renamed from: w */
    public static final MediaItem f10930w = new MediaItem.Builder().setUri(Uri.EMPTY).build();

    /* renamed from: k */
    public final ArrayList f10931k;

    /* renamed from: l */
    public final HashSet f10932l;

    /* renamed from: m */
    public Handler f10933m;

    /* renamed from: n */
    public final ArrayList f10934n;

    /* renamed from: o */
    public final IdentityHashMap f10935o;

    /* renamed from: p */
    public final HashMap f10936p;

    /* renamed from: q */
    public final HashSet f10937q;

    /* renamed from: r */
    public final boolean f10938r;

    /* renamed from: s */
    public final boolean f10939s;

    /* renamed from: t */
    public boolean f10940t;

    /* renamed from: u */
    public HashSet f10941u;

    /* renamed from: v */
    public ShuffleOrder f10942v;

    public ConcatenatingMediaSource(MediaSource... mediaSourceArr) {
        this(false, mediaSourceArr);
    }

    /* renamed from: a */
    public final void m2728a(int i, Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            C0696e c0696e = (C0696e) it.next();
            int i2 = i + 1;
            ArrayList arrayList = this.f10934n;
            if (i > 0) {
                C0696e c0696e2 = (C0696e) arrayList.get(i - 1);
                int windowCount = c0696e2.f11355a.getTimeline().getWindowCount() + c0696e2.f11359e;
                c0696e.f11358d = i;
                c0696e.f11359e = windowCount;
                c0696e.f11360f = false;
                c0696e.f11357c.clear();
            } else {
                c0696e.f11358d = i;
                c0696e.f11359e = 0;
                c0696e.f11360f = false;
                c0696e.f11357c.clear();
            }
            m2730c(i, 1, c0696e.f11355a.getTimeline().getWindowCount());
            arrayList.add(i, c0696e);
            this.f10936p.put(c0696e.f11356b, c0696e);
            prepareChildSource(c0696e, c0696e.f11355a);
            if (isEnabled() && this.f10935o.isEmpty()) {
                this.f10937q.add(c0696e);
            } else {
                disableChildSource(c0696e);
            }
            i = i2;
        }
    }

    public synchronized void addMediaSource(MediaSource mediaSource) {
        addMediaSource(this.f10931k.size(), mediaSource);
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection) {
        m2729b(this.f10931k.size(), collection, null, null);
    }

    /* renamed from: b */
    public final void m2729b(int i, Collection collection, Handler handler, Runnable runnable) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (handler == null) {
            z = true;
        } else {
            z = false;
        }
        if (runnable == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2) {
            z3 = false;
        }
        Assertions.checkArgument(z3);
        Handler handler2 = this.f10933m;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            Assertions.checkNotNull((MediaSource) it.next());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new C0696e((MediaSource) it2.next(), this.f10939s));
        }
        this.f10931k.addAll(i, arrayList);
        if (handler2 != null && !collection.isEmpty()) {
            handler2.obtainMessage(0, new C1663ou(i, arrayList, m2731d(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    /* renamed from: c */
    public final void m2730c(int i, int i2, int i3) {
        while (true) {
            ArrayList arrayList = this.f10934n;
            if (i < arrayList.size()) {
                C0696e c0696e = (C0696e) arrayList.get(i);
                c0696e.f11358d += i2;
                c0696e.f11359e += i3;
                i++;
            } else {
                return;
            }
        }
    }

    public synchronized void clear() {
        removeMediaSourceRange(0, getSize());
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaPeriod createPeriod(MediaSource.MediaPeriodId mediaPeriodId, Allocator allocator, long j) {
        Object childTimelineUidFromConcatenatedUid = AbstractConcatenatedTimeline.getChildTimelineUidFromConcatenatedUid(mediaPeriodId.periodUid);
        MediaSource.MediaPeriodId copyWithPeriodUid = mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getChildPeriodUidFromConcatenatedUid(mediaPeriodId.periodUid));
        C0696e c0696e = (C0696e) this.f10936p.get(childTimelineUidFromConcatenatedUid);
        if (c0696e == null) {
            c0696e = new C0696e(new BaseMediaSource(), this.f10939s);
            c0696e.f11360f = true;
            prepareChildSource(c0696e, c0696e.f11355a);
        }
        this.f10937q.add(c0696e);
        enableChildSource(c0696e);
        c0696e.f11357c.add(copyWithPeriodUid);
        MaskingMediaPeriod createPeriod = c0696e.f11355a.createPeriod(copyWithPeriodUid, allocator, j);
        this.f10935o.put(createPeriod, c0696e);
        m2732e();
        return createPeriod;
    }

    /* renamed from: d */
    public final C1598nu m2731d(Handler handler, Runnable runnable) {
        if (handler != null && runnable != null) {
            C1598nu c1598nu = new C1598nu(handler, runnable);
            this.f10932l.add(c1598nu);
            return c1598nu;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void disableInternal() {
        super.disableInternal();
        this.f10937q.clear();
    }

    /* renamed from: e */
    public final void m2732e() {
        Iterator it = this.f10937q.iterator();
        while (it.hasNext()) {
            C0696e c0696e = (C0696e) it.next();
            if (c0696e.f11357c.isEmpty()) {
                disableChildSource(c0696e);
                it.remove();
            }
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public void enableInternal() {
    }

    /* renamed from: f */
    public final synchronized void m2733f(Set set) {
        try {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                C1598nu c1598nu = (C1598nu) it.next();
                c1598nu.f23494a.post(c1598nu.f23495b);
            }
            this.f10932l.removeAll(set);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: g */
    public final void m2734g(int i, int i2, Handler handler, Runnable runnable) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (handler == null) {
            z = true;
        } else {
            z = false;
        }
        if (runnable == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z == z2) {
            z3 = true;
        }
        Assertions.checkArgument(z3);
        Handler handler2 = this.f10933m;
        ArrayList arrayList = this.f10931k;
        arrayList.add(i2, (C0696e) arrayList.remove(i));
        if (handler2 != null) {
            handler2.obtainMessage(2, new C1663ou(i, Integer.valueOf(i2), m2731d(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    public synchronized Timeline getInitialTimeline() {
        ShuffleOrder shuffleOrder;
        try {
            if (this.f10942v.getLength() != this.f10931k.size()) {
                shuffleOrder = this.f10942v.cloneAndClear().cloneAndInsert(0, this.f10931k.size());
            } else {
                shuffleOrder = this.f10942v;
            }
        } catch (Throwable th) {
            throw th;
        }
        return new C1561mu(this.f10931k, shuffleOrder, this.f10938r);
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public MediaItem getMediaItem() {
        return f10930w;
    }

    public synchronized MediaSource getMediaSource(int i) {
        return ((C0696e) this.f10931k.get(i)).f11355a;
    }

    public synchronized int getSize() {
        return this.f10931k.size();
    }

    /* renamed from: h */
    public final void m2735h(int i, int i2, Handler handler, Runnable runnable) {
        boolean z;
        boolean z2;
        boolean z3 = false;
        if (handler == null) {
            z = true;
        } else {
            z = false;
        }
        if (runnable == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z == z2) {
            z3 = true;
        }
        Assertions.checkArgument(z3);
        Handler handler2 = this.f10933m;
        Util.removeRange(this.f10931k, i, i2);
        if (handler2 != null) {
            handler2.obtainMessage(1, new C1663ou(i, Integer.valueOf(i2), m2731d(handler, runnable))).sendToTarget();
        } else if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    /* renamed from: i */
    public final void m2736i(C1598nu c1598nu) {
        if (!this.f10940t) {
            ((Handler) Assertions.checkNotNull(this.f10933m)).obtainMessage(4).sendToTarget();
            this.f10940t = true;
        }
        if (c1598nu != null) {
            this.f10941u.add(c1598nu);
        }
    }

    @Override // com.google.android.exoplayer2.source.BaseMediaSource, com.google.android.exoplayer2.source.MediaSource
    public boolean isSingleWindow() {
        return false;
    }

    /* renamed from: j */
    public final void m2737j(ShuffleOrder shuffleOrder, Handler handler, Runnable runnable) {
        boolean z;
        boolean z2;
        boolean z3 = true;
        if (handler == null) {
            z = true;
        } else {
            z = false;
        }
        if (runnable == null) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z != z2) {
            z3 = false;
        }
        Assertions.checkArgument(z3);
        Handler handler2 = this.f10933m;
        if (handler2 != null) {
            int size = getSize();
            if (shuffleOrder.getLength() != size) {
                shuffleOrder = shuffleOrder.cloneAndClear().cloneAndInsert(0, size);
            }
            handler2.obtainMessage(3, new C1663ou(0, shuffleOrder, m2731d(handler, runnable))).sendToTarget();
            return;
        }
        if (shuffleOrder.getLength() > 0) {
            shuffleOrder = shuffleOrder.cloneAndClear();
        }
        this.f10942v = shuffleOrder;
        if (runnable != null && handler != null) {
            handler.post(runnable);
        }
    }

    /* renamed from: k */
    public final void m2738k() {
        this.f10940t = false;
        HashSet hashSet = this.f10941u;
        this.f10941u = new HashSet();
        refreshSourceInfo(new C1561mu(this.f10934n, this.f10942v, this.f10938r));
        ((Handler) Assertions.checkNotNull(this.f10933m)).obtainMessage(5, hashSet).sendToTarget();
    }

    public synchronized void moveMediaSource(int i, int i2) {
        m2734g(i, i2, null, null);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public synchronized void prepareSourceInternal(@Nullable TransferListener transferListener) {
        try {
            super.prepareSourceInternal(transferListener);
            this.f10933m = new Handler(new C1524lu(0, this));
            if (this.f10931k.isEmpty()) {
                m2738k();
            } else {
                this.f10942v = this.f10942v.cloneAndInsert(0, this.f10931k.size());
                m2728a(0, this.f10931k);
                m2736i(null);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource
    public void releasePeriod(MediaPeriod mediaPeriod) {
        IdentityHashMap identityHashMap = this.f10935o;
        C0696e c0696e = (C0696e) Assertions.checkNotNull((C0696e) identityHashMap.remove(mediaPeriod));
        c0696e.f11355a.releasePeriod(mediaPeriod);
        ArrayList arrayList = c0696e.f11357c;
        arrayList.remove(((MaskingMediaPeriod) mediaPeriod).f10968id);
        if (!identityHashMap.isEmpty()) {
            m2732e();
        }
        if (c0696e.f11360f && arrayList.isEmpty()) {
            this.f10937q.remove(c0696e);
            releaseChildSource(c0696e);
        }
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource, com.google.android.exoplayer2.source.BaseMediaSource
    public synchronized void releaseSourceInternal() {
        try {
            super.releaseSourceInternal();
            this.f10934n.clear();
            this.f10937q.clear();
            this.f10936p.clear();
            this.f10942v = this.f10942v.cloneAndClear();
            Handler handler = this.f10933m;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
                this.f10933m = null;
            }
            this.f10940t = false;
            this.f10941u.clear();
            m2733f(this.f10932l);
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized MediaSource removeMediaSource(int i) {
        MediaSource mediaSource;
        mediaSource = getMediaSource(i);
        m2735h(i, i + 1, null, null);
        return mediaSource;
    }

    public synchronized void removeMediaSourceRange(int i, int i2) {
        m2735h(i, i2, null, null);
    }

    public synchronized void setShuffleOrder(ShuffleOrder shuffleOrder) {
        m2737j(shuffleOrder, null, null);
    }

    public ConcatenatingMediaSource(boolean z, MediaSource... mediaSourceArr) {
        this(z, new ShuffleOrder.DefaultShuffleOrder(0), mediaSourceArr);
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    @Nullable
    public MediaSource.MediaPeriodId getMediaPeriodIdForChildMediaPeriodId(C0696e c0696e, MediaSource.MediaPeriodId mediaPeriodId) {
        for (int i = 0; i < c0696e.f11357c.size(); i++) {
            if (((MediaSource.MediaPeriodId) c0696e.f11357c.get(i)).windowSequenceNumber == mediaPeriodId.windowSequenceNumber) {
                return mediaPeriodId.copyWithPeriodUid(AbstractConcatenatedTimeline.getConcatenatedUid(c0696e.f11356b, mediaPeriodId.periodUid));
            }
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public int getWindowIndexForChildWindowIndex(C0696e c0696e, int i) {
        return i + c0696e.f11359e;
    }

    @Override // com.google.android.exoplayer2.source.CompositeMediaSource
    public void onChildSourceInfoRefreshed(C0696e c0696e, MediaSource mediaSource, Timeline timeline) {
        int i = c0696e.f11358d + 1;
        ArrayList arrayList = this.f10934n;
        if (i < arrayList.size()) {
            int windowCount = timeline.getWindowCount() - (((C0696e) arrayList.get(c0696e.f11358d + 1)).f11359e - c0696e.f11359e);
            if (windowCount != 0) {
                m2730c(c0696e.f11358d + 1, 0, windowCount);
            }
        }
        m2736i(null);
    }

    public ConcatenatingMediaSource(boolean z, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        this(z, false, shuffleOrder, mediaSourceArr);
    }

    public synchronized void addMediaSource(MediaSource mediaSource, Handler handler, Runnable runnable) {
        addMediaSource(this.f10931k.size(), mediaSource, handler, runnable);
    }

    public synchronized void clear(Handler handler, Runnable runnable) {
        removeMediaSourceRange(0, getSize(), handler, runnable);
    }

    public synchronized void moveMediaSource(int i, int i2, Handler handler, Runnable runnable) {
        m2734g(i, i2, handler, runnable);
    }

    public synchronized void removeMediaSourceRange(int i, int i2, Handler handler, Runnable runnable) {
        m2735h(i, i2, handler, runnable);
    }

    public synchronized void setShuffleOrder(ShuffleOrder shuffleOrder, Handler handler, Runnable runnable) {
        m2737j(shuffleOrder, handler, runnable);
    }

    public ConcatenatingMediaSource(boolean z, boolean z2, ShuffleOrder shuffleOrder, MediaSource... mediaSourceArr) {
        for (MediaSource mediaSource : mediaSourceArr) {
            Assertions.checkNotNull(mediaSource);
        }
        this.f10942v = shuffleOrder.getLength() > 0 ? shuffleOrder.cloneAndClear() : shuffleOrder;
        this.f10935o = new IdentityHashMap();
        this.f10936p = new HashMap();
        this.f10931k = new ArrayList();
        this.f10934n = new ArrayList();
        this.f10941u = new HashSet();
        this.f10932l = new HashSet();
        this.f10937q = new HashSet();
        this.f10938r = z;
        this.f10939s = z2;
        addMediaSources(Arrays.asList(mediaSourceArr));
    }

    public synchronized MediaSource removeMediaSource(int i, Handler handler, Runnable runnable) {
        MediaSource mediaSource;
        mediaSource = getMediaSource(i);
        m2735h(i, i + 1, handler, runnable);
        return mediaSource;
    }

    public synchronized void addMediaSource(int i, MediaSource mediaSource) {
        m2729b(i, Collections.singletonList(mediaSource), null, null);
    }

    public synchronized void addMediaSources(Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        m2729b(this.f10931k.size(), collection, handler, runnable);
    }

    public synchronized void addMediaSources(int i, Collection<MediaSource> collection) {
        m2729b(i, collection, null, null);
    }

    public synchronized void addMediaSource(int i, MediaSource mediaSource, Handler handler, Runnable runnable) {
        m2729b(i, Collections.singletonList(mediaSource), handler, runnable);
    }

    public synchronized void addMediaSources(int i, Collection<MediaSource> collection, Handler handler, Runnable runnable) {
        m2729b(i, collection, handler, runnable);
    }
}
