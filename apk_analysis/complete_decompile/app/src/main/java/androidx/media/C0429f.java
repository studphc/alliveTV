package androidx.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;
import java.util.List;

/* renamed from: androidx.media.f */
/* loaded from: classes.dex */
public final class C0429f extends MediaBrowserServiceCompat.Result {

    /* renamed from: f */
    public final /* synthetic */ ResultReceiver f6697f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0429f(Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.f6697f = resultReceiver;
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    /* renamed from: d */
    public final void mo1554d(Object obj) {
        List list = (List) obj;
        int i = this.f6672e & 4;
        ResultReceiver resultReceiver = this.f6697f;
        if (i == 0 && list != null) {
            Bundle bundle = new Bundle();
            bundle.putParcelableArray(MediaBrowserServiceCompat.KEY_SEARCH_RESULTS, (Parcelable[]) list.toArray(new MediaBrowserCompat.MediaItem[0]));
            resultReceiver.send(0, bundle);
            return;
        }
        resultReceiver.send(-1, null);
    }
}
