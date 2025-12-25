package p000;

import android.app.Activity;
import android.text.Selection;
import android.text.Spannable;
import android.view.DragEvent;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.core.view.ContentInfoCompat;
import androidx.core.view.ViewCompat;

/* renamed from: n9 */
/* loaded from: classes.dex */
public abstract class AbstractC1577n9 {
    @DoNotInline
    /* renamed from: a */
    public static boolean m6320a(@NonNull DragEvent dragEvent, @NonNull TextView textView, @NonNull Activity activity) {
        activity.requestDragAndDropPermissions(dragEvent);
        int offsetForPosition = textView.getOffsetForPosition(dragEvent.getX(), dragEvent.getY());
        textView.beginBatchEdit();
        try {
            Selection.setSelection((Spannable) textView.getText(), offsetForPosition);
            ViewCompat.performReceiveContent(textView, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
            textView.endBatchEdit();
            return true;
        } catch (Throwable th) {
            textView.endBatchEdit();
            throw th;
        }
    }

    @DoNotInline
    /* renamed from: b */
    public static boolean m6321b(@NonNull DragEvent dragEvent, @NonNull View view, @NonNull Activity activity) {
        activity.requestDragAndDropPermissions(dragEvent);
        ViewCompat.performReceiveContent(view, new ContentInfoCompat.Builder(dragEvent.getClipData(), 3).build());
        return true;
    }
}
