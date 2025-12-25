package p000;

import android.view.KeyEvent;
import androidx.leanback.app.PlaybackSupportFragment;
import androidx.leanback.widget.BaseGridView;

/* loaded from: classes.dex */
public final class t52 implements BaseGridView.OnKeyInterceptListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackSupportFragment f26699a;

    public t52(PlaybackSupportFragment playbackSupportFragment) {
        this.f26699a = playbackSupportFragment;
    }

    @Override // androidx.leanback.widget.BaseGridView.OnKeyInterceptListener
    public final boolean onInterceptKeyEvent(KeyEvent keyEvent) {
        return this.f26699a.m1332n(keyEvent);
    }
}
