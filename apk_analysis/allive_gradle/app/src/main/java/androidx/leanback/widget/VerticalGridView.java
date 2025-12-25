package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class VerticalGridView extends BaseGridView {
    public VerticalGridView(@NonNull Context context) {
        this(context, null);
    }

    @SuppressLint({"CustomViewStyleable"})
    public void initAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        m1384f0(context, attributeSet);
        int[] iArr = R.styleable.lbVerticalGridView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        setColumnWidth(obtainStyledAttributes);
        setNumColumns(obtainStyledAttributes.getInt(R.styleable.lbVerticalGridView_numberOfColumns, 1));
        obtainStyledAttributes.recycle();
    }

    public void setColumnWidth(TypedArray typedArray) {
        int i = R.styleable.lbVerticalGridView_columnWidth;
        if (typedArray.peekValue(i) != null) {
            setColumnWidth(typedArray.getLayoutDimension(i, 0));
        }
    }

    public void setNumColumns(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if (i >= 0) {
            gridLayoutManager.f5700a0 = i;
            requestLayout();
        } else {
            gridLayoutManager.getClass();
            throw new IllegalArgumentException();
        }
    }

    public VerticalGridView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VerticalGridView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5584M0.setOrientation(1);
        initAttributes(context, attributeSet);
    }

    public void setColumnWidth(int i) {
        this.f5584M0.m1415T(i);
        requestLayout();
    }
}
