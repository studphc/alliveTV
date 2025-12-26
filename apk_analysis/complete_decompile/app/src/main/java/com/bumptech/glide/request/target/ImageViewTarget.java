package com.bumptech.glide.request.target;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.transition.Transition;

/* loaded from: classes.dex */
public abstract class ImageViewTarget<Z> extends ViewTarget<ImageView, Z> implements Transition.ViewAdapter {

    /* renamed from: h */
    public Animatable f9115h;

    public ImageViewTarget(ImageView imageView) {
        super(imageView);
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    @Nullable
    public Drawable getCurrentDrawable() {
        return ((ImageView) this.view).getDrawable();
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadCleared(@Nullable Drawable drawable) {
        super.onLoadCleared(drawable);
        Animatable animatable = this.f9115h;
        if (animatable != null) {
            animatable.stop();
        }
        setResource(null);
        this.f9115h = null;
        setDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadFailed(@Nullable Drawable drawable) {
        super.onLoadFailed(drawable);
        setResource(null);
        this.f9115h = null;
        setDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.ViewTarget, com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.request.target.Target
    public void onLoadStarted(@Nullable Drawable drawable) {
        super.onLoadStarted(drawable);
        setResource(null);
        this.f9115h = null;
        setDrawable(drawable);
    }

    @Override // com.bumptech.glide.request.target.Target
    public void onResourceReady(@NonNull Z z, @Nullable Transition<? super Z> transition) {
        if (transition != null && transition.transition(z, this)) {
            if (z instanceof Animatable) {
                Animatable animatable = (Animatable) z;
                this.f9115h = animatable;
                animatable.start();
                return;
            }
            this.f9115h = null;
            return;
        }
        setResource(z);
        if (z instanceof Animatable) {
            Animatable animatable2 = (Animatable) z;
            this.f9115h = animatable2;
            animatable2.start();
            return;
        }
        this.f9115h = null;
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        Animatable animatable = this.f9115h;
        if (animatable != null) {
            animatable.start();
        }
    }

    @Override // com.bumptech.glide.request.target.BaseTarget, com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        Animatable animatable = this.f9115h;
        if (animatable != null) {
            animatable.stop();
        }
    }

    @Override // com.bumptech.glide.request.transition.Transition.ViewAdapter
    public void setDrawable(Drawable drawable) {
        ((ImageView) this.view).setImageDrawable(drawable);
    }

    public abstract void setResource(@Nullable Z z);

    @Deprecated
    public ImageViewTarget(ImageView imageView, boolean z) {
        super(imageView, z);
    }
}
