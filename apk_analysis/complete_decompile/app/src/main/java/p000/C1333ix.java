package p000;

import android.animation.Animator;
import android.transition.ChangeBounds;
import android.transition.TransitionValues;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import java.util.HashMap;

/* renamed from: ix */
/* loaded from: classes.dex */
public final class C1333ix extends ChangeBounds {

    /* renamed from: a */
    public int f20297a;

    /* renamed from: b */
    public final HashMap f20298b = new HashMap();

    /* renamed from: c */
    public final SparseIntArray f20299c = new SparseIntArray();

    /* renamed from: d */
    public final HashMap f20300d = new HashMap();

    @Override // android.transition.ChangeBounds, android.transition.Transition
    public final Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        View view;
        int i;
        Animator createAnimator = super.createAnimator(viewGroup, transitionValues, transitionValues2);
        if (createAnimator != null && transitionValues2 != null && (view = transitionValues2.view) != null) {
            Integer num = (Integer) this.f20298b.get(view);
            if (num != null) {
                i = num.intValue();
            } else {
                int i2 = this.f20299c.get(view.getId(), -1);
                if (i2 != -1) {
                    i = i2;
                } else {
                    Integer num2 = (Integer) this.f20300d.get(view.getClass().getName());
                    if (num2 != null) {
                        i = num2.intValue();
                    } else {
                        i = this.f20297a;
                    }
                }
            }
            createAnimator.setStartDelay(i);
        }
        return createAnimator;
    }
}
