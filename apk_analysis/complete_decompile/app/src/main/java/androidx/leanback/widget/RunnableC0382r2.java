package androidx.leanback.widget;

/* renamed from: androidx.leanback.widget.r2 */
/* loaded from: classes.dex */
public final class RunnableC0382r2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ C0386s2 f6407a;

    public RunnableC0382r2(C0386s2 c0386s2) {
        this.f6407a = c0386s2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SearchBar searchBar = this.f6407a.f6412a;
        searchBar.f6126a.onKeyboardDismiss(searchBar.f6130e);
    }
}
