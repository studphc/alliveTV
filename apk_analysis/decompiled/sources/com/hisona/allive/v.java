package com.hisona.allive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import defpackage.p72;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class v extends RecyclerView.Adapter {
    public final ArrayList d = new ArrayList();
    public final /* synthetic */ ProfileSelectFragment e;

    public v(ProfileSelectFragment profileSelectFragment) {
        this.e = profileSelectFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        x xVar = (x) viewHolder;
        p72 p72Var = (p72) this.d.get(i);
        xVar.u.setText(p72Var.b);
        GlideApp.with(this.e.getContext()).mo54load("http://" + p72Var.a).fitCenter().override(100, 100).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(xVar.t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_item, viewGroup, false);
        inflate.setFocusableInTouchMode(false);
        inflate.setFocusable(true);
        inflate.setClickable(true);
        return new x(this.e, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        x xVar = (x) viewHolder;
        int absoluteAdapterPosition = xVar.getAbsoluteAdapterPosition();
        ProfileSelectFragment profileSelectFragment = this.e;
        if (absoluteAdapterPosition == profileSelectFragment.y0) {
            profileSelectFragment.y0 = -1;
            xVar.itemView.requestFocus();
        }
    }
}
