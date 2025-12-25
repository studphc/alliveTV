package p000;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.AbstractC0217m;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;

/* loaded from: classes.dex */
public class y53 extends AbstractC0217m {

    /* renamed from: c */
    public final WindowInsets.Builder f28846c;

    public y53() {
        this.f28846c = x53.m8129b();
    }

    @Override // androidx.core.view.AbstractC0217m
    @NonNull
    /* renamed from: b */
    public WindowInsetsCompat mo966b() {
        WindowInsets build;
        m965a();
        build = this.f28846c.build();
        WindowInsetsCompat windowInsetsCompat = WindowInsetsCompat.toWindowInsetsCompat(build);
        windowInsetsCompat.f3941a.mo988r(this.f4004b);
        return windowInsetsCompat;
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: c */
    public void mo967c(@Nullable DisplayCutoutCompat displayCutoutCompat) {
        DisplayCutout displayCutout;
        WindowInsets.Builder builder = this.f28846c;
        if (displayCutoutCompat != null) {
            displayCutout = displayCutoutCompat.f3872a;
        } else {
            displayCutout = null;
        }
        builder.setDisplayCutout(displayCutout);
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: f */
    public void mo970f(@NonNull Insets insets) {
        this.f28846c.setMandatorySystemGestureInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: g */
    public void mo971g(@NonNull Insets insets) {
        this.f28846c.setStableInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: h */
    public void mo972h(@NonNull Insets insets) {
        this.f28846c.setSystemGestureInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: i */
    public void mo973i(@NonNull Insets insets) {
        this.f28846c.setSystemWindowInsets(insets.toPlatformInsets());
    }

    @Override // androidx.core.view.AbstractC0217m
    /* renamed from: j */
    public void mo974j(@NonNull Insets insets) {
        this.f28846c.setTappableElementInsets(insets.toPlatformInsets());
    }

    public y53(@NonNull WindowInsetsCompat windowInsetsCompat) {
        super(windowInsetsCompat);
        WindowInsets.Builder m8129b;
        WindowInsets windowInsets = windowInsetsCompat.toWindowInsets();
        if (windowInsets != null) {
            m8129b = x53.m8130c(windowInsets);
        } else {
            m8129b = x53.m8129b();
        }
        this.f28846c = m8129b;
    }
}
