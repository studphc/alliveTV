package com.hisona.allive;

import android.view.View;
import com.hisona.allive.ProfileSelectFragment;

/* renamed from: com.hisona.allive.w */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC1089w implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ C1090x f16017a;

    public ViewOnClickListenerC1089w(C1090x c1090x) {
        this.f16017a = c1090x;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        C1090x c1090x = this.f16017a;
        ProfileSelectFragment profileSelectFragment = c1090x.f16020v;
        profileSelectFragment.f15905y0 = 0;
        ProfileSelectFragment.OnListItemClickListener onListItemClickListener = profileSelectFragment.f15906z0;
        if (onListItemClickListener != null) {
            onListItemClickListener.onItemClick(view, c1090x.getAbsoluteAdapterPosition());
        }
    }
}
