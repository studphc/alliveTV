package p000;

import android.view.ActionMode;
import android.view.SearchEvent;
import android.view.Window;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class n53 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m6315a(Window.Callback callback, SearchEvent searchEvent) {
        return callback.onSearchRequested(searchEvent);
    }

    @DoNotInline
    /* renamed from: b */
    public static ActionMode m6316b(Window.Callback callback, ActionMode.Callback callback2, int i) {
        return callback.onWindowStartingActionMode(callback2, i);
    }
}
