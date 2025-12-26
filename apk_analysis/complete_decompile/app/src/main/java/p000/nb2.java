package p000;

import android.graphics.drawable.Drawable;
import android.view.View;
import com.bumptech.glide.request.target.CustomViewTarget;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes.dex */
public final class nb2 extends CustomViewTarget {

    /* renamed from: f */
    public final /* synthetic */ int f23320f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ nb2(View view, int i) {
        super(view);
        this.f23320f = i;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadFailed(Drawable drawable) {
        int i = this.f23320f;
    }

    @Override // com.bumptech.glide.request.target.CustomViewTarget
    public final void onResourceCleared(Drawable drawable) {
        int i = this.f23320f;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object obj, Transition transition) {
        int i = this.f23320f;
    }

    /* renamed from: a */
    private final void m6334a(Drawable drawable) {
    }

    /* renamed from: b */
    private final void m6335b(Drawable drawable) {
    }

    /* renamed from: c */
    private final void m6336c(Drawable drawable) {
    }

    /* renamed from: d */
    private final void m6337d(Drawable drawable) {
    }

    /* renamed from: e */
    private final void m6338e(Object obj, Transition transition) {
    }

    /* renamed from: f */
    private final void m6339f(Object obj, Transition transition) {
    }
}
