package p000;

import android.media.AudioManager;
import android.os.Handler;
import android.os.Message;

/* renamed from: cd */
/* loaded from: classes.dex */
public final class C0589cd implements Handler.Callback, AudioManager.OnAudioFocusChangeListener {

    /* renamed from: a */
    public final Handler f8333a;

    /* renamed from: b */
    public final AudioManager.OnAudioFocusChangeListener f8334b;

    public C0589cd(AudioManager.OnAudioFocusChangeListener onAudioFocusChangeListener, Handler handler) {
        this.f8334b = onAudioFocusChangeListener;
        this.f8333a = new Handler(handler.getLooper(), this);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        if (message.what == 2782386) {
            this.f8334b.onAudioFocusChange(message.arg1);
            return true;
        }
        return false;
    }

    @Override // android.media.AudioManager.OnAudioFocusChangeListener
    public final void onAudioFocusChange(int i) {
        Handler handler = this.f8333a;
        handler.sendMessage(Message.obtain(handler, 2782386, i, 0));
    }
}
