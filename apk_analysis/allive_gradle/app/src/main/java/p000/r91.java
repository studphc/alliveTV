package p000;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.request.Request;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes.dex */
public final class r91 implements Target {

    /* renamed from: a */
    public int f25909a;

    /* renamed from: b */
    public int f25910b;

    /* renamed from: c */
    public Request f25911c;

    @Override // com.bumptech.glide.request.target.Target
    public final Request getRequest() {
        return this.f25911c;
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void getSize(SizeReadyCallback sizeReadyCallback) {
        sizeReadyCallback.onSizeReady(this.f25910b, this.f25909a);
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void setRequest(Request request) {
        this.f25911c = request;
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onStart() {
    }

    @Override // com.bumptech.glide.manager.LifecycleListener
    public final void onStop() {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadCleared(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadFailed(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onLoadStarted(Drawable drawable) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void removeCallback(SizeReadyCallback sizeReadyCallback) {
    }

    @Override // com.bumptech.glide.request.target.Target
    public final void onResourceReady(Object obj, Transition transition) {
    }
}
