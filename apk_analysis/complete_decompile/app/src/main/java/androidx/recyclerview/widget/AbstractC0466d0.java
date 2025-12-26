package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.d0 */
/* loaded from: classes.dex */
public abstract class AbstractC0466d0 implements Animator.AnimatorListener {

    /* renamed from: a */
    public final float f7337a;

    /* renamed from: b */
    public final float f7338b;

    /* renamed from: c */
    public final float f7339c;

    /* renamed from: d */
    public final float f7340d;

    /* renamed from: e */
    public final RecyclerView.ViewHolder f7341e;

    /* renamed from: f */
    public final int f7342f;

    /* renamed from: g */
    public final ValueAnimator f7343g;

    /* renamed from: h */
    public boolean f7344h;

    /* renamed from: i */
    public float f7345i;

    /* renamed from: j */
    public float f7346j;

    /* renamed from: k */
    public boolean f7347k = false;

    /* renamed from: l */
    public boolean f7348l = false;

    /* renamed from: m */
    public float f7349m;

    public AbstractC0466d0(RecyclerView.ViewHolder viewHolder, int i, float f, float f2, float f3, float f4) {
        this.f7342f = i;
        this.f7341e = viewHolder;
        this.f7337a = f;
        this.f7338b = f2;
        this.f7339c = f3;
        this.f7340d = f4;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(RecyclerView.f7068F0, 1.0f);
        this.f7343g = ofFloat;
        ofFloat.addUpdateListener(new C0463c0(this));
        ofFloat.setTarget(viewHolder.itemView);
        ofFloat.addListener(this);
        this.f7349m = RecyclerView.f7068F0;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationCancel(Animator animator) {
        this.f7349m = 1.0f;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        if (!this.f7348l) {
            this.f7341e.setIsRecyclable(true);
        }
        this.f7348l = true;
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator animator) {
    }
}
