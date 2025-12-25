package p000;

import android.app.Person;
import android.media.session.MediaSessionManager;
import android.os.Parcelable;
import android.text.PrecomputedText;
import android.text.TextPaint;

/* loaded from: classes.dex */
public abstract /* synthetic */ class hm1 {
    /* renamed from: f */
    public static /* bridge */ /* synthetic */ Person m5098f(Parcelable parcelable) {
        return (Person) parcelable;
    }

    /* renamed from: g */
    public static /* bridge */ /* synthetic */ Person m5099g(Object obj) {
        return (Person) obj;
    }

    /* renamed from: k */
    public static /* synthetic */ PrecomputedText.Params.Builder m5103k(TextPaint textPaint) {
        return new PrecomputedText.Params.Builder(textPaint);
    }

    /* renamed from: n */
    public static /* bridge */ /* synthetic */ PrecomputedText m5106n(Object obj) {
        return (PrecomputedText) obj;
    }

    /* renamed from: u */
    public static /* synthetic */ void m5113u(int i, int i2, String str) {
        new MediaSessionManager.RemoteUserInfo(str, i, i2);
    }

    /* renamed from: y */
    public static /* bridge */ /* synthetic */ boolean m5117y(CharSequence charSequence) {
        return charSequence instanceof PrecomputedText;
    }

    /* renamed from: z */
    public static /* bridge */ /* synthetic */ boolean m5118z(Object obj) {
        return obj instanceof PrecomputedText;
    }
}
