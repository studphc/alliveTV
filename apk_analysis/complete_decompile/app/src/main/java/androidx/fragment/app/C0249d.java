package androidx.fragment.app;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.content.Context;
import android.content.res.Resources;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.R;
import androidx.fragment.app.DefaultSpecialEffectsController;
import androidx.fragment.app.SpecialEffectsController;
import kotlin.jvm.internal.Intrinsics;
import p000.C1540m9;
import p000.jt0;
import p000.ot0;

/* renamed from: androidx.fragment.app.d */
/* loaded from: classes.dex */
public final class C0249d extends DefaultSpecialEffectsController.SpecialEffectsInfo {

    /* renamed from: b */
    public final boolean f4651b;

    /* renamed from: c */
    public boolean f4652c;

    /* renamed from: d */
    public C1540m9 f4653d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0249d(SpecialEffectsController.Operation operation, boolean z) {
        super(operation);
        Intrinsics.checkNotNullParameter(operation, "operation");
        this.f4651b = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x007d  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final C1540m9 m1223a(Context context) {
        boolean z;
        int i;
        int i2;
        ViewGroup viewGroup;
        ViewGroup viewGroup2;
        Animation onCreateAnimation;
        Animation loadAnimation;
        C1540m9 c1540m9;
        C1540m9 c1540m92;
        int i3;
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f4652c) {
            return this.f4653d;
        }
        Fragment fragment = getOperation().getFragment();
        if (getOperation().getFinalState() == SpecialEffectsController.Operation.State.VISIBLE) {
            z = true;
        } else {
            z = false;
        }
        jt0 jt0Var = fragment.f4431N;
        if (jt0Var == null) {
            i = 0;
        } else {
            i = jt0Var.f20608f;
        }
        if (this.f4651b) {
            if (z) {
                if (jt0Var != null) {
                    i2 = jt0Var.f20606d;
                    fragment.m1144k(0, 0, 0, 0);
                    viewGroup = fragment.f4427J;
                    if (viewGroup != null) {
                        int i4 = R.id.visible_removing_fragment_view_tag;
                        if (viewGroup.getTag(i4) != null) {
                            fragment.f4427J.setTag(i4, null);
                        }
                    }
                    viewGroup2 = fragment.f4427J;
                    if (viewGroup2 != null || viewGroup2.getLayoutTransition() == null) {
                        onCreateAnimation = fragment.onCreateAnimation(i, z, i2);
                        if (onCreateAnimation == null) {
                            c1540m92 = new C1540m9(onCreateAnimation);
                        } else {
                            Animator onCreateAnimator = fragment.onCreateAnimator(i, z, i2);
                            if (onCreateAnimator != null) {
                                c1540m92 = new C1540m9(onCreateAnimator);
                            } else {
                                if (i2 == 0 && i != 0) {
                                    if (i != 4097) {
                                        if (i != 8194) {
                                            if (i != 8197) {
                                                if (i != 4099) {
                                                    if (i != 4100) {
                                                        i3 = -1;
                                                    } else if (z) {
                                                        i3 = ot0.m6727a(android.R.attr.activityOpenEnterAnimation, context);
                                                    } else {
                                                        i3 = ot0.m6727a(android.R.attr.activityOpenExitAnimation, context);
                                                    }
                                                } else if (z) {
                                                    i3 = R.animator.fragment_fade_enter;
                                                } else {
                                                    i3 = R.animator.fragment_fade_exit;
                                                }
                                            } else if (z) {
                                                i3 = ot0.m6727a(android.R.attr.activityCloseEnterAnimation, context);
                                            } else {
                                                i3 = ot0.m6727a(android.R.attr.activityCloseExitAnimation, context);
                                            }
                                        } else if (z) {
                                            i3 = R.animator.fragment_close_enter;
                                        } else {
                                            i3 = R.animator.fragment_close_exit;
                                        }
                                    } else if (z) {
                                        i3 = R.animator.fragment_open_enter;
                                    } else {
                                        i3 = R.animator.fragment_open_exit;
                                    }
                                    i2 = i3;
                                }
                                if (i2 != 0) {
                                    boolean equals = "anim".equals(context.getResources().getResourceTypeName(i2));
                                    try {
                                        if (equals) {
                                            try {
                                                loadAnimation = AnimationUtils.loadAnimation(context, i2);
                                            } catch (Resources.NotFoundException e) {
                                                throw e;
                                            } catch (RuntimeException unused) {
                                            }
                                            if (loadAnimation != null) {
                                                c1540m9 = new C1540m9(loadAnimation);
                                                c1540m92 = c1540m9;
                                            }
                                        }
                                        Animator loadAnimator = AnimatorInflater.loadAnimator(context, i2);
                                        if (loadAnimator != null) {
                                            c1540m9 = new C1540m9(loadAnimator);
                                            c1540m92 = c1540m9;
                                        }
                                    } catch (RuntimeException e2) {
                                        if (!equals) {
                                            Animation loadAnimation2 = AnimationUtils.loadAnimation(context, i2);
                                            if (loadAnimation2 != null) {
                                                c1540m92 = new C1540m9(loadAnimation2);
                                            }
                                        } else {
                                            throw e2;
                                        }
                                    }
                                }
                            }
                        }
                        this.f4653d = c1540m92;
                        this.f4652c = true;
                        return c1540m92;
                    }
                    c1540m92 = null;
                    this.f4653d = c1540m92;
                    this.f4652c = true;
                    return c1540m92;
                }
                i2 = 0;
                fragment.m1144k(0, 0, 0, 0);
                viewGroup = fragment.f4427J;
                if (viewGroup != null) {
                }
                viewGroup2 = fragment.f4427J;
                if (viewGroup2 != null) {
                }
                onCreateAnimation = fragment.onCreateAnimation(i, z, i2);
                if (onCreateAnimation == null) {
                }
                this.f4653d = c1540m92;
                this.f4652c = true;
                return c1540m92;
            }
            if (jt0Var != null) {
                i2 = jt0Var.f20607e;
                fragment.m1144k(0, 0, 0, 0);
                viewGroup = fragment.f4427J;
                if (viewGroup != null) {
                }
                viewGroup2 = fragment.f4427J;
                if (viewGroup2 != null) {
                }
                onCreateAnimation = fragment.onCreateAnimation(i, z, i2);
                if (onCreateAnimation == null) {
                }
                this.f4653d = c1540m92;
                this.f4652c = true;
                return c1540m92;
            }
            i2 = 0;
            fragment.m1144k(0, 0, 0, 0);
            viewGroup = fragment.f4427J;
            if (viewGroup != null) {
            }
            viewGroup2 = fragment.f4427J;
            if (viewGroup2 != null) {
            }
            onCreateAnimation = fragment.onCreateAnimation(i, z, i2);
            if (onCreateAnimation == null) {
            }
            this.f4653d = c1540m92;
            this.f4652c = true;
            return c1540m92;
        }
        if (z) {
            if (jt0Var != null) {
                i2 = jt0Var.f20604b;
                fragment.m1144k(0, 0, 0, 0);
                viewGroup = fragment.f4427J;
                if (viewGroup != null) {
                }
                viewGroup2 = fragment.f4427J;
                if (viewGroup2 != null) {
                }
                onCreateAnimation = fragment.onCreateAnimation(i, z, i2);
                if (onCreateAnimation == null) {
                }
                this.f4653d = c1540m92;
                this.f4652c = true;
                return c1540m92;
            }
            i2 = 0;
            fragment.m1144k(0, 0, 0, 0);
            viewGroup = fragment.f4427J;
            if (viewGroup != null) {
            }
            viewGroup2 = fragment.f4427J;
            if (viewGroup2 != null) {
            }
            onCreateAnimation = fragment.onCreateAnimation(i, z, i2);
            if (onCreateAnimation == null) {
            }
            this.f4653d = c1540m92;
            this.f4652c = true;
            return c1540m92;
        }
        if (jt0Var != null) {
            i2 = jt0Var.f20605c;
            fragment.m1144k(0, 0, 0, 0);
            viewGroup = fragment.f4427J;
            if (viewGroup != null) {
            }
            viewGroup2 = fragment.f4427J;
            if (viewGroup2 != null) {
            }
            onCreateAnimation = fragment.onCreateAnimation(i, z, i2);
            if (onCreateAnimation == null) {
            }
            this.f4653d = c1540m92;
            this.f4652c = true;
            return c1540m92;
        }
        i2 = 0;
        fragment.m1144k(0, 0, 0, 0);
        viewGroup = fragment.f4427J;
        if (viewGroup != null) {
        }
        viewGroup2 = fragment.f4427J;
        if (viewGroup2 != null) {
        }
        onCreateAnimation = fragment.onCreateAnimation(i, z, i2);
        if (onCreateAnimation == null) {
        }
        this.f4653d = c1540m92;
        this.f4652c = true;
        return c1540m92;
    }
}
