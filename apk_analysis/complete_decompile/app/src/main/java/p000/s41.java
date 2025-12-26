package p000;

import android.content.ClipData;
import androidx.annotation.DoNotInline;
import androidx.core.util.Consumer;

/* loaded from: classes.dex */
public abstract class s41 {
    @DoNotInline
    /* renamed from: a */
    public static void m7330a(int i, ClipData.Item item, Consumer<String> consumer) {
        if (item.getHtmlText() != null || item.getIntent() != null || item.getTextLinks() != null) {
            consumer.accept("ClipData item at position " + i + " contains htmlText, textLinks or intent: " + item);
        }
    }
}
