package androidx.appcompat.widget;

import android.content.Intent;
import androidx.appcompat.widget.ShareActionProvider;
import p000.C1859u4;

/* renamed from: androidx.appcompat.widget.o */
/* loaded from: classes.dex */
public final class C0106o implements ActivityChooserModel$OnChooseActivityListener {

    /* renamed from: a */
    public final /* synthetic */ ShareActionProvider f1625a;

    public C0106o(ShareActionProvider shareActionProvider) {
        this.f1625a = shareActionProvider;
    }

    @Override // androidx.appcompat.widget.ActivityChooserModel$OnChooseActivityListener
    public final boolean onChooseActivity(C1859u4 c1859u4, Intent intent) {
        ShareActionProvider shareActionProvider = this.f1625a;
        ShareActionProvider.OnShareTargetSelectedListener onShareTargetSelectedListener = shareActionProvider.f1418h;
        if (onShareTargetSelectedListener != null) {
            onShareTargetSelectedListener.onShareTargetSelected(shareActionProvider, intent);
            return false;
        }
        return false;
    }
}
