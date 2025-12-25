package p000;

import android.os.PersistableBundle;
import androidx.annotation.DoNotInline;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* loaded from: classes.dex */
public abstract class l42 {
    @JvmStatic
    @DoNotInline
    /* renamed from: a */
    public static final void m5849a(@NotNull PersistableBundle persistableBundle, @Nullable String str, boolean z) {
        persistableBundle.putBoolean(str, z);
    }

    @JvmStatic
    @DoNotInline
    /* renamed from: b */
    public static final void m5850b(@NotNull PersistableBundle persistableBundle, @Nullable String str, @NotNull boolean[] zArr) {
        persistableBundle.putBooleanArray(str, zArr);
    }
}
