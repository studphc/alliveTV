package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout;

/* loaded from: classes.dex */
public class Placeholder extends View {

    /* renamed from: a */
    public int f3199a;

    /* renamed from: b */
    public View f3200b;

    /* renamed from: c */
    public int f3201c;

    public Placeholder(Context context) {
        super(context);
        this.f3199a = -1;
        this.f3200b = null;
        this.f3201c = 4;
        m660a(null);
    }

    /* renamed from: a */
    public final void m660a(AttributeSet attributeSet) {
        super.setVisibility(this.f3201c);
        this.f3199a = -1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_placeholder);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ConstraintLayout_placeholder_content) {
                    this.f3199a = obtainStyledAttributes.getResourceId(index, this.f3199a);
                } else if (index == R.styleable.ConstraintLayout_placeholder_placeholder_emptyVisibility) {
                    this.f3201c = obtainStyledAttributes.getInt(index, this.f3201c);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public View getContent() {
        return this.f3200b;
    }

    public int getEmptyVisibility() {
        return this.f3201c;
    }

    @Override // android.view.View
    public void onDraw(@NonNull Canvas canvas) {
        if (isInEditMode()) {
            canvas.drawRGB(223, 223, 223);
            Paint paint = new Paint();
            paint.setARGB(255, 210, 210, 210);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
            Rect rect = new Rect();
            canvas.getClipBounds(rect);
            paint.setTextSize(rect.height());
            int height = rect.height();
            int width = rect.width();
            paint.setTextAlign(Paint.Align.LEFT);
            paint.getTextBounds("?", 0, 1, rect);
            canvas.drawText("?", ((width / 2.0f) - (rect.width() / 2.0f)) - rect.left, ((rect.height() / 2.0f) + (height / 2.0f)) - rect.bottom, paint);
        }
    }

    public void setContentId(int i) {
        View findViewById;
        if (this.f3199a == i) {
            return;
        }
        View view = this.f3200b;
        if (view != null) {
            view.setVisibility(0);
            ((ConstraintLayout.LayoutParams) this.f3200b.getLayoutParams()).f3160f = false;
            this.f3200b = null;
        }
        this.f3199a = i;
        if (i != -1 && (findViewById = ((View) getParent()).findViewById(i)) != null) {
            findViewById.setVisibility(8);
        }
    }

    public void setEmptyVisibility(int i) {
        this.f3201c = i;
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
        if (this.f3200b == null) {
            return;
        }
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) getLayoutParams();
        ConstraintLayout.LayoutParams layoutParams2 = (ConstraintLayout.LayoutParams) this.f3200b.getLayoutParams();
        layoutParams2.f3171q.setVisibility(0);
        ConstraintWidget.DimensionBehaviour horizontalDimensionBehaviour = layoutParams.f3171q.getHorizontalDimensionBehaviour();
        ConstraintWidget.DimensionBehaviour dimensionBehaviour = ConstraintWidget.DimensionBehaviour.FIXED;
        if (horizontalDimensionBehaviour != dimensionBehaviour) {
            layoutParams.f3171q.setWidth(layoutParams2.f3171q.getWidth());
        }
        if (layoutParams.f3171q.getVerticalDimensionBehaviour() != dimensionBehaviour) {
            layoutParams.f3171q.setHeight(layoutParams2.f3171q.getHeight());
        }
        layoutParams2.f3171q.setVisibility(8);
    }

    public void updatePreLayout(ConstraintLayout constraintLayout) {
        if (this.f3199a == -1 && !isInEditMode()) {
            setVisibility(this.f3201c);
        }
        View findViewById = constraintLayout.findViewById(this.f3199a);
        this.f3200b = findViewById;
        if (findViewById != null) {
            ((ConstraintLayout.LayoutParams) findViewById.getLayoutParams()).f3160f = true;
            this.f3200b.setVisibility(0);
            setVisibility(0);
        }
    }

    public Placeholder(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3199a = -1;
        this.f3200b = null;
        this.f3201c = 4;
        m660a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f3199a = -1;
        this.f3200b = null;
        this.f3201c = 4;
        m660a(attributeSet);
    }

    public Placeholder(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.f3199a = -1;
        this.f3200b = null;
        this.f3201c = 4;
        m660a(attributeSet);
    }
}
