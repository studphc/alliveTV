package com.google.android.exoplayer2.offline;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.analytics.PlayerId;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.upstream.DefaultAllocator;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.util.ArrayList;
import p000.C1524lu;

/* renamed from: com.google.android.exoplayer2.offline.a */
/* loaded from: classes.dex */
public final class C0680a implements MediaSource.MediaSourceCaller, MediaPeriod.Callback, Handler.Callback {

    /* renamed from: a */
    public final MediaSource f10850a;

    /* renamed from: b */
    public final DownloadHelper f10851b;

    /* renamed from: c */
    public final DefaultAllocator f10852c = new DefaultAllocator(true, 65536);

    /* renamed from: d */
    public final ArrayList f10853d = new ArrayList();

    /* renamed from: e */
    public final Handler f10854e = Util.createHandlerForCurrentOrMainLooper(new C1524lu(1, this));

    /* renamed from: f */
    public final HandlerThread f10855f;

    /* renamed from: g */
    public final Handler f10856g;

    /* renamed from: h */
    public Timeline f10857h;

    /* renamed from: i */
    public MediaPeriod[] f10858i;

    /* renamed from: j */
    public boolean f10859j;

    public C0680a(MediaSource mediaSource, DownloadHelper downloadHelper) {
        this.f10850a = mediaSource;
        this.f10851b = downloadHelper;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadHelper");
        this.f10855f = handlerThread;
        handlerThread.start();
        Handler createHandler = Util.createHandler(handlerThread.getLooper(), this);
        this.f10856g = createHandler;
        createHandler.sendEmptyMessage(0);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        Handler handler = this.f10856g;
        MediaSource mediaSource = this.f10850a;
        if (i != 0) {
            ArrayList arrayList = this.f10853d;
            int i2 = 0;
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return false;
                    }
                    MediaPeriod[] mediaPeriodArr = this.f10858i;
                    if (mediaPeriodArr != null) {
                        int length = mediaPeriodArr.length;
                        while (i2 < length) {
                            mediaSource.releasePeriod(mediaPeriodArr[i2]);
                            i2++;
                        }
                    }
                    mediaSource.releaseSource(this);
                    handler.removeCallbacksAndMessages(null);
                    this.f10855f.quit();
                    return true;
                }
                MediaPeriod mediaPeriod = (MediaPeriod) message.obj;
                if (arrayList.contains(mediaPeriod)) {
                    mediaPeriod.continueLoading(0L);
                }
                return true;
            }
            try {
                if (this.f10858i == null) {
                    mediaSource.maybeThrowSourceInfoRefreshError();
                } else {
                    while (i2 < arrayList.size()) {
                        ((MediaPeriod) arrayList.get(i2)).maybeThrowPrepareError();
                        i2++;
                    }
                }
                handler.sendEmptyMessageDelayed(1, 100L);
            } catch (IOException e) {
                this.f10854e.obtainMessage(1, e).sendToTarget();
            }
            return true;
        }
        mediaSource.prepareSource(this, null, PlayerId.UNSET);
        handler.sendEmptyMessage(1);
        return true;
    }

    @Override // com.google.android.exoplayer2.source.SequenceableLoader.Callback
    public final void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        MediaPeriod mediaPeriod2 = mediaPeriod;
        if (this.f10853d.contains(mediaPeriod2)) {
            this.f10856g.obtainMessage(2, mediaPeriod2).sendToTarget();
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaPeriod.Callback
    public final void onPrepared(MediaPeriod mediaPeriod) {
        ArrayList arrayList = this.f10853d;
        arrayList.remove(mediaPeriod);
        if (arrayList.isEmpty()) {
            this.f10856g.removeMessages(1);
            this.f10854e.sendEmptyMessage(0);
        }
    }

    @Override // com.google.android.exoplayer2.source.MediaSource.MediaSourceCaller
    public final void onSourceInfoRefreshed(MediaSource mediaSource, Timeline timeline) {
        MediaPeriod[] mediaPeriodArr;
        if (this.f10857h != null) {
            return;
        }
        if (timeline.getWindow(0, new Timeline.Window()).isLive()) {
            this.f10854e.obtainMessage(1, new DownloadHelper.LiveContentUnsupportedException()).sendToTarget();
            return;
        }
        this.f10857h = timeline;
        this.f10858i = new MediaPeriod[timeline.getPeriodCount()];
        int i = 0;
        while (true) {
            mediaPeriodArr = this.f10858i;
            if (i >= mediaPeriodArr.length) {
                break;
            }
            MediaPeriod createPeriod = this.f10850a.createPeriod(new MediaSource.MediaPeriodId(timeline.getUidOfPeriod(i)), this.f10852c, 0L);
            this.f10858i[i] = createPeriod;
            this.f10853d.add(createPeriod);
            i++;
        }
        for (MediaPeriod mediaPeriod : mediaPeriodArr) {
            mediaPeriod.prepare(this, 0L);
        }
    }
}
