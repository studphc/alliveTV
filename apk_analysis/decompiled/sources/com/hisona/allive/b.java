package com.hisona.allive;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;

/* loaded from: classes2.dex */
public final class b extends ImageCardView {
    public final /* synthetic */ CardPresenter A;
    public final /* synthetic */ ViewGroup z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(CardPresenter cardPresenter, Context context, ViewGroup viewGroup) {
        super(context);
        this.A = cardPresenter;
        this.z = viewGroup;
    }

    @Override // androidx.leanback.widget.BaseCardView, android.view.View
    public final void setSelected(boolean z) {
        int i;
        if (z) {
            i = CardPresenter.d;
        } else {
            i = CardPresenter.e;
        }
        setBackgroundColor(i);
        findViewById(R.id.info_field).setBackgroundColor(i);
        boolean z2 = this.A.c;
        ViewGroup viewGroup = this.z;
        if (z2 && z) {
            setBackground(ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.image_border));
        } else {
            setBackground(ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.image_borderless));
        }
        super.setSelected(z);
    }
}
