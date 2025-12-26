package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionHelper;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.ArrayList;
import p000.RunnableC0006a5;

/* loaded from: classes.dex */
public class Carousel extends MotionHelper {
    public static final int TOUCH_UP_CARRY_ON = 2;
    public static final int TOUCH_UP_IMMEDIATE_STOP = 1;

    /* renamed from: e */
    public Adapter f2614e;

    /* renamed from: f */
    public final ArrayList f2615f;

    /* renamed from: g */
    public int f2616g;

    /* renamed from: h */
    public int f2617h;

    /* renamed from: i */
    public MotionLayout f2618i;

    /* renamed from: j */
    public int f2619j;

    /* renamed from: k */
    public boolean f2620k;

    /* renamed from: l */
    public int f2621l;

    /* renamed from: m */
    public int f2622m;

    /* renamed from: n */
    public int f2623n;

    /* renamed from: o */
    public int f2624o;

    /* renamed from: p */
    public float f2625p;

    /* renamed from: q */
    public int f2626q;

    /* renamed from: r */
    public int f2627r;

    /* renamed from: s */
    public int f2628s;

    /* renamed from: t */
    public float f2629t;

    /* renamed from: u */
    public int f2630u;

    /* renamed from: v */
    public int f2631v;

    /* renamed from: w */
    public final RunnableC0125a f2632w;

    /* loaded from: classes.dex */
    public interface Adapter {
        int count();

        void onNewItem(int i);

        void populate(View view, int i);
    }

    public Carousel(Context context) {
        super(context);
        this.f2614e = null;
        this.f2615f = new ArrayList();
        this.f2616g = 0;
        this.f2617h = 0;
        this.f2619j = -1;
        this.f2620k = false;
        this.f2621l = -1;
        this.f2622m = -1;
        this.f2623n = -1;
        this.f2624o = -1;
        this.f2625p = 0.9f;
        this.f2626q = 0;
        this.f2627r = 4;
        this.f2628s = 1;
        this.f2629t = 2.0f;
        this.f2630u = -1;
        this.f2631v = 200;
        this.f2632w = new RunnableC0125a(this);
    }

    /* renamed from: f */
    public final void m531f(int i, boolean z) {
        MotionLayout motionLayout;
        MotionScene.Transition transition;
        if (i == -1 || (motionLayout = this.f2618i) == null || (transition = motionLayout.getTransition(i)) == null || z == transition.isEnabled()) {
            return;
        }
        transition.setEnabled(z);
    }

