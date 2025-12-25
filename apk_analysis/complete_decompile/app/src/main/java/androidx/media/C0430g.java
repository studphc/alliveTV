package androidx.media;

import android.os.Bundle;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;

/* renamed from: androidx.media.g */
/* loaded from: classes.dex */
public final class C0430g extends MediaBrowserServiceCompat.Result {

    /* renamed from: f */
    public final /* synthetic */ ResultReceiver f6698f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0430g(Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.f6698f = resultReceiver;
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    /* renamed from: b */
    public final void mo1552b(Bundle bundle) {
        this.f6698f.send(-1, bundle);
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    /* renamed from: c */
    public final void mo1553c(Bundle bundle) {
        this.f6698f.send(1, bundle);
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    /* renamed from: d */
    public final void mo1554d(Object obj) {
        this.f6698f.send(0, (Bundle) obj);
    }
}
