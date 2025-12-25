package androidx.media;

import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import p000.b01;

/* renamed from: androidx.media.n */
/* loaded from: classes.dex */
public final class C0437n extends MediaBrowserServiceCompat.Result {

    /* renamed from: f */
    public final /* synthetic */ b01 f6718f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0437n(String str, b01 b01Var) {
        super(str);
        this.f6718f = b01Var;
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    /* renamed from: d */
    public final void mo1554d(Object obj) {
        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) obj;
        b01 b01Var = this.f6718f;
        if (mediaItem == null) {
            b01Var.m2000q(null);
            return;
        }
        Parcel obtain = Parcel.obtain();
        mediaItem.writeToParcel(obtain, 0);
        b01Var.m2000q(obtain);
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    public final void detach() {
        ((MediaBrowserService.Result) this.f6718f.f7833b).detach();
    }
}
