package p000;

import android.text.TextUtils;
import androidx.emoji2.text.TypefaceEmojiRasterizer;
import com.google.common.base.Splitter;
import com.google.gson.JsonIOException;
import com.google.gson.internal.ObjectConstructor;
import java.util.Iterator;

/* renamed from: jv */
/* loaded from: classes2.dex */
public final class C1368jv implements ObjectConstructor, h80, em2 {

    /* renamed from: a */
    public final /* synthetic */ int f20642a;

    /* renamed from: b */
    public final String f20643b;

    public /* synthetic */ C1368jv(String str, int i) {
        this.f20642a = i;
        this.f20643b = str;
    }

    @Override // p000.em2
    /* renamed from: a */
    public Iterator mo92a(Splitter splitter, CharSequence charSequence) {
        return new dm2(this, splitter, charSequence, 1);
    }

    @Override // p000.h80
    /* renamed from: b */
    public boolean mo1081b(CharSequence charSequence, int i, int i2, TypefaceEmojiRasterizer typefaceEmojiRasterizer) {
        if (!TextUtils.equals(charSequence.subSequence(i, i2), this.f20643b)) {
            return true;
        }
        typefaceEmojiRasterizer.setExclusion(true);
        return false;
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        switch (this.f20642a) {
            case 0:
                throw new JsonIOException(this.f20643b);
            case 1:
                throw new JsonIOException(this.f20643b);
            default:
                throw new JsonIOException(this.f20643b);
        }
    }

    @Override // p000.h80
    public Object getResult() {
        return this;
    }
}
