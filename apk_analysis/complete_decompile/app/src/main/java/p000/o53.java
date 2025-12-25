package p000;

import android.view.KeyboardShortcutGroup;
import android.view.Menu;
import android.view.Window;
import androidx.annotation.DoNotInline;
import java.util.List;

/* loaded from: classes.dex */
public abstract class o53 {
    @DoNotInline
    /* renamed from: a */
    public static void m6443a(Window.Callback callback, List<KeyboardShortcutGroup> list, Menu menu, int i) {
        callback.onProvideKeyboardShortcuts(list, menu, i);
    }
}
