package p000;

import androidx.core.util.Consumer;

/* loaded from: classes.dex */
public final /* synthetic */ class q41 implements Consumer {

    /* renamed from: a */
    public final /* synthetic */ int f25431a;

    @Override // androidx.core.util.Consumer
    public final void accept(Object obj) {
        String str = (String) obj;
        switch (this.f25431a) {
            case 0:
                throw new SecurityException(str);
            default:
                return;
        }
    }
}
