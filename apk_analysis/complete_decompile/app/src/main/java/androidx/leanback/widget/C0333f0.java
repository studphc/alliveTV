package androidx.leanback.widget;

import android.app.Activity;
import android.graphics.Matrix;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.app.SharedElementCallback;
import androidx.leanback.widget.DetailsOverviewRowPresenter;
import java.lang.ref.WeakReference;
import java.util.List;

/* renamed from: androidx.leanback.widget.f0 */
/* loaded from: classes.dex */
public final class C0333f0 extends SharedElementCallback {

    /* renamed from: b */
    public WeakReference f6288b;

    /* renamed from: c */
    public Activity f6289c;

    /* renamed from: d */
    public boolean f6290d;

    /* renamed from: e */
    public String f6291e;

    /* renamed from: f */
    public int f6292f;

    /* renamed from: g */
    public int f6293g;

    /* renamed from: h */
    public ImageView.ScaleType f6294h;

    /* renamed from: i */
    public Matrix f6295i;

    /* renamed from: a */
    public static void m1497a(ImageView imageView) {
        imageView.measure(View.MeasureSpec.makeMeasureSpec(imageView.getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(imageView.getMeasuredHeight(), 1073741824));
        imageView.layout(imageView.getLeft(), imageView.getTop(), imageView.getRight(), imageView.getBottom());
    }

    @Override // androidx.core.app.SharedElementCallback
    public final void onSharedElementEnd(List list, List list2, List list3) {
        if (list2.size() < 1) {
            return;
        }
        DetailsOverviewRowPresenter.ViewHolder viewHolder = (DetailsOverviewRowPresenter.ViewHolder) this.f6288b.get();
        View view = (View) list2.get(0);
        if (viewHolder != null && viewHolder.f5627n == view) {
            ImageView.ScaleType scaleType = this.f6294h;
            if (scaleType != null) {
                ImageView imageView = viewHolder.f5629p;
                imageView.setScaleType(scaleType);
                if (this.f6294h == ImageView.ScaleType.MATRIX) {
                    imageView.setImageMatrix(this.f6295i);
                }
                this.f6294h = null;
                m1497a(imageView);
            }
            HorizontalGridView horizontalGridView = viewHolder.f5632s;
            horizontalGridView.setDescendantFocusability(131072);
            horizontalGridView.setVisibility(0);
            horizontalGridView.setDescendantFocusability(262144);
            horizontalGridView.requestFocus();
            viewHolder.f5631r.setVisibility(0);
        }
    }

    @Override // androidx.core.app.SharedElementCallback
    public final void onSharedElementStart(List list, List list2, List list3) {
        Matrix matrix;
        if (list2.size() < 1) {
            return;
        }
        DetailsOverviewRowPresenter.ViewHolder viewHolder = (DetailsOverviewRowPresenter.ViewHolder) this.f6288b.get();
        View view = (View) list2.get(0);
        if (viewHolder != null && viewHolder.f5627n == view) {
            View view2 = (View) list3.get(0);
            boolean z = view2 instanceof ImageView;
            ImageView imageView = viewHolder.f5629p;
            if (z) {
                DetailsOverviewRowPresenter.ViewHolder viewHolder2 = (DetailsOverviewRowPresenter.ViewHolder) this.f6288b.get();
                if (this.f6294h == null && viewHolder2 != null) {
                    ImageView imageView2 = viewHolder2.f5629p;
                    ImageView.ScaleType scaleType = imageView2.getScaleType();
                    this.f6294h = scaleType;
                    if (scaleType == ImageView.ScaleType.MATRIX) {
                        matrix = imageView2.getMatrix();
                    } else {
                        matrix = null;
                    }
                    this.f6295i = matrix;
                }
                ImageView imageView3 = (ImageView) view2;
                imageView.setScaleType(imageView3.getScaleType());
                if (imageView3.getScaleType() == ImageView.ScaleType.MATRIX) {
                    imageView.setImageMatrix(imageView3.getImageMatrix());
                }
                m1497a(imageView);
            }
            int width = view.getWidth();
            int height = view.getHeight();
            imageView.measure(View.MeasureSpec.makeMeasureSpec(width, 1073741824), View.MeasureSpec.makeMeasureSpec(height, 1073741824));
            imageView.layout(0, 0, width, height);
            int i = this.f6292f;
            ViewGroup viewGroup = viewHolder.f5630q;
            if (i != 0 && this.f6293g != 0) {
                viewGroup.measure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f6293g, 1073741824));
                viewGroup.layout(width, viewGroup.getTop(), this.f6292f + width, viewGroup.getTop() + this.f6293g);
            } else {
                viewGroup.offsetLeftAndRight(width - viewGroup.getLeft());
            }
            viewHolder.f5632s.setVisibility(4);
            viewHolder.f5631r.setVisibility(4);
        }
    }
}
