package com.hisona.allive;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import defpackage.re1;

/* loaded from: classes2.dex */
public final class q extends Presenter {
    public final /* synthetic */ MainFragment b;

    public q(MainFragment mainFragment) {
        this.b = mainFragment;
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        re1 re1Var = (re1) obj;
        View view = viewHolder.view;
        re1Var.a = view;
        ImageView imageView = (ImageView) view.findViewById(R.id.grid_icon);
        TextView textView = (TextView) view.findViewById(R.id.grid_label);
        int i = re1Var.b;
        Drawable drawable = null;
        if (i == 0) {
            drawable = view.getResources().getDrawable(R.drawable.setting_icon_32b, null);
        } else if (i == 1) {
            drawable = view.getResources().getDrawable(R.drawable.help_icon_32b, null);
        } else if (i == 2) {
            drawable = view.getResources().getDrawable(R.drawable.license_icon_32b, null);
        } else if (i == 3) {
            drawable = view.getResources().getDrawable(R.drawable.app_icon_32b, null);
        }
        imageView.setImageDrawable(drawable);
        textView.setText(re1Var.c);
    }

    @Override // androidx.leanback.widget.Presenter
    public final Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = ((LayoutInflater) viewGroup.getContext().getSystemService("layout_inflater")).inflate(R.layout.icon_grid_item, (ViewGroup) null);
        MainFragment mainFragment = this.b;
        inflate.setLayoutParams(new ViewGroup.LayoutParams(mainFragment.getResources().getInteger(R.integer.GRID_ITEM_WIDTH), mainFragment.getResources().getInteger(R.integer.GRID_ITEM_HEIGHT)));
        inflate.setBackgroundColor(ContextCompat.getColor(mainFragment.requireContext(), R.color.fastlane_background));
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        return new Presenter.ViewHolder(inflate);
    }

    @Override // androidx.leanback.widget.Presenter
    public final void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
    }
}
