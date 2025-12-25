package androidx.constraintlayout.helper.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;

/* loaded from: classes.dex */
public class Flow extends VirtualLayout {
    public static final int CHAIN_PACKED = 2;
    public static final int CHAIN_SPREAD = 0;
    public static final int CHAIN_SPREAD_INSIDE = 1;
    public static final int HORIZONTAL = 0;
    public static final int HORIZONTAL_ALIGN_CENTER = 2;
    public static final int HORIZONTAL_ALIGN_END = 1;
    public static final int HORIZONTAL_ALIGN_START = 0;
    public static final int VERTICAL = 1;
    public static final int VERTICAL_ALIGN_BASELINE = 3;
    public static final int VERTICAL_ALIGN_BOTTOM = 1;
    public static final int VERTICAL_ALIGN_CENTER = 2;
    public static final int VERTICAL_ALIGN_TOP = 0;
    public static final int WRAP_ALIGNED = 2;
    public static final int WRAP_CHAIN = 1;
    public static final int WRAP_NONE = 0;

    /* renamed from: d */
    public androidx.constraintlayout.core.widgets.Flow f2645d;

    public Flow(Context context) {
        super(context);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public void init(AttributeSet attributeSet) {
        super.init(attributeSet);
        this.f2645d = new androidx.constraintlayout.core.widgets.Flow();
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_Layout_android_orientation) {
                    this.f2645d.setOrientation(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_padding) {
                    this.f2645d.setPadding(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingStart) {
                    this.f2645d.setPaddingStart(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingEnd) {
                    this.f2645d.setPaddingEnd(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingLeft) {
                    this.f2645d.setPaddingLeft(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingTop) {
                    this.f2645d.setPaddingTop(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingRight) {
                    this.f2645d.setPaddingRight(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_android_paddingBottom) {
                    this.f2645d.setPaddingBottom(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_wrapMode) {
                    this.f2645d.setWrapMode(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalStyle) {
                    this.f2645d.setHorizontalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalStyle) {
                    this.f2645d.setVerticalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalStyle) {
                    this.f2645d.setFirstHorizontalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalStyle) {
                    this.f2645d.setLastHorizontalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalStyle) {
                    this.f2645d.setFirstVerticalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalStyle) {
                    this.f2645d.setLastVerticalStyle(obtainStyledAttributes.getInt(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalBias) {
                    this.f2645d.setHorizontalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstHorizontalBias) {
                    this.f2645d.setFirstHorizontalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastHorizontalBias) {
                    this.f2645d.setLastHorizontalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_firstVerticalBias) {
                    this.f2645d.setFirstVerticalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_lastVerticalBias) {
                    this.f2645d.setLastVerticalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalBias) {
                    this.f2645d.setVerticalBias(obtainStyledAttributes.getFloat(index, 0.5f));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalAlign) {
                    this.f2645d.setHorizontalAlign(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalAlign) {
                    this.f2645d.setVerticalAlign(obtainStyledAttributes.getInt(index, 2));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_horizontalGap) {
                    this.f2645d.setHorizontalGap(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_verticalGap) {
                    this.f2645d.setVerticalGap(obtainStyledAttributes.getDimensionPixelSize(index, 0));
                } else if (index == R.styleable.ConstraintLayout_Layout_flow_maxElementsWrap) {
                    this.f2645d.setMaxElementsWrap(obtainStyledAttributes.getInt(index, -1));
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mHelperWidget = this.f2645d;
        validateParams();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        super.loadParameters(constraint, helperWidget, layoutParams, sparseArray);
        if (helperWidget instanceof androidx.constraintlayout.core.widgets.Flow) {
            androidx.constraintlayout.core.widgets.Flow flow = (androidx.constraintlayout.core.widgets.Flow) helperWidget;
            int i = layoutParams.orientation;
            if (i != -1) {
                flow.setOrientation(i);
            }
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    @SuppressLint({"WrongCall"})
    public void onMeasure(int i, int i2) {
        onMeasure(this.f2645d, i, i2);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public void resolveRtl(ConstraintWidget constraintWidget, boolean z) {
        this.f2645d.applyRtl(z);
    }

    public void setFirstHorizontalBias(float f) {
        this.f2645d.setFirstHorizontalBias(f);
        requestLayout();
    }

    public void setFirstHorizontalStyle(int i) {
        this.f2645d.setFirstHorizontalStyle(i);
        requestLayout();
    }

    public void setFirstVerticalBias(float f) {
        this.f2645d.setFirstVerticalBias(f);
        requestLayout();
    }

    public void setFirstVerticalStyle(int i) {
        this.f2645d.setFirstVerticalStyle(i);
        requestLayout();
    }

    public void setHorizontalAlign(int i) {
        this.f2645d.setHorizontalAlign(i);
        requestLayout();
    }

    public void setHorizontalBias(float f) {
        this.f2645d.setHorizontalBias(f);
        requestLayout();
    }

    public void setHorizontalGap(int i) {
        this.f2645d.setHorizontalGap(i);
        requestLayout();
    }

    public void setHorizontalStyle(int i) {
        this.f2645d.setHorizontalStyle(i);
        requestLayout();
    }

    public void setLastHorizontalBias(float f) {
        this.f2645d.setLastHorizontalBias(f);
        requestLayout();
    }

    public void setLastHorizontalStyle(int i) {
        this.f2645d.setLastHorizontalStyle(i);
        requestLayout();
    }

    public void setLastVerticalBias(float f) {
        this.f2645d.setLastVerticalBias(f);
        requestLayout();
    }

    public void setLastVerticalStyle(int i) {
        this.f2645d.setLastVerticalStyle(i);
        requestLayout();
    }

    public void setMaxElementsWrap(int i) {
        this.f2645d.setMaxElementsWrap(i);
        requestLayout();
    }

    public void setOrientation(int i) {
        this.f2645d.setOrientation(i);
        requestLayout();
    }

    public void setPadding(int i) {
        this.f2645d.setPadding(i);
        requestLayout();
    }

    public void setPaddingBottom(int i) {
        this.f2645d.setPaddingBottom(i);
        requestLayout();
    }

    public void setPaddingLeft(int i) {
        this.f2645d.setPaddingLeft(i);
        requestLayout();
    }

    public void setPaddingRight(int i) {
        this.f2645d.setPaddingRight(i);
        requestLayout();
    }

    public void setPaddingTop(int i) {
        this.f2645d.setPaddingTop(i);
        requestLayout();
    }

    public void setVerticalAlign(int i) {
        this.f2645d.setVerticalAlign(i);
        requestLayout();
    }

    public void setVerticalBias(float f) {
        this.f2645d.setVerticalBias(f);
        requestLayout();
    }

    public void setVerticalGap(int i) {
        this.f2645d.setVerticalGap(i);
        requestLayout();
    }

    public void setVerticalStyle(int i) {
        this.f2645d.setVerticalStyle(i);
        requestLayout();
    }

    public void setWrapMode(int i) {
        this.f2645d.setWrapMode(i);
        requestLayout();
    }

    public Flow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout
    public void onMeasure(androidx.constraintlayout.core.widgets.VirtualLayout virtualLayout, int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (virtualLayout != null) {
            virtualLayout.measure(mode, size, mode2, size2);
            setMeasuredDimension(virtualLayout.getMeasuredWidth(), virtualLayout.getMeasuredHeight());
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public Flow(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
