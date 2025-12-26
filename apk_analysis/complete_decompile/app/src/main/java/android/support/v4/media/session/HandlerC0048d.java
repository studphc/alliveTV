package android.support.v4.media.session;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import java.util.List;

/* renamed from: android.support.v4.media.session.d */
/* loaded from: classes.dex */
public final class HandlerC0048d extends Handler {

    /* renamed from: a */
    public boolean f420a;

    /* renamed from: b */
    public final /* synthetic */ MediaControllerCompat.Callback f421b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0048d(MediaControllerCompat.Callback callback, Looper looper) {
        super(looper);
        this.f421b = callback;
        this.f420a = false;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        if (!this.f420a) {
            return;
        }
        int i = message.what;
        MediaControllerCompat.Callback callback = this.f421b;
        switch (i) {
            case 1:
                Bundle data = message.getData();
                MediaSessionCompat.ensureClassLoader(data);
                callback.onSessionEvent((String) message.obj, data);
                return;
            case 2:
                callback.onPlaybackStateChanged((PlaybackStateCompat) message.obj);
                return;
            case 3:
                callback.onMetadataChanged((MediaMetadataCompat) message.obj);
                return;
            case 4:
                callback.onAudioInfoChanged((MediaControllerCompat.PlaybackInfo) message.obj);
                return;
            case 5:
                callback.onQueueChanged((List) message.obj);
                return;
            case 6:
                callback.onQueueTitleChanged((CharSequence) message.obj);
                return;
            case 7:
                Bundle bundle = (Bundle) message.obj;
                MediaSessionCompat.ensureClassLoader(bundle);
                callback.onExtrasChanged(bundle);
                return;
            case 8:
                callback.onSessionDestroyed();
                return;
            case 9:
                callback.onRepeatModeChanged(((Integer) message.obj).intValue());
                return;
            case 10:
            default:
                return;
            case 11:
                callback.onCaptioningEnabledChanged(((Boolean) message.obj).booleanValue());
                return;
            case 12:
                callback.onShuffleModeChanged(((Integer) message.obj).intValue());
                return;
            case 13:
                callback.onSessionReady();
                return;
        }
    }
}
