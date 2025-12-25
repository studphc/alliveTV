package p000;

import android.text.method.SingleLineTransformationMethod;
import android.view.View;
import java.util.Locale;

/* loaded from: classes.dex */
public final class w12 extends SingleLineTransformationMethod {

    /* renamed from: a */
    public Locale f28042a;

    @Override // android.text.method.ReplacementTransformationMethod, android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence, View view) {
        CharSequence transformation = super.getTransformation(charSequence, view);
        if (transformation != null) {
            return transformation.toString().toUpperCase(this.f28042a);
        }
        return null;
    }
}
