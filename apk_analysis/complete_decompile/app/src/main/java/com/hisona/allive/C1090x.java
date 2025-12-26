package com.hisona.allive;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import p000.q72;

/* renamed from: com.hisona.allive.x */
/* loaded from: classes2.dex */
public final class C1090x extends RecyclerView.ViewHolder {

    /* renamed from: t */
    public final ImageView f16018t;

    /* renamed from: u */
    public final TextView f16019u;

    /* renamed from: v */
    public final /* synthetic */ ProfileSelectFragment f16020v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1090x(ProfileSelectFragment profileSelectFragment, View view) {
        super(view);
        this.f16020v = profileSelectFragment;
        view.setOnFocusChangeListener(new q72(0, this));
        view.setOnClickListener(new ViewOnClickListenerC1089w(this));
        this.f16018t = (ImageView) view.findViewById(R.id.profile_icon);
        this.f16019u = (TextView) view.findViewById(R.id.profile_label);
    }
}
