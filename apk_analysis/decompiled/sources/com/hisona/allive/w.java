package com.hisona.allive;

import android.view.View;
import com.hisona.allive.ProfileSelectFragment;

/* loaded from: classes2.dex */
public final class w implements View.OnClickListener {
    public final /* synthetic */ x a;

    public w(x xVar) {
        this.a = xVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        x xVar = this.a;
        ProfileSelectFragment profileSelectFragment = xVar.v;
        profileSelectFragment.y0 = 0;
        ProfileSelectFragment.OnListItemClickListener onListItemClickListener = profileSelectFragment.z0;
        if (onListItemClickListener != null) {
            onListItemClickListener.onItemClick(view, xVar.getAbsoluteAdapterPosition());
        }
    }
}
