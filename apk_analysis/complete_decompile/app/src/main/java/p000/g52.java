package p000;

import android.view.KeyEvent;
import androidx.leanback.app.PlaybackFragment;
import androidx.leanback.widget.BaseGridView;

/* loaded from: classes.dex */
public final class g52 implements BaseGridView.OnKeyInterceptListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackFragment f17546a;

    public g52(PlaybackFragment playbackFragment) {
        this.f17546a = playbackFragment;
    }

    @Override // androidx.leanback.widget.BaseGridView.OnKeyInterceptListener
    public final boolean onInterceptKeyEvent(KeyEvent keyEvent) {
        return this.f17546a.m1322d(keyEvent);
    }
}
