package p000;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;

/* renamed from: x9 */
/* loaded from: classes.dex */
public abstract class AbstractC1975x9 {
    @NonNull
    @DoNotInline
    /* renamed from: a */
    public static TextClassifier m8150a(@NonNull TextView textView) {
        TextClassificationManager textClassificationManager = (TextClassificationManager) textView.getContext().getSystemService(TextClassificationManager.class);
        if (textClassificationManager != null) {
            return textClassificationManager.getTextClassifier();
        }
        return TextClassifier.NO_OP;
    }
}
