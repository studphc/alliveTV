package androidx.media;

import android.os.Parcel;
import android.service.media.MediaBrowserService;
import android.support.v4.media.MediaBrowserCompat;
import androidx.media.MediaBrowserServiceCompat;
import java.util.ArrayList;
import java.util.List;
import p000.b01;

/* renamed from: androidx.media.j */
/* loaded from: classes.dex */
public final class C0433j extends MediaBrowserServiceCompat.Result {

    /* renamed from: f */
    public final /* synthetic */ b01 f6708f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0433j(String str, b01 b01Var) {
        super(str);
        this.f6708f = b01Var;
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    /* renamed from: d */
    public final void mo1554d(Object obj) {
        ArrayList arrayList;
        List<MediaBrowserCompat.MediaItem> list = (List) obj;
        if (list != null) {
            arrayList = new ArrayList();
            for (MediaBrowserCompat.MediaItem mediaItem : list) {
                Parcel obtain = Parcel.obtain();
                mediaItem.writeToParcel(obtain, 0);
                arrayList.add(obtain);
            }
        } else {
            arrayList = null;
        }
        this.f6708f.m2000q(arrayList);
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    public final void detach() {
        ((MediaBrowserService.Result) this.f6708f.f7833b).detach();
    }
}
