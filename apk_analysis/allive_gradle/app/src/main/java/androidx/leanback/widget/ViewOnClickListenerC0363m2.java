package androidx.leanback.widget;

import android.view.View;
import androidx.leanback.widget.PlaybackTransportRowPresenter;

/* renamed from: androidx.leanback.widget.m2 */
/* loaded from: classes.dex */
public final class ViewOnClickListenerC0363m2 implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackTransportRowPresenter.ViewHolder f6325a;

    public ViewOnClickListenerC0363m2(PlaybackTransportRowPresenter.ViewHolder viewHolder) {
        this.f6325a = viewHolder;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PlaybackTransportRowPresenter.ViewHolder viewHolder = this.f6325a;
        PlaybackTransportRowPresenter.this.onProgressBarClicked(viewHolder);
    }
}
