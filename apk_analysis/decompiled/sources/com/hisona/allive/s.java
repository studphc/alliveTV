package com.hisona.allive;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;
import com.hisona.allive.Utils;

/* loaded from: classes2.dex */
public final class s extends RowHeaderPresenter {
    @Override // androidx.leanback.widget.RowHeaderPresenter, androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        HeaderItem headerItem;
        if (obj instanceof ListRow) {
            headerItem = ((ListRow) obj).getHeaderItem();
        } else {
            headerItem = ((PageRow) obj).getHeaderItem();
        }
        View view = viewHolder.view;
        view.setFocusable(true);
        ImageView imageView = (ImageView) view.findViewById(R.id.header_icon);
        TextView textView = (TextView) view.findViewById(R.id.header_label);
        long id = headerItem.getId();
        Drawable drawable = null;
        if (id == Utils.Header.Favorite.ordinal()) {
            drawable = view.getResources().getDrawable(R.drawable.favorite_icon_32b, null);
        } else if (id == Utils.Header.Tving.ordinal()) {
            drawable = view.getResources().getDrawable(R.drawable.tving_icon_32b, null);
        } else if (id == Utils.Header.Wavve.ordinal()) {
            drawable = view.getResources().getDrawable(R.drawable.wavve_icon_32b, null);
        } else if (id == Utils.Header.Etc.ordinal()) {
            drawable = view.getResources().getDrawable(R.drawable.setting_icon_32b, null);
        }
        imageView.setImageDrawable(drawable);
        textView.setText(headerItem.getName());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [android.view.View$OnKeyListener, java.lang.Object] */
    @Override // androidx.leanback.widget.RowHeaderPresenter, androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = ((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(R.layout.icon_header_item, (ViewGroup) null);
        inflate.setAlpha(0.5f);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        inflate.setOnKeyListener(new Object());
        return new RowHeaderPresenter.ViewHolder(inflate);
    }

    @Override // androidx.leanback.widget.RowHeaderPresenter, androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    }
}
