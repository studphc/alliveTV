package p000;

import android.view.DisplayCutout;
import android.view.WindowInsets;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.DisplayCutoutCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.Objects;

/* loaded from: classes.dex */
public class b63 extends a63 {
    public b63(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull WindowInsets windowInsets) {
        super(windowInsetsCompat, windowInsets);
    }

    @Override // androidx.core.view.C0220p
    @NonNull
    /* renamed from: a */
    public WindowInsetsCompat mo993a() {
        WindowInsets consumeDisplayCutout;
        consumeDisplayCutout = this.f4010c.consumeDisplayCutout();
        return WindowInsetsCompat.toWindowInsetsCompat(consumeDisplayCutout);
    }

    @Override // androidx.core.view.C0218n, androidx.core.view.C0220p
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b63)) {
            return false;
        }
        b63 b63Var = (b63) obj;
        if (Objects.equals(this.f4010c, b63Var.f4010c) && Objects.equals(this.f4014g, b63Var.f4014g)) {
            return true;
        }
        return false;
    }

    @Override // androidx.core.view.C0220p
    @Nullable
    /* renamed from: f */
    public DisplayCutoutCompat mo994f() {
        DisplayCutout displayCutout;
        displayCutout = this.f4010c.getDisplayCutout();
        if (displayCutout == null) {
            return null;
        }
        return new DisplayCutoutCompat(displayCutout);
    }

    @Override // androidx.core.view.C0220p
    public int hashCode() {
        return this.f4010c.hashCode();
    }

    public b63(@NonNull WindowInsetsCompat windowInsetsCompat, @NonNull b63 b63Var) {
        super(windowInsetsCompat, b63Var);
    }
}
