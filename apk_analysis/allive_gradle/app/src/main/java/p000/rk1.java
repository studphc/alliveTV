package p000;

import android.media.session.MediaSession;
import android.os.Bundle;
import android.support.v4.media.session.IMediaSession;
import android.support.v4.media.session.MediaSessionCompat;
import androidx.core.app.BundleCompat;
import androidx.media.C0438o;
import androidx.media.MediaBrowserProtocol;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class rk1 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaSessionCompat.Token f26004a;

    /* renamed from: b */
    public final /* synthetic */ C0438o f26005b;

    public rk1(C0438o c0438o, MediaSessionCompat.Token token) {
        this.f26005b = c0438o;
        this.f26004a = token;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C0438o c0438o = this.f26005b;
        ArrayList arrayList = c0438o.f6714a;
        boolean isEmpty = arrayList.isEmpty();
        MediaSessionCompat.Token token = this.f26004a;
        if (!isEmpty) {
            IMediaSession extraBinder = token.getExtraBinder();
            if (extraBinder != null) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    BundleCompat.putBinder((Bundle) it.next(), MediaBrowserProtocol.EXTRA_SESSION_BINDER, extraBinder.asBinder());
                }
            }
            arrayList.clear();
        }
        c0438o.f6715b.setSessionToken((MediaSession.Token) token.getToken());
    }
}
