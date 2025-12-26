package p000;

import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.util.Util;

/* renamed from: id */
/* loaded from: classes.dex */
public final /* synthetic */ class RunnableC1302id implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f18370a;

    /* renamed from: b */
    public final /* synthetic */ AudioRendererEventListener.EventDispatcher f18371b;

    /* renamed from: c */
    public final /* synthetic */ Exception f18372c;

    public /* synthetic */ RunnableC1302id(AudioRendererEventListener.EventDispatcher eventDispatcher, Exception exc, int i) {
        this.f18370a = i;
        this.f18371b = eventDispatcher;
        this.f18372c = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f18370a) {
            case 0:
                ((AudioRendererEventListener) Util.castNonNull(this.f18371b.f9655b)).onAudioCodecError(this.f18372c);
                return;
            default:
                ((AudioRendererEventListener) Util.castNonNull(this.f18371b.f9655b)).onAudioSinkError(this.f18372c);
                return;
        }
    }
}
