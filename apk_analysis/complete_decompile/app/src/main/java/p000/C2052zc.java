package p000;

import android.media.AudioManager;
import android.os.Handler;

/* renamed from: zc */
/* loaded from: classes.dex */
public final class C2052zc implements AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    public final Handler f29306a;

    /* renamed from: b */
    public final /* synthetic */ C0014ad f29307b;

    public C2052zc(C0014ad c0014ad, Handler handler) {
        this.f29307b = c0014ad;
        this.f29306a = handler;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        this.f29306a.post(new RunnableC2015yc(i, 0, this));
    }
}
