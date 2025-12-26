package androidx.emoji2.viewsintegration;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import p000.k80;
import p000.l80;
import p000.o63;

/* loaded from: classes.dex */
public final class EmojiTextViewHelper {

    /* renamed from: a */
    public final o63 f4311a;

    public EmojiTextViewHelper(@NonNull TextView textView) {
        this(textView, true);
    }

    @NonNull
    public InputFilter[] getFilters(@NonNull InputFilter[] inputFilterArr) {
        return this.f4311a.mo5509o(inputFilterArr);
    }

    public boolean isEnabled() {
        return this.f4311a.mo5510s();
    }

    public void setAllCaps(boolean z) {
        this.f4311a.mo5505I(z);
    }

    public void setEnabled(boolean z) {
        this.f4311a.mo5506J(z);
    }

    public void updateTransformationMethod() {
        this.f4311a.mo5507Q();
    }

    @Nullable
    public TransformationMethod wrapTransformationMethod(@Nullable TransformationMethod transformationMethod) {
        return this.f4311a.mo5508R(transformationMethod);
    }

    public EmojiTextViewHelper(@NonNull TextView textView, boolean z) {
        Preconditions.checkNotNull(textView, "textView cannot be null");
        if (!z) {
            this.f4311a = new l80(textView);
        } else {
            this.f4311a = new k80(textView);
        }
    }
}
