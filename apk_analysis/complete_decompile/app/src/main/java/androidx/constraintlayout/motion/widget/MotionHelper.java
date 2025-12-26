package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R;
import java.util.HashMap;

/* loaded from: classes.dex */
public class MotionHelper extends ConstraintHelper implements MotionHelperInterface {

    /* renamed from: b */
    public boolean f2822b;

    /* renamed from: c */
    public boolean f2823c;

    /* renamed from: d */
    public float f2824d;
    protected View[] views;

    public MotionHelper(Context context) {
        super(context);
        this.f2822b = false;
        this.f2823c = false;
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public float getProgress() {
        return this.f2824d;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.MotionHelper);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.MotionHelper_onShow) {
                    this.f2822b = obtainStyledAttributes.getBoolean(index, this.f2822b);
                } else if (index == R.styleable.MotionHelper_onHide) {
                    this.f2823c = obtainStyledAttributes.getBoolean(index, this.f2823c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public boolean isDecorator() {
        return false;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isUseOnHide() {
        return this.f2823c;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public boolean isUsedOnShow() {
        return this.f2822b;
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onFinishedMotionScene(MotionLayout motionLayout) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPostDraw(Canvas canvas) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionHelperInterface
    public void onPreDraw(Canvas canvas) {
    }

    public void onPreSetup(MotionLayout motionLayout, HashMap<View, MotionController> hashMap) {
    }

    public void onTransitionChange(MotionLayout motionLayout, int i, int i2, float f) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionStarted(MotionLayout motionLayout, int i, int i2) {
    }

    @Override // androidx.constraintlayout.motion.widget.MotionLayout.TransitionListener
    public void onTransitionTrigger(MotionLayout motionLayout, int i, boolean z, float f) {
    }

    public void setProgress(View view, float f) {
    }

    @Override // androidx.constraintlayout.motion.widget.Animatable
    public void setProgress(float f) {
        this.f2824d = f;
        int i = 0;
        if (this.mCount > 0) {
            this.views = getViews((ConstraintLayout) getParent());
            while (i < this.mCount) {
                setProgress(this.views[i], f);
                i++;
            }
            return;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        while (i < childCount) {
            View childAt = viewGroup.getChildAt(i);
            if (!(childAt instanceof MotionHelper)) {
                setProgress(childAt, f);
            }
            i++;
        }
    }

    public MotionHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f2822b = false;
        this.f2823c = false;
        init(attributeSet);
    }

    public MotionHelper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2822b = false;
        this.f2823c = false;
        init(attributeSet);
    }
}
