package com.google.android.exoplayer2.upstream;

import android.os.Handler;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import p000.RunnableC1228gd;

/* loaded from: classes.dex */
public interface BandwidthMeter {

    /* loaded from: classes.dex */
    public interface EventListener {

        /* loaded from: classes.dex */
        public static final class EventDispatcher {

            /* renamed from: a */
            public final CopyOnWriteArrayList f12390a = new CopyOnWriteArrayList();

            public void addListener(Handler handler, EventListener eventListener) {
                Assertions.checkNotNull(handler);
                Assertions.checkNotNull(eventListener);
                removeListener(eventListener);
                this.f12390a.add(new C0733a(handler, eventListener));
            }

            public void bandwidthSample(int i, long j, long j2) {
                Iterator it = this.f12390a.iterator();
                while (it.hasNext()) {
                    C0733a c0733a = (C0733a) it.next();
                    if (!c0733a.f12568c) {
                        c0733a.f12566a.post(new RunnableC1228gd(c0733a, i, j, j2, 1));
                    }
                }
            }

            public void removeListener(EventListener eventListener) {
                CopyOnWriteArrayList copyOnWriteArrayList = this.f12390a;
                Iterator it = copyOnWriteArrayList.iterator();
                while (it.hasNext()) {
                    C0733a c0733a = (C0733a) it.next();
                    if (c0733a.f12567b == eventListener) {
                        c0733a.f12568c = true;
                        copyOnWriteArrayList.remove(c0733a);
                    }
                }
            }
        }

        void onBandwidthSample(int i, long j, long j2);
    }

    void addEventListener(Handler handler, EventListener eventListener);

    long getBitrateEstimate();

    long getTimeToFirstByteEstimateUs();

    @Nullable
    TransferListener getTransferListener();

    void removeEventListener(EventListener eventListener);
}
