package com.hisona.allive;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.q72;

/* loaded from: classes2.dex */
public final class x extends RecyclerView.ViewHolder {
    public final ImageView t;
    public final TextView u;
    public final /* synthetic */ ProfileSelectFragment v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public x(ProfileSelectFragment profileSelectFragment, View view) {
        super(view);
        this.v = profileSelectFragment;
        view.setOnFocusChangeListener(new q72(0, this));
        view.setOnClickListener(new w(this));
        this.t = (ImageView) view.findViewById(R.id.profile_icon);
        this.u = (TextView) view.findViewById(R.id.profile_label);
    }
}
