package android.support.v4.media.session;

import android.app.PendingIntent;
import android.content.Context;
import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteCallbackList;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.util.Log;
import androidx.media.MediaSessionManager;
import androidx.versionedparcelable.VersionedParcelable;
import java.util.List;

/* renamed from: android.support.v4.media.session.p */
/* loaded from: classes.dex */
public class C0060p implements InterfaceC0058n {

    /* renamed from: a */
    public final MediaSession f433a;

    /* renamed from: b */
    public final MediaSessionCompat.Token f434b;

    /* renamed from: d */
    public Bundle f436d;

    /* renamed from: g */
    public PlaybackStateCompat f439g;

    /* renamed from: h */
    public List f440h;

    /* renamed from: i */
    public MediaMetadataCompat f441i;

    /* renamed from: j */
    public int f442j;

    /* renamed from: k */
    public boolean f443k;

    /* renamed from: l */
    public int f444l;

    /* renamed from: m */
    public int f445m;

    /* renamed from: n */
    public MediaSessionCompat.Callback f446n;

    /* renamed from: o */
    public MediaSessionManager.RemoteUserInfo f447o;

    /* renamed from: c */
    public final Object f435c = new Object();

    /* renamed from: e */
    public boolean f437e = false;

    /* renamed from: f */
    public final RemoteCallbackList f438f = new RemoteCallbackList();

    public C0060p(Context context, String str, VersionedParcelable versionedParcelable, Bundle bundle) {
        MediaSession mo134e = mo134e(context, str, bundle);
        this.f433a = mo134e;
        this.f434b = new MediaSessionCompat.Token(mo134e.getSessionToken(), new BinderC0059o(this), versionedParcelable);
        this.f436d = bundle;
        m137h(3);
    }

    @Override // android.support.v4.media.session.InterfaceC0058n
    /* renamed from: a */
    public final MediaSessionCompat.Callback mo130a() {
        MediaSessionCompat.Callback callback;
        synchronized (this.f435c) {
            callback = this.f446n;
        }
        return callback;
    }

    @Override // android.support.v4.media.session.InterfaceC0058n
    /* renamed from: b */
    public void mo131b(int i) {
        this.f442j = i;
    }

    @Override // android.support.v4.media.session.InterfaceC0058n
    /* renamed from: c */
    public void mo132c(MediaSessionManager.RemoteUserInfo remoteUserInfo) {
        synchronized (this.f435c) {
            this.f447o = remoteUserInfo;
        }
    }

    @Override // android.support.v4.media.session.InterfaceC0058n
    /* renamed from: d */
    public MediaSessionManager.RemoteUserInfo mo133d() {
        MediaSessionManager.RemoteUserInfo remoteUserInfo;
        synchronized (this.f435c) {
            remoteUserInfo = this.f447o;
        }
        return remoteUserInfo;
    }

    /* renamed from: e */
    public MediaSession mo134e(Context context, String str, Bundle bundle) {
        return new MediaSession(context, str);
    }

    /* renamed from: f */
    public final String m135f() {
        MediaSession mediaSession = this.f433a;
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        try {
            return (String) mediaSession.getClass().getMethod("getCallingPackage", null).invoke(mediaSession, null);
        } catch (Exception e) {
            Log.e("MediaSessionCompat", "Cannot execute MediaSession.getCallingPackage()", e);
            return null;
        }
    }

    /* renamed from: g */
    public final void m136g(MediaSessionCompat.Callback callback, Handler handler) {
        C0057m c0057m;
        synchronized (this.f435c) {
            try {
                this.f446n = callback;
                MediaSession mediaSession = this.f433a;
                if (callback == null) {
                    c0057m = null;
                } else {
                    c0057m = callback.f371b;
                }
                mediaSession.setCallback(c0057m, handler);
                if (callback != null) {
                    callback.m125b(this, handler);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.support.v4.media.session.InterfaceC0058n
    public final PlaybackStateCompat getPlaybackState() {
        return this.f439g;
    }

    /* renamed from: h */
    public final void m137h(int i) {
        this.f433a.setFlags(i | 3);
    }

    /* renamed from: i */
    public final void m138i(PendingIntent pendingIntent) {
        this.f433a.setMediaButtonReceiver(pendingIntent);
    }

    public C0060p(Object obj) {
        if (obj instanceof MediaSession) {
            MediaSession mediaSession = (MediaSession) obj;
            this.f433a = mediaSession;
            this.f434b = new MediaSessionCompat.Token(mediaSession.getSessionToken(), new BinderC0059o(this), null);
            this.f436d = null;
            m137h(3);
            return;
        }
        throw new IllegalArgumentException("mediaSession is not a valid MediaSession object");
    }
}
