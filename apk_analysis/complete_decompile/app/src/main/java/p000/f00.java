package p000;

import android.media.AudioTrack;
import android.os.ConditionVariable;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;

/* loaded from: classes.dex */
public final class f00 extends Thread {

    /* renamed from: a */
    public final /* synthetic */ int f17053a = 0;

    /* renamed from: b */
    public final /* synthetic */ Object f17054b;

    /* renamed from: c */
    public final /* synthetic */ Object f17055c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f00(SimpleCache simpleCache, ConditionVariable conditionVariable) {
        super("ExoPlayer:SimpleCacheInit");
        this.f17055c = simpleCache;
        this.f17054b = conditionVariable;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        switch (this.f17053a) {
            case 0:
                DefaultAudioSink defaultAudioSink = (DefaultAudioSink) this.f17055c;
                AudioTrack audioTrack = (AudioTrack) this.f17054b;
                try {
                    audioTrack.flush();
                    audioTrack.release();
                    return;
                } finally {
                    defaultAudioSink.f9718h.open();
                }
            default:
                synchronized (((SimpleCache) this.f17055c)) {
                    ((ConditionVariable) this.f17054b).open();
                    SimpleCache.m2998a((SimpleCache) this.f17055c);
                    ((SimpleCache) this.f17055c).f12643b.onCacheInitialized();
                }
                return;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f00(DefaultAudioSink defaultAudioSink, AudioTrack audioTrack) {
        super("ExoPlayer:AudioTrackReleaseThread");
        this.f17055c = defaultAudioSink;
        this.f17054b = audioTrack;
    }
}
