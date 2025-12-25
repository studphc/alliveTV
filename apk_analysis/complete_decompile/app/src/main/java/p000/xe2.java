package p000;

import androidx.leanback.widget.SearchBar;
import com.google.android.gms.common.api.internal.zabq;

/* loaded from: classes.dex */
public final class xe2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f28528a;

    /* renamed from: b */
    public final /* synthetic */ int f28529b;

    /* renamed from: c */
    public final /* synthetic */ Object f28530c;

    public /* synthetic */ xe2(int i, int i2, Object obj) {
        this.f28528a = i2;
        this.f28530c = obj;
        this.f28529b = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f28528a) {
            case 0:
                SearchBar searchBar = (SearchBar) this.f28530c;
                searchBar.f6147v.play(searchBar.f6148w.get(this.f28529b), 1.0f, 1.0f, 1, 0, 1.0f);
                return;
            default:
                ((zabq) this.f28530c).m3118g(this.f28529b);
                return;
        }
    }
}
