package p000;

import android.app.Activity;
import android.view.DragAndDropPermissions;
import android.view.DragEvent;
import androidx.annotation.DoNotInline;

/* loaded from: classes.dex */
public abstract class g60 {
    @DoNotInline
    /* renamed from: a */
    public static void m4929a(DragAndDropPermissions dragAndDropPermissions) {
        dragAndDropPermissions.release();
    }

    @DoNotInline
    /* renamed from: b */
    public static DragAndDropPermissions m4930b(Activity activity, DragEvent dragEvent) {
        return activity.requestDragAndDropPermissions(dragEvent);
    }
}
