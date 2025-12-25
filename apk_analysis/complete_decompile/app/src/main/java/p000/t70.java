package p000;

import android.view.View;
import android.view.Window;
import androidx.activity.SystemBarStyle;
import androidx.annotation.DoNotInline;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* loaded from: classes.dex */
public final class t70 implements w70 {
    @Override // p000.w70
    @DoNotInline
    /* renamed from: a */
    public void mo7466a(@NotNull SystemBarStyle statusBarStyle, @NotNull SystemBarStyle navigationBarStyle, @NotNull Window window, @NotNull View view, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(statusBarStyle, "statusBarStyle");
        Intrinsics.checkNotNullParameter(navigationBarStyle, "navigationBarStyle");
        Intrinsics.checkNotNullParameter(window, "window");
        Intrinsics.checkNotNullParameter(view, "view");
        WindowCompat.setDecorFitsSystemWindows(window, false);
        window.setStatusBarColor(statusBarStyle.getScrim$activity_release(z));
        window.setNavigationBarColor(navigationBarStyle.getDarkScrim());
        new WindowInsetsControllerCompat(window, view).setAppearanceLightStatusBars(!z);
    }
}
