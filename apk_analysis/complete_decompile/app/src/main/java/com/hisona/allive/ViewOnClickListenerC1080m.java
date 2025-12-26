package com.hisona.allive;

import android.view.View;

/* renamed from: com.hisona.allive.m */
/* loaded from: classes2.dex */
public final class ViewOnClickListenerC1080m implements View.OnClickListener {

    /* renamed from: a */
    public final /* synthetic */ MainFragment f15999a;

    public ViewOnClickListenerC1080m(MainFragment mainFragment) {
        this.f15999a = mainFragment;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Utils.showToast(this.f15999a.getContext(), R.string.notready);
    }
}
