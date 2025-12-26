package androidx.core.content;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;

@Deprecated
/* loaded from: classes.dex */
public final class SharedPreferencesCompat {

    @Deprecated
    /* loaded from: classes.dex */
    public static final class EditorCompat {

        /* renamed from: b */
        public static EditorCompat f3565b;

        /* renamed from: a */
        public final C0176a f3566a = new Object();

        @Deprecated
        public static EditorCompat getInstance() {
            if (f3565b == null) {
                f3565b = new EditorCompat();
            }
            return f3565b;
        }

        @Deprecated
        public void apply(@NonNull SharedPreferences.Editor editor) {
            this.f3566a.getClass();
            try {
                editor.apply();
            } catch (AbstractMethodError unused) {
                editor.commit();
            }
        }
    }
}
