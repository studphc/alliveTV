package androidx.leanback.widget;

import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.leanback.widget.Presenter;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: classes.dex */
public class RowHeaderPresenter extends Presenter {

    /* renamed from: b */
    public final int f6099b;

    /* renamed from: c */
    public final Paint f6100c;

    /* renamed from: d */
    public boolean f6101d;

    /* renamed from: e */
    public final boolean f6102e;

    public RowHeaderPresenter() {
        this(androidx.leanback.R.layout.lb_row_header);
    }

    public static float getFontDescent(@NonNull TextView textView, @NonNull Paint paint) {
        if (paint.getTextSize() != textView.getTextSize()) {
            paint.setTextSize(textView.getTextSize());
        }
        if (paint.getTypeface() != textView.getTypeface()) {
            paint.setTypeface(textView.getTypeface());
        }
        return paint.descent();
    }

    public int getSpaceUnderBaseline(@NonNull ViewHolder viewHolder) {
        int paddingBottom = viewHolder.view.getPaddingBottom();
        View view = viewHolder.view;
        if (view instanceof TextView) {
            return paddingBottom + ((int) getFontDescent((TextView) view, this.f6100c));
        }
        return paddingBottom;
    }

    public boolean isNullItemVisibilityGone() {
        return this.f6101d;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(@NonNull Presenter.ViewHolder viewHolder, @Nullable Object obj) {
        HeaderItem headerItem;
        if (obj == null) {
            headerItem = null;
        } else {
            headerItem = ((Row) obj).getHeaderItem();
        }
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (headerItem == null) {
            RowHeaderView rowHeaderView = viewHolder2.f6105d;
            if (rowHeaderView != null) {
                rowHeaderView.setText((CharSequence) null);
            }
            TextView textView = viewHolder2.f6106e;
            if (textView != null) {
                textView.setText((CharSequence) null);
            }
            viewHolder.view.setContentDescription(null);
            if (this.f6101d) {
                viewHolder.view.setVisibility(8);
                return;
            }
            return;
        }
        RowHeaderView rowHeaderView2 = viewHolder2.f6105d;
        if (rowHeaderView2 != null) {
            rowHeaderView2.setText(headerItem.getName());
        }
        TextView textView2 = viewHolder2.f6106e;
        if (textView2 != null) {
            if (TextUtils.isEmpty(headerItem.getDescription())) {
                textView2.setVisibility(8);
            } else {
                textView2.setVisibility(0);
            }
            textView2.setText(headerItem.getDescription());
        }
        viewHolder.view.setContentDescription(headerItem.getContentDescription());
        viewHolder.view.setVisibility(0);
    }

    @Override // androidx.leanback.widget.Presenter
    @NonNull
    public Presenter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(this.f6099b, viewGroup, false));
        if (this.f6102e) {
            setSelectLevel(viewHolder, RecyclerView.f7068F0);
        }
        return viewHolder;
    }

    public void onSelectLevelChanged(@NonNull ViewHolder viewHolder) {
        if (this.f6102e) {
            View view = viewHolder.view;
            float f = viewHolder.f6104c;
            view.setAlpha(((1.0f - f) * viewHolder.f6103b) + f);
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(@NonNull Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        RowHeaderView rowHeaderView = viewHolder2.f6105d;
        if (rowHeaderView != null) {
            rowHeaderView.setText((CharSequence) null);
        }
        TextView textView = viewHolder2.f6106e;
        if (textView != null) {
            textView.setText((CharSequence) null);
        }
        if (this.f6102e) {
            setSelectLevel(viewHolder2, RecyclerView.f7068F0);
        }
    }

    public void setNullItemVisibilityGone(boolean z) {
        this.f6101d = z;
    }

    public final void setSelectLevel(@NonNull ViewHolder viewHolder, float f) {
        viewHolder.f6103b = f;
        onSelectLevelChanged(viewHolder);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RowHeaderPresenter(int i) {
        this(i, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public RowHeaderPresenter(int i, boolean z) {
        this.f6100c = new Paint(1);
        this.f6099b = i;
        this.f6102e = z;
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends Presenter.ViewHolder {

        /* renamed from: b */
        public float f6103b;

        /* renamed from: c */
        public final float f6104c;

        /* renamed from: d */
        public final RowHeaderView f6105d;

        /* renamed from: e */
        public final TextView f6106e;

        public ViewHolder(@NonNull View view) {
            super(view);
            this.f6105d = (RowHeaderView) view.findViewById(androidx.leanback.R.id.row_header);
            this.f6106e = (TextView) view.findViewById(androidx.leanback.R.id.row_header_description);
            RowHeaderView rowHeaderView = this.f6105d;
            if (rowHeaderView != null) {
                rowHeaderView.getCurrentTextColor();
            }
            this.f6104c = this.view.getResources().getFraction(androidx.leanback.R.fraction.lb_browse_header_unselect_alpha, 1, 1);
        }

        public final float getSelectLevel() {
            return this.f6103b;
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public ViewHolder(@NonNull RowHeaderView rowHeaderView) {
            super(rowHeaderView);
            this.f6105d = rowHeaderView;
            if (rowHeaderView != null) {
                rowHeaderView.getCurrentTextColor();
            }
            this.f6104c = this.view.getResources().getFraction(androidx.leanback.R.fraction.lb_browse_header_unselect_alpha, 1, 1);
        }
    }
}
