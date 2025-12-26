package androidx.leanback.widget;

import android.graphics.Bitmap;
import androidx.leanback.widget.PlaybackSeekDataProvider;
import androidx.leanback.widget.PlaybackTransportRowPresenter;

/* renamed from: androidx.leanback.widget.l2 */
/* loaded from: classes.dex */
public final class C0359l2 extends PlaybackSeekDataProvider.ResultCallback {

    /* renamed from: a */
    public final /* synthetic */ PlaybackTransportRowPresenter.ViewHolder f6321a;

    public C0359l2(PlaybackTransportRowPresenter.ViewHolder viewHolder) {
        this.f6321a = viewHolder;
    }

    @Override // androidx.leanback.widget.PlaybackSeekDataProvider.ResultCallback
    public final void onThumbnailLoaded(Bitmap bitmap, int i) {
        PlaybackTransportRowPresenter.ViewHolder viewHolder = this.f6321a;
        int childCount = i - (viewHolder.f6046G - (viewHolder.f6063v.getChildCount() / 2));
        if (childCount >= 0 && childCount < viewHolder.f6063v.getChildCount()) {
            viewHolder.f6063v.setThumbBitmap(childCount, bitmap);
        }
    }
}
