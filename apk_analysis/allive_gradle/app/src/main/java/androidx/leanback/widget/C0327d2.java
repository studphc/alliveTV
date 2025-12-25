package androidx.leanback.widget;

import android.view.KeyEvent;
import androidx.leanback.widget.PlaybackControlsRowPresenter;
import androidx.leanback.widget.PlaybackControlsRowView;

/* renamed from: androidx.leanback.widget.d2 */
/* loaded from: classes.dex */
public final class C0327d2 implements PlaybackControlsRowView.OnUnhandledKeyListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackControlsRowPresenter.ViewHolder f6280a;

    public C0327d2(PlaybackControlsRowPresenter.ViewHolder viewHolder) {
        this.f6280a = viewHolder;
    }

    @Override // androidx.leanback.widget.PlaybackControlsRowView.OnUnhandledKeyListener
    public final boolean onUnhandledKey(KeyEvent keyEvent) {
        PlaybackControlsRowPresenter.ViewHolder viewHolder = this.f6280a;
        if (viewHolder.getOnKeyListener() != null && viewHolder.getOnKeyListener().onKey(viewHolder.view, keyEvent.getKeyCode(), keyEvent)) {
            return true;
        }
        return false;
    }
}
