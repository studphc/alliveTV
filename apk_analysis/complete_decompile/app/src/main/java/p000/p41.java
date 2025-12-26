package p000;

import android.content.Intent;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.Serializable;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class p41 {
    @DoNotInline
    /* renamed from: a */
    public static <T> T[] m6831a(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
        return (T[]) intent.getParcelableArrayExtra(str, cls);
    }

    @DoNotInline
    /* renamed from: b */
    public static <T> ArrayList<T> m6832b(@NonNull Intent intent, @Nullable String str, @NonNull Class<? extends T> cls) {
        return intent.getParcelableArrayListExtra(str, cls);
    }

    @DoNotInline
    /* renamed from: c */
    public static <T> T m6833c(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
        return (T) intent.getParcelableExtra(str, cls);
    }

    @DoNotInline
    /* renamed from: d */
    public static <T extends Serializable> T m6834d(@NonNull Intent intent, @Nullable String str, @NonNull Class<T> cls) {
        return (T) intent.getSerializableExtra(str, cls);
    }
}