    /* renamed from: g */
    public final void m532g(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.Carousel);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.Carousel_carousel_firstView) {
                    this.f2619j = obtainStyledAttributes.getResourceId(index, this.f2619j);
                } else if (index == R.styleable.Carousel_carousel_backwardTransition) {
                    this.f2621l = obtainStyledAttributes.getResourceId(index, this.f2621l);
                } else if (index == R.styleable.Carousel_carousel_forwardTransition) {
                    this.f2622m = obtainStyledAttributes.getResourceId(index, this.f2622m);
                } else if (index == R.styleable.Carousel_carousel_emptyViewsBehavior) {
                    this.f2627r = obtainStyledAttributes.getInt(index, this.f2627r);
                } else if (index == R.styleable.Carousel_carousel_previousState) {
                    this.f2623n = obtainStyledAttributes.getResourceId(index, this.f2623n);
                } else if (index == R.styleable.Carousel_carousel_nextState) {
                    this.f2624o = obtainStyledAttributes.getResourceId(index, this.f2624o);
                } else if (index == R.styleable.Carousel_carousel_touchUp_dampeningFactor) {
                    this.f2625p = obtainStyledAttributes.getFloat(index, this.f2625p);
                } else if (index == R.styleable.Carousel_carousel_touchUpMode) {
                    this.f2628s = obtainStyledAttributes.getInt(index, this.f2628s);
                } else if (index == R.styleable.Carousel_carousel_touchUp_velocityThreshold) {
                    this.f2629t = obtainStyledAttributes.getFloat(index, this.f2629t);
                } else if (index == R.styleable.Carousel_carousel_infinite) {
                    this.f2620k = obtainStyledAttributes.getBoolean(index, this.f2620k);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public int getCount() {
        Adapter adapter = this.f2614e;
        if (adapter != null) {
            return adapter.count();
        }
        return 0;
    }

    public int getCurrentIndex() {
        return this.f2617h;
    }

    /* renamed from: h */
    public final void m533h() {
        Adapter adapter = this.f2614e;
        if (adapter == null || this.f2618i == null || adapter.count() == 0) {
            return;
        }
        ArrayList arrayList = this.f2615f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            int i2 = (this.f2617h + i) - this.f2626q;
            if (this.f2620k) {
                if (i2 < 0) {
                    int i3 = this.f2627r;
                    if (i3 != 4) {
                        m534i(i3, view);
                    } else {
                        m534i(0, view);
                    }
                    if (i2 % this.f2614e.count() == 0) {
                        this.f2614e.populate(view, 0);
                    } else {
                        Adapter adapter2 = this.f2614e;
                        adapter2.populate(view, (i2 % this.f2614e.count()) + adapter2.count());
                    }
                } else if (i2 >= this.f2614e.count()) {
                    if (i2 == this.f2614e.count()) {
                        i2 = 0;
                    } else if (i2 > this.f2614e.count()) {
                        i2 %= this.f2614e.count();
                    }
                    int i4 = this.f2627r;
                    if (i4 != 4) {
                        m534i(i4, view);
                    } else {
                        m534i(0, view);
                    }
                    this.f2614e.populate(view, i2);
                } else {
                    m534i(0, view);
                    this.f2614e.populate(view, i2);
                }
            } else if (i2 < 0) {
                m534i(this.f2627r, view);
            } else if (i2 >= this.f2614e.count()) {
                m534i(this.f2627r, view);
            } else {
                m534i(0, view);
                this.f2614e.populate(view, i2);
            }
        }
        int i5 = this.f2630u;
        if (i5 != -1 && i5 != this.f2617h) {
            this.f2618i.post(new RunnableC0006a5(3, this));
        } else if (i5 == this.f2617h) {
            this.f2630u = -1;
        }
        if (this.f2621l != -1 && this.f2622m != -1) {
            if (this.f2620k) {
                return;
            }
            int count = this.f2614e.count();
            if (this.f2617h == 0) {
                m531f(this.f2621l, false);
            } else {
                m531f(this.f2621l, true);
                this.f2618i.setTransition(this.f2621l);
            }
            if (this.f2617h == count - 1) {
                m531f(this.f2622m, false);
                return;
            } else {
                m531f(this.f2622m, true);
                this.f2618i.setTransition(this.f2622m);
                return;
            }
        }
        Log.w("Carousel", "No backward or forward transitions defined for Carousel!");
    }

    /* renamed from: i */
    public final void m534i(int i, View view) {
        ConstraintSet.Constraint constraint;
        MotionLayout motionLayout = this.f2618i;
        if (motionLayout == null) {
            return;
        }
        for (int i2 : motionLayout.getConstraintSetIds()) {
            ConstraintSet constraintSet = this.f2618i.getConstraintSet(i2);
            if (constraintSet != null && (constraint = constraintSet.getConstraint(view.getId())) != null) {
                constraint.propertySet.mVisibilityMode = 1;
                view.setVisibility(i);
            }
        }
    }

    public boolean isInfinite() {
        return this.f2620k;
    }

    public void jumpToIndex(int i) {
        this.f2617h = Math.max(0, Math.min(getCount() - 1, i));
        refresh();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (getParent() instanceof MotionLayout) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            ArrayList arrayList = this.f2615f;
            arrayList.clear();
            for (int i = 0; i < this.mCount; i++) {
                int i2 = this.mIds[i];
                View viewById = motionLayout.getViewById(i2);
                if (this.f2619j == i2) {
                    this.f2626q = i;
                }
                arrayList.add(viewById);
            }
            this.f2618i = motionLayout;
            if (this.f2628s == 2) {
                MotionScene.Transition transition = motionLayout.getTransition(this.f2622m);
                if (transition != null) {
                    transition.setOnTouchUp(5);
                }
                MotionScene.Transition transition2 = this.f2618i.getTransition(this.f2621l);
                if (transition2 != null) {
                    transition2.setOnTouchUp(5);
                }
            }
            m533h();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f2615f.clear();
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelper, androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
        int i2 = this.f2617h;
        this.f2616g = i2;
        if (i == this.f2624o) {
            this.f2617h = i2 + 1;
        } else if (i == this.f2623n) {
            this.f2617h = i2 - 1;
        }
        if (this.f2620k) {
            if (this.f2617h >= this.f2614e.count()) {
                this.f2617h = 0;
            }
            if (this.f2617h < 0) {
                this.f2617h = this.f2614e.count() - 1;
            }
        } else {
            if (this.f2617h >= this.f2614e.count()) {
                this.f2617h = this.f2614e.count() - 1;
            }
            if (this.f2617h < 0) {
                this.f2617h = 0;
            }
        }
        if (this.f2616g != this.f2617h) {
            this.f2618i.post(this.f2632w);
        }
    }

    public void refresh() {
        ArrayList arrayList = this.f2615f;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = (View) arrayList.get(i);
            if (this.f2614e.count() == 0) {
                m534i(this.f2627r, view);
            } else {
                m534i(0, view);
            }
        }
        this.f2618i.rebuildScene();
        m533h();
    }

    public void setAdapter(Adapter adapter) {
        this.f2614e = adapter;
    }

    public void setInfinite(boolean z) {
        this.f2620k = z;
    }

    public void transitionToIndex(int i, int i2) {
        this.f2630u = Math.max(0, Math.min(getCount() - 1, i));
        int max = Math.max(0, i2);
        this.f2631v = max;
        this.f2618i.setTransitionDuration(max);
        if (i < this.f2617h) {
            this.f2618i.transitionToState(this.f2623n, this.f2631v);
        } else {
            this.f2618i.transitionToState(this.f2624o, this.f2631v);
        }
    }

    public Carousel(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2614e = null;
        this.f2615f = new ArrayList();
        this.f2616g = 0;
        this.f2617h = 0;
        this.f2619j = -1;
        this.f2620k = false;
        this.f2621l = -1;
        this.f2622m = -1;
        this.f2623n = -1;
        this.f2624o = -1;
        this.f2625p = 0.9f;
        this.f2626q = 0;
        this.f2627r = 4;
        this.f2628s = 1;
        this.f2629t = 2.0f;
        this.f2630u = -1;
        this.f2631v = 200;
        this.f2632w = new RunnableC0125a(this);
        m532g(context, attributeSet);
    }

    public Carousel(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2614e = null;
        this.f2615f = new ArrayList();
        this.f2616g = 0;
        this.f2617h = 0;
        this.f2619j = -1;
        this.f2620k = false;
        this.f2621l = -1;
        this.f2622m = -1;
        this.f2623n = -1;
        this.f2624o = -1;
        this.f2625p = 0.9f;
        this.f2626q = 0;
        this.f2627r = 4;
        this.f2628s = 1;
        this.f2629t = 2.0f;
        this.f2630u = -1;
        this.f2631v = 200;
        this.f2632w = new RunnableC0125a(this);
        m532g(context, attributeSet);
    }
}
