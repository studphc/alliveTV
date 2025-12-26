package android.support.v4.media.session;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.media.MediaSessionManager;

/* renamed from: android.support.v4.media.session.l */
/* loaded from: classes.dex */
public final class HandlerC0056l extends Handler {

    /* renamed from: a */
    public final /* synthetic */ MediaSessionCompat.Callback f430a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0056l(MediaSessionCompat.Callback callback, Looper looper) {
        super(looper);
        this.f430a = callback;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        InterfaceC0058n interfaceC0058n;
        MediaSessionCompat.Callback callback;
        HandlerC0056l handlerC0056l;
        if (message.what == 1) {
            synchronized (this.f430a.f370a) {
                interfaceC0058n = (InterfaceC0058n) this.f430a.f373d.get();
                callback = this.f430a;
                handlerC0056l = callback.f374e;
            }
            if (interfaceC0058n != null && callback == interfaceC0058n.mo130a() && handlerC0056l != null) {
                interfaceC0058n.mo132c((MediaSessionManager.RemoteUserInfo) message.obj);
                this.f430a.m124a(interfaceC0058n, handlerC0056l);
                interfaceC0058n.mo132c(null);
            }
        }
    }
}
