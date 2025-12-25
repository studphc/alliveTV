package p000;

import android.media.MediaCodec;
import com.google.android.exoplayer2.mediacodec.C0676a;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter;

/* renamed from: dc */
/* loaded from: classes.dex */
public final /* synthetic */ class C1117dc implements MediaCodec.OnFrameRenderedListener {

    /* renamed from: a */
    public final /* synthetic */ int f16338a;

    /* renamed from: b */
    public final /* synthetic */ MediaCodecAdapter.OnFrameRenderedListener f16339b;

    /* renamed from: c */
    public final /* synthetic */ MediaCodecAdapter f16340c;

    public /* synthetic */ C1117dc(MediaCodecAdapter mediaCodecAdapter, MediaCodecAdapter.OnFrameRenderedListener onFrameRenderedListener, int i) {
        this.f16338a = i;
        this.f16340c = mediaCodecAdapter;
        this.f16339b = onFrameRenderedListener;
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        switch (this.f16338a) {
            case 0:
                C0676a c0676a = (C0676a) this.f16340c;
                c0676a.getClass();
                this.f16339b.onFrameRendered(c0676a, j, j2);
                return;
            default:
                SynchronousMediaCodecAdapter synchronousMediaCodecAdapter = (SynchronousMediaCodecAdapter) this.f16340c;
                synchronousMediaCodecAdapter.getClass();
                this.f16339b.onFrameRendered(synchronousMediaCodecAdapter, j, j2);
                return;
        }
    }
}
