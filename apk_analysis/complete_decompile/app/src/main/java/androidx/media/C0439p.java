package androidx.media;

import android.os.Bundle;
import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;
import java.util.List;
import p000.b01;

/* renamed from: androidx.media.p */
/* loaded from: classes.dex */
public final class C0439p extends MediaBrowserServiceCompat.Result {

    /* renamed from: f */
    public final /* synthetic */ b01 f6720f;

    /* renamed from: g */
    public final /* synthetic */ Bundle f6721g;

    /* renamed from: h */
    public final /* synthetic */ C0440q f6722h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0439p(C0440q c0440q, String str, b01 b01Var, Bundle bundle) {
        super(str);
        this.f6722h = c0440q;
        this.f6720f = b01Var;
        this.f6721g = bundle;
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    /* renamed from: d */
    public final void mo1554d(Object obj) {
        List<MediaBrowserCompat.MediaItem> list = (List) obj;
        b01 b01Var = this.f6720f;
        if (list == null) {
            b01Var.m2000q(null);
            return;
        }
        if ((this.f6672e & 1) != 0) {
            this.f6722h.f6723f.getClass();
            list = MediaBrowserServiceCompat.m1549a(list, this.f6721g);
        }
        ArrayList arrayList = new ArrayList();
        for (MediaBrowserCompat.MediaItem mediaItem : list) {
            Parcel obtain = Parcel.obtain();
            mediaItem.writeToParcel(obtain, 0);
            arrayList.add(obtain);
        }
        b01Var.m2000q(arrayList);
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    public final void detach() {
        ((MediaBrowserService.Result) this.f6720f.f7833b).detach();
    }
}
