package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

/* renamed from: android.support.v4.media.j */
/* loaded from: classes.dex */
public final class RunnableC0035j implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaBrowserCompat.CustomActionCallback f337a;

    /* renamed from: b */
    public final /* synthetic */ String f338b;

    /* renamed from: c */
    public final /* synthetic */ Bundle f339c;

    public RunnableC0035j(String str, Bundle bundle, MediaBrowserCompat.CustomActionCallback customActionCallback) {
        this.f337a = customActionCallback;
        this.f338b = str;
        this.f339c = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f337a.onError(this.f338b, this.f339c, null);
    }
}
