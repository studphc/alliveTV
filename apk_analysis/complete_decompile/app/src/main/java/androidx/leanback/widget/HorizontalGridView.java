package androidx.leanback.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class HorizontalGridView extends BaseGridView {

    /* renamed from: X0 */
    public boolean f5838X0;

    /* renamed from: Y0 */
    public boolean f5839Y0;

    /* renamed from: Z0 */
    public Paint f5840Z0;

    /* renamed from: a1 */
    public Bitmap f5841a1;

    /* renamed from: b1 */
    public LinearGradient f5842b1;

    /* renamed from: c1 */
    public int f5843c1;

    /* renamed from: d1 */
    public int f5844d1;

    /* renamed from: e1 */
    public Bitmap f5845e1;

    /* renamed from: f1 */
    public LinearGradient f5846f1;

    /* renamed from: g1 */
    public int f5847g1;

    /* renamed from: h1 */
    public int f5848h1;

    /* renamed from: i1 */
    public final Rect f5849i1;

    public HorizontalGridView(@NonNull Context context) {
        this(context, null);
    }

    private Bitmap getTempBitmapHigh() {
        Bitmap bitmap = this.f5845e1;
        if (bitmap == null || bitmap.getWidth() != this.f5847g1 || this.f5845e1.getHeight() != getHeight()) {
            this.f5845e1 = Bitmap.createBitmap(this.f5847g1, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.f5845e1;
    }

    private Bitmap getTempBitmapLow() {
        Bitmap bitmap = this.f5841a1;
        if (bitmap == null || bitmap.getWidth() != this.f5843c1 || this.f5841a1.getHeight() != getHeight()) {
            this.f5841a1 = Bitmap.createBitmap(this.f5843c1, getHeight(), Bitmap.Config.ARGB_8888);
        }
        return this.f5841a1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void draw(@NonNull Canvas canvas) {
        boolean z;
        int i;
        int width;
        int i2;
        int i3;
        boolean z2 = true;
        if (this.f5838X0) {
            int childCount = getChildCount();
            for (int i4 = 0; i4 < childCount; i4++) {
                View childAt = getChildAt(i4);
                this.f5584M0.getClass();
                C0377q0 c0377q0 = (C0377q0) childAt.getLayoutParams();
                c0377q0.getClass();
                if (childAt.getLeft() + c0377q0.f6398e < getPaddingLeft() - this.f5844d1) {
                    z = true;
                    break;
                }
            }
        }
        z = false;
        if (this.f5839Y0) {
            for (int childCount2 = getChildCount() - 1; childCount2 >= 0; childCount2--) {
                View childAt2 = getChildAt(childCount2);
                this.f5584M0.getClass();
                C0377q0 c0377q02 = (C0377q0) childAt2.getLayoutParams();
                c0377q02.getClass();
                if (childAt2.getRight() - c0377q02.f6400g > (getWidth() - getPaddingRight()) + this.f5848h1) {
                    break;
                }
            }
        }
        z2 = false;
        if (!z) {
            this.f5841a1 = null;
        }
        if (!z2) {
            this.f5845e1 = null;
        }
        if (!z && !z2) {
            super.draw(canvas);
            return;
        }
        if (this.f5838X0) {
            i = (getPaddingLeft() - this.f5844d1) - this.f5843c1;
        } else {
            i = 0;
        }
        if (this.f5839Y0) {
            width = (getWidth() - getPaddingRight()) + this.f5848h1 + this.f5847g1;
        } else {
            width = getWidth();
        }
        int save = canvas.save();
        if (this.f5838X0) {
            i2 = this.f5843c1;
        } else {
            i2 = 0;
        }
        int i5 = i2 + i;
        if (this.f5839Y0) {
            i3 = this.f5847g1;
        } else {
            i3 = 0;
        }
        canvas.clipRect(i5, 0, width - i3, getHeight());
        super.draw(canvas);
        canvas.restoreToCount(save);
        Canvas canvas2 = new Canvas();
        Rect rect = this.f5849i1;
        rect.top = 0;
        rect.bottom = getHeight();
        if (z && this.f5843c1 > 0) {
            Bitmap tempBitmapLow = getTempBitmapLow();
            tempBitmapLow.eraseColor(0);
            canvas2.setBitmap(tempBitmapLow);
            int save2 = canvas2.save();
            canvas2.clipRect(0, 0, this.f5843c1, getHeight());
            float f = -i;
            canvas2.translate(f, RecyclerView.f7068F0);
            super.draw(canvas2);
            canvas2.restoreToCount(save2);
            this.f5840Z0.setShader(this.f5842b1);
            canvas2.drawRect(RecyclerView.f7068F0, RecyclerView.f7068F0, this.f5843c1, getHeight(), this.f5840Z0);
            rect.left = 0;
            rect.right = this.f5843c1;
            canvas.translate(i, RecyclerView.f7068F0);
            canvas.drawBitmap(tempBitmapLow, rect, rect, (Paint) null);
            canvas.translate(f, RecyclerView.f7068F0);
        }
        if (z2 && this.f5847g1 > 0) {
            Bitmap tempBitmapHigh = getTempBitmapHigh();
            tempBitmapHigh.eraseColor(0);
            canvas2.setBitmap(tempBitmapHigh);
            int save3 = canvas2.save();
            canvas2.clipRect(0, 0, this.f5847g1, getHeight());
            canvas2.translate(-(width - this.f5847g1), RecyclerView.f7068F0);
            super.draw(canvas2);
            canvas2.restoreToCount(save3);
            this.f5840Z0.setShader(this.f5846f1);
            canvas2.drawRect(RecyclerView.f7068F0, RecyclerView.f7068F0, this.f5847g1, getHeight(), this.f5840Z0);
            rect.left = 0;
            rect.right = this.f5847g1;
            canvas.translate(width - r3, RecyclerView.f7068F0);
            canvas.drawBitmap(tempBitmapHigh, rect, rect, (Paint) null);
            canvas.translate(-(width - this.f5847g1), RecyclerView.f7068F0);
        }
    }

    /* renamed from: g0 */
    public final void m1446g0() {
        if (!this.f5838X0 && !this.f5839Y0) {
            setLayerType(0, null);
            setWillNotDraw(true);
        } else {
            setLayerType(2, null);
            setWillNotDraw(false);
        }
    }

    @SuppressLint({"GetterSetterNames"})
    public final boolean getFadingLeftEdge() {
        return this.f5838X0;
    }

    public final int getFadingLeftEdgeLength() {
        return this.f5843c1;
    }

    public final int getFadingLeftEdgeOffset() {
        return this.f5844d1;
    }

    @SuppressLint({"GetterSetterNames"})
    public final boolean getFadingRightEdge() {
        return this.f5839Y0;
    }

    public final int getFadingRightEdgeLength() {
        return this.f5847g1;
    }

    public final int getFadingRightEdgeOffset() {
        return this.f5848h1;
    }

    @SuppressLint({"CustomViewStyleable"})
    public void initAttributes(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        m1384f0(context, attributeSet);
        int[] iArr = R.styleable.lbHorizontalGridView;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        ViewCompat.saveAttributeDataForStyleable(this, context, iArr, attributeSet, obtainStyledAttributes, 0, 0);
        setRowHeight(obtainStyledAttributes);
        setNumRows(obtainStyledAttributes.getInt(R.styleable.lbHorizontalGridView_numberOfRows, 1));
        obtainStyledAttributes.recycle();
        m1446g0();
        Paint paint = new Paint();
        this.f5840Z0 = paint;
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    public final void setFadingLeftEdge(boolean z) {
        if (this.f5838X0 != z) {
            this.f5838X0 = z;
            if (!z) {
                this.f5841a1 = null;
            }
            invalidate();
            m1446g0();
        }
    }

    public final void setFadingLeftEdgeLength(int i) {
        if (this.f5843c1 != i) {
            this.f5843c1 = i;
            if (i != 0) {
                this.f5842b1 = new LinearGradient(RecyclerView.f7068F0, RecyclerView.f7068F0, this.f5843c1, RecyclerView.f7068F0, 0, ViewCompat.MEASURED_STATE_MASK, Shader.TileMode.CLAMP);
            } else {
                this.f5842b1 = null;
            }
            invalidate();
        }
    }

    public final void setFadingLeftEdgeOffset(int i) {
        if (this.f5844d1 != i) {
            this.f5844d1 = i;
            invalidate();
        }
    }

    public final void setFadingRightEdge(boolean z) {
        if (this.f5839Y0 != z) {
            this.f5839Y0 = z;
            if (!z) {
                this.f5845e1 = null;
            }
            invalidate();
            m1446g0();
        }
    }

    public final void setFadingRightEdgeLength(int i) {
        if (this.f5847g1 != i) {
            this.f5847g1 = i;
            if (i != 0) {
                this.f5846f1 = new LinearGradient(RecyclerView.f7068F0, RecyclerView.f7068F0, this.f5847g1, RecyclerView.f7068F0, ViewCompat.MEASURED_STATE_MASK, 0, Shader.TileMode.CLAMP);
            } else {
                this.f5846f1 = null;
            }
            invalidate();
        }
    }

    public final void setFadingRightEdgeOffset(int i) {
        if (this.f5848h1 != i) {
            this.f5848h1 = i;
            invalidate();
        }
    }

    public void setNumRows(int i) {
        GridLayoutManager gridLayoutManager = this.f5584M0;
        if (i >= 0) {
            gridLayoutManager.f5700a0 = i;
            requestLayout();
        } else {
            gridLayoutManager.getClass();
            throw new IllegalArgumentException();
        }
    }

    public void setRowHeight(TypedArray typedArray) {
        int i = R.styleable.lbHorizontalGridView_rowHeight;
        if (typedArray.peekValue(i) != null) {
            setRowHeight(typedArray.getLayoutDimension(i, 0));
        }
    }

    public HorizontalGridView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public HorizontalGridView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f5840Z0 = new Paint();
        this.f5849i1 = new Rect();
        this.f5584M0.setOrientation(0);
        initAttributes(context, attributeSet);
    }

    public void setRowHeight(int i) {
        this.f5584M0.m1415T(i);
        requestLayout();
    }
}
