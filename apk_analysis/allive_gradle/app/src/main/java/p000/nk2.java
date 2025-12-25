package p000;

import android.view.View;

/* loaded from: classes.dex */
public final class nk2 extends p63 {

    /* renamed from: f */
    public final /* synthetic */ int f23391f;

    @Override // p000.pk2
    /* renamed from: a */
    public final float mo6355a(View view) {
        switch (this.f23391f) {
            case 0:
                return view.getTranslationX() - view.getWidth();
            case 1:
                return view.getTranslationX() + view.getWidth();
            case 2:
                if (view.getLayoutDirection() == 1) {
                    return view.getTranslationX() + view.getWidth();
                }
                return view.getTranslationX() - view.getWidth();
            default:
                if (view.getLayoutDirection() == 1) {
                    return view.getTranslationX() - view.getWidth();
                }
                return view.getTranslationX() + view.getWidth();
        }
    }
}
