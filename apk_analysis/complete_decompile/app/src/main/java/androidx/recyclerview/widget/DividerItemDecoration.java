package androidx.recyclerview.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class DividerItemDecoration extends RecyclerView.ItemDecoration {
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;

    /* renamed from: d */
    public static final int[] f6983d = {R.attr.listDivider};

    /* renamed from: a */
    public Drawable f6984a;

    /* renamed from: b */
    public int f6985b;

    /* renamed from: c */
    public final Rect f6986c = new Rect();

    @SuppressLint({"UnknownNullness"})
    public DividerItemDecoration(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(f6983d);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        this.f6984a = drawable;
        if (drawable == null) {
            Log.w("DividerItem", "@android:attr/listDivider was not set in the theme used for this DividerItemDecoration. Please set that attribute all call setDrawable()");
        }
        obtainStyledAttributes.recycle();
        setOrientation(i);
    }

    @Nullable
    public Drawable getDrawable() {
        return this.f6984a;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    @SuppressLint({"UnknownNullness"})
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        Drawable drawable = this.f6984a;
        if (drawable == null) {
            rect.set(0, 0, 0, 0);
        } else if (this.f6985b == 1) {
            rect.set(0, 0, 0, drawable.getIntrinsicHeight());
        } else {
            rect.set(0, 0, drawable.getIntrinsicWidth(), 0);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
    @SuppressLint({"UnknownNullness"})
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        int height;
        int i;
        int width;
        int i2;
        if (recyclerView.getLayoutManager() != null && this.f6984a != null) {
            int i3 = this.f6985b;
            Rect rect = this.f6986c;
            int i4 = 0;
            if (i3 == 1) {
                canvas.save();
                if (recyclerView.getClipToPadding()) {
                    i2 = recyclerView.getPaddingLeft();
                    width = recyclerView.getWidth() - recyclerView.getPaddingRight();
                    canvas.clipRect(i2, recyclerView.getPaddingTop(), width, recyclerView.getHeight() - recyclerView.getPaddingBottom());
                } else {
                    width = recyclerView.getWidth();
                    i2 = 0;
                }
                int childCount = recyclerView.getChildCount();
                while (i4 < childCount) {
                    View childAt = recyclerView.getChildAt(i4);
                    recyclerView.getDecoratedBoundsWithMargins(childAt, rect);
                    int round = Math.round(childAt.getTranslationY()) + rect.bottom;
                    this.f6984a.setBounds(i2, round - this.f6984a.getIntrinsicHeight(), width, round);
                    this.f6984a.draw(canvas);
                    i4++;
                }
                canvas.restore();
                return;
            }
            canvas.save();
            if (recyclerView.getClipToPadding()) {
                i = recyclerView.getPaddingTop();
                height = recyclerView.getHeight() - recyclerView.getPaddingBottom();
                canvas.clipRect(recyclerView.getPaddingLeft(), i, recyclerView.getWidth() - recyclerView.getPaddingRight(), height);
            } else {
                height = recyclerView.getHeight();
                i = 0;
            }
            int childCount2 = recyclerView.getChildCount();
            while (i4 < childCount2) {
                View childAt2 = recyclerView.getChildAt(i4);
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt2, rect);
                int round2 = Math.round(childAt2.getTranslationX()) + rect.right;
                this.f6984a.setBounds(round2 - this.f6984a.getIntrinsicWidth(), i, round2, height);
                this.f6984a.draw(canvas);
                i4++;
            }
            canvas.restore();
        }
    }

    public void setDrawable(@NonNull Drawable drawable) {
        if (drawable != null) {
            this.f6984a = drawable;
            return;
        }
        throw new IllegalArgumentException("Drawable cannot be null.");
    }

    public void setOrientation(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException("Invalid orientation. It should be either HORIZONTAL or VERTICAL");
        }
        this.f6985b = i;
    }
}
