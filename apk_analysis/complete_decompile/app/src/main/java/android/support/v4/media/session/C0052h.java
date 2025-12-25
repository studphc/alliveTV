package android.support.v4.media.session;

import android.content.Context;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* renamed from: android.support.v4.media.session.h */
/* loaded from: classes.dex */
public class C0052h implements InterfaceC0050f {

    /* renamed from: a */
    public final MediaController f423a;

    /* renamed from: b */
    public final Object f424b = new Object();

    /* renamed from: c */
    public final ArrayList f425c = new ArrayList();

    /* renamed from: d */
    public final HashMap f426d = new HashMap();

    /* renamed from: e */
    public Bundle f427e;

    /* renamed from: f */
    public final MediaSessionCompat.Token f428f;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [android.support.v4.media.session.MediaControllerCompat$MediaControllerImplApi21$ExtraBinderRequestResultReceiver, android.os.ResultReceiver] */
    public C0052h(Context context, MediaSessionCompat.Token token) {
        this.f428f = token;
        MediaController mediaController = new MediaController(context, (MediaSession.Token) token.getToken());
        this.f423a = mediaController;
        if (token.getExtraBinder() == null) {
            ?? resultReceiver = new ResultReceiver(null);
            resultReceiver.f360a = new WeakReference(this);
            mediaController.sendCommand(MediaControllerCompat.COMMAND_GET_EXTRA_BINDER, null, resultReceiver);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [android.support.v4.media.session.g, android.support.v4.media.session.IMediaControllerCallback, android.support.v4.media.session.e, java.lang.Object] */
    /* renamed from: a */
    public final void m126a() {
        MediaSessionCompat.Token token = this.f428f;
        if (token.getExtraBinder() == null) {
            return;
        }
        ArrayList arrayList = this.f425c;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            MediaControllerCompat.Callback callback = (MediaControllerCompat.Callback) it.next();
            ?? abstractBinderC0049e = new AbstractBinderC0049e(callback);
            this.f426d.put(callback, abstractBinderC0049e);
            callback.f359c = abstractBinderC0049e;
            try {
                token.getExtraBinder().registerCallbackListener(abstractBinderC0049e);
                callback.m121a(13, null, null);
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e);
            }
        }
        arrayList.clear();
    }

    /* renamed from: b */
    public final void m127b(MediaControllerCompat.Callback callback) {
        this.f423a.unregisterCallback(callback.f357a);
        synchronized (this.f424b) {
            if (this.f428f.getExtraBinder() != null) {
                try {
                    BinderC0051g binderC0051g = (BinderC0051g) this.f426d.remove(callback);
                    if (binderC0051g != null) {
                        callback.f359c = null;
                        this.f428f.getExtraBinder().unregisterCallbackListener(binderC0051g);
                    }
                } catch (RemoteException e) {
                    Log.e("MediaControllerCompat", "Dead object in unregisterCallback.", e);
                }
            } else {
                this.f425c.remove(callback);
            }
        }
    }

    @Override // android.support.v4.media.session.InterfaceC0050f
    public Bundle getSessionInfo() {
        if (this.f427e != null) {
            return new Bundle(this.f427e);
        }
        MediaSessionCompat.Token token = this.f428f;
        if (token.getExtraBinder() != null) {
            try {
                this.f427e = token.getExtraBinder().getSessionInfo();
            } catch (RemoteException e) {
                Log.e("MediaControllerCompat", "Dead object in getSessionInfo.", e);
                this.f427e = Bundle.EMPTY;
            }
        }
        Bundle unparcelWithClassLoader = MediaSessionCompat.unparcelWithClassLoader(this.f427e);
        this.f427e = unparcelWithClassLoader;
        if (unparcelWithClassLoader == null) {
            return Bundle.EMPTY;
        }
        return new Bundle(this.f427e);
    }
}
