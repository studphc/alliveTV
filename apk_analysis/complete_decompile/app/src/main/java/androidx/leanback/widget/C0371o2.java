package androidx.leanback.widget;

import androidx.leanback.widget.PlaybackTransportRowPresenter;
import androidx.leanback.widget.SeekBar;

/* renamed from: androidx.leanback.widget.o2 */
/* loaded from: classes.dex */
public final class C0371o2 extends SeekBar.AccessibilitySeekListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackTransportRowPresenter.ViewHolder f6334a;

    public C0371o2(PlaybackTransportRowPresenter.ViewHolder viewHolder) {
        this.f6334a = viewHolder;
    }

    @Override // androidx.leanback.widget.SeekBar.AccessibilitySeekListener
    public final boolean onAccessibilitySeekBackward() {
        PlaybackTransportRowPresenter.ViewHolder viewHolder = this.f6334a;
        if (!viewHolder.m1475d()) {
            return false;
        }
        viewHolder.m1477f(false);
        return true;
    }

    @Override // androidx.leanback.widget.SeekBar.AccessibilitySeekListener
    public final boolean onAccessibilitySeekForward() {
        PlaybackTransportRowPresenter.ViewHolder viewHolder = this.f6334a;
        if (!viewHolder.m1475d()) {
            return false;
        }
        viewHolder.m1477f(true);
        return true;
    }
}
