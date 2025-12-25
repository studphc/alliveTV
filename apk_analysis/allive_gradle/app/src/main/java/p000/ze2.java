package p000;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.leanback.widget.SearchBar;

/* loaded from: classes.dex */
public final class ze2 implements Runnable {

    /* renamed from: a */
    public final /* synthetic */ int f29339a;

    /* renamed from: b */
    public final /* synthetic */ SearchBar f29340b;

    public /* synthetic */ ze2(SearchBar searchBar, int i) {
        this.f29339a = i;
        this.f29340b = searchBar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f29339a) {
            case 0:
                SearchBar searchBar = this.f29340b;
                searchBar.setSearchQueryInternal(searchBar.f6127b.getText().toString());
                return;
            default:
                SearchBar searchBar2 = this.f29340b;
                searchBar2.f6127b.requestFocusFromTouch();
                searchBar2.f6127b.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 0, searchBar2.f6127b.getWidth(), searchBar2.f6127b.getHeight(), 0));
                searchBar2.f6127b.dispatchTouchEvent(MotionEvent.obtain(SystemClock.uptimeMillis(), SystemClock.uptimeMillis(), 1, searchBar2.f6127b.getWidth(), searchBar2.f6127b.getHeight(), 0));
                return;
        }
    }
}
