package com.google.android.exoplayer2.drm;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.RunnableC0547b7;
import p000.RunnableC1185f7;
import p000.u60;

/* loaded from: classes.dex */
public interface DrmSessionEventListener {

    /* loaded from: classes.dex */
    public static class EventDispatcher {

        /* renamed from: a */
        public final CopyOnWriteArrayList f9978a;

        @Nullable
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final int windowIndex;

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null);
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.exoplayer2.drm.g] */
        public void addEventListener(Handler handler, DrmSessionEventListener drmSessionEventListener) {
            Assertions.checkNotNull(handler);
            Assertions.checkNotNull(drmSessionEventListener);
            ?? obj = new Object();
            obj.f10033a = handler;
            obj.f10034b = drmSessionEventListener;
            this.f9978a.add(obj);
        }

        public void drmKeysLoaded() {
            Iterator it = this.f9978a.iterator();
            while (it.hasNext()) {
                C0665g c0665g = (C0665g) it.next();
                Util.postOrRun(c0665g.f10033a, new u60(this, c0665g.f10034b, 2));
            }
        }

        public void drmKeysRemoved() {
            Iterator it = this.f9978a.iterator();
            while (it.hasNext()) {
                C0665g c0665g = (C0665g) it.next();
                Util.postOrRun(c0665g.f10033a, new u60(this, c0665g.f10034b, 0));
            }
        }

        public void drmKeysRestored() {
            Iterator it = this.f9978a.iterator();
            while (it.hasNext()) {
                C0665g c0665g = (C0665g) it.next();
                Util.postOrRun(c0665g.f10033a, new u60(this, c0665g.f10034b, 1));
            }
        }

        public void drmSessionAcquired(int i) {
            Iterator it = this.f9978a.iterator();
            while (it.hasNext()) {
                C0665g c0665g = (C0665g) it.next();
                Util.postOrRun(c0665g.f10033a, new RunnableC1185f7(this, c0665g.f10034b, i, 2));
            }
        }

        public void drmSessionManagerError(Exception exc) {
            Iterator it = this.f9978a.iterator();
            while (it.hasNext()) {
                C0665g c0665g = (C0665g) it.next();
                Util.postOrRun(c0665g.f10033a, new RunnableC0547b7(this, c0665g.f10034b, exc, 5));
            }
        }

        public void drmSessionReleased() {
            Iterator it = this.f9978a.iterator();
            while (it.hasNext()) {
                C0665g c0665g = (C0665g) it.next();
                Util.postOrRun(c0665g.f10033a, new u60(this, c0665g.f10034b, 3));
            }
        }

        public void removeEventListener(DrmSessionEventListener drmSessionEventListener) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f9978a;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                C0665g c0665g = (C0665g) it.next();
                if (c0665g.f10034b == drmSessionEventListener) {
                    copyOnWriteArrayList.remove(c0665g);
                }
            }
        }

        @CheckResult
        public EventDispatcher withParameters(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId) {
            return new EventDispatcher(this.f9978a, i, mediaPeriodId);
        }

        public EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList, int i, MediaSource.MediaPeriodId mediaPeriodId) {
            this.f9978a = copyOnWriteArrayList;
            this.windowIndex = i;
            this.mediaPeriodId = mediaPeriodId;
        }
    }

    void onDrmKeysLoaded(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmKeysRemoved(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmKeysRestored(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    @Deprecated
    void onDrmSessionAcquired(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId);

    void onDrmSessionAcquired(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, int i2);

    void onDrmSessionManagerError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, Exception exc);

    void onDrmSessionReleased(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId);
}
