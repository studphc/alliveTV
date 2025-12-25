package androidx.leanback.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: classes.dex */
public class ScaleFrameLayout extends FrameLayout {

    /* renamed from: a */
    public float f6122a;

    /* renamed from: b */
    public float f6123b;

    /* renamed from: c */
    public float f6124c;

    public ScaleFrameLayout(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        view.setScaleX(this.f6124c);
        view.setScaleY(this.f6124c);
    }

    @Override // android.view.ViewGroup
    public boolean addViewInLayout(View view, int i, ViewGroup.LayoutParams layoutParams, boolean z) {
        boolean addViewInLayout = super.addViewInLayout(view, i, layoutParams, z);
        if (addViewInLayout) {
            view.setScaleX(this.f6124c);
            view.setScaleY(this.f6124c);
        }
        return addViewInLayout;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00de  */
    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float pivotX;
        int paddingLeft;
        int i5;
        int paddingRight;
        int paddingTop;
        int i6;
        int paddingBottom;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        ScaleFrameLayout scaleFrameLayout = this;
        int childCount = getChildCount();
        int layoutDirection = getLayoutDirection();
        if (layoutDirection == 1) {
            pivotX = getWidth() - getPivotX();
        } else {
            pivotX = getPivotX();
        }
        if (scaleFrameLayout.f6122a != 1.0f) {
            int paddingLeft2 = getPaddingLeft();
            float f = scaleFrameLayout.f6122a;
            paddingLeft = paddingLeft2 + ((int) ((pivotX - (pivotX / f)) + 0.5f));
            i5 = (int) ((((i3 - i) - pivotX) / f) + pivotX + 0.5f);
            paddingRight = getPaddingRight();
        } else {
            paddingLeft = getPaddingLeft();
            i5 = i3 - i;
            paddingRight = getPaddingRight();
        }
        int i14 = i5 - paddingRight;
        float pivotY = getPivotY();
        if (scaleFrameLayout.f6123b != 1.0f) {
            int paddingTop2 = getPaddingTop();
            float f2 = scaleFrameLayout.f6123b;
            paddingTop = paddingTop2 + ((int) ((pivotY - (pivotY / f2)) + 0.5f));
            i6 = (int) ((((i4 - i2) - pivotY) / f2) + pivotY + 0.5f);
            paddingBottom = getPaddingBottom();
        } else {
            paddingTop = getPaddingTop();
            i6 = i4 - i2;
            paddingBottom = getPaddingBottom();
        }
        int i15 = i6 - paddingBottom;
        int i16 = 0;
        while (i16 < childCount) {
            View childAt = scaleFrameLayout.getChildAt(i16);
            if (childAt.getVisibility() != 8) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i17 = layoutParams.gravity;
                if (i17 == -1) {
                    i17 = 8388659;
                }
                int absoluteGravity = Gravity.getAbsoluteGravity(i17, layoutDirection);
                int i18 = i17 & 112;
                int i19 = absoluteGravity & 7;
                if (i19 != 1) {
                    if (i19 != 5) {
                        i9 = layoutParams.leftMargin + paddingLeft;
                        if (i18 == 16) {
                            if (i18 != 48) {
                                if (i18 != 80) {
                                    i13 = layoutParams.topMargin;
                                } else {
                                    i10 = i15 - measuredHeight;
                                    i11 = layoutParams.bottomMargin;
                                }
                            } else {
                                i13 = layoutParams.topMargin;
                            }
                            i12 = i13 + paddingTop;
                            childAt.layout(i9, i12, measuredWidth + i9, measuredHeight + i12);
                            childAt.setPivotX(pivotX - i9);
                            childAt.setPivotY(pivotY - i12);
                        } else {
                            i10 = (((i15 - paddingTop) - measuredHeight) / 2) + paddingTop + layoutParams.topMargin;
                            i11 = layoutParams.bottomMargin;
                        }
                        i12 = i10 - i11;
                        childAt.layout(i9, i12, measuredWidth + i9, measuredHeight + i12);
                        childAt.setPivotX(pivotX - i9);
                        childAt.setPivotY(pivotY - i12);
                    } else {
                        i7 = i14 - measuredWidth;
                        i8 = layoutParams.rightMargin;
                    }
                } else {
                    i7 = (((i14 - paddingLeft) - measuredWidth) / 2) + paddingLeft + layoutParams.leftMargin;
                    i8 = layoutParams.rightMargin;
                }
                i9 = i7 - i8;
                if (i18 == 16) {
                }
                i12 = i10 - i11;
                childAt.layout(i9, i12, measuredWidth + i9, measuredHeight + i12);
                childAt.setPivotX(pivotX - i9);
                childAt.setPivotY(pivotY - i12);
            }
            i16++;
            scaleFrameLayout = this;
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        float f = this.f6122a;
        if (f == 1.0f && this.f6123b == 1.0f) {
            super.onMeasure(i, i2);
            return;
        }
        if (f != 1.0f) {
            i = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i) / f) + 0.5f), View.MeasureSpec.getMode(i));
        }
        float f2 = this.f6123b;
        if (f2 != 1.0f) {
            i2 = View.MeasureSpec.makeMeasureSpec((int) ((View.MeasureSpec.getSize(i2) / f2) + 0.5f), View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
        setMeasuredDimension((int) ((getMeasuredWidth() * this.f6122a) + 0.5f), (int) ((getMeasuredHeight() * this.f6123b) + 0.5f));
    }

    public void setChildScale(float f) {
        if (this.f6124c != f) {
            this.f6124c = f;
            for (int i = 0; i < getChildCount(); i++) {
                getChildAt(i).setScaleX(f);
                getChildAt(i).setScaleY(f);
            }
        }
    }

    @Override // android.view.View
    public void setForeground(Drawable drawable) {
        throw new UnsupportedOperationException();
    }

    public void setLayoutScaleX(float f) {
        if (f != this.f6122a) {
            this.f6122a = f;
            requestLayout();
        }
    }

    public void setLayoutScaleY(float f) {
        if (f != this.f6123b) {
            this.f6123b = f;
            requestLayout();
        }
    }

    public ScaleFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScaleFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f6122a = 1.0f;
        this.f6123b = 1.0f;
        this.f6124c = 1.0f;
    }
}
