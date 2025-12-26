package p000;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

/* loaded from: classes.dex */
public final class l80 extends o63 {

    /* renamed from: u */
    public final k80 f22383u;

    public l80(TextView textView) {
        this.f22383u = new k80(textView);
    }

    @Override // p000.o63
    /* renamed from: I */
    public final void mo5505I(boolean z) {
        if (!EmojiCompat.isConfigured()) {
            return;
        }
        this.f22383u.mo5505I(z);
    }

    @Override // p000.o63
    /* renamed from: J */
    public final void mo5506J(boolean z) {
        boolean isConfigured = EmojiCompat.isConfigured();
        k80 k80Var = this.f22383u;
        if (!isConfigured) {
            k80Var.f20777w = z;
        } else {
            k80Var.mo5506J(z);
        }
    }

    @Override // p000.o63
    /* renamed from: Q */
    public final void mo5507Q() {
        if (!EmojiCompat.isConfigured()) {
            return;
        }
        this.f22383u.mo5507Q();
    }

    @Override // p000.o63
    /* renamed from: R */
    public final TransformationMethod mo5508R(TransformationMethod transformationMethod) {
        if (!EmojiCompat.isConfigured()) {
            return transformationMethod;
        }
        return this.f22383u.mo5508R(transformationMethod);
    }

    @Override // p000.o63
    /* renamed from: o */
    public final InputFilter[] mo5509o(InputFilter[] inputFilterArr) {
        if (!EmojiCompat.isConfigured()) {
            return inputFilterArr;
        }
        return this.f22383u.mo5509o(inputFilterArr);
    }

    @Override // p000.o63
    /* renamed from: s */
    public final boolean mo5510s() {
        return this.f22383u.f20777w;
    }
}
