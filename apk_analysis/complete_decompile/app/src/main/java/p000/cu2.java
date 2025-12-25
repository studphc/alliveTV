package p000;

import androidx.leanback.widget.TitleHelper;

/* loaded from: classes.dex */
public final class cu2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f16117a;

    /* renamed from: b */
    public final /* synthetic */ TitleHelper f16118b;

    public /* synthetic */ cu2(TitleHelper titleHelper, int i) {
        this.f16117a = i;
        this.f16118b = titleHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f16117a) {
            case 0:
                this.f16118b.f6237b.setVisibility(0);
                return;
            default:
                this.f16118b.f6237b.setVisibility(4);
                return;
        }
    }
}
