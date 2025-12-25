package p000;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.Transformation;
import androidx.core.view.OneShotPreDrawListener;

/* loaded from: classes.dex */
public final class nt0 extends AnimationSet implements Runnable {

    /* renamed from: a */
    public final ViewGroup f23485a;

    /* renamed from: b */
    public final View f23486b;

    /* renamed from: c */
    public boolean f23487c;

    /* renamed from: d */
    public boolean f23488d;

    /* renamed from: e */
    public boolean f23489e;

    public nt0(Animation animation, ViewGroup viewGroup, View view) {
        super(false);
        this.f23489e = true;
        this.f23485a = viewGroup;
        this.f23486b = view;
        addAnimation(animation);
        viewGroup.post(this);
    }

    @Override // android.view.animation.AnimationSet, android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation) {
        this.f23489e = true;
        if (this.f23487c) {
            return !this.f23488d;
        }
        if (!super.getTransformation(j, transformation)) {
            this.f23487c = true;
            OneShotPreDrawListener.add(this.f23485a, this);
        }
        return true;
    }

    @Override // java.lang.Runnable
    public final void run() {
        boolean z = this.f23487c;
        ViewGroup viewGroup = this.f23485a;
        if (!z && this.f23489e) {
            this.f23489e = false;
            viewGroup.post(this);
        } else {
            viewGroup.endViewTransition(this.f23486b);
            this.f23488d = true;
        }
    }

    @Override // android.view.animation.Animation
    public final boolean getTransformation(long j, Transformation transformation, float f) {
        this.f23489e = true;
        if (this.f23487c) {
            return !this.f23488d;
        }
        if (!super.getTransformation(j, transformation, f)) {
            this.f23487c = true;
            OneShotPreDrawListener.add(this.f23485a, this);
        }
        return true;
    }
}
