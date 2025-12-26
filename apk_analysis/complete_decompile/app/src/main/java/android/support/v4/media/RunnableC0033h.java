package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

/* renamed from: android.support.v4.media.h */
/* loaded from: classes.dex */
public final class RunnableC0033h implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaBrowserCompat.SearchCallback f331a;

    /* renamed from: b */
    public final /* synthetic */ String f332b;

    /* renamed from: c */
    public final /* synthetic */ Bundle f333c;

    public RunnableC0033h(String str, Bundle bundle, MediaBrowserCompat.SearchCallback searchCallback) {
        this.f331a = searchCallback;
        this.f332b = str;
        this.f333c = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f331a.onError(this.f332b, this.f333c);
    }
}
