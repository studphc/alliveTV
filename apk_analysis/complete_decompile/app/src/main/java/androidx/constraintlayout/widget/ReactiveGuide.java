package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.SharedValues;

/* loaded from: classes.dex */
public class ReactiveGuide extends View implements SharedValues.SharedValuesListener {

    /* renamed from: a */
    public int f3204a;

    /* renamed from: b */
    public boolean f3205b;

    /* renamed from: c */
    public int f3206c;

    /* renamed from: d */
    public boolean f3207d;

    public ReactiveGuide(Context context) {
        super(context);
        this.f3204a = -1;
        this.f3205b = false;
        this.f3206c = 0;
        this.f3207d = true;
        super.setVisibility(8);
        m661a(null);
    }

    /* renamed from: a */
    public final void m661a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_ReactiveGuide);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_valueId) {
                    this.f3204a = obtainStyledAttributes.getResourceId(index, this.f3204a);
                } else if (index == R.styleable.ConstraintLayout_ReactiveGuide_reactiveGuide_animateChange) {
                    this.f3205b = obtainStyledAttributes.getBoolean(index, this.f3205b);
                } else if (index == R.styleable.f3203x2694048c) {
                    this.f3206c = obtainStyledAttributes.getResourceId(index, this.f3206c);
                } else if (index == R.styleable.f3202xfdeff96) {
                    this.f3207d = obtainStyledAttributes.getBoolean(index, this.f3207d);
                }
            }
            obtainStyledAttributes.recycle();
        }
        if (this.f3204a != -1) {
            ConstraintLayout.getSharedValues().addListener(this.f3204a, this);
        }
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    public void draw(@NonNull Canvas canvas) {
    }

    public int getApplyToConstraintSetId() {
        return this.f3206c;
    }

    public int getAttributeId() {
        return this.f3204a;
    }

    public boolean isAnimatingChange() {
        return this.f3205b;
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    @Override // androidx.constraintlayout.widget.SharedValues.SharedValuesListener
    public void onNewValue(int i, int i2, int i3) {
        setGuidelineBegin(i2);
        int id = getId();
        if (id > 0 && (getParent() instanceof MotionLayout)) {
            MotionLayout motionLayout = (MotionLayout) getParent();
            int currentState = motionLayout.getCurrentState();
            int i4 = this.f3206c;
            if (i4 != 0) {
                currentState = i4;
            }
            int i5 = 0;
            if (this.f3205b) {
                if (this.f3207d) {
                    int[] constraintSetIds = motionLayout.getConstraintSetIds();
                    while (i5 < constraintSetIds.length) {
                        int i6 = constraintSetIds[i5];
                        if (i6 != currentState) {
                            ConstraintSet constraintSet = motionLayout.getConstraintSet(i6);
                            constraintSet.setGuidelineEnd(id, i2);
                            motionLayout.updateState(i6, constraintSet);
                        }
                        i5++;
                    }
                }
                ConstraintSet cloneConstraintSet = motionLayout.cloneConstraintSet(currentState);
                cloneConstraintSet.setGuidelineEnd(id, i2);
                motionLayout.updateStateAnimate(currentState, cloneConstraintSet, 1000);
                return;
            }
            if (this.f3207d) {
                int[] constraintSetIds2 = motionLayout.getConstraintSetIds();
                while (i5 < constraintSetIds2.length) {
                    int i7 = constraintSetIds2[i5];
                    ConstraintSet constraintSet2 = motionLayout.getConstraintSet(i7);
                    constraintSet2.setGuidelineEnd(id, i2);
                    motionLayout.updateState(i7, constraintSet2);
                    i5++;
                }
                return;
            }
            ConstraintSet constraintSet3 = motionLayout.getConstraintSet(currentState);
            constraintSet3.setGuidelineEnd(id, i2);
            motionLayout.updateState(currentState, constraintSet3);
        }
    }

    public void setAnimateChange(boolean z) {
        this.f3205b = z;
    }

    public void setApplyToConstraintSetId(int i) {
        this.f3206c = i;
    }

    public void setAttributeId(int i) {
        SharedValues sharedValues = ConstraintLayout.getSharedValues();
        int i2 = this.f3204a;
        if (i2 != -1) {
            sharedValues.removeListener(i2, this);
        }
        this.f3204a = i;
        if (i != -1) {
            sharedValues.addListener(i, this);
        }
    }

    public void setGuidelineBegin(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideBegin = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelineEnd(int i) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guideEnd = i;
        setLayoutParams(layoutParams);
    }

    public void setGuidelinePercent(float f) {
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        layoutParams.guidePercent = f;
        setLayoutParams(layoutParams);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3204a = -1;
        this.f3205b = false;
        this.f3206c = 0;
        this.f3207d = true;
        super.setVisibility(8);
        m661a(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3204a = -1;
        this.f3205b = false;
        this.f3206c = 0;
        this.f3207d = true;
        super.setVisibility(8);
        m661a(attributeSet);
    }

    public ReactiveGuide(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f3204a = -1;
        this.f3205b = false;
        this.f3206c = 0;
        this.f3207d = true;
        super.setVisibility(8);
        m661a(attributeSet);
    }
}
