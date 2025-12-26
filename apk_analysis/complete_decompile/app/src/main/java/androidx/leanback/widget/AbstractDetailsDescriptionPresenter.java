package androidx.leanback.widget;

import android.graphics.Paint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.widget.Presenter;

/* loaded from: classes.dex */
public abstract class AbstractDetailsDescriptionPresenter extends Presenter {

    /* loaded from: classes.dex */
    public static class ViewHolder extends Presenter.ViewHolder {

        /* renamed from: b */
        public final TextView f5517b;

        /* renamed from: c */
        public final TextView f5518c;

        /* renamed from: d */
        public final TextView f5519d;

        /* renamed from: e */
        public final int f5520e;

        /* renamed from: f */
        public final int f5521f;

        /* renamed from: g */
        public final int f5522g;

        /* renamed from: h */
        public final int f5523h;

        /* renamed from: i */
        public final int f5524i;

        /* renamed from: j */
        public final int f5525j;

        /* renamed from: k */
        public final int f5526k;

        /* renamed from: l */
        public final Paint.FontMetricsInt f5527l;

        /* renamed from: m */
        public final Paint.FontMetricsInt f5528m;

        /* renamed from: n */
        public final Paint.FontMetricsInt f5529n;

        /* renamed from: o */
        public final int f5530o;

        /* renamed from: p */
        public ViewTreeObserverOnPreDrawListenerC0316b f5531p;

        public ViewHolder(@NonNull View view) {
            super(view);
            TextView textView = (TextView) view.findViewById(androidx.leanback.R.id.lb_details_description_title);
            this.f5517b = textView;
            TextView textView2 = (TextView) view.findViewById(androidx.leanback.R.id.lb_details_description_subtitle);
            this.f5518c = textView2;
            TextView textView3 = (TextView) view.findViewById(androidx.leanback.R.id.lb_details_description_body);
            this.f5519d = textView3;
            this.f5520e = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_description_title_baseline) + m1380a(textView).ascent;
            this.f5521f = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_description_under_title_baseline_margin);
            this.f5522g = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_description_under_subtitle_baseline_margin);
            this.f5523h = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_description_title_line_spacing);
            this.f5524i = view.getResources().getDimensionPixelSize(androidx.leanback.R.dimen.lb_details_description_body_line_spacing);
            this.f5525j = view.getResources().getInteger(androidx.leanback.R.integer.lb_details_description_body_max_lines);
            this.f5526k = view.getResources().getInteger(androidx.leanback.R.integer.lb_details_description_body_min_lines);
            this.f5530o = textView.getMaxLines();
            this.f5527l = m1380a(textView);
            this.f5528m = m1380a(textView2);
            this.f5529n = m1380a(textView3);
            textView.addOnLayoutChangeListener(new ViewOnLayoutChangeListenerC0311a(this));
        }

        /* renamed from: a */
        public static Paint.FontMetricsInt m1380a(TextView textView) {
            Paint paint = new Paint(1);
            paint.setTextSize(textView.getTextSize());
            paint.setTypeface(textView.getTypeface());
            return paint.getFontMetricsInt();
        }

        @NonNull
        public TextView getBody() {
            return this.f5519d;
        }

        @NonNull
        public TextView getSubtitle() {
            return this.f5518c;
        }

        @NonNull
        public TextView getTitle() {
            return this.f5517b;
        }
    }

    /* renamed from: a */
    public static void m1379a(TextView textView, int i) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) textView.getLayoutParams();
        marginLayoutParams.topMargin = i;
        textView.setLayoutParams(marginLayoutParams);
    }

    public abstract void onBindDescription(@NonNull ViewHolder viewHolder, @NonNull Object obj);

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(@NonNull Presenter.ViewHolder viewHolder, @Nullable Object obj) {
        boolean z;
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        onBindDescription(viewHolder2, obj);
        boolean isEmpty = TextUtils.isEmpty(viewHolder2.f5517b.getText());
        boolean z2 = true;
        TextView textView = viewHolder2.f5517b;
        if (isEmpty) {
            textView.setVisibility(8);
            z = false;
        } else {
            textView.setVisibility(0);
            textView.setLineSpacing(textView.getLineSpacingExtra() + (viewHolder2.f5523h - textView.getLineHeight()), textView.getLineSpacingMultiplier());
            textView.setMaxLines(viewHolder2.f5530o);
            z = true;
        }
        m1379a(textView, viewHolder2.f5520e);
        TextView textView2 = viewHolder2.f5518c;
        boolean isEmpty2 = TextUtils.isEmpty(textView2.getText());
        Paint.FontMetricsInt fontMetricsInt = viewHolder2.f5527l;
        Paint.FontMetricsInt fontMetricsInt2 = viewHolder2.f5528m;
        int i = viewHolder2.f5521f;
        if (isEmpty2) {
            textView2.setVisibility(8);
            z2 = false;
        } else {
            textView2.setVisibility(0);
            if (z) {
                m1379a(textView2, (fontMetricsInt2.ascent + i) - fontMetricsInt.descent);
            } else {
                m1379a(textView2, 0);
            }
        }
        TextView textView3 = viewHolder2.f5519d;
        if (TextUtils.isEmpty(textView3.getText())) {
            textView3.setVisibility(8);
            return;
        }
        textView3.setVisibility(0);
        textView3.setLineSpacing(textView3.getLineSpacingExtra() + (viewHolder2.f5524i - textView3.getLineHeight()), textView3.getLineSpacingMultiplier());
        Paint.FontMetricsInt fontMetricsInt3 = viewHolder2.f5529n;
        if (z2) {
            m1379a(textView3, (viewHolder2.f5522g + fontMetricsInt3.ascent) - fontMetricsInt2.descent);
        } else if (z) {
            m1379a(textView3, (i + fontMetricsInt3.ascent) - fontMetricsInt.descent);
        } else {
            m1379a(textView3, 0);
        }
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(@NonNull Presenter.ViewHolder viewHolder) {
    }

    @Override // androidx.leanback.widget.Presenter
    public void onViewAttachedToWindow(@NonNull Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (viewHolder2.f5531p == null) {
            viewHolder2.f5531p = new ViewTreeObserverOnPreDrawListenerC0316b(viewHolder2);
            viewHolder2.view.getViewTreeObserver().addOnPreDrawListener(viewHolder2.f5531p);
        }
        super.onViewAttachedToWindow(viewHolder);
    }

    @Override // androidx.leanback.widget.Presenter
    public void onViewDetachedFromWindow(@NonNull Presenter.ViewHolder viewHolder) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (viewHolder2.f5531p != null) {
            viewHolder2.view.getViewTreeObserver().removeOnPreDrawListener(viewHolder2.f5531p);
            viewHolder2.f5531p = null;
        }
        super.onViewDetachedFromWindow(viewHolder);
    }

    @Override // androidx.leanback.widget.Presenter
    @NonNull
    public final ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_details_description, viewGroup, false));
    }
}
