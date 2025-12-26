package androidx.leanback.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter;
import androidx.leanback.widget.Presenter;

/* loaded from: classes.dex */
public class DetailsOverviewLogoPresenter extends Presenter {

    /* loaded from: classes.dex */
    public static class ViewHolder extends Presenter.ViewHolder {

        /* renamed from: b */
        public boolean f5612b;

        @Nullable
        protected FullWidthDetailsOverviewRowPresenter mParentPresenter;

        @Nullable
        protected FullWidthDetailsOverviewRowPresenter.ViewHolder mParentViewHolder;

        public ViewHolder(@NonNull View view) {
            super(view);
        }

        @Nullable
        public FullWidthDetailsOverviewRowPresenter getParentPresenter() {
            return this.mParentPresenter;
        }

        @Nullable
        public FullWidthDetailsOverviewRowPresenter.ViewHolder getParentViewHolder() {
            return this.mParentViewHolder;
        }

        public boolean isSizeFromDrawableIntrinsic() {
            return this.f5612b;
        }

        public void setSizeFromDrawableIntrinsic(boolean z) {
            this.f5612b = z;
        }
    }

    public boolean isBoundToImage(@NonNull ViewHolder viewHolder, @Nullable DetailsOverviewRow detailsOverviewRow) {
        if (detailsOverviewRow != null && detailsOverviewRow.getImageDrawable() != null) {
            return true;
        }
        return false;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onBindViewHolder(@NonNull Presenter.ViewHolder viewHolder, @Nullable Object obj) {
        float f;
        DetailsOverviewRow detailsOverviewRow = (DetailsOverviewRow) obj;
        ImageView imageView = (ImageView) viewHolder.view;
        imageView.setImageDrawable(detailsOverviewRow.getImageDrawable());
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        if (isBoundToImage(viewHolder2, detailsOverviewRow)) {
            if (viewHolder2.isSizeFromDrawableIntrinsic()) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                layoutParams.width = detailsOverviewRow.getImageDrawable().getIntrinsicWidth();
                layoutParams.height = detailsOverviewRow.getImageDrawable().getIntrinsicHeight();
                if (imageView.getMaxWidth() > 0 || imageView.getMaxHeight() > 0) {
                    float f2 = 1.0f;
                    if (imageView.getMaxWidth() > 0 && layoutParams.width > imageView.getMaxWidth()) {
                        f = imageView.getMaxWidth() / layoutParams.width;
                    } else {
                        f = 1.0f;
                    }
                    if (imageView.getMaxHeight() > 0 && layoutParams.height > imageView.getMaxHeight()) {
                        f2 = imageView.getMaxHeight() / layoutParams.height;
                    }
                    float min = Math.min(f, f2);
                    layoutParams.width = (int) (layoutParams.width * min);
                    layoutParams.height = (int) (layoutParams.height * min);
                }
                imageView.setLayoutParams(layoutParams);
            }
            viewHolder2.mParentPresenter.notifyOnBindLogo(viewHolder2.mParentViewHolder);
        }
    }

    @NonNull
    public View onCreateView(@NonNull ViewGroup viewGroup) {
        return LayoutInflater.from(viewGroup.getContext()).inflate(androidx.leanback.R.layout.lb_fullwidth_details_overview_logo, viewGroup, false);
    }

    @Override // androidx.leanback.widget.Presenter
    @NonNull
    public Presenter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup) {
        boolean z;
        View onCreateView = onCreateView(viewGroup);
        ViewHolder viewHolder = new ViewHolder(onCreateView);
        ViewGroup.LayoutParams layoutParams = onCreateView.getLayoutParams();
        if (layoutParams.width == -2 && layoutParams.height == -2) {
            z = true;
        } else {
            z = false;
        }
        viewHolder.setSizeFromDrawableIntrinsic(z);
        return viewHolder;
    }

    @Override // androidx.leanback.widget.Presenter
    public void onUnbindViewHolder(@NonNull Presenter.ViewHolder viewHolder) {
    }

    public void setContext(@NonNull ViewHolder viewHolder, @Nullable FullWidthDetailsOverviewRowPresenter.ViewHolder viewHolder2, @Nullable FullWidthDetailsOverviewRowPresenter fullWidthDetailsOverviewRowPresenter) {
        viewHolder.mParentViewHolder = viewHolder2;
        viewHolder.mParentPresenter = fullWidthDetailsOverviewRowPresenter;
    }
}
