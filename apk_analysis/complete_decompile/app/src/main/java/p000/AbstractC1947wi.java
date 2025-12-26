package p000;

import android.os.Bundle;
import android.util.Size;
import android.util.SizeF;
import androidx.annotation.DoNotInline;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* renamed from: wi */
/* loaded from: classes.dex */
public abstract class AbstractC1947wi {
    @JvmStatic
    @DoNotInline
    /* renamed from: a */
    public static final void m8058a(@NotNull Bundle bundle, @NotNull String str, @Nullable Size size) {
        bundle.putSize(str, size);
    }

    @JvmStatic
    @DoNotInline
    /* renamed from: b */
    public static final void m8059b(@NotNull Bundle bundle, @NotNull String str, @Nullable SizeF sizeF) {
        bundle.putSizeF(str, sizeF);
    }
}
