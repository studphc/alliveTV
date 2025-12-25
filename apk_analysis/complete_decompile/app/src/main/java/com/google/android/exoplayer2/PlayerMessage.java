package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class PlayerMessage {

    /* renamed from: a */
    public final Target f9475a;

    /* renamed from: b */
    public final Sender f9476b;

    /* renamed from: c */
    public final Clock f9477c;

    /* renamed from: d */
    public final Timeline f9478d;

    /* renamed from: e */
    public int f9479e;

    /* renamed from: f */
    public Object f9480f;

    /* renamed from: g */
    public Looper f9481g;

    /* renamed from: h */
    public int f9482h;

    /* renamed from: i */
    public long f9483i = C0643C.TIME_UNSET;

    /* renamed from: j */
    public boolean f9484j = true;

    /* renamed from: k */
    public boolean f9485k;

    /* renamed from: l */
    public boolean f9486l;

    /* renamed from: m */
    public boolean f9487m;

    /* renamed from: n */
    public boolean f9488n;

    /* loaded from: classes.dex */
    public interface Sender {
        void sendMessage(PlayerMessage playerMessage);
    }

    /* loaded from: classes.dex */
    public interface Target {
        void handleMessage(int i, @Nullable Object obj);
    }

    public PlayerMessage(Sender sender, Target target, Timeline timeline, int i, Clock clock, Looper looper) {
        this.f9476b = sender;
        this.f9475a = target;
        this.f9478d = timeline;
        this.f9481g = looper;
        this.f9477c = clock;
        this.f9482h = i;
    }

    public synchronized boolean blockUntilDelivered() {
        try {
            Assertions.checkState(this.f9485k);
            Assertions.checkState(this.f9481g.getThread() != Thread.currentThread());
            while (!this.f9487m) {
                wait();
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9486l;
    }

    public synchronized PlayerMessage cancel() {
        Assertions.checkState(this.f9485k);
        this.f9488n = true;
        markAsProcessed(false);
        return this;
    }

    public boolean getDeleteAfterDelivery() {
        return this.f9484j;
    }

    public Looper getLooper() {
        return this.f9481g;
    }

    public int getMediaItemIndex() {
        return this.f9482h;
    }

    @Nullable
    public Object getPayload() {
        return this.f9480f;
    }

    public long getPositionMs() {
        return this.f9483i;
    }

    public Target getTarget() {
        return this.f9475a;
    }

    public Timeline getTimeline() {
        return this.f9478d;
    }

    public int getType() {
        return this.f9479e;
    }

    public synchronized boolean isCanceled() {
        return this.f9488n;
    }

    public synchronized void markAsProcessed(boolean z) {
        this.f9486l = z | this.f9486l;
        this.f9487m = true;
        notifyAll();
    }

    public PlayerMessage send() {
        Assertions.checkState(!this.f9485k);
        if (this.f9483i == C0643C.TIME_UNSET) {
            Assertions.checkArgument(this.f9484j);
        }
        this.f9485k = true;
        this.f9476b.sendMessage(this);
        return this;
    }

    public PlayerMessage setDeleteAfterDelivery(boolean z) {
        Assertions.checkState(!this.f9485k);
        this.f9484j = z;
        return this;
    }

    @Deprecated
    public PlayerMessage setHandler(Handler handler) {
        return setLooper(handler.getLooper());
    }

    public PlayerMessage setLooper(Looper looper) {
        Assertions.checkState(!this.f9485k);
        this.f9481g = looper;
        return this;
    }

    public PlayerMessage setPayload(@Nullable Object obj) {
        Assertions.checkState(!this.f9485k);
        this.f9480f = obj;
        return this;
    }

    public PlayerMessage setPosition(long j) {
        Assertions.checkState(!this.f9485k);
        this.f9483i = j;
        return this;
    }

    public PlayerMessage setType(int i) {
        Assertions.checkState(!this.f9485k);
        this.f9479e = i;
        return this;
    }

    public PlayerMessage setPosition(int i, long j) {
        Assertions.checkState(!this.f9485k);
        Assertions.checkArgument(j != C0643C.TIME_UNSET);
        Timeline timeline = this.f9478d;
        if (i >= 0 && (timeline.isEmpty() || i < timeline.getWindowCount())) {
            this.f9482h = i;
            this.f9483i = j;
            return this;
        }
        throw new IllegalSeekPositionException(timeline, i, j);
    }

    public synchronized boolean blockUntilDelivered(long j) {
        boolean z;
        try {
            Assertions.checkState(this.f9485k);
            Assertions.checkState(this.f9481g.getThread() != Thread.currentThread());
            long elapsedRealtime = this.f9477c.elapsedRealtime() + j;
            while (true) {
                z = this.f9487m;
                if (z || j <= 0) {
                    break;
                }
                this.f9477c.onThreadBlocked();
                wait(j);
                j = elapsedRealtime - this.f9477c.elapsedRealtime();
            }
            if (!z) {
                throw new TimeoutException("Message delivery timed out.");
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f9486l;
    }
}
