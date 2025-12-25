package androidx.media;

import android.os.Bundle;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.os.ResultReceiver;
import androidx.media.MediaBrowserServiceCompat;

/* renamed from: androidx.media.e */
/* loaded from: classes.dex */
public final class C0428e extends MediaBrowserServiceCompat.Result {

    /* renamed from: f */
    public final /* synthetic */ ResultReceiver f6696f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0428e(Object obj, ResultReceiver resultReceiver) {
        super(obj);
        this.f6696f = resultReceiver;
    }

    @Override // androidx.media.MediaBrowserServiceCompat.Result
    /* renamed from: d */
    public final void mo1554d(Object obj) {
        MediaBrowserCompat.MediaItem mediaItem = (MediaBrowserCompat.MediaItem) obj;
        int i = this.f6672e & 2;
        ResultReceiver resultReceiver = this.f6696f;
        if (i != 0) {
            resultReceiver.send(-1, null);
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putParcelable(MediaBrowserServiceCompat.KEY_MEDIA_ITEM, mediaItem);
        resultReceiver.send(0, bundle);
    }
}
