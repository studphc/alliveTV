package com.hisona.allive;

import android.content.Context;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.ImageCardView;

/* renamed from: com.hisona.allive.b */
/* loaded from: classes2.dex */
public final class C1066b extends ImageCardView {

    /* renamed from: A */
    public final /* synthetic */ CardPresenter f15972A;

    /* renamed from: z */
    public final /* synthetic */ ViewGroup f15973z;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1066b(CardPresenter cardPresenter, Context context, ViewGroup viewGroup) {
        super(context);
        this.f15972A = cardPresenter;
        this.f15973z = viewGroup;
    }

    @Override // androidx.leanback.widget.BaseCardView, android.view.View
    public final void setSelected(boolean z) {
        int i;
        if (z) {
            i = CardPresenter.f15800d;
        } else {
            i = CardPresenter.f15801e;
        }
        setBackgroundColor(i);
        findViewById(R.id.info_field).setBackgroundColor(i);
        boolean z2 = this.f15972A.f15803c;
        ViewGroup viewGroup = this.f15973z;
        if (z2 && z) {
            setBackground(ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.image_border));
        } else {
            setBackground(ContextCompat.getDrawable(viewGroup.getContext(), R.drawable.image_borderless));
        }
        super.setSelected(z);
    }
}
