package p000;

import android.view.MotionEvent;
import androidx.leanback.app.PlaybackFragment;
import androidx.leanback.widget.BaseGridView;

/* loaded from: classes.dex */
public final class f52 implements BaseGridView.OnTouchInterceptListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackFragment f17129a;

    public f52(PlaybackFragment playbackFragment) {
        this.f17129a = playbackFragment;
    }

    @Override // androidx.leanback.widget.BaseGridView.OnTouchInterceptListener
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f17129a.m1322d(motionEvent);
    }
}
