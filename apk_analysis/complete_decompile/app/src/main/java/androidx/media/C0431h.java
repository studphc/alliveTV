package androidx.media;

import android.os.Bundle;
import android.os.IBinder;
import androidx.media.MediaBrowserServiceCompat;
import androidx.media.MediaSessionManager;
import java.util.HashMap;
import p000.RunnableC1104d;
import p000.al1;

/* renamed from: androidx.media.h */
/* loaded from: classes.dex */
public final class C0431h implements IBinder.DeathRecipient {

    /* renamed from: a */
    public final String f6699a;

    /* renamed from: b */
    public final int f6700b;

    /* renamed from: c */
    public final int f6701c;

    /* renamed from: d */
    public final MediaSessionManager.RemoteUserInfo f6702d;

    /* renamed from: e */
    public final Bundle f6703e;

    /* renamed from: f */
    public final al1 f6704f;

    /* renamed from: g */
    public final HashMap f6705g = new HashMap();

    /* renamed from: h */
    public MediaBrowserServiceCompat.BrowserRoot f6706h;

    /* renamed from: i */
    public final /* synthetic */ MediaBrowserServiceCompat f6707i;

    public C0431h(MediaBrowserServiceCompat mediaBrowserServiceCompat, String str, int i, int i2, Bundle bundle, al1 al1Var) {
        this.f6707i = mediaBrowserServiceCompat;
        this.f6699a = str;
        this.f6700b = i;
        this.f6701c = i2;
        this.f6702d = new MediaSessionManager.RemoteUserInfo(str, i, i2);
        this.f6703e = bundle;
        this.f6704f = al1Var;
    }

    @Override // android.os.IBinder.DeathRecipient
    public final void binderDied() {
        this.f6707i.f6664f.post(new RunnableC1104d(27, this));
    }
}
