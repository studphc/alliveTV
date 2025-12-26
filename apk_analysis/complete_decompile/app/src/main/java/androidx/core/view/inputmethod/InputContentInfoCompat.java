package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import p000.j41;
import p000.jz2;
import p000.k41;

/* loaded from: classes.dex */
public final class InputContentInfoCompat {

    /* renamed from: a */
    public final k41 f3991a;

    public InputContentInfoCompat(@NonNull Uri uri, @NonNull ClipDescription clipDescription, @Nullable Uri uri2) {
        if (Build.VERSION.SDK_INT >= 25) {
            this.f3991a = new j41(uri, clipDescription, uri2);
        } else {
            this.f3991a = new jz2(uri, clipDescription, uri2, 5);
        }
    }

    @Nullable
    public static InputContentInfoCompat wrap(@Nullable Object obj) {
        if (obj == null || Build.VERSION.SDK_INT < 25) {
            return null;
        }
        return new InputContentInfoCompat(new j41(obj));
    }

    @NonNull
    public Uri getContentUri() {
        return this.f3991a.mo5387b();
    }

    @NonNull
    public ClipDescription getDescription() {
        return this.f3991a.mo5389d();
    }

    @Nullable
    public Uri getLinkUri() {
        return this.f3991a.mo5386a();
    }

    public void releasePermission() {
        this.f3991a.mo5391f();
    }

    public void requestPermission() {
        this.f3991a.mo5388c();
    }

    @Nullable
    public Object unwrap() {
        return this.f3991a.mo5390e();
    }

    public InputContentInfoCompat(j41 j41Var) {
        this.f3991a = j41Var;
    }
}
