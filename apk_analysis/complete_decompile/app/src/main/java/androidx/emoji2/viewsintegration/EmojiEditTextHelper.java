package androidx.emoji2.viewsintegration;

import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.util.Preconditions;
import androidx.emoji2.text.EmojiCompat;
import p000.C1540m9;
import p000.d80;
import p000.g80;
import p000.n80;

/* loaded from: classes.dex */
public final class EmojiEditTextHelper {

    /* renamed from: a */
    public final C1540m9 f4308a;

    /* renamed from: b */
    public int f4309b;

    /* renamed from: c */
    public int f4310c;

    public EmojiEditTextHelper(@NonNull EditText editText) {
        this(editText, true);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public int getEmojiReplaceStrategy() {
        return this.f4310c;
    }

    @Nullable
    public KeyListener getKeyListener(@Nullable KeyListener keyListener) {
        this.f4308a.getClass();
        if (!(keyListener instanceof g80)) {
            if (keyListener == null) {
                return null;
            }
            if (!(keyListener instanceof NumberKeyListener)) {
                return new g80(keyListener);
            }
            return keyListener;
        }
        return keyListener;
    }

    public int getMaxEmojiCount() {
        return this.f4309b;
    }

    public boolean isEnabled() {
        return ((n80) this.f4308a.f22855c).f23283f;
    }

    @Nullable
    public InputConnection onCreateInputConnection(@Nullable InputConnection inputConnection, @NonNull EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        C1540m9 c1540m9 = this.f4308a;
        c1540m9.getClass();
        if (!(inputConnection instanceof d80)) {
            return new d80((EditText) c1540m9.f22854b, inputConnection, editorInfo);
        }
        return inputConnection;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void setEmojiReplaceStrategy(int i) {
        this.f4310c = i;
        ((n80) this.f4308a.f22855c).f23282e = i;
    }

    public void setEnabled(boolean z) {
        n80 n80Var = (n80) this.f4308a.f22855c;
        if (n80Var.f23283f != z) {
            if (n80Var.f23280c != null) {
                EmojiCompat.get().unregisterInitCallback(n80Var.f23280c);
            }
            n80Var.f23283f = z;
            if (z) {
                n80.m6319a(n80Var.f23278a, EmojiCompat.get().getLoadState());
            }
        }
    }

    public void setMaxEmojiCount(@IntRange(from = 0) int i) {
        Preconditions.checkArgumentNonnegative(i, "maxEmojiCount should be greater than 0");
        this.f4309b = i;
        ((n80) this.f4308a.f22855c).f23281d = i;
    }

    public EmojiEditTextHelper(@NonNull EditText editText, boolean z) {
        this.f4309b = Integer.MAX_VALUE;
        this.f4310c = 0;
        Preconditions.checkNotNull(editText, "editText cannot be null");
        this.f4308a = new C1540m9(editText, z);
    }
}
