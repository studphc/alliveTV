package androidx.leanback.widget;

import android.view.KeyEvent;
import androidx.leanback.widget.PlaybackTransportRowPresenter;
import androidx.leanback.widget.PlaybackTransportRowView;

/* renamed from: androidx.leanback.widget.i2 */
/* loaded from: classes.dex */
public final class C0347i2 implements PlaybackTransportRowView.OnUnhandledKeyListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackTransportRowPresenter.ViewHolder f6309a;

    public C0347i2(PlaybackTransportRowPresenter.ViewHolder viewHolder) {
        this.f6309a = viewHolder;
    }

    @Override // androidx.leanback.widget.PlaybackTransportRowView.OnUnhandledKeyListener
    public final boolean onUnhandledKey(KeyEvent keyEvent) {
        PlaybackTransportRowPresenter.ViewHolder viewHolder = this.f6309a;
        if (viewHolder.getOnKeyListener() != null) {
            return viewHolder.getOnKeyListener().onKey(viewHolder.view, keyEvent.getKeyCode(), keyEvent);
        }
        return false;
    }
}
