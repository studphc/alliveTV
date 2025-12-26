package p000;

import android.content.DialogInterface;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.leanback.app.PlaybackFragment;
import androidx.leanback.app.PlaybackSupportFragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: q7 */
/* loaded from: classes.dex */
public final class HandlerC1714q7 extends Handler {

    /* renamed from: a */
    public final /* synthetic */ int f25473a;

    /* renamed from: b */
    public Object f25474b;

    /* JADX WARN: Removed duplicated region for block: B:39:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:41:? A[RETURN, SYNTHETIC] */
    @Override // android.os.Handler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void handleMessage(Message message) {
        C1190fc c1190fc;
        switch (this.f25473a) {
            case 0:
                int i = message.what;
                if (i != -3 && i != -2 && i != -1) {
                    if (i == 1) {
                        ((DialogInterface) message.obj).dismiss();
                        return;
                    }
                    return;
                }
                ((DialogInterface.OnClickListener) message.obj).onClick((DialogInterface) ((WeakReference) this.f25474b).get(), message.what);
                return;
            case 1:
                C1227gc c1227gc = (C1227gc) this.f25474b;
                c1227gc.getClass();
                int i2 = message.what;
                C1190fc c1190fc2 = null;
                if (i2 != 0) {
                    if (i2 != 1) {
                        if (i2 != 2) {
                            AtomicReference atomicReference = c1227gc.f17641d;
                            IllegalStateException illegalStateException = new IllegalStateException(String.valueOf(message.what));
                            while (!atomicReference.compareAndSet(null, illegalStateException) && atomicReference.get() == null) {
                            }
                        } else {
                            c1227gc.f17642e.open();
                        }
                        if (c1190fc2 == null) {
                            C1227gc.m4934c(c1190fc2);
                            return;
                        }
                        return;
                    }
                    c1190fc = (C1190fc) message.obj;
                    int i3 = c1190fc.f17203a;
                    int i4 = c1190fc.f17204b;
                    MediaCodec.CryptoInfo cryptoInfo = c1190fc.f17206d;
                    long j = c1190fc.f17207e;
                    int i5 = c1190fc.f17208f;
                    try {
                        synchronized (C1227gc.f17637h) {
                            c1227gc.f17638a.queueSecureInputBuffer(i3, i4, cryptoInfo, j, i5);
                        }
                    } catch (RuntimeException e) {
                        AtomicReference atomicReference2 = c1227gc.f17641d;
                        while (!atomicReference2.compareAndSet(null, e) && atomicReference2.get() == null) {
                        }
                    }
                } else {
                    c1190fc = (C1190fc) message.obj;
                    try {
                        c1227gc.f17638a.queueInputBuffer(c1190fc.f17203a, c1190fc.f17204b, c1190fc.f17205c, c1190fc.f17207e, c1190fc.f17208f);
                    } catch (RuntimeException e2) {
                        AtomicReference atomicReference3 = c1227gc.f17641d;
                        while (!atomicReference3.compareAndSet(null, e2) && atomicReference3.get() == null) {
                        }
                    }
                }
                c1190fc2 = c1190fc;
                if (c1190fc2 == null) {
                }
            case 2:
                if (message.what != 1) {
                    super.handleMessage(message);
                    return;
                } else {
                    ((LocalBroadcastManager) this.f25474b).m1547a();
                    return;
                }
            case 3:
                if (message.what == 1) {
                    PlaybackFragment playbackFragment = (PlaybackFragment) this.f25474b;
                    if (playbackFragment.f5103C) {
                        playbackFragment.hideControlsOverlay(true);
                        return;
                    }
                    return;
                }
                return;
            default:
                if (message.what == 1) {
                    PlaybackSupportFragment playbackSupportFragment = (PlaybackSupportFragment) this.f25474b;
                    if (playbackSupportFragment.f5156G0) {
                        playbackSupportFragment.hideControlsOverlay(true);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    public /* synthetic */ HandlerC1714q7(int i, Object obj) {
        this.f25473a = i;
        this.f25474b = obj;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HandlerC1714q7(Object obj, Looper looper, int i) {
        super(looper);
        this.f25473a = i;
        this.f25474b = obj;
    }
}
