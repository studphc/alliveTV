package com.hisona.allive;

import android.view.View;

/* loaded from: classes2.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ MainFragment a;

    public m(MainFragment mainFragment) {
        this.a = mainFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Utils.showToast(this.a.getContext(), R.string.notready);
    }
}
