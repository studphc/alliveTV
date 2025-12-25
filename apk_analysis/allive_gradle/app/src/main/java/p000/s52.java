package p000;

import android.view.MotionEvent;
import androidx.leanback.app.PlaybackSupportFragment;
import androidx.leanback.widget.BaseGridView;

/* loaded from: classes.dex */
public final class s52 implements BaseGridView.OnTouchInterceptListener {

    /* renamed from: a */
    public final /* synthetic */ PlaybackSupportFragment f26250a;

    public s52(PlaybackSupportFragment playbackSupportFragment) {
        this.f26250a = playbackSupportFragment;
    }

    @Override // androidx.leanback.widget.BaseGridView.OnTouchInterceptListener
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f26250a.m1332n(motionEvent);
    }
}
