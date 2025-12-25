package com.hisona.allive;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.ArrayList;
import p000.p72;

/* renamed from: com.hisona.allive.v */
/* loaded from: classes2.dex */
public final class C1088v extends RecyclerView.Adapter {

    /* renamed from: d */
    public final ArrayList f16015d = new ArrayList();

    /* renamed from: e */
    public final /* synthetic */ ProfileSelectFragment f16016e;

    public C1088v(ProfileSelectFragment profileSelectFragment) {
        this.f16016e = profileSelectFragment;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final int getItemCount() {
        return this.f16015d.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        C1090x c1090x = (C1090x) viewHolder;
        p72 p72Var = (p72) this.f16015d.get(i);
        c1090x.f16019u.setText(p72Var.f25057b);
        GlideApp.with(this.f16016e.getContext()).mo8501load("http://" + p72Var.f25056a).fitCenter().override(100, 100).diskCacheStrategy(DiskCacheStrategy.NONE).skipMemoryCache(true).into(c1090x.f16018t);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.profile_item, viewGroup, false);
        inflate.setFocusableInTouchMode(false);
        inflate.setFocusable(true);
        inflate.setClickable(true);
        return new C1090x(this.f16016e, inflate);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public final void onViewAttachedToWindow(RecyclerView.ViewHolder viewHolder) {
        C1090x c1090x = (C1090x) viewHolder;
        int absoluteAdapterPosition = c1090x.getAbsoluteAdapterPosition();
        ProfileSelectFragment profileSelectFragment = this.f16016e;
        if (absoluteAdapterPosition == profileSelectFragment.f15905y0) {
            profileSelectFragment.f15905y0 = -1;
            c1090x.itemView.requestFocus();
        }
    }
}
