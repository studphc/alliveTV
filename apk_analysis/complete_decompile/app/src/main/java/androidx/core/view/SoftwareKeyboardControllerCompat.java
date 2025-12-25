package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.WindowInsetsController;
import androidx.annotation.NonNull;
import p000.ai2;

/* loaded from: classes.dex */
public final class SoftwareKeyboardControllerCompat {

    /* renamed from: a */
    public final ai2 f3903a;

    /* JADX WARN: Type inference failed for: r0v2, types: [ai2, androidx.core.view.d] */
    public SoftwareKeyboardControllerCompat(@NonNull View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            ?? ai2Var = new ai2(2, view);
            ai2Var.f3975c = view;
            this.f3903a = ai2Var;
            return;
        }
        this.f3903a = new ai2(2, view);
    }

    public void hide() {
        this.f3903a.mo96e();
    }

    public void show() {
        this.f3903a.mo97f();
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [ai2, androidx.core.view.d] */
    public SoftwareKeyboardControllerCompat(WindowInsetsController windowInsetsController) {
        ?? ai2Var = new ai2(2, null);
        ai2Var.f3976d = windowInsetsController;
        this.f3903a = ai2Var;
    }
}
