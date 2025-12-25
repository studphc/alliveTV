package p000;

import android.graphics.Insets;
import android.graphics.Rect;
import android.view.View;
import android.view.WindowInsets;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public abstract class h43 {
    @DoNotInline
    /* renamed from: a */
    public static void m5036a(@NonNull View view, @NonNull Rect rect, @NonNull Rect rect2) {
        Insets systemWindowInsets = view.computeSystemWindowInsets(new WindowInsets.Builder().setSystemWindowInsets(Insets.of(rect)).build(), rect2).getSystemWindowInsets();
        rect.set(systemWindowInsets.left, systemWindowInsets.top, systemWindowInsets.right, systemWindowInsets.bottom);
    }
}
