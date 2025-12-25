package com.google.android.exoplayer2.source;

import android.os.Handler;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C0643C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.RunnableC0547b7;
import p000.nm1;

/* loaded from: classes.dex */
public interface MediaSourceEventListener {

    /* loaded from: classes.dex */
    public static class EventDispatcher {

        /* renamed from: a */
        public final CopyOnWriteArrayList f10983a;

        /* renamed from: b */
        public final long f10984b;

        @Nullable
        public final MediaSource.MediaPeriodId mediaPeriodId;
        public final int windowIndex;

        public EventDispatcher() {
            this(new CopyOnWriteArrayList(), 0, null, 0L);
        }

        /* renamed from: a */
        public final long m2741a(long j) {
            long usToMs = Util.usToMs(j);
            if (usToMs == C0643C.TIME_UNSET) {
                return C0643C.TIME_UNSET;
            }
            return this.f10984b + usToMs;
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.lang.Object, com.google.android.exoplayer2.source.i] */
        public void addEventListener(Handler handler, MediaSourceEventListener mediaSourceEventListener) {
            Assertions.checkNotNull(handler);
            Assertions.checkNotNull(mediaSourceEventListener);
            ?? obj = new Object();
            obj.f11532a = handler;
            obj.f11533b = mediaSourceEventListener;
            this.f10983a.add(obj);
        }

        public void downstreamFormatChanged(int i, @Nullable Format format, int i2, @Nullable Object obj, long j) {
            downstreamFormatChanged(new MediaLoadData(1, i, format, i2, obj, m2741a(j), C0643C.TIME_UNSET));
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, int i) {
            loadCanceled(loadEventInfo, i, -1, null, 0, null, C0643C.TIME_UNSET, C0643C.TIME_UNSET);
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, int i) {
            loadCompleted(loadEventInfo, i, -1, null, 0, null, C0643C.TIME_UNSET, C0643C.TIME_UNSET);
        }

        public void loadError(LoadEventInfo loadEventInfo, int i, IOException iOException, boolean z) {
            loadError(loadEventInfo, i, -1, null, 0, null, C0643C.TIME_UNSET, C0643C.TIME_UNSET, iOException, z);
        }

        public void loadStarted(LoadEventInfo loadEventInfo, int i) {
            loadStarted(loadEventInfo, i, -1, null, 0, null, C0643C.TIME_UNSET, C0643C.TIME_UNSET);
        }

        public void removeEventListener(MediaSourceEventListener mediaSourceEventListener) {
            CopyOnWriteArrayList copyOnWriteArrayList = this.f10983a;
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                C0703i c0703i = (C0703i) it.next();
                if (c0703i.f11533b == mediaSourceEventListener) {
                    copyOnWriteArrayList.remove(c0703i);
                }
            }
        }

        public void upstreamDiscarded(int i, long j, long j2) {
            upstreamDiscarded(new MediaLoadData(1, i, null, 3, null, m2741a(j), m2741a(j2)));
        }

        @CheckResult
        public EventDispatcher withParameters(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, long j) {
            return new EventDispatcher(this.f10983a, i, mediaPeriodId, j);
        }

        public EventDispatcher(CopyOnWriteArrayList copyOnWriteArrayList, int i, MediaSource.MediaPeriodId mediaPeriodId, long j) {
            this.f10983a = copyOnWriteArrayList;
            this.windowIndex = i;
            this.mediaPeriodId = mediaPeriodId;
            this.f10984b = j;
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2) {
            loadCanceled(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, m2741a(j), m2741a(j2)));
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2) {
            loadCompleted(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, m2741a(j), m2741a(j2)));
        }

        public void loadError(LoadEventInfo loadEventInfo, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2, IOException iOException, boolean z) {
            loadError(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, m2741a(j), m2741a(j2)), iOException, z);
        }

        public void loadStarted(LoadEventInfo loadEventInfo, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2) {
            loadStarted(loadEventInfo, new MediaLoadData(i, i2, format, i3, obj, m2741a(j), m2741a(j2)));
        }

        public void downstreamFormatChanged(MediaLoadData mediaLoadData) {
            Iterator it = this.f10983a.iterator();
            while (it.hasNext()) {
                C0703i c0703i = (C0703i) it.next();
                Util.postOrRun(c0703i.f11532a, new RunnableC0547b7(this, c0703i.f11533b, mediaLoadData, 11));
            }
        }

        public void upstreamDiscarded(MediaLoadData mediaLoadData) {
            MediaSource.MediaPeriodId mediaPeriodId = (MediaSource.MediaPeriodId) Assertions.checkNotNull(this.mediaPeriodId);
            Iterator it = this.f10983a.iterator();
            while (it.hasNext()) {
                C0703i c0703i = (C0703i) it.next();
                Util.postOrRun(c0703i.f11532a, new nm1(this, c0703i.f11533b, mediaPeriodId, mediaLoadData, 3));
            }
        }

        public void loadCanceled(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator it = this.f10983a.iterator();
            while (it.hasNext()) {
                C0703i c0703i = (C0703i) it.next();
                Util.postOrRun(c0703i.f11532a, new nm1(this, c0703i.f11533b, loadEventInfo, mediaLoadData, 1));
            }
        }

        public void loadCompleted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator it = this.f10983a.iterator();
            while (it.hasNext()) {
                C0703i c0703i = (C0703i) it.next();
                Util.postOrRun(c0703i.f11532a, new nm1(this, c0703i.f11533b, loadEventInfo, mediaLoadData, 0));
            }
        }

        public void loadError(final LoadEventInfo loadEventInfo, final MediaLoadData mediaLoadData, final IOException iOException, final boolean z) {
            Iterator it = this.f10983a.iterator();
            while (it.hasNext()) {
                C0703i c0703i = (C0703i) it.next();
                final MediaSourceEventListener mediaSourceEventListener = c0703i.f11533b;
                Util.postOrRun(c0703i.f11532a, new Runnable() { // from class: om1
                    @Override // java.lang.Runnable
                    public final void run() {
                        MediaSourceEventListener.EventDispatcher eventDispatcher = MediaSourceEventListener.EventDispatcher.this;
                        mediaSourceEventListener.onLoadError(eventDispatcher.windowIndex, eventDispatcher.mediaPeriodId, loadEventInfo, mediaLoadData, iOException, z);
                    }
                });
            }
        }

        public void loadStarted(LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
            Iterator it = this.f10983a.iterator();
            while (it.hasNext()) {
                C0703i c0703i = (C0703i) it.next();
                Util.postOrRun(c0703i.f11532a, new nm1(this, c0703i.f11533b, loadEventInfo, mediaLoadData, 2));
            }
        }
    }

    void onDownstreamFormatChanged(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);

    void onLoadCanceled(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadCompleted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onLoadError(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean z);

    void onLoadStarted(int i, @Nullable MediaSource.MediaPeriodId mediaPeriodId, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData);

    void onUpstreamDiscarded(int i, MediaSource.MediaPeriodId mediaPeriodId, MediaLoadData mediaLoadData);
}
