package androidx.leanback.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatViewInflater;

/* loaded from: classes.dex */
public class LeanbackAppCompatViewInflater extends AppCompatViewInflater {
    @Override // androidx.appcompat.app.AppCompatViewInflater
    @NonNull
    public View createView(@Nullable Context context, @Nullable String str, @Nullable AttributeSet attributeSet) {
        str.getClass();
        if (!str.equals("androidx.leanback.widget.GuidedActionEditText")) {
            return null;
        }
        return new GuidedActionAppCompatEditText(context, attributeSet);
    }
}
