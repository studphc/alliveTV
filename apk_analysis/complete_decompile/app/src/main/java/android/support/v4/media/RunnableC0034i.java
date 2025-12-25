package android.support.v4.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;

/* renamed from: android.support.v4.media.i */
/* loaded from: classes.dex */
public final class RunnableC0034i implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ MediaBrowserCompat.CustomActionCallback f334a;

    /* renamed from: b */
    public final /* synthetic */ String f335b;

    /* renamed from: c */
    public final /* synthetic */ Bundle f336c;

    public RunnableC0034i(String str, Bundle bundle, MediaBrowserCompat.CustomActionCallback customActionCallback) {
        this.f334a = customActionCallback;
        this.f335b = str;
        this.f336c = bundle;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f334a.onError(this.f335b, this.f336c, null);
    }
}
