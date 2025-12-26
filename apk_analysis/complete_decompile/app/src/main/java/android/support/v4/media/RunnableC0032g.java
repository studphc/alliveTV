package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

/* renamed from: android.support.v4.media.g */
/* loaded from: classes.dex */
public final class RunnableC0032g implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaBrowserCompat.SearchCallback f328a;

    /* renamed from: b */
    public final /* synthetic */ String f329b;

    /* renamed from: c */
    public final /* synthetic */ Bundle f330c;

    public RunnableC0032g(String str, Bundle bundle, MediaBrowserCompat.SearchCallback searchCallback) {
        this.f328a = searchCallback;
        this.f329b = str;
        this.f330c = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f328a.onError(this.f329b, this.f330c);
    }
}
