package p000;

import android.os.HandlerThread;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.common.util.concurrent.SettableFuture;

/* loaded from: classes.dex */
public final class eo1 {

    /* renamed from: a */
    public final MediaSource.Factory f16926a;

    /* renamed from: b */
    public final HandlerThread f16927b;

    /* renamed from: c */
    public final HandlerWrapper f16928c;

    /* renamed from: d */
    public final SettableFuture f16929d;

    public eo1(MediaSource.Factory factory, Clock clock) {
        this.f16926a = factory;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:MetadataRetriever");
        this.f16927b = handlerThread;
        handlerThread.start();
        this.f16928c = clock.createHandler(handlerThread.getLooper(), new do1(this));
        this.f16929d = SettableFuture.create();
    }
}
