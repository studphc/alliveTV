package p000;

import com.google.android.exoplayer2.decoder.SimpleDecoder;

/* loaded from: classes.dex */
public final class ki2 extends Thread {

    /* renamed from: a */
    public final /* synthetic */ SimpleDecoder f20863a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ki2(SimpleDecoder simpleDecoder) {
        super("ExoPlayer:SimpleDecoder");
        this.f20863a = simpleDecoder;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        SimpleDecoder simpleDecoder = this.f20863a;
        simpleDecoder.getClass();
        do {
            try {
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            }
        } while (simpleDecoder.m2508a());
    }
}
