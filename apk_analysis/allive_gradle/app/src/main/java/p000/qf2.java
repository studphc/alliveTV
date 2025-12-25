package p000;

import androidx.appcompat.widget.SearchView;
import androidx.cursoradapter.widget.CursorAdapter;

/* loaded from: classes.dex */
public final class qf2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f25570a;

    /* renamed from: b */
    public final /* synthetic */ SearchView f25571b;

    public /* synthetic */ qf2(SearchView searchView, int i) {
        this.f25570a = i;
        this.f25571b = searchView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f25570a) {
            case 0:
                this.f25571b.m270k();
                return;
            default:
                CursorAdapter cursorAdapter = this.f25571b.f1377R;
                if (cursorAdapter instanceof mq2) {
                    cursorAdapter.changeCursor(null);
                    return;
                }
                return;
        }
    }
}
