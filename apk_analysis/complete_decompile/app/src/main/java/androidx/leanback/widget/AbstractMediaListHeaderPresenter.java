package androidx.leanback.widget;

import android.content.Context;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.leanback.widget.RowPresenter;

/* loaded from: classes.dex */
public abstract class AbstractMediaListHeaderPresenter extends RowPresenter {

    /* renamed from: e */
    public final ContextThemeWrapper f5553e;

    /* renamed from: f */
    public int f5554f;

    /* renamed from: g */
    public boolean f5555g;

    /* loaded from: classes.dex */
    public static class ViewHolder extends RowPresenter.ViewHolder {

        /* renamed from: n */
        public final TextView f5556n;

        public ViewHolder(View view) {
            super(view);
            this.f5556n = (TextView) view.findViewById(androidx.leanback.R.id.mediaListHeader);
        }

        public TextView getHeaderView() {
            return this.f5556n;
        }
    }

    public AbstractMediaListHeaderPresenter(Context context, int i) {
        this.f5554f = 0;
        this.f5553e = new ContextThemeWrapper(context.getApplicationContext(), i);
        setHeaderPresenter(null);
    }

    @Override // androidx.leanback.widget.RowPresenter
    public RowPresenter.ViewHolder createRowViewHolder(ViewGroup viewGroup) {
        Context context = this.f5553e;
        if (context == null) {
            context = viewGroup.getContext();
        }
        View inflate = LayoutInflater.from(context).inflate(androidx.leanback.R.layout.lb_media_list_header, viewGroup, false);
        inflate.setFocusable(false);
        inflate.setFocusableInTouchMode(false);
        ViewHolder viewHolder = new ViewHolder(inflate);
        if (this.f5555g) {
            viewHolder.view.setBackgroundColor(this.f5554f);
        }
        return viewHolder;
    }

    @Override // androidx.leanback.widget.RowPresenter
    public boolean isUsingDefaultSelectEffect() {
        return false;
    }

    public abstract void onBindMediaListHeaderViewHolder(ViewHolder viewHolder, Object obj);

    @Override // androidx.leanback.widget.RowPresenter
    public void onBindRowViewHolder(@NonNull RowPresenter.ViewHolder viewHolder, @NonNull Object obj) {
        super.onBindRowViewHolder(viewHolder, obj);
        onBindMediaListHeaderViewHolder((ViewHolder) viewHolder, obj);
    }

    public void setBackgroundColor(int i) {
        this.f5555g = true;
        this.f5554f = i;
    }

    public AbstractMediaListHeaderPresenter() {
        this.f5554f = 0;
        this.f5553e = null;
        setHeaderPresenter(null);
    }
}
